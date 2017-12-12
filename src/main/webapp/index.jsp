<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>中国移动交流网站</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css">
</head>

<body>
    <%--hello, spring mvc index.--%>
    <div id="root"></div>
    <script src="./js/common.js"></script>
    <script src="./js/index.js"></script>
    <script>
        window.onload = function () {
            setTimeout(function () {
                window.location.href = "/MySpring/#/webdata/list";
            }, 500);
        }
    </script>
</body>
</html>
