<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/15
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>statics/css/index.css">
</head>
<body>
<h2>Test success!</h2>

dog:${requestScope.dog}

<br>

attribute:${requestScope.attribute}

</body>
</html>
