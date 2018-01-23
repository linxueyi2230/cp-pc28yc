<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html mip>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1,initial-scale=1">
    <title>PC蛋蛋火车预测-做全网最专业的28预测分析</title>
    <meta name="keywords"
          content="PC蛋蛋火车预测,加拿大28火车预测,PC蛋蛋开奖查询,加拿大28开奖查询,PC蛋蛋随机预测,加拿大28随机预测,提供最专业的预测软件!">
    <meta name="description"
          content="PC蛋蛋火车预测,加拿大28火车预测,PC蛋蛋开奖查询,加拿大28开奖查询,PC蛋蛋随机预测,加拿大28随机预测,提供最专业的预测软件!">
    <link rel="stylesheet" type="text/css" href="https://mipcache.bdstatic.com/static/v1/mip.css">
    <link rel="shortcut icon" href="./images/favicon.ico">
    <link rel="stylesheet" href="./css/sweet-alert.css"/>
    <link rel="stylesheet" href="./css/fakeLoader.css"/>
    <link rel="stylesheet" href="./css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./css/style.css"/>
    <link rel="stylesheet" href="./css/banner.css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
</head>
<body>
<div class="index_top">
    <div class="index_top_one">PC蛋蛋火车预测</div>
</div>

<!--banner start-->
<div class="main_visual">
    <div class="main_image">
        <ul>
            <li><span class="img_1"><img
                    src="./images/banner/img_banner_1.png" width="100%"
                    height="170px"/> </span></li>
            <li><span class="img_1"><img
                    src="./images/banner/img_banner_1.png" width="100%"
                    height="170px"/> </span></li>
        </ul>
        <a href="javascript:;" id="btn_prev"></a>
        <a href="javascript:;" id="btn_next"></a>
    </div>
</div>
<!--end banner-->
<div class="tcss">
    <table class="table table-bordered">
        <tr>
            <td align="center" colspan="2" id="loading">PC蛋蛋加拿大28火车预测</td>
        </tr>
        <tr>
            <td align="center"><a href="/Keno/KenoInfo.html">PC蛋蛋开奖查询</a></td>
            <td align="center"><a href="/Canada/CanadaInfo.html">加拿大28开奖查询</a>
            </td>
        </tr>
        <tr>
            <td align="center"><a href="/Keno/KenoTrend.html">PC蛋蛋走势图</a></td>
            <td align="center"><a href="/Canada/CanadaTrend.html">加拿大28走势图</a>
            </td>
        </tr>
        <tr>
            <td align="center"><a href="/Keno/KenoYuce.html">PC蛋蛋组合预测</a></td>
            <td align="center"><a href="/Canada/CanadaYuce.html">加拿大28组合预测</a>
            </td>
        </tr>
        <tr>
            <td align="center"><a href="/Keno/KenoDxYuce.html">PC蛋蛋大小预测</a></td>
            <td
                    align="center"><a
                    href="/Canada/CanadaDxYuce.html">加拿大28大小预测</a></td>
        </tr>
        <tr>
            <td align="center"><a href="/Keno/KenoDsYuce.html">PC蛋蛋单双预测</a></td>
            <td
                    align="center"><a
                    href="/Canada/CanadaDsYuce.html">加拿大28单双预测</a></td>
        </tr>
        <tr>
            <td align="center"><a href="#" onclick="update()">PC蛋蛋火车预测</a></td>
            <td
                    align="center"><a
                    href="#" onclick="update()">加拿大28火车预测</a></td>
        </tr>
        <tr>
            <td align="center" colspan="2">PC蛋蛋火车预测免责声明</td>
        </tr>
        <tr>
            <td colspan="2" style="font-size: 14px;">本页仅针对PC蛋蛋官方平台（www.pceggs.com）
                用户提供数据测试，仅供参考，严禁以任何形式用于其他非正规平台，请各位网友严格自律，
                否则风险自负，数据来源：北京快乐8、加拿大国外官方网站。
            </td>
        </tr>
    </table>
</div>

<script src="https://mipcache.bdstatic.com/static/v1/mip.js"></script>
<script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/fakeLoader.min.js"></script>
<script type="text/javascript" src="./js/jquery.event.drag-1.5.min.js"></script>
<script type="text/javascript" src="./js/jquery.touchSlider.js"></script>
<script type="text/javascript" src="./js/alert.js"></script>
<script type="text/javascript" src="./js/moshi.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type="text/javascript">

    $(document).ready(function () {

        $(".main_visual").hover(function () {
            $("#btn_prev,#btn_next").fadeIn()
        }, function () {
            $("#btn_prev,#btn_next").fadeOut()
        });

        $dragBln = false;

        $(".main_image").touchSlider({
            flexible: true,
            speed: 200,
            btn_prev: $("#btn_prev"),
            btn_next: $("#btn_next"),
            paging: $(".flicking_con a"),
            counter: function (e) {
                $(".flicking_con a").removeClass("on").eq(e.current - 1).addClass("on");
            }
        });

        $(".main_image").bind("mousedown", function () {
            $dragBln = false;
        });

        $(".main_image").bind("dragstart", function () {
            $dragBln = true;
        });

        $(".main_image a").click(function () {
            if ($dragBln) {
                return false;
            }
        });

        timer = setInterval(function () {
            $("#btn_next").click();
        }, 3000);

        $(".main_visual").hover(function () {
            clearInterval(timer);
        }, function () {
            timer = setInterval(function () {
                $("#btn_next").click();
            }, 3000);
        });

        $(".main_image").bind("touchstart", function () {
            clearInterval(timer);
        }).bind("touchend", function () {
            timer = setInterval(function () {
                $("#btn_next").click();
            }, 3000);
        });

    });
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?e793b040336ff6f3c4bc9b093f2418c9";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>
