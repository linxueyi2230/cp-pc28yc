<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>PC蛋蛋单双 - 火车预测</title>
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
<div class="yuce" style="border: 1px solid #d2d2d2">
    <table class="table table-bordered">
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:20px;background:rgba(55, 71, 79, 0.86)"
                colspan="5"><a href="/"
                               style="color:#ff7373;">PC蛋蛋单双 - 火车预测</a></td>
        </tr>
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:16px;"
                colspan="5">总共预测PC蛋蛋<strong
                    style="color: red;">${KenoYuce.size()}</strong>期数据
            </td>
        </tr>
        <tr style="background-color:#eaeaea;">
            <td align="center" style="vertical-align: inherit;">期号</td>
            <td align="center" style="vertical-align: inherit;">时间</td>
            <td align="center" style="vertical-align: inherit;">开奖结果</td>
            <td align="center" style="vertical-align: inherit;">开奖预测</td>
            <td align="center" style="vertical-align: inherit;">预测结果</td>
        </tr>
        <c:forEach items="${KenoYuce}" var="kenoYc" begin="0" end="0">
            <tr>
                <td align="center"
                    style="vertical-align: inherit;">${kenoYc.id}</td>
                <td align="center" style="vertical-align:
                inherit;">${kenoYc.date}</td>
                <td align="center"
                    style="vertical-align: inherit;">...
                </td>
                <td>
                    <c:choose>
                        <c:when test="${kenoYc.yuce%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>双</strong>
                            </div>
                        </c:when>
                        <c:when test="${kenoYc.yuce%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>单</strong>
                            </div>
                        </c:when>
                    </c:choose>
                </td>
                <td align="center"
                    style="vertical-align: inherit;">${kenoYc.result}</td>
            </tr>
        </c:forEach>

        <c:forEach items="${KenoYuce}" var="kenoYc" begin="1" end="30">
            <tr>
                <td align="center"
                    style="vertical-align: inherit;">${kenoYc.id}</td>
                <td align="center" style="vertical-align:
                inherit;">${kenoYc.date}</td>
                <td align="center"
                    style="vertical-align: inherit;">${kenoYc.number}=<strong
                        style="color:red;">${kenoYc.result}</strong>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${kenoYc.yuce%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>双</strong>
                            </div>
                        </c:when>
                        <c:when test="${kenoYc.yuce%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>单</strong>
                            </div>
                        </c:when>
                    </c:choose>
                </td>
                <td align="center">
                    <c:choose>
                        <c:when
                                test="${(kenoYc.yuce%2==0&&kenoYc.result%2==0)||(kenoYc.yuce%2!=0&&kenoYc.result%2!=0)}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中啦</strong>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div
                                    style="width:100%;height:100%;">
                                <strong style="color:green">输了</strong>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<br>
<div id="ban">
    <ul class="list-inline" style="text-align: center;padding-top: 6px;">
        <li>
            <button type="button" class="btn" onclick="window.location.href='/'">主页</button>
        </li>
        <li>
            <button type="button" class="btn" onclick="window.location.href='/Keno/KenoDsYuceChange.html'">更换算法
            </button>
        </li>
        <li>
            <button type="button" class="btn"onclick="window.location.href='/Keno/KenoDsYuce.html'">刷新</button>
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
            location.href = "/Keno/KenoDsYuce.html";
        }
    }
    setInterval("AutoRefresh()", 1000);
</script>
</body>
</html>
