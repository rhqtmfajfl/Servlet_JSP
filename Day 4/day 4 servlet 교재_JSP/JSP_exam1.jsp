language="java" jsp 에서 실행되는 언어는 자바이다라는 의미  
contentType="text/html; charset=UTF-8"  

jsp를 servlet으로 변화해라고 할때 사용하는 지시자 태그
<%@  %> 태그

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제1</title>   타이틀 태그
</head>
<body>
<h1>JSP 맛보기</h1>
  
<hr>
  
<h3>현재 시간 정보 : <%= java.time.LocalDateTime.now()%></h3>   /------> 날짜와  시간 까지면 localdatetime , 날짜 까지면 localdate
  
                    = 은 표현식 태그는 자바 식만 줄 수 있다 연산식 호출식 위에 세미콜론 주면 안된다.
  
                    @ 지시자 태그
  
  
                    <%= 여기까지가 jsp  
  
</body>
</html>
