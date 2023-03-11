package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/target")
public class target extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		if(name.equals("root") && password.equals("root")) {
			Cookie cookie = new Cookie("JavaServlet", name);
			cookie.setMaxAge(10);
			
			resp.addCookie(cookie);
			resp.sendRedirect("/Test/welcome");
		} else {
			resp.sendRedirect("/Test/form.html");
		}
	}
}
