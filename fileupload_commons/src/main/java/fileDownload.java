

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo = "d:/test/uploadedFiles";
		String fileName = request.getParameter("fileName");
		String downloadFileFullPath = String.format("%s/%s", file_repo, fileName);
		System.out.println("다운로드 " + downloadFileFullPath);
		
		ServletOutputStream outputStream = response.getOutputStream();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
