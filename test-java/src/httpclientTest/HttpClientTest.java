package httpclientTest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;

public class HttpClientTest {

	public static void main(String[] args) {
		HttpConnector con = HttpConnector.getInstance();
		HttpPost httpRequest = new HttpPost(
				"http://10.10.10.217:10004/WebBuilding");
		httpRequest.setHeader("Connection", "close");// 短连接
		HttpResponse httpResponse = null;
		try {
			httpResponse = con.getHttpClient().execute(httpRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(httpResponse.getStatusLine().getStatusCode());
	}

}
