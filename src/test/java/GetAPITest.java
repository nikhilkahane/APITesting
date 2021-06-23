import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.API.base.TestBase;
import com.API.client.RestClient;

public class GetAPITest extends TestBase{
	
	TestBase testBase;
	RestClient restClient;
	CloseableHttpResponse httpResponse;
	
	String url,u1,u2;
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		
		u1 = prop.getProperty("url");
		u2 = prop.getProperty("serviceurl");
		url = u1 + u2;
		System.out.println(url);
		
	}
	
	@Test
	public void testGetAPI() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		httpResponse = restClient.get(url);
		
		
		//1. staus code
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				System.out.println("Status Code from response is --> "+statusCode);
				Assert.assertEquals(statusCode, expectedStatus);
				
				//2.body in JSON format
				String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");//get the response body in string
				JSONObject responseJson = new JSONObject(responseString); // convert string to JSON
				System.out.println("Response JSON is --> "+responseJson);
				
				
				//3.All Headers
				Header[] headerArray = httpResponse.getAllHeaders();//get all headers from response
				HashMap<String,String> allHeaders = new HashMap<String,String>(); 
				for(Header header: headerArray) { //store them in hashmap
					allHeaders.put(header.getName(), header.getValue());
				}
				System.out.println("Headers from response are --> "+allHeaders);
				
				
	}
	

}
