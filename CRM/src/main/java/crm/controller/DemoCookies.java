package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="democookie", urlPatterns = {"/cookiedemo"})
public class DemoCookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Cookie demock = new Cookie("demo", "Hellocookie");
//		resp.addCookie(demock);
		Cookie[] cookie = req.getCookies();
		for(Cookie cook : cookie) {
			System.out.println("ten cookie: "+cook.getValue());
		}
	}
}
