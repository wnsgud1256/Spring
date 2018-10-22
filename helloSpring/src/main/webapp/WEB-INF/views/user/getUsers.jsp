<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user/getUsers.jsp</title>
</head>
<body>
<a href="insertUserForm.do">회원등록</a>
<table border="1" style="width:500px">
<tr><td>아디</td><td>이름</td><td>패스위드</td><td>롤</td></tr>
<c:forEach items="${list}" var="user">
<tr><td><a href="updateUserForm.do?id=${user.id}">${user.id}</a></td><td>${user.name}</td><td>${user.password}</td><td>${user.role}</td></tr>;
</c:forEach>

</table>
 <!--jstl  %태그를 대체하기 위해 나온 태그들  <~~>	-->

</body>
</html>