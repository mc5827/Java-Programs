import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RequestServlet extends HttpServlet
{
	/*public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c=DriverManager.getConnection("jdbc:odbc:mydsn100");
		Statement s=c.createStatement();
		
		//int x=s.executeUpdate("insert into emp values('"+name+"')");
		ResultSet rs=s.executeQuery("select * from emp");
		
		while(rs.next())
		{
			out.println(rs.getString(1));
			out.println(rs.getString(2));
			
			out.println("<br>");
		}
		}
		catch(Exception exp){out.println(exp);}
		
		/*if(name.equals("ducat") && pass.equals("ducat"))
			out.println("User valid trough service");
		
		else
			out.println("User invalid trough service");
		*/
			/*
		out.println("</body></html>");
	}*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		
		
		
		
		//if(name.equals("ducat") && pass.equals("ducat"))
			out.println("User valid trough post");
		
		//else
			out.println("User invalid trough post");
			
		out.println("</body></html>");
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		
		/*if(name.equals("ducat") && pass.equals("ducat"))
			out.println("User valid trough get");
		
		else
			out.println("User invalid trough get");
		*/
		out.println("</body></html>");
	}
}
