package baitaplogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean hasError = false;
        // Kiểm tra thông tin đăng nhập
        // Check for login validation
        if (!"admin".equals(username)) {
            
            request.setAttribute("accounterror", "Sai tên đăng nhập");
            hasError = true;
        }

        if (!"123456".equals(password)) {

            request.setAttribute("passworderror", "Mật khẩu không đúng");
            hasError = true;
        }

        if (hasError) {
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            
        	request.setAttribute("username", username);
        	request.setAttribute("password", password);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        }
	

}
