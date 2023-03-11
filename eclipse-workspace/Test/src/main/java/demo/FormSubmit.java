package demo;

import java.awt.image.BandCombineOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-submit")
public class FormSubmit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = resp.getWriter();
		String ten = req.getParameter("name");
		int tuoi = Integer.parseInt(req.getParameter("age"));
		if(tuoi < 15) {
			printWriter.println("<h1>" + ten + " đang dưới độ tuổi lao động</h1>");
		} else if(tuoi >= 15 && tuoi <= 65) {
			printWriter.println("<h1>" + ten + " đang ở trong độ tuổi lao động</h1>");
		} else {
			printWriter.println("<h1>" + ten + " ở sau độ tuổi lao động</h1>");
		}
		printWriter.close();
	}
}
