/*
 * jQuery版弹窗 - xyPop-v2.0 beta (UTF-8)
 * @Author	xiaoYan
 * @Create	Thu November 11 2015 15:30:45 GMT+0800 (中国标准时间)
 */
!function (w, $) {
    var utils = {
            //当前JS路径
            getPath: function () {
                var js = document.scripts, script = js[js.length - 1], jsPath = script.src;
                return jsPath.substring(0, jsPath.lastIndexOf("/") + 1);
            }(),
            //浏览器检测
            browser: function () {
                return {
                    mobile: /Android|iPhone|SymbianOS|Windows Phone|iPad|iPod/.test(navigator.userAgent.toLowerCase())
                };
            }()
        },
        /**工厂构造函数*/
        Factory = function (configs) {
            var _i = this, c = _i.options;
            _i.config = $.extend({}, c, configs);

            //实例化弹窗
            if (!(_i instanceof Factory)) {
                return new Factory(configs);
            }
            _i.init();
        };
    Factory.prototype = {
        options: {
            dom: "xy-ui-pop",			//标识弹窗，用于关闭所有
            id: "uiPop",					//弹窗ID (不同ID对应不同弹窗)
            title: "提示",				//标题(为false时隐藏标题)
            content: "",					//消息内容
            type: "warning",			//图标类型 warning|error|success|confirm
            padding: "20px",			//内容填充区域
            lock: 1,						//锁定屏幕(遮罩)
            fixed: false,					//是否固定定位
            zIndex: 9999,				//设置元素层叠
            time: 0,						//定时关闭

            btn: "确定",					//按钮(String/Array) 	btn:"确定" | btn:["确定", "取消"] | btn: ['按钮1', '按钮2', '按钮3', …]
            onShow: null,				//打开弹窗成功回调方法
            onOk: null,					//确定按钮回调方法
            onClose: null,				//关闭按钮回调方法
            bottom: true,				//底部(为false时隐藏底部)

            alpha: [".4", "#000"],	//设置遮罩层背景及透明度
            skinPath: "skin/"			//css或image路径
        },
        init: function () {
            var _i = this, opt = _i.config, c = null, popWin = null, offsetL, offsetT;

            _i.isfixed = (opt.fixed || opt.time) ? true : false;

            if ($("#" + opt.id)[0])
                return;

            c = $("<div id='" + opt.id + "' class='" + opt.dom + "'></div>");
            c.html(
                /**遮罩*/
                (opt.lock ? '<div class="xy-ui-overlay"></div>' : '')
                /**窗体*/
                + '<div class="xy-ui-wrapper anim-ui-wrapper">'
                /*标题区域*/
                + (opt.title ? '<div class="xy-ui-head"><div class="xy-ui-title">' + opt.title + '</div><a class="xy-ui-close"></a></div>' : '')
                /*内容区域*/
                + '<div class="xy-ui-body">'
                + (opt.type ? '<div style="text-align:center;"><span style="background:url(' + opt.skinPath + opt.type + '_icon.gif) no-repeat 0 center;display:inline-block;padding:0.75rem 0 0.75rem 2.625rem;">' + opt.content + '</span></div>' : opt.content)
                + '</div>'
                /*底部区域*/
                + (opt.bottom && opt.btn ? function () {
                    /*定义多个按钮*/
                    var btn = "";
                    typeof opt.btn === "string" && (opt.btn = [opt.btn]);
                    $.each(opt.btn, function (i, v) {
                        btn += '<a class="ui-btns xy_ui_btn' + i + '" style="width: ' + (100 / opt.btn.length) + '%">' + v + '</a>';
                    });
                    return '<div class="xy-ui-foot">'
                        + '<div class="xy-ui-btns">' + btn + '</div>'
                    '</div>'
                }() : '')
                + '</div>'
            );
            $("body").append(c); //插入到body最后

            /**锁屏设置*/
            _i.overlay = c.find(".xy-ui-overlay");
            _i.overlay.css({
                "background-color": opt.alpha[1] || "#000",
                "opacity": 0,
                "z-index": _i.maxIndex() + 1
            }).fadeTo(300, opt.alpha[0]);

            _i.popWin = popWin = c.find(".xy-ui-wrapper");
            popWin.css({
                "position": _i.isfixed ? "fixed" : "absolute",
                "z-index": _i.maxIndex() + 1
            });

            _i.body = _i.popWin.find(".xy-ui-body");
            _i.body.css({
                "padding": opt.padding
            });

            offsetL = ($(window).width() - popWin.outerWidth()) / 2;
            offsetT = ($(window).height() - popWin.outerHeight()) / 2;

            /**弹窗定位*/
            popWin.css({
                "left": _i.isfixed ? offsetL : $(document).scrollLeft() + offsetL,
                "top": _i.isfixed ? offsetT : $(document).scrollTop() + offsetT
            });

            /**弹窗重置*/
            _i.setPos = function () {
                if (!_i.isfixed) {
                    popWin.css({
                        "left": $(document).scrollLeft() + ($(window).width() - popWin.outerWidth()) / 2,
                        "top": $(document).scrollTop() + ($(window).height() - popWin.outerHeight()) / 2
                    });
                } else {
                    popWin.css({
                        "left": ($(window).width() - popWin.outerWidth()) / 2,
                        "top": ($(window).height() - popWin.outerHeight()) / 2
                    });
                }
            }
            $(window).resize(_i.setPos);

            _i.ui_overlay = c.find(".xy-ui-overlay");
            _i.ui_close = c.find(".xy-ui-close");

            //弹窗事件
            _i.callback();
        },
        callback: function () {
            var _i = this, opt = _i.config;

            opt.onShow && opt.onShow(_i);
            //弹窗自动关闭
            if (opt.time) {
                setTimeout(function () {
                    _i.close();
                }, opt.time * 1000);
            }

            //按钮事件
            _i.popWin.find(".xy-ui-btns a").on("click", function () {
                var index = $(this).index();

                if (index === 0) { //默认是确定按钮 [第一个按钮，可以写btn1]
                    opt.onOk ? (_i.close(), opt.onOk(_i)) : _i.close();
                } else if (index === 1) { //默认是取消按钮 [第二个按钮，可以写btn2]
                    _i.close();
                } else {
                    opt["btn" + (index + 1)] && _i.close();
                }
                opt["btn" + (index + 1)] && opt["btn" + (index + 1)](_i);
            });
            //右上角关闭
            if (_i.ui_close[0]) {
                _i.ui_close.on("click", function () {
                    _i.close();
                });
            }

            //点击锁屏重置窗体位置 (双击关闭弹窗)
            _i.ui_overlay.on("click", function () {
                _i.setPos();
            });
        },
        //关闭弹窗
        close: function () {
            var _i = this, opt = _i.config;

            if ($("#" + opt.id)) {
                $("#" + opt.id).remove();
            }
            opt.onClose && opt.onClose(_i); //执行关闭事件
        },
        //关闭页面所有弹窗(根据页面唯一弹窗标识)
        closeAll: function () {
            $("." + this.config.dom).each(function () {
                $(this).remove();
            });
        },
        //获取弹窗最大层级
        maxIndex: function () {
            for (var idx = this.config.zIndex, elem = $("*"), i = 0, len = elem.length; i < len; i++)
                idx = Math.max(idx, elem[i].style.zIndex);
            return idx;
        }
    };

    //提供外部访问接口
    var interface = (function () {
        /*
         ===多功能消息弹窗(合并alert和confirm)(可接收三个参数[可向左容错])===
         1. 参数1个 信息内容
         2. 参数2个 {a:1~2组合[信息内容~配置参数] | b:1~3组合[信息内容~执行函数]}
         3. 参数3个 {a:1~2~3组合[信息内容~定时关闭~执行函数] | b:1~2~3组合[信息内容~配置参数~执行函数]}
         */
        exports = function (content, options, fn) {
            Factory(
                typeof content === "object" ? arguments[0] : $.extend({
                    content: content,
                    onOk: typeof options === "function" ? options : fn,
                    btn: arguments.length === 3 ? ["确定", "取消"] : typeof options === "function" ? ["确定", "取消"] : ["关闭"]
                }, options || {})
            );
        };

        /*
         ===简单信息弹窗(可接收三个参数[可向左容错])===
         1. 参数1个 信息内容
         2. 参数2个 {a:1~2组合[信息内容~配置参数] | b:1~3组合[信息内容~执行函数]}
         3. 参数3个 信息内容~配置参数~执行函数
         */
        exports.msg = function (content, options, fn) {
            Factory(
                $.extend({
                    title: false,
                    content: content,
                    time: 3,
                    bottom: false,
                    onClose: typeof options === "function" ? options : fn
                }, options || {})
            );
        };

        /*
         ===加载外部css与js===
         1. 	xyPop.load("skin/xyPop.css");				//默认方式
         xyPop.load("skin/xyPop.css, aaa.css");		//使用逗号分隔  ("a, b, c, d......")
         xyPop.load(["skin/xyPop.css", "aaa.css"]);	//使用数组形式 (["a", "b", "c", "d"......])
         2.	加载js方法同上
         */
        exports.load = function (path) {
            //加载多个文件
            var file = $.isArray(path) ? path : $.trim(path).replace(/[ ]{2,}/g, " ").split(",");
            $.each(file, function (i, v) {
                var f = file[i].replace(/\s/g, ""),
                    isCss = /\.css$/.test(f),
                    node = document.createElement(isCss ? "link" : "script"),
                    //唯一标识
                    id = "xyPopTag_" + f.replace(/(\.|\/|\:)/g, "");

                isCss && (node.rel = "stylesheet");
                node[isCss ? "href" : "src"] = f;
                node.id = id;

                if (!$("#" + id)[0]) {
                    $("head")[0].appendChild(node);
                }
            });
        };

        return exports;
    }());

    //加载css文件
    interface.load("skin/xyPop.css");

    //提供外部接口
    w.xyPop = interface;

}(window, jQuery);