package base;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RedirectServlet 수행 시작");
		response.sendRedirect("/edu/htmlexam/first.html");  //uri다주고 다른 웹사이트도 된다. .url도 된다.
		//response.sendRedirect("http://www.naver.com/");
		System.out.println("RedirectServlet 수행 종료");
	}
}



//////////////

redirect는 httpresonse 객체를 사용한다.


	
여기서 중요한 건 redirect나 forward나 first.html을 구동하는건 똑같다.


redicet에 대해 자세히 보려면
개발자도구에서 Network에서 301은 다른 애한테 넘긴다.
	
응답 헤더에 다른 정보도 잇다

redirect는 first도 요청했고 redirect도 요청했다.
	
forward는 forward만 요청했다.
	

	
같은서버의 같은 프로젝트를 사용할 경우 forward 한다.
	
그런데 요청 재시작할 자원이 다른 곳에 있다하면 redirect다.
	

요청 재시작할 자원이 다른 서버이거나 다른 곳에 있다면 redircet를 사용한다.
	
