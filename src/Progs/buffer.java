package Progs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;



public class buffer 
{	
	@Test
	public void getURLStatus()
	{
		int code=0;
		HttpURLConnection connection;
		String add = "https://www.proptiger.com/careers";
		try
		{
		URL url = new URL(add);
		
		connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setInstanceFollowRedirects(false);			//To disable redirects else 301 will also give 200
		connection.connect();
		code = connection.getResponseCode();
		}catch(IOException E){System.err.println("oops either link is invalid or some error occured");}
		System.out.println("code of " + add + " is " + code);
	}
}
