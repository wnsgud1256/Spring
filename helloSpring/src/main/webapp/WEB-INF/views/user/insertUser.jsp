<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<h3>회원정보등록</h3>
<form action="./insertUser.do">
	id <input type="text" name="id" value="${user.id}"><br>
	pw <input type="text" name="password" value="${user.password}"><br>
	name <input type="text" name="name" value="${user.name}"><br>
	role <input type="text" name="role" value="${user.role}"><br>
	<input type="submit" value="등록"/>

</form>
</body>
</html>