package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class welcome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			printWriter.println("<h1> Đăng nhập thành công với cookie: " + c.getName() + "</h1>");
			resp.setHeader("Refresh", "1");
		}
	}
}
