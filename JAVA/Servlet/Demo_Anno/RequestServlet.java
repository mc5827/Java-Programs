import javx.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RequestServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		if(name.equals("ducat") && pass.equals("ducat"))
			out.println("User valid trough service");
		
		else
			out.println("User invalid trough service");
			
		out.println("</body></html>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException , Exception
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c=DriverManager.getConnection("jdbc:odbc:mydsn");
		
	}
}
		
	}
}