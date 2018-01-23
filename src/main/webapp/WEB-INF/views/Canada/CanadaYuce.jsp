<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>加拿大28组合 - 火车预测</title>
    <meta name="keywords"
          content="加拿大28火车预测,加拿大28组合预测,加拿大28贴吧交流,加拿大28预测软件,加拿大28走势图,加拿大28开奖查询,免费提供绿色、无广告的加拿大28预测交流网站!">
    <meta name="description"
          content="加拿大28火车预测,加拿大28组合预测,加拿大28贴吧交流,加拿大28预测软件,加拿大28走势图,加拿大28开奖查询,免费提供绿色、无广告的加拿大28预测交流网站!">
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
                               style="color:#ff7373;">加拿大28组合 - 火车预测</a></td>
        </tr>
        <tr>
            <td align="center"
                style="vertical-align: inherit;font-size:16px;"
                colspan="5">总共预测加拿大<strong
                    style="color: red;">${CanadaYuce.size()}</strong>期数据
            </td>
        </tr>

        <tr style="background-color:#eaeaea;">
            <td align="center" style="vertical-align: inherit;">期号</td>
            <td align="center" style="vertical-align: inherit;">时间</td>
            <td align="center" style="vertical-align: inherit;">开奖结果</td>
            <td align="center" style="vertical-align: inherit;">开奖预测</td>
            <td align="center" style="vertical-align: inherit;">预测结果</td>
        </tr>
        <c:forEach items="${CanadaYuce}" var="canadaYc" begin="0" end="0">
            <tr>
                <td align="center"
                    style="vertical-align: inherit;">${canadaYc.id}</td>
                <td align="center" style="vertical-align:
                inherit;">${canadaYc.date}</td>
                <td align="center"
                    style="vertical-align: inherit;">...
                </td>
                <td>
                    <c:choose>
                        <c:when test="${canadaYc.yuce>=14&&canadaYc.yuce%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>大☆双</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce>=14&&canadaYc.yuce%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>大☆单</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce<=13&&canadaYc.yuce%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>小☆双</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce<=13&&canadaYc.yuce%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>小☆单</strong>
                            </div>
                        </c:when>
                    </c:choose>
                </td>
                <td align="center"
                    style="vertical-align: inherit;">${canadaYc.result}</td>
            </tr>
        </c:forEach>

        <c:forEach items="${CanadaYuce}" var="canadaYc" begin="1" end="30">
            <tr>
                <td align="center"
                    style="vertical-align: inherit;">${canadaYc.id}</td>
                <td align="center" style="vertical-align:
                inherit;">${canadaYc.date}</td>
                <td align="center"
                    style="vertical-align: inherit;">${canadaYc.number}=<strong
                        style="color:red;">${canadaYc.result}</strong>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${canadaYc.yuce>=14&&canadaYc.yuce%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>大☆双</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce>=14&&canadaYc.yuce%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>大☆单</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce<=13&&canadaYc.yuce%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>小☆双</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce<=13&&canadaYc.yuce%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong>小☆单</strong>
                            </div>
                        </c:when>
                    </c:choose>
                </td>
                <td align="center">
                    <c:choose>
                        <c:when
                                test="${canadaYc.yuce>=14&&canadaYc.yuce%2==0&&canadaYc.result>=14&&canadaYc.result%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆组合</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce>=14&&canadaYc.yuce%2!=0&&canadaYc.result>=14&&canadaYc.result%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆组合</strong>
                            </div>
                        </c:when>
                        <c:when
                                test="${canadaYc.yuce<=13&&canadaYc.yuce%2==0&&canadaYc.result<=13&&canadaYc.result%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆组合</strong>
                            </div>
                        </c:when>
                        <c:when
                                test="${canadaYc.yuce<=13&&canadaYc.yuce%2!=0&&canadaYc.result<=13&&canadaYc.result%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆组合</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce>=14&&canadaYc.result>=14}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆大小</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce<=13&&canadaYc.result<=13}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆大小</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce%2==0&&canadaYc.result%2==0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆单双</strong>
                            </div>
                        </c:when>
                        <c:when test="${canadaYc.yuce%2!=0&&canadaYc.result%2!=0}">
                            <div style="width:100%;height:100%;text-align: center;">
                                <strong style="color:red">中☆单双</strong>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div
                                    style="width:100%;height:100%;">
                                <strong style="color:green">啥也没中</strong>
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
            <button type="button" class="btn" onclick="window.location.href='/'">
                主页
            </button>
        </li>
        <li>
            <button type="button" class="btn" onclick="window.location.href='/Canada/CanadaYuceChange.html'">
                更换算法
            </button>
        </li>
        <li>
            <button type="button" class="btn" onclick="window.location.href='/Canada/CanadaYuce.html'">
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
        if ((m == 1 && s == 1) || (m == 4 && s == 1)
            || (m == 7 && s == 1) || (m == 10 && s == 1)
            || (m == 13 && s == 1) || (m == 17 && s == 1)
            || (m == 20 && s == 1) || (m == 23 && s == 1)
            || (m == 27 && s == 1) || (m == 30 && s == 1)
            || (m == 33 && s == 1) || (m == 37 && s == 1)
            || (m == 40 && s == 1) || (m == 43 && s == 1)
            || (m == 47 && s == 1) || (m == 50 && s == 1)
            || (m == 53 && s == 1) || (m == 57 && s == 1)) {
            location.href = "/Canada/CanadaYuce.html";
        }
    }
    setInterval("AutoRefresh()", 1000);
</script>
</body>
</html>
