package crm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.entity.EmployeeEntity;
import crm.service.EmployeeService;
import crm.utils.MD5;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name="loginController",urlPatterns ={"/login"})
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	EmployeeService employeeService = new EmployeeService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String saved = request.getParameter("remember");
		    // Kiểm tra nếu tìm thấy nhân viên
		    if (employeeService.getAccount(email,password) != null) {
		        
		    	System.out.println("Đăng nhập thành công.");
		    	if(saved!=null) {
		    		Cookie saveEmail =  new Cookie("email", email);
		    		Cookie savePassword =  new Cookie("password",password);
		    		
		    		response.addCookie(saveEmail);
		    		response.addCookie(savePassword);
		    		
		    	}
		    	
		    	request.getRequestDispatcher("login.jsp").forward(request, response);
		    } else {
		        System.out.println("Đăng nhập thất bại. Sai email hoặc mật khẩu.");
		        // Chuyển hướng lại trang đăng nhập với thông báo lỗi
		        request.setAttribute("error", "Sai email hoặc mật khẩu!");
		        request.getRequestDispatcher("login.jsp").forward(request, response);
		    }
	}

}
