package nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientDemo {

	private final static int port = 7111;
	
	public static void main(String[] args) {
		try {
			SocketAddress socketAddress = new InetSocketAddress(port);
			SocketChannel clientChannel;
			clientChannel = SocketChannel.open(socketAddress);
			clientChannel.configureBlocking(false);
			
			Selector selector = Selector.open();
			clientChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
			
			while(true){
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				while(it.hasNext()){
					SelectionKey key = it.next();
					it.remove();
					SocketChannel channel = (SocketChannel) key.channel();
					if(key.isReadable()){
						//�����
						System.out.println("������Ӧ:");
						ByteBuffer respone = ByteBuffer.allocate(32);
						if(channel.read(respone) != -1){
							WritableByteChannel outChannel = Channels.newChannel(System.out);
							respone.flip();
							outChannel.write(respone);
							System.out.println();
							respone.clear();
						}
						key.interestOps(SelectionKey.OP_WRITE);
					}else if(key.isWritable()){
						//д���
						System.out.println("��д����:");
						ReadableByteChannel systemIn = Channels.newChannel(System.in);
						ByteBuffer request = ByteBuffer.allocate(32); 
						systemIn.read(request);
						request.flip();
						channel.write(request);
						key.interestOps(SelectionKey.OP_READ);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
