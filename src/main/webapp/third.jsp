<%--
  Created by IntelliJ IDEA.
  User: edu
  Date: 28.04.2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>is present</title>
</head>
<body>
    ${empty param.a or empty param.b ? "empty": param.a.concat(", ").concat(param.b)}
</body>
</html>
