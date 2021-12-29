package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal") //멤버명
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v=0;		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		member_v += 10;   // 10만큼 누적 처리
		local_v += 10;     // 10만큼 누적 처리
		out.print("<ul>");
		out.print("<li>멤버변수 : "+ member_v +"</li>");  //멤버변수 10이 출력  새로고침할때마다 10씩 증가도니다.
		out.print("<li>지역변수 : "+ local_v +"</li>");  //지역변수 10이 출력
		out.print("</ul>");
		out.close();		
	}
}

/////////////////////////////////////////////////////////////////
servelt 프로그램의 수행상의 특징

한번 객체 생성되면 서버 죽을때까지 유지되거나 리로드 될대까지 유지한다.
	
	
     생성된 객체를 
     
     하나의 서블릿 객체를 공유해서 수행한다.
클라이언트 수가 많아지더라도 
	
	
둘다 메모리 할당이 되면 0만큼 할당


 서블릿은 한번 객체 생성되면 계속해서 쓰이는 구나를 알 수 있다.	
 멤버변수는 한번쓰인 객체가 계속 생성된다.
 메모리 할당을 또하고 또하는 것이 
 서블릿을 요청할때마다 doget이 호출되는데 지역변수는 사라졌다 다시 할당되었다 한다.
	
	
 어느 브라우저에서 실행하더라도 멤버변수는 공유해서 실행 된다.
 어떤 클라이언트가 요청을 해오든 멤버변수는 서버가 없어지거나 리로드 될때 까지 공유되고 유지 된다. 
 
 
	
 클라이언트마다 각각 메모리에 할당되는게 필요하다면 지역변수를 활용한다.
 클라이언트별로 각각 할당이 필요한것이면 지역변수에 담아야 한다.
	
 서블릿 개발할 때 웬만하면 지역변수를 활용한다.
 
 서블릿에서는 멤버변수로 선언하느냐
 지역변수로 선언하느냐에 따라서 그변수를 어떻게 활용하는지 달라진다.
	

 만약 로그아웃할때까지 유지하려면 
 
 지역변수는 요청이 끝날때까지만 유지된다.
	
     그럼 만약 로그아웃할때 까지 유지하려면 멤버변수로 한다.
	
  지역변수는 리턴되면서 다 날아 간다.
  다음 요청시에도 메모리를 계속 유지하면서 사용하고 싶으면
  지역변수는 개별적 할당은 되지만 요청끝나면 사라진다.
  
  멤버변수는 단점은 모든 클라이언트가 공유하게 된다. 그러니까 우리가 필요에 의해서 어떤 데이터 공간이 필요한데 
  지역변수로 하자니 공유가 ㄷ안되
  멤버변수로 하자니 각 메모리 할당이 안된다.

	
	/////////////////////////////////////
	SESSION에 대한 설명
  그래서 이때 필요한게 http session 객체를 활용한다.
 
   클라이언트 별로 개별적으로 만들어 진다.
        그러므로 우리는 getsession
        http session이라는 객체는 그냥 만들어지지 않고 WAS 한테 만들어 달라고 해야한다.
    각 클라이언트 별로 HTTP SESSION이라는 객체를 만들어 놓고 WAS 가 관리한다.
	


SESSION 객체를 만들어서 계속 유지하고 싶은 데이터를 만드는 메소드는 SET() 메소드이다ㅣ

삭제는 REMOVE 메소드이다.
메소드는 등록 제한 없다.
등록시에는 이름 으로

클라이언트마다 클라이언트 세션 개수가 만들어진다.
	

HTTP 세션 객체가 만들어진 이후 이 클라이언트가 요청을 하면 클라이언트 ㅔㅅ션이 만들어지는데 
이 때 세션 객체는 자동으로 삭제 된다. 이것은 WAS가 한다

기본값 30분동 이후에 삭제 된다. 
예를 들어 자소서 작성시 INACTIVE INTERVAL을 주면 세션이 시간이 지나면 자동으로 없어진다.
	
INACTIVE INTERVAL
	
