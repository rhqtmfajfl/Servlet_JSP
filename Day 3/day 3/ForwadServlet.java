package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FowardServlet 수행 시작");		
		RequestDispatcher rd = request.getRequestDispatcher("/htmlexam/first.html");// 컨텍스트패스 이후 부분을 줘야	   //여기서 edu를 붙이면 현재 프로젝의 context를 붙여서 찾는다 다른거 못 붙이게 하려고 
		//동일한 자원에 있는것만 forward 할 수 있게끔 강제 하기 위해서 
		// context에서 edu를 뺀 나머지만 찾는다.
		//getRequestDispatcher는 forward 객체 를 적는다. /htmlexam/first.html로 넘기겠어라는 의미이다.
		//컨택스트 패스 제외한 나머지 부분
		
		//RequestDispatcher rd = request.getRequestDispatcher("http://www.naver.com/");// 컨텍스트패스 이후 부분을 줘야	
		// 이부분에서 네이버를 forward는 안된다 동일한 프로젝트내에 없기 때문에
		// jsp나 servlet이면 가능하다.
		rd.forward(request, response);	 //forward로 하면 더이상 밑에게 실행이 안되도록 한다.
		
		System.out.println("FowardServlet 수행 종료");		
	}
}







