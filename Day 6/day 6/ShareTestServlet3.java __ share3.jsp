크롬에서 100까지 증가시킨 값이 

엣지에서 110으로 증가 가능하다.


서블릿 context 객체에 보관한 객체는 모든 브라우저가 공유한다.



package controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;
@WebServlet("/sharetest3")
public class ShareTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		ServletContext context = getServletContext();
		if(context.getAttribute("objapp") == null) {
			context.setAttribute("objapp", new CountVO());
		}
		CountVO vo = (CountVO)context.getAttribute("objapp");
		vo.setNumber(param);
		
		request.getRequestDispatcher("/jspsrc/share3.jsp").
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
<h2>서블릿이 전달한 객체(application)</h2>
<hr>
<%
	CountVO vo = (CountVO)application.getAttribute("objapp");
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



