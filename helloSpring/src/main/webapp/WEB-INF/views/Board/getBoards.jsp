<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<table border="1" style="width:500px">
<tr><td>번호</td><td>TITLE</td><td>글쓴이</td><td>내용</td><td>올린날짜</td><td>조회수</td></tr>
<c:forEach items="${list}" var="board">
<tr><td>${board.seq}</td><td>${board.title}</td><td>${board.writer}</td><td>${board.content}</td><td>${board.regdate}</td><td>${board.cnt}</td></tr>;
</c:forEach>

</table>

</body>
</html>