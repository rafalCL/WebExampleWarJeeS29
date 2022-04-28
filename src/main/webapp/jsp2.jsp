<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>jsp2.jsp</title>
</head>
<body>
    <c:if test="${not empty end}">
        <c:forEach var="i" begin="${start}" end="${end}">
            <div>${i}</div>
        </c:forEach>
    </c:if>
</body>
</html>
