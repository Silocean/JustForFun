import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPServer {
	DatagramSocket ds_server = null;
	DatagramPacket dp_send = null;
	DatagramPacket dp_receive = null;
	byte[] buf = new byte[1024];
	InetAddress address = null;
	int port = 0;
	byte[] data = new byte[300000];
	
	public UDPServer() {
		try {
			ds_server = new DatagramSocket(5678);
			dp_receive = new DatagramPacket(buf, buf.length);
			ds_server.receive(dp_receive);
			System.out.println(new String(buf, 0, dp_receive.getLength()));
			address = dp_receive.getAddress();
			port = dp_receive.getPort();
			System.out.println(port);
			System.out.println("客户机的地址：" + address + " " + port);
			dp_send = new DatagramPacket(data, data.length);
			dp_send.setAddress(address);
			dp_send.setPort(port);
			FileInputStream fis = new FileInputStream("d:/0.gif");
			byte[] fileData = new byte[300];
			while (fis.read(fileData, 0, fileData.length) != -1) {
				dp_send.setData(fileData);
				fis.close();
				ds_server.send(dp_send);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new UDPServer();
	}
}
