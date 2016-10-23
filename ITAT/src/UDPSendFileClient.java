import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class UDPSendFileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] data = new byte[30000];
		
		try {
			System.out.println("请输入指定文件的绝对路径");
			DatagramSocket ds_client = new DatagramSocket(0000);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			byte[] buf = str.getBytes();
			DatagramPacket dp_send = new DatagramPacket(buf, buf.length , new InetSocketAddress("localhost", 8888));
			ds_client.send(dp_send);
			
			DatagramPacket dp_receive = new DatagramPacket(data, data.length);
			ds_client.receive(dp_receive);
			String string = new String(data, 0, dp_receive.getLength());
			if(string.equals("文件未找到!")) {
				System.out.println("文件未找到!");
			} else {
				/*ByteArrayInputStream bais = new ByteArrayInputStream(data);
				DataInputStream dis = new DataInputStream(bais);
				while(dis.readChar() != -1) {
					System.out.print(dis.readChar());
				}*/
				
				ds_client.receive(dp_receive);
				System.out.print(dp_receive.getData());
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
