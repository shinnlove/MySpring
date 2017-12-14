<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<title>中国移动交流网站</title>--%>
    <%--<link rel="stylesheet" type="text/css" href="./css/index.css">--%>
<%--</head>--%>

<%--<body>--%>
    <%--&lt;%&ndash;hello, spring mvc index.&ndash;%&gt;--%>
    <%--<div id="root"></div>--%>
    <%--<script src="./js/common.js"></script>--%>
    <%--<script src="./js/index.js"></script>--%>
<%--</body>--%>
<%--</html>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<title>中国移动交流网站</title>--%>
    <%--<link rel="stylesheet" type="text/css" href="./css/index.css?<%=Math.random()%>">--%>
<%--</head>--%>

<%--<body>--%>
<%--&lt;%&ndash;hello, spring mvc index.&ndash;%&gt;--%>
<%--<div id="root"></div>--%>
<%--<script src="./js/common.js?<%=Math.random()%>"></script>--%>
<%--<script src="./js/index.js?<%=Math.random()%>"></script>--%>
<%--</body>--%>
<%--</html>--%>


<%--=======================================================================================--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>中国移动交流网站</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css?<%=new java.util.Random().nextInt(100) %>">
</head>

<body>
<%--hello, spring mvc index.--%>
<div id="root"></div>
<script src="./js/common.js?<%=new java.util.Random().nextInt(100) %>"></script>
<script src="./js/index.js?<%=new java.util.Random().nextInt(100) %>"></script>
</body>
</html>