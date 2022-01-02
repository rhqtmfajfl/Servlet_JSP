
표현식 태그로 다양하게 표현하기

우리가 간단하게

<%1> 는 선언문 변수
<%> 는 지역변수

컨테이너 이름ㅇ ㅣ카탈리나  

서블릿의 이름 

톰캣안에 들어가 있는 


서블릿에는 코요테


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>표현식 태그 점검</h1>
<hr>
<% int num = 10;%>   이부분을 주석처리하면 num 부분이 다 에러가 발생한다.
<%-- 는 jsp 전용 주석이다. --%>
<ul>
  
  식이되어야지 문장이 되어서는 안된다. 식은 끝에 ; 세미 콜론이 없다.   수행문장이 오면 안되고 식이 와야한다.
  
  
	<li><%= 100%></li>
	<li><%=num %></li>
	<li><%=++num %></li>
	<li><%= num*2 %></li>
	<li><%= "가나다".length() %></li>
	<li><%= num % 2 == 0%></li>
	
  
  <li><%= request.getParameter("stname") %></li>   내장 객체 변수
	<li><%= new java.util.Date(session.getCreationTime()) %></li>  세션객체가 만들어진 시간을 의미한다.
  jsp는 세션객체가 자동 생성된다 세션을 생성하든 안하든 세션 객체가 자동 생성된다.
  최초요청시 jsp는 자동 생성
  하지만 jsp의 세션 객체가 30분이상 서버에 요청을 안했을 때 삭제 된다.
    
	<li><%= application.getServerInfo() %></li>  내장 객체 변수이다.     아파치 톰캣....
		String getServerInfo()는 서버 정보를 구한다. 웹 컨테이너 이름과 버전 리턴,  jsp 컨테이너에 대한
		/ 정보)
	
	<li><%= application.getContextPath() %></li>	 내장 객체 변수이다.
	request.getContextPath()하무는 프로젝트 path만 가져온다.
	
	// 예 http://localhost:8080/project/list.jsp
	
	return /project를 가져온다.
	
	
  servlet context를 참조하는 내장객체 변수이다.
  //get방식으로 전달되는거든 
</ul>
</body>
</html>

내장 객체 이외의 함수 
request.getRequestURI() 함수 = 프로젝트 + 파일경로까지 가져옵니다.

출처: https://yi-chi.tistory.com/12 [2chi]
[return]        /project/list.jsp  를 가져옵니다 ㅎ



String url = request.getRequestURI.split("/");

String Name = url[url.length -1];       // list.jsp



출처: https://yi-chi.tistory.com/12 [2chi]


l-value = r-value

l-value에는 변수가 올수 있다.

r-value는 식(변수, 리터럴, 상수, 연산식, 리턴값이 있는 함수 호출식)이 올수 있다.






