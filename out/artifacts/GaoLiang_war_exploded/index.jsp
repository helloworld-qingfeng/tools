<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图新专利案件辅助检查系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body id="cdp" bgcolor="#e0ffff">
<center><font color=#00FF00; face="隶书" size=5>专利案件辅助检查系统</font><a href="http://39.103.173.150">(点我进入自动标号系统)</a></center>
<br>
<object type="text/x-scriptlet" width=49%; algin="left"  height=100% data="${pageContext.request.contextPath}/check.jsp">
</object>
<object type="text/x-scriptlet" width=49%; algin="right"  height=100% data="${pageContext.request.contextPath}/Picture.jsp">
</object>
<br>
<SCRIPT LANGUAGE="JavaScript">
    document.oncontextmenu=new Function("event.returnValue=true");
    document.onselectstart=new Function("event.returnValue=true");
    function goHist(a)
    {
        history.go(a);
    }
</script>
<br>
</body>
</html>

