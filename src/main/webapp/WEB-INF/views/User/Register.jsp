<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>吧主PC蛋蛋预测|加拿大28预测|交流网</title>
    <meta name="keywords"
          content="PC蛋蛋,吧主预测,PC蛋蛋预测,PC蛋蛋吧主,PC蛋蛋贴吧,PC蛋蛋预测软件,PC蛋蛋中介,幸运28,加拿大28,免费提供绿色、无广告的PC蛋蛋预测交流网站!">
    <meta name="description"
          content="PC蛋蛋,吧主预测,PC蛋蛋预测,PC蛋蛋吧主,PC蛋蛋贴吧,PC蛋蛋预测软件,PC蛋蛋中介,幸运28,加拿大28,免费提供绿色、无广告的PC蛋蛋预测交流网站!">  <link rel="shortcut icon" href="../images/favicon.ico">
    <link rel="stylesheet" href="../css/sweet-alert.css"/>
    <link rel="stylesheet" href="../css/fakeLoader.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>

<div class="index_top">
    <div class="index_top_one">吧主PC蛋蛋|加拿大28
        |预测网<span style="font-size:15px; ">(Beta)</span></div>
</div>
<br>
<br>
<div style="padding-top: 40px;">
    <div class="form-group" style="text-align:center">
        <label for="eg_name">请输入蛋蛋昵称</label>
        <input type="text" class="form-control" id="eg_name"
               placeholder="请输入蛋蛋昵称">
    </div>
    <div class="form-group" style="text-align:center">
        <label for="eg_qq">请输入QQ号码</label>
        <input type="text" class="form-control" id="eg_qq"
               placeholder="请输入QQ号码">
    </div>
    <div class="form-group" style="text-align:center">
        <label for="eg_username">请输入登陆账号</label>
        <input type="text" class="form-control" id="eg_username"
               placeholder="请输入登陆账号">
    </div>
    <div class="form-group" style="text-align:center">
        <label for="eg_password">请输入登陆密码</label>
        <input type="password" class="form-control" id="eg_password"
               placeholder="请输入登陆密码">
    </div>
    <div class="form-group" style="text-align:center">
        <button type="submit" class="btn btn-default" id="submit">注册
        </button>
    </div>
    <div class="form-group" style="text-align:center;color: red;
    font-size: 16px;" id="erro_data">
    </div>
</div>

<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/sweet-alert.min.js"></script>
<script type="text/javascript" src="../js/fakeLoader.min.js"></script>
<script type="text/javascript" src="../js/moshi.js"></script>
<script type="text/javascript" src="../js/regexp.js"></script>
<script type="text/javascript">
    $("#submit").click(function () {
        var name = $("#eg_name").val();
        var qq = $("#eg_qq").val();
        var username = $("#eg_username").val();
        var password = $("#eg_password").val();
        if (!isName(name)) {
            $("#erro_data").html("蛋蛋昵称建议在6~18位!")
            return;
        }
        if (!isQq(qq)) {
            $("#erro_data").html("QQ号建议在4~10位!")
            return;
        }
        if (!isUserName(username)) {
            $("#erro_data").html("登录账号建议在6~18位,必须是数字与字母组合!")
            return;
        }
        if (!isUserPassword(password)) {
            $("#erro_data").html("登录密码建议在6~18位,必须是数字与字母组合!")
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/User/addRegister',
            data: {name: name, qq: qq, username: username, password: password},
            success: function (data) {
                var json = eval('(' + data + ')')
                if (json.error.errorCode != 10000 || json.error.errorCode == '') {
                    $("#erro_data").html(json.error.errorInfo)
                    return;
                }else{
                    window.location.href="/User/toUserLogin";
                    return;
                }
            },
        });
    })
</script>
</body>
</html>