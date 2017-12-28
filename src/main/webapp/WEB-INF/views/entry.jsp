<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>入口</title>
</head>

<body>
<div>
    <!--注意action提交的路径不能/开头，必须是相对路径，而且不需要前面的路径-->
    <form action="randomTeam" method="get">
        <input type="text" name="empId" placeholder="请输入你的工号">
        <input type="text" name="empName" placeholder="请输入你的花名">
        <input type="text" name="domainAccount" placeholder="请输入你的域账号">
        <input type="submit" value="开始随机">
    </form>
</div>

</body>
</html>
