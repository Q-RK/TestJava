package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChargeServer {

	private final static int PORT = 9090; 
	
	public static void main(String[] args) {
		System.out.println("在端口"+PORT+"监听连接");
		
		byte[] content = new byte[100];
		for(int i = 0 ; i < 100 ;i++){
			content[i] = (byte)i;
		}
		
		ServerSocketChannel serverChannel;
		Selector sel = null;
		try {
			serverChannel = ServerSocketChannel.open();
			ServerSocket serverSocket = serverChannel.socket();
			SocketAddress endpoint = new InetSocketAddress(PORT);
			serverSocket.bind(endpoint);
			serverChannel.configureBlocking(false);
			sel = Selector.open();
			serverChannel.register(sel, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			try {
				sel.select();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Set<SelectionKey> iterator = sel.selectedKeys();
			Iterator<SelectionKey> it = iterator.iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				it.remove();
				if(key.isAcceptable()){
					//服务器端
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					try {
						SocketChannel client = server.accept();
						System.out.println("接受客户端：" + client);
						client.configureBlocking(false);
						SelectionKey key2 = client.register(sel, SelectionKey.OP_WRITE);
						ByteBuffer buffer = ByteBuffer.allocate(100);
						buffer.put(content);
						buffer.flip();
						key2.attach(buffer);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(key.isWritable()){
					//客户端
					SocketChannel client  = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					if(!buffer.hasRemaining()){
						buffer.flip();
					}
					try {
						client.write(buffer);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
