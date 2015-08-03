package nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemoWithoutNIO {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 7111);
			
			InputStream inStream = s.getInputStream();
			OutputStream outStream = s.getOutputStream();
			//���
			PrintWriter out = new PrintWriter(outStream, true);
			System.out.println("input your request:");
			Scanner systenin = new Scanner(System.in);
			out.print(systenin.nextLine());
			out.flush();
			
			s.shutdownOutput();
			
			//����
			Scanner in = new Scanner(inStream);
			StringBuilder sb = new StringBuilder();
			while(in.hasNextLine()){
				String line = in.nextLine();
				sb.append(line);
			}
			System.out.println("respone:"+sb.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
