<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<!-- 아이디와 패스워드 값이 넘어오는것을 확인 할수 있음 /web.xml에 필터를 걸지 않으면 화면이 꺠짐 -->
	<h3>회원정보등록</h3>
	<form action="./insertUser.do" method="post">
		id <input type="text" name="id" value="${user.id}"><br>
		pw <input type="text" name="password" value="${user.password}"><br>
		name <input type="text" name="name" value="${user.name}"><br>
		role<select name="role">
			<c:forEach items="${roleMap}" var="temp">
				<option value="${temp.key}">${temp.value}</option>
			</c:forEach>
		</select> 
		<input type="submit" value="등록" />
	</form>
</body>
</html>