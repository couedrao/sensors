package clientm2m;

import java.math.BigInteger;

import commons.constants.Operation;
import commons.resource.RequestPrimitive;
import http.RestHttpClient;

public class Post {

	Long[] postm2m(String msg, String to, int resourceType, int reqid) {
		Long t = System.currentTimeMillis();
		BigInteger operation = Operation.CREATE;
		RequestPrimitive request = new RequestPrimitive();
		request.setTo(to);
		request.setOperation(operation);
		request.setResourceType(resourceType);
		request.setFrom("admin:admin");
		request.setRequestContentType("application/xml");
		String inStr = msg;
		request.setContent(inStr);
		BigInteger reqint = new RestHttpClient().sendRequest(request).getResponseStatusCode();
		Long[] ret = { reqint.longValue(), System.currentTimeMillis() - t };
		return ret;
	}

}
