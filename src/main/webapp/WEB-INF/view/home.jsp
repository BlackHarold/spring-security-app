<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 20.02.2020
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Company Home Page</h2>
<hr>
<p>Ошибки быть не должно</p>
<p>
    User: <security:authentication property="principal.username"/>
</p>
<p>
    Role(s): <security:authentication property="principal.authorities"/>
</p>


<hr>
<%--Add link to point to /leaders for managers--%>
<security:authorize access="hasRole('MANAGER')">
    <p><a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for Manager peeps)
    </p>
</security:authorize>
<hr>
<security:authorize access="hasRole('ADMIN')">
    <p><a href="${pageContext.request.contextPath}/systems">Administrator Console</a>
        (Only for Admins)
    </p>
</security:authorize>
<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
