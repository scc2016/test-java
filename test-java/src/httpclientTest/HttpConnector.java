package httpclientTest;

import java.security.KeyStore;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

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
		sExecutorService = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(nThreads);
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
			httpClient = new DefaultHttpClient();
			// 初始化工作
		}

		return httpClient;
	}

	public synchronized void shoutDown() {
		httpClient.getConnectionManager().shutdown();
		httpClient = null;
	}

}