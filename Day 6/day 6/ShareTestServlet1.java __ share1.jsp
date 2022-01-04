package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CountVO;
@WebServlet("/sharetest1")

public class ShareTestServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int param = Integer.parseInt(request.getParameter("num"));  num을 꺼내서 param에 넣는다.

		CountVO vo = new CountVO();

    vo.setNumber(param);
		request.setAttribute("objreq", vo);    //sh
		request.getRequestDispatcher("/jspsrc/share1.jsp").
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
<h2>서블릿이 전달한 객체(request)</h2>
<hr>
<%
	CountVO vo = (CountVO)request.getAttribute("objreq");    // setAttribute했던 것을 get 하고 있다.
                                        리퀘스트 객체안에 objreq라고 되어있는것을 가져온다.
                                          
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




