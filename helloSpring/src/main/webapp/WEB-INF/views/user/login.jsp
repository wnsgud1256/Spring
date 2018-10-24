<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
${userDTO}<hr>
${user}<hr>			<!-- 아이디와 패스워드 값이 넘어오는것을 확인 할수 있음 /web.xml에 필터를 걸지 않으면 화면이 꺠짐 -->
<h3>회원정보등록</h3>
<form action="./login.do" method="post">
	id <input type="text" name="id" value="${user.id}"><br>
	pw <input type="text" name="password" value="${user.password}"><br>
	<input type="submit" value="로그인"/>

</form>
</body>
</html>