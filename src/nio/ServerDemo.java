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
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class ServerDemo {
	public static void main(String[] args) {
		final int port = 7111;
		
		ServerSocketChannel serverChannel;
		Selector selector = null;
		try{
			serverChannel = ServerSocketChannel.open();
			ServerSocket serverSocket = serverChannel.socket();
			SocketAddress socketAddress = new InetSocketAddress(port);
			serverSocket.bind(socketAddress);
			serverChannel.configureBlocking(false);
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		while(true){
			
			try {
				selector.select();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
			Set<SelectionKey> readKey = selector.selectedKeys();
			Iterator<SelectionKey> it = readKey.iterator();
			
			while(it.hasNext()){
				SelectionKey key = it.next();
				it.remove();
				if(key.isAcceptable()){
					try {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client = server.accept();
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(32));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(key.isReadable()){
					try {
						System.out.println("trying to recive request...");
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer attach = (ByteBuffer) key.attachment();
						attach.clear();
						if(client.read(attach)!=-1){
							attach.flip();
							String request = Charset.forName("gb2312").newDecoder().decode(attach).toString();
							System.out.println("recived the message :"+request);
							String sendMessage = "server recived :"+request;
							ByteBuffer send = ByteBuffer.wrap(sendMessage.getBytes());
							client.write(send);
							key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						}
						else{
							System.out.println("close the client connection...");
							client.close();
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						try {
							key.channel().close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}
}
