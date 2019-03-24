package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TodayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		LocalDateTime time = LocalDateTime.now();
		//Lines were separated to read easier
		out.print("<html>");
		out.print("<head><title>today</title></head>");
		out.print("<body>");
		//Hyperlink to the index
		out.print("<a href='/aboutme/index.html'>메인화면</a>");
		out.print("<h1><center>");
		out.print("<br><br>");
		//Print local time, format : '현재시간 : yyyy/mm/dd hh:mm'
		out.print("현재시간 : "
				+ time.getYear() + "/" + time.getMonthValue() + "/" + time.getDayOfMonth() + " " 
				+ time.getHour() + ":" + time.getMinute());
		out.print("</h1></center>");
		out.print("</body>");
		out.print("</html>");
	}
}
