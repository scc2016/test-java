package httpclientTest;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class ComHttpClient {
	public static void main(String[] args) throws IOException {
		HttpClient httpclient = new HttpClient();
		HttpMethod method = new GetMethod("http://baidu.com");
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			int statusCode = httpclient.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK)
				;
			{
				System.err.println("Method failed: " + method.getStatusLine());
			}
			byte[] responseBody = method.getResponseBody();
			System.out.println(new String(responseBody));
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			System.out.println("Please check your provided http address!");

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		method.releaseConnection();
	}
}