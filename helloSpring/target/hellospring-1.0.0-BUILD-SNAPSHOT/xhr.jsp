<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spingxhr.jsp</title>
<script>
	function dupcheck(){
		//1.xhr 객체 생성
		var xhr = new XMLHttpRequest();
		
		//2. 콜백함수 이용
		xhr.onreadystatechange = function() {
			if( xhr.readyState == 4 ) { //전송 완료
			 if( xhr.status == 200) { //전송 OK
				 //Json변환할떄 JsonIgnore를 쓰면 해당 이그노어를 쓴곳을 제외 하고 변환함
				 //
				 //var jsondata = eval( "(" + xhr.responseText + ")");
			 	 //값을 두개이상 넘길려면 json 타입으로 변경후 값을 넘기는게 좋음.
			 	 //JSON은 자바스크립트에 내장되어있음.
			 	 //결과처리 -json
				 //var jsondata = JSON.parse( xhr.responseText );//json데이터로 변환처리 String 을 object로 바꿈 : 괄호안에있는  xhr.responseText를 json타입으로 바꿈 
				 //document.getElementById("result").innerHTML = jsondata.userid + ":" +jsondata.result;
				 
				 
				 //결과처리 - xml
				var datas = xhr.responseXML;
				var userid = datas.getElementsByTagName("userid")[0].firstChild.nodeValue;
				var result = datas.getElementsByTagName("result")[0].firstChild.nodeValue;
				document.getElementById("result").innerHTML = "xml: "+userid + ":" + result;
			 }else{
				 //에러메시지
				 alert(xhr.status + ":" + xhr.statusText );
			 }
			}else{
				//로딩중 이미지
				document.getElementById("result").innerHTML = "처리중";
			}
		}
		//3. open함수 이용(서버연결)
		//3.1 쿼리 문자열 추가
		var param="?id=" + document.getElementById("userid").value;
		xhr.open("get" , "LoginCheck.do"+param );//요청방식 
		//4. send
		xhr.send();
	}
//보통은 콜백함수를 따로만듬
</script>
</head>
<body>

	<form>
	<input type="text" name="userid" id="userid" onchange="dupcheck()"/><span id="result"></span>
	<input type="text" name="userpw" id="userpw"/>
	<input type="submit" value="로그인" />
	</form>
	
</body>
</html>