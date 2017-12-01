<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>使用WebSocket通信</title>
</head>

<body>
<div style="width:600px; height:240px; overflow-y:auto; border:1px solid #333;" id="show"></div>
<input type="text" size="80" id="msg" name="msg" placeholder="输入聊天内容"/>
<input type="button" value="发送" id="sendBtn" name="sendBtn"/>

<script type="text/javascript">
    var webSocket = new WebSocket("ws://127.0.0.1:8080/firstSpring/websocket/chat");
    var sendMsg = function () {
        var inputElement = document.getElementById('msg');
        // 发送消息(核心代码是webSocket.send()函数)
        webSocket.send(inputElement.value);
        // 清空单行文本框
        inputElement.value = "";
    }
    var send = function (event) {
        if (event.keyCode == 13) {
            sendMsg();
        }
    };
    webSocket.onopen = function () {
        webSocket.onmessage = function (event) {
            var show = document.getElementById("show");
            // 接收并显示消息(核心内容是event.data)
            show.innerHTML += event.data + "<br/>";
            show.scrollTop = show.scrollHeight;
        }
        document.getElementById("msg").onkeydown = send;
        document.getElementById("sendBtn").onclick = sendMsg;
    };
    webSocket.onclose = function (event) {
        document.getElementById("msg").onkeydown = null;
        document.getElementById("sendBtn").onclick = null;
        console.log("websocket已关闭");
    }
</script>
</body>
</html>
