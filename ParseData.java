

import java.io.*;
import java.net.*;
import com.google.gson.Gson;

public class ParseData {

	// this function performs basic HTTP requests in Java by using the built-in Java class HttpUrlConnection
	public static String weather(String city) throws IOException, ProtocolException, MalformedURLException{

		// linking the url object to an actual url
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=9ef83269c3c08df327a2a1a3af62a153");

		// creating but not establishing the connection object
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// establishing a connection to the URL
		con.setRequestMethod("GET");

		// parsing the InputStream of HttpUrlConnection and reading the response of the request and
		// placing it in the content String
		con.connect();

		// reading the connection InputStream
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String inputLine;

		StringBuffer content = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {

			content.append(inputLine);
		}

		in.close();

		// close the connection
		con.disconnect();

		// this converts the StringBuffer in JSON to usable String format
		String json_read = content.toString();

		WeatherBot json_data = new Gson().fromJson(json_read, WeatherBot.class);

		return json_data.Temperature();
	}

	public static String kanyeQuote() throws IOException, ProtocolException, MalformedURLException {

		// linking the url object to an actual url
		URL url = new URL("http://api.kanye.rest");

		// creating but not establishing the connection object
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// establishing a connection to the URL
		con.setRequestMethod("GET");

		// parsing the InputStream of HttpUrlConnection and reading the response of the request and
		// placing it in the content String
		con.connect();

		// reading the connection InputStream
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String inputLine;

		StringBuffer content = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {

			content.append(inputLine);
		}

		in.close();

		// close the connection
		con.disconnect();

		// this converts the StringBuffer in JSON to usable String format
		String json_read = content.toString();

		KanyeBot json_data = new Gson().fromJson(json_read, KanyeBot.class);

		return json_data.kanyeQuote();

	}
}
