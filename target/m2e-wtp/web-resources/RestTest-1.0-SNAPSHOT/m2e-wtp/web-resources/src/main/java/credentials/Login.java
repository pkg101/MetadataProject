package credentials;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Login {

	public Login()
	{
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpResponse response=null;
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Login - "+e);
		}
	}
}
