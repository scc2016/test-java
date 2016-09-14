package httpclientTest;

import java.security.KeyStore;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

public class HttpConnector {

	private final static int TIMEOUT = 1000;
	private final static int CONNECT_TIMEOUT = 6000;
	private final static int SO_TIMEOUT = 10000;

	private static HttpConnector instance = new HttpConnector();
	private int nThreads = 3;
	private ThreadPoolExecutor sExecutorService;

	// 服务器秘钥
	private static KeyStore trustStore;

	public static KeyStore getTrustStore() {
		return trustStore;
	}

	public static void setTrustStore(KeyStore trustStore) {
		HttpConnector.trustStore = trustStore;
	}

	private HttpClient httpClient;

	private HttpConnector() {
		sExecutorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(nThreads);
	}

	public static HttpConnector getInstance() {
		return instance;
	}

	public int getThreadsPoolSize() {
		return nThreads;
	}

	public void setThreadsPoolSize(int size) {
		nThreads = size;
		sExecutorService.setMaximumPoolSize(nThreads);
		sExecutorService.setCorePoolSize(nThreads);
	}

	public void sendRequest(Runnable runnable) {
		sExecutorService.execute(runnable);
	}

	public synchronized HttpClient getHttpClient() {
		if (null == httpClient) {
			// 初始化工作
			HttpParams params = new BasicHttpParams();

			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
			HttpProtocolParams.setUseExpectContinue(params, true);

			// 设置连接管理器的超时
			ConnManagerParams.setTimeout(params, TIMEOUT);

			// 设置连接超时
			HttpConnectionParams.setConnectionTimeout(params, CONNECT_TIMEOUT);

			// 设置Socket超时
			HttpConnectionParams.setSoTimeout(params, SO_TIMEOUT);

			SchemeRegistry schemeRegistry = new SchemeRegistry();
			schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 80));

			ClientConnectionManager connManager = new ThreadSafeClientConnManager(params, schemeRegistry);

			httpClient = new DefaultHttpClient(connManager, params);
		}

		return httpClient;
	}

	public synchronized void shoutDown() {
		httpClient.getConnectionManager().shutdown();
		httpClient = null;
	}

}