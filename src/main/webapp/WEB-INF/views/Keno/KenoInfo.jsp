<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>PC蛋蛋开奖查询 - 火车预测</title>
    <meta name="keywords"
          content="PC蛋蛋火车预测,PC蛋蛋贴吧交流,PC蛋蛋预测软件,PC蛋蛋走势图,PC蛋蛋开奖查询,免费提供绿色、无广告的PC蛋蛋预测交流网站!">
    <meta name="description"
          content="PC蛋蛋火车预测,PC蛋蛋贴吧交流,PC蛋蛋预测软件,PC蛋蛋走势图,PC蛋蛋开奖查询,免费提供绿色、无广告的PC蛋蛋预测交流网站!">
    <link rel="shortcut icon" href="../images/favicon.ico">
    <link rel="stylesheet" href="../css/sweet-alert.css"/>
    <link rel="stylesheet" href="../css/fakeLoader.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<!-- yuce start -->
<div class="yuce">
    <table class="table table-bordered">
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:20px;background:rgba(55, 71, 79, 0.86)"
                colspan="3"><a href="/"
                               style="color:#ff7373;">PC蛋蛋开奖查询 - 火车预测</a></td>
        </tr>
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:16px;"
                colspan="3">总共获取PC蛋蛋<strong
                    style="color: red;">${Keno.size()}</strong>期数据
            </td>
        </tr>
        <tr style="background-color:#eaeaea;">
            <td align="center" style="vertical-align: inherit;">开奖期号</td>
            <td align="center" style="vertical-align: inherit;">开奖时间</td>
            <td align="center" style="vertical-align: inherit;">开奖结果</td>
        </tr>
        <c:forEach items="${Keno}" var="keno" begin="0" end="30">
            <tr>
                <td align="center"
                    style="vertical-align: inherit;">${keno.id}</td>
                <td align="center" style="vertical-align:
                inherit;">${keno.date}</td>
                <td align="center"
                    style="vertical-align: inherit;">${keno.number}=<strong
                        style="color:red;">${keno.result}</strong></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<br>
<div id="ban">
    <ul class="list-inline" style="text-align: center;padding-top: 6px;">
        <li>
            <button type="button" class="btn" onclick="window.location.href='/'">
                主页
            </button>
        </li>
        <li>
            <button type="button" class="btn" onclick="window.location.href='/Keno/KenoInfo.html'">
                刷新
            </button>
        </li>
    </ul>
</div>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/sweet-alert.min.js"></script>
<script type="text/javascript" src="../js/fakeLoader.min.js"></script>
<script type="text/javascript" src="../js/moshi.js"></script>
<script type="text/javascript">
    function AutoRefresh() {
        var date = new Date();
        var m = date.getMinutes();
        var s = date.getSeconds();
        if ((m == 1 && s == 1) || (m == 6 && s == 1) || (m == 11 && s == 1) || (m == 16 && s == 1) || (m == 21 && s == 1) || (m == 26 && s == 1) || (m == 31 && s == 1) || (m == 36 && s == 1) || (m == 41 && s == 1) || (m == 46 && s == 1) || (m == 51 && s == 1) || (m == 56 && s == 1)) {
            location.href = "/Keno/KenoInfo.html";
        }
    }
    setInterval("AutoRefresh()", 1000);
</script>
</body>
</html>
