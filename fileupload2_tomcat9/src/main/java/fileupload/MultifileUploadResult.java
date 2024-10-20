package fileupload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultifileUploadResult
 */
@WebServlet("/multifileuploadresult.do")
public class MultifileUploadResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultifileUploadResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		
		List<String> orgList = new ArrayList<String>();
		List<String> fileList = new ArrayList<String>();
		
		try {
			MultipartRequest mr = new MultipartRequest(
						request,
						request.getSession().getServletContext().getRealPath("/files"),
						1024*1024*100,
						"UTF-8",
						new DefaultFileRenamePolicy()
					);
			String realpath = request.getSession().getServletContext().getRealPath("/files");
			System.out.println(realpath);
			
//			String orgfilename = mr.getOriginalFileName("attach");
//			String filename = mr.getFilesystemName("attach");
//			System.out.println(orgfilename);
//			System.out.println(filename);

			Enumeration e = mr.getFileNames();
			
			while(e.hasMoreElements()) {
				String file = e.nextElement().toString();
				String orgfilename = mr.getOriginalFileName(file);
				String filename = mr.getFilesystemName(file);
				
				System.out.println(orgfilename);
				System.out.println(filename);
				
				orgList.add(orgfilename);
				fileList.add(filename);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("orgList", orgList);
		request.setAttribute("fileList", fileList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/multifileresult.jsp");
		dispatcher.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
