<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!-- 태그 파일의 경로 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user/getUsers.jsp</title>
<script>
	function go_page(p) {
		document.frm.page.value = p;
		document.frm.submit();
	}
	function sort(s){
		document.frm.sort.value=s;
		document.frm.submit();
	}
</script>
</head>
<%-- <c:if test="${userSearchDTO.searchCondition=='id'}">
								<%out.print("selected='selected'");%>
								</c:if> --%><!--test:조건 -->

<body>
	<img src="./images/Koala.jpg" style="width: 200px">
	<a href="./getBoards.do">로그인</a>
	<a href="inserUser.do">등록하기</a>
	<div>
		<form action="getUsers.do" name="frm">
			<input type="hidden" name="page" value="1">
			<input type="hidden" name="sort" value="id">
			role<select name="role">
				<option value="">선택</option>
			<c:forEach items="${roleMap}" var="temp">
				<option value="${temp.key}">${temp.value}</option>
			</c:forEach>
			</select>
			<select name="searchCondition">
				<option value="id">아디</option>
				<option value="name">이름</option>
				</select>	
				<script>
				document.frm.searchCondition.value='${userSearchDTO.searchCondition}';
				</script> <!-- 자바스크립트에서 하는방법 -->
					
				<input type="text" name="searchKeyword"
				value="${userSearchDTO.searchKeyword}"> 
				<input type="submit" value="검색">
		</form>
	</div>
	<table border="1" style="width: 500px;">
		<tr>
			<td><a href="#" onclick="sort('id')">아이디</a></td>
			<td><a href="#" onclick="sort('name')">이름</a></td>
			<td>패스위드</td>
			<td>롤</td>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<td><a href="updateUserForm.do?id=${user.id}">${user.id}</a></td>
				<td>${user.name}</td>
				<td>${user.password}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>
	<!--jstl  %태그를 대체하기 위해 나온 태그들  <~~>	-->
	<my:paging paging="${paging}" />
	<!-- jsFunc="go" 펑션 이름도 넘겨줄수 있음. 자바스크립트로 쓸려면 펑션이름을 go라고 지어야함.-->
</body>
</html>