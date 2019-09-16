package clientm2m;

import java.math.BigInteger;

import commons.constants.Operation;
import commons.resource.RequestPrimitive;
import http.RestHttpClient;

public class Post implements Runnable {
	private String msg;
	private String to;
	private int resourceType;
	private Long[] result = null;

	Post(String msg, String to, int resourceType) {
		this.msg = msg;
		this.to = to;
		this.resourceType = resourceType;
	}

	public void run() {
		Long t = System.currentTimeMillis();
		BigInteger operation = Operation.CREATE;
		RequestPrimitive request = new RequestPrimitive();
		request.setTo(to);
		request.setOperation(operation);
		request.setResourceType(resourceType);
		request.setFrom("admin:admin");
		request.setRequestContentType("text/plain");
		String inStr = msg;
		request.setContent(inStr);
		BigInteger reqint = new RestHttpClient().sendRequest(request).getResponseStatusCode();
		Long[] ret = { reqint.longValue(), System.currentTimeMillis() - t };
		result = ret;
		synchronized (this) {
			notifyAll();
		}
	}

	public synchronized Long[] get() throws InterruptedException {
		while (result == null)
			wait();
		return result;
	}
}
