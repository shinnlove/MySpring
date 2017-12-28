<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/artDialog/ui-dialog.css">
    <title>入口</title>
</head>

<body>
<div>
    <!--注意action提交的路径不能/开头，必须是相对路径，而且不需要前面的路径-->
    <h1>我向HRG闻漪发誓：价值观保证填写正确，否则年终绩效给我打325！</h1>
    <form name="randomForm" action="randomTeam" method="get">
        <input type="text" name="empId" placeholder="请输入你的工号"><br>
        <input type="text" name="empName" placeholder="请输入你的花名"><br>
        <input type="button" name="entry-btn" value="进入分组">
    </form>
</div>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/artDialog/dialog-min.js"></script>
<script type="text/javascript" src="../js/utils/utils-common.js"></script>
<script type="text/javascript">
    $(function () {

        $("body").on("click", "input[name='entry-btn']", function (e) {
            var empId = $("input[name='empId']").val();
            var empName = $("input[name='empName']").val();
            if (empId == "") {
                utils.ART.showDialog("请输入你的工号", "HRG闻漪对你说：想要325吗？");
                return false;
            }
            if (empName == "") {
                utils.ART.showDialog("请输入你的花名", "HRG闻漪对你说：想要325吗？");
                return false;
            }

            $("form[name='randomForm']").submit();

        });

    });
</script>
</body>
</html>
