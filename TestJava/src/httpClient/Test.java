package httpClient;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test {
	public static void main(String[] args) {
		try {
			/////////////////////
			HttpClient httpClient = new DefaultHttpClient();
			// 构造请求,如果想使用POST则new一个HttpPost
			HttpGet get = new HttpGet("http://www.baidu.com");
			HttpResponse response = httpClient.execute(get);
			// 先从响应头得到实体
			HttpEntity entity = response.getEntity();
			// 得到实体输入流
			InputStream inSm = entity.getContent();
			Scanner inScn = new Scanner(inSm);
			while (inScn.hasNextLine()) {
				System.out.println(inScn.nextLine());
			}
			entity.consumeContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
