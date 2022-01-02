package base;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(location = "c:/Temp/uploadtest")  //이거를 빼먹으면 밑에서 Collection(Part)에서 에러 발생한다.

//파일 저장 위치


public class UploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");  //타입 정보와 char 정보 줬다.
		PrintWriter out = response.getWriter();  
		request.setCharacterEncoding("utf-8");  //일반쿼리도 읽을것이기 때문에 utf-8 해줬다.
		String path = "c:/Temp/uploadtest";   // 내가 원하는 경로명을 줄 수 있다.  여기서 uploadtest폴더가 있어야 한다.
		//그런데 여기서는 uploadtest파일이 없다면 만들수있도록 했다.
		
		
		File isDir = new File(path);
		if (!isDir.isDirectory()) {  //이미 존재하는 디렉토리인지 확인 그런데 파일이 없다면 isDir.mkdirs() 블록을 사용한다.
			
			isDir.mkdirs();    // mkdir은 Temp/a/b를 하면 path구조에 맞춰서 디렉토리(파일)을 만들어 ㅜㄴ다.
		}
		
		Collection<Part> parts = request.getParts();  //전달된 part 갯수 만금 Collection에 담아준다.
		
		
		for (Part part : parts) {  //parts를 리턴받는다.
			String fileName = part.getSubmittedFileName(); //이부분  어떤의미지?  내가 지정한 파일의 이름과 확장자명을 같이 가져온다.
			
			
			if (fileName != null) {  //업로드 되는 파일에 대한 파트를 입력받아서 null이 아니면
				//part.getSubmittedFileName(); 이게 NULL이아니면 sySTEM.CURRENTTimeMilis()(1970년 0시를 기준으로 시간을 뽑아내서
				// 업로드된 파일이름으로 Write한다.)
				part.write(System.currentTimeMillis()+"_"+fileName); 
				out.print("업로드한 파일 이름: " + fileName + "<br>");  //업로드할 파일의 이름
				out.print("크기: " + part.getSize() + "<br>");  //업로드된 파일의 사이즈 출력
			} else {
				// 전달된 네임벨류쌍의 이름을 뽑아내서 그 네임 벨류를 theAuthor the~~가 뽑잏ㄴ다.
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print(partName + " : " + fieldValue + "<br>");
			}
		}
		out.close();
	}
}
