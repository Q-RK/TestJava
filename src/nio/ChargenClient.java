package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class ChargenClient {

	private final static byte[] ADDR = {(byte) 192,(byte) 168,1,102};
	private final static int PORT = 9090;
	private final static int SIZE = 100;
	
	public static void main(String[] args) throws IOException {
		SocketAddress clientAddress = new InetSocketAddress( InetAddress.getByAddress(ADDR), PORT);
		SocketChannel client = SocketChannel.open(clientAddress);
		
		ByteBuffer buffer = ByteBuffer.allocate(SIZE);
		WritableByteChannel out = Channels.newChannel(System.out);
		while(client.read(buffer) != -1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		System.out.println("服务器端信息接收完毕断开连接");
		client.close();
	}
}
