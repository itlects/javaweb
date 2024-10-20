

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileDownload
 */
@WebServlet("/fileDownload.do")
//@WebServlet(
//	    name = "DownloadServlet",
//	    urlPatterns = {"/fileDownload.do"}
//)
public class fileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		// TODO Auto-generated method stub
		/*
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo = "c:/upload";
		String fileName = (String)request.getParameter("fileName");
		System.out.println("fileName " + fileName);
		String downloadFileFullPath = String.format("%s/%s", file_repo, fileName);
		System.out.println("다운로드 " + downloadFileFullPath);
		
		OutputStream outputStream = response.getOutputStream();
		//ServletOutputStream outputStream = response.getOutputStream();
		File file = new File(downloadFileFullPath);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count = fileInputStream.read(buffer);
			
			if(count == -1) { 
				break; 
			}
			outputStream.write(buffer, 0, count);
		}
		
		fileInputStream.close();
		outputStream.close();	
		*/	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		//doGet(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String file_repo="c:/upload";
		String fileName = (String)request.getParameter("fileName"); // 매개변수로 전송된 파일 이름을 읽어옴
		System.out.println("fileName="+fileName);
		
		OutputStream out = response.getOutputStream(); // response에서 OutputStream 객체를 가져옴
		
		//String downFile = String.format("%s/%s", file_repo, fileName);
		String downFile = file_repo+"/"+fileName;
		File f=new File(downFile);
		
		// 파일을 다운로드할 수 있게 설정
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
		FileInputStream in=new FileInputStream(f);
		// 버퍼 기능을 이용해 파일에서 버퍼로 데이터를 읽어와 한꺼번에 출력함
     byte[] buffer=new byte[1024*8];
		while(true) {
			int count=in.read(buffer);
			if(count==-1)
				break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
}
