import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.*;


public class ValidateCreditCard extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>");
		out.println("  <BODY>");
			
		try{
			
			InitialContext ctx=new InitialContext();
			Object object=ctx.lookup("DemoHome6");
			
			pack.DemoHome h=(pack.DemoHome)PortableRemoteObject.narrow(object, pack.DemoHome.class);
			pack.Demo r=h.create();
			out.println(r.add(200,20));
			
		}
		catch(Exception e){}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
