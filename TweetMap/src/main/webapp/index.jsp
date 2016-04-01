<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="sun.misc.GC.LatencyRequest"%>
<%@page import="org.json.simple.parser.*"%>
<%@page import="org.json.simple.*"%>

<%@page import="java.io.*"%>
<%@page import="java.net.*"%>
<%!String test() {
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
	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>

var map;
function initialize() {
		var text1 = '<%=test()%>';
		//alert(text1);
		var obj = JSON.parse(text1);
		var mapOptions = {
			zoom : 3,
			center : new google.maps.LatLng(51.508742, -10.120850),

		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		var key, count = 0;
		for (key in obj.tweets_data) {
			var marker1 = new google.maps.Marker({
				position : new google.maps.LatLng(obj.tweets_data[key].latitude,
						obj.tweets_data[key].longitude),
			});
			marker1.setMap(map);
		}
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="map-canvas" style="height: 500px; width: 100%"></div>
</body>
</html>