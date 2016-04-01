<html>
<body>
<h2>Hello World!</h2>
<%@page import = "java.io.*" %>
<%@page import = "java.net.*" %>
<%
String output;
try {
URL url = new URL(
		"http://search-twitter-5gu4ih6lf3cmvhjygzhd6dwkqi.us-east-1.cloudsearch.amazonaws.com/2013-01-01/search?q=egypt");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
conn.setRequestProperty("Accept", "application/json");

if (conn.getResponseCode() != 200) {
	throw new RuntimeException("Failed : HTTP error code : "
			+ conn.getResponseCode());
}

BufferedReader br = new BufferedReader(new InputStreamReader(
		(conn.getInputStream())));


System.out.println("Output from Server .... \n");
while ((output = br.readLine()) != null) {
	out.println(output);
}

conn.disconnect();

} catch (MalformedURLException e) {

e.printStackTrace();

} catch (IOException e) {

e.printStackTrace();


%>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js">

	var myData = "<%=output%>"
</script>
<%} %>
<div>
<ul>
  <li ng-repeat="x in myData">
    {{ x.id}}
  </li>
</ul>
</div>
</body>
</html>
