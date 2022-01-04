세션이 유지되는동안 값이 증가

그리고 다른 브라우저에서 실행시 다시 카운트 한다.



package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.CountVO;
@WebServlet("/sharetest2")
public class ShareTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		if(session.getAttribute("objsession") == null) {   //최초요청시만 참 그 후에는 꺼내서 사용 한다.

			session.setAttribute("objsession", new CountVO());
		}
		CountVO vo = (CountVO)session.getAttribute("objsession");
		vo.setNumber(param);
		
		request.getRequestDispatcher("/jspsrc/share2.jsp").
		              forward(request, response);
	}
}






<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.CountVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
</head>
<body>
<h2>서블릿이 전달한 객체(session)</h2>
<hr>
<%
	CountVO vo = (CountVO)session.getAttribute("objsession");
    if(vo != null) {
%>
		추출된 값 : <%= vo.getNumber() %><br>		
<%
    } else {
%>
    	추출된 객체가 없슈!!
<%	
    }
%>
</body>
</html>



