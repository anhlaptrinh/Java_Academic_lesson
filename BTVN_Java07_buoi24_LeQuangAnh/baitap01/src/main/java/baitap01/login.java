package baitap01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet(urlPatterns ={"/login"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        // Kiểm tra thông tin đăng nhập
	        if ("admin".equals(username) && "123456".equals(password)) {
	            // Chuyển hướng đến trang welcome nếu thông tin đúng
	        	response.sendRedirect(request.getContextPath()+"/welcome");
	        } else {
	            // Quay lại trang đăng nhập nếu thông tin không đúng
	        	response.sendRedirect("login.html");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
