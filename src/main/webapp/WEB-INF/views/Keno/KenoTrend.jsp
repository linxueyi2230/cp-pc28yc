<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>PC蛋蛋走势查询 - 火车预测</title>
    <meta name="keywords"
          content="PC蛋蛋火车预测,PC蛋蛋贴吧交流,PC蛋蛋预测软件,PC蛋蛋走势图,PC蛋蛋开奖查询,免费提供绿色、无广告的PC蛋蛋预测交流网站!">
    <meta name="description"
          content="PC蛋蛋火车预测,PC蛋蛋贴吧交流,PC蛋蛋预测软件,PC蛋蛋走势图,PC蛋蛋开奖查询,免费提供绿色、无广告的PC蛋蛋预测交流网站!">
    <link rel="shortcut icon" href="../images/favicon.ico">
    <link rel="stylesheet" href="../css/sweet-alert.css"/>
    <link rel="stylesheet" href="../css/fakeLoader.css"/>
    <link rel="stylesheet" href="../css/bootstrap.ming.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<!-- yuce start -->
<div class="yuce">
    <table class="table table-bordered">
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:23px;background:rgba(55, 71, 79, 0.86)"
                colspan="10"><a href="/"
                               style="color:#ff7373;">PC蛋蛋走势图 - 火车预测</a></td>
        </tr>
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:16px;"
                colspan="10">总共分析PC蛋蛋<strong
                    style="color: red;">${KenoTrend.size()}</strong>期数据</td>
        </tr>
        <tr style="background-color:#eaeaea;">
            <td align="center" style="vertical-align: inherit;">期号</td>
            <td align="center" style="vertical-align: inherit;">开奖号</td>
            <td align="center" style="vertical-align: inherit;">大</td>
            <td align="center" style="vertical-align: inherit;">小</td>
            <td align="center" style="vertical-align: inherit;">单</td>
            <td align="center" style="vertical-align: inherit;">双</td>
            <td align="center" style="vertical-align: inherit;">小双</td>
            <td align="center" style="vertical-align: inherit;">小单</td>
            <td align="center" style="vertical-align: inherit;">大双</td>
            <td align="center" style="vertical-align: inherit;">大单</td>
        </tr>
        <c:forEach items="${KenoTrend}" var="kenoTrend" begin="0" end="30">
            <tr>
                <td align="center" style="vertical-align:
                inherit;">${kenoTrend.id}</td>
                <td align="center" style="vertical-align:
                inherit;">${kenoTrend.number}=<strong style="color:red;">${kenoTrend.result}</strong></td>
                <td align="center" style="vertical-align: inherit;">
                    <c:if test="${kenoTrend.result>=14}"><div style="background-color:#ef5b9c;color:white;border-radius: 2px;">大</div></c:if>
                </td>
                <td align="center" style="vertical-align: inherit;">
                    <c:if test="${kenoTrend.result<=13}"><div style="background-color:#009ad6;color:white;border-radius: 2px;">小</div></c:if>
                </td>
                <td align="center" style="vertical-align: inherit;">
                    <c:if test="${kenoTrend.result%2!=0}"><div style="background-color:orange;color:white;border-radius: 2px;">单</div></c:if>
                </td>
                <td align="center" style="vertical-align: inherit;">
                    <c:if test="${kenoTrend.result%2==0}"><div style="background-color:#45b97c;color:white;border-radius: 2px;">双</div></c:if>
                </td>
                <td align="center">
                    <c:if test="${kenoTrend.result%2==0&&kenoTrend.result<=13}">
                        <div style="background-color:#6f60aa;color:white;border-radius: 2px;">小双</div>
                    </c:if>
                </td>
                <td align="center" >
                    <c:if test="${kenoTrend.result%2!=0&&kenoTrend.result<=13}">
                        <div style="background-color:#00a6ac;color:white;border-radius: 2px;">小单</div>
                    </c:if>
                </td>
                <td align="center" >
                    <c:if test="${kenoTrend.result%2==0&&kenoTrend.result>=14}">
                        <div style="background-color:#f47a55;color:white;border-radius: 2px;">大双</div>
                    </c:if>
                </td>
                <td align="center" >
                    <c:if test="${kenoTrend.result%2!=0&&kenoTrend.result>=14}">
                        <div style="background-color:#b2d235;color:white;border-radius: 2px;">大单</div>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
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
            <button type="button" class="btn" onclick="window.location.href='/Keno/KenoTrend.html'">
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
            location.href = "/Keno/KenoTrend.html";
        }
    }
    setInterval("AutoRefresh()", 1000);
</script>
</body>
</html>
