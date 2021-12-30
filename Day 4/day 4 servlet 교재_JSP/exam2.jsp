<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int member_v = 0; %>  // 선언문은 멤버변수를 선언한다거나 메소드를 정의할 때 상요한다
<%                                    수행문의 내용은 서블릿으로 바뀔때 서비스 메소드 안으로 들어간다.
                                      GET하고 POST로 나누지않는다.
                                        서블릿은 바뀔때 이 코드가 DO GET으로 가느냐 POST로가느냐 서블릿이 결정되지만
                                       JSP는 자동으로 DOGETPOST로자동으로 변환된다.
                                       
                                       JSP는 멤버변수의 자원을 한번만 할당하지만.
	int local_v = 0;
	member_v += 10;
	local_v += 10;                        지역변수는 계속 할당할 수있다.
%>

<h1>JSP의 멤버 변수와 지역변수</h1>
<hr>
<ul>
	<li>멤버 변수 :<%= member_v %></li>
	<li>지역 변수 :<%= local_v %></li>
	
</ul>

</body>
</html>




JSP는 실행될 때 서블릿으로 바뀐다. 다만 JSP는 멤버 변수 선언하고 싶으면 선언문에 선언한다.

<%!>가 있는 곳에 선언해야 멤버 변수가 된다.
