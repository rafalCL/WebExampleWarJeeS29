<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>jsp1.jsp</title>
</head>
<body>
    <c:out value="${userRole}" default="guest" />
</body>
</html>
