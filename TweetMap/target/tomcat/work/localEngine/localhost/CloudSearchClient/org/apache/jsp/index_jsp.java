package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sun.misc.GC.LatencyRequest;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.io.*;
import java.net.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String test() {
		JSONObject jsonObject = null;
		JSONObject subObject = null;
		JSONArray array = null;
		JSONArray finalArray = new JSONArray();
		JSONObject finalJSONObject = new JSONObject();
		String finalJsonString = "";
		String output;
		try {
			URL url = new URL(
					"http://search-twitter-5gu4ih6lf3cmvhjygzhd6dwkqi.us-east-1.cloudsearch.amazonaws.com/2013-01-01/search?q=egypt&cursor=initial&size=10000");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			JSONParser jsonParser = new JSONParser();
			jsonObject = (JSONObject) jsonParser.parse(br);
			subObject = (JSONObject) jsonObject.get("hits");

			//System.out.println(subObject);
			array = (JSONArray) subObject.get("hit");
			//System.out.println(array);

			java.util.Iterator iterator = array.iterator();

			while (iterator.hasNext()) {
				JSONObject insideArrayJSONObject = (JSONObject) iterator.next();
				String id = (String) insideArrayJSONObject.get("id");

				JSONObject insideInsideArrayObject = (JSONObject) insideArrayJSONObject
						.get("fields");
				//System.out.println(insideInsideArrayObject);

				String username = (String) insideInsideArrayObject
						.get("username");
				String tweettext = (String) insideInsideArrayObject
						.get("tweettext");

				String latitude = (String) insideInsideArrayObject
						.get("latitude");
				String longitude = (String) insideInsideArrayObject
						.get("longitude");

				//System.out.println(id+","+username+","+latitude+","+longitude);

				JSONObject a = new JSONObject();
				a.put("id", id);
				//a.put("username", username);
				//a.put("tweettext", tweettext);
				a.put("latitude", latitude);
				a.put("longitude", longitude);

				finalArray.add(a);
			}
			finalJSONObject.put("tweets_data", finalArray);
			//out.println(finalJSONObject);
			finalJsonString = finalJSONObject.toJSONString();
			System.out.println(finalJsonString);
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return finalJsonString;
	}
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("var map;\r\n");
      out.write("function initialize() {\r\n");
      out.write("\t\tvar text1 = '");
      out.print(test());
      out.write("';\r\n");
      out.write("\t\t//alert(text1);\r\n");
      out.write("\t\tvar obj = JSON.parse(text1);\r\n");
      out.write("\t\tvar mapOptions = {\r\n");
      out.write("\t\t\tzoom : 3,\r\n");
      out.write("\t\t\tcenter : new google.maps.LatLng(51.508742, -10.120850),\r\n");
      out.write("\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tmap = new google.maps.Map(document.getElementById('map-canvas'),\r\n");
      out.write("\t\t\t\tmapOptions);\r\n");
      out.write("\t\tvar key, count = 0;\r\n");
      out.write("\t\tfor (key in obj.tweets_data) {\r\n");
      out.write("\t\t\tvar marker1 = new google.maps.Marker({\r\n");
      out.write("\t\t\t\tposition : new google.maps.LatLng(obj.tweets_data[key].latitude,\r\n");
      out.write("\t\t\t\t\t\tobj.tweets_data[key].longitude),\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tmarker1.setMap(map);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tgoogle.maps.event.addDomListener(window, 'load', initialize);\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"map-canvas\" style=\"height: 500px; width: 100%\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
