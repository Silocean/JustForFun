import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPSendFileServer {
	
	static DatagramPacket dp_send = null;
	static DatagramSocket ds_server = null;
	static DatagramPacket dp_receive = null;
	static String str = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] data = new byte[30000];
		
		byte[] buf = new byte[1024];
		try {
			ds_server = new DatagramSocket(8888);
			dp_receive = new DatagramPacket(buf, buf.length);
			
			ds_server.receive(dp_receive);
			str = new String(buf, 0, dp_receive.getLength());
			System.out.println(str);
			
			File f = new File(str);
			
			if(!f.exists()) {
				byte[] buf1 = "ÎÄ¼þÎ´ÕÒµ½!".getBytes();
				dp_send = new DatagramPacket(buf1, buf1.length);
				dp_send.setAddress(dp_receive.getAddress());
				dp_send.setPort(dp_receive.getPort());
				ds_server.send(dp_send);
				ds_server.close();
			} else {
				/*BufferedReader br = new BufferedReader(new FileReader(str));
				String string = br.readLine();
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				DataOutputStream dos = new DataOutputStream(baos);
				
				while((string=br.readLine()) != null) {
					dos.writeChars(string);
				}
				data = baos.toByteArray();*/
				dp_send = new DatagramPacket(data, data.length);
				dp_send.setAddress(dp_receive.getAddress());
				dp_send.setPort(dp_receive.getPort());
				
				FileInputStream fis = new FileInputStream(str);
				byte[] fileData = new byte[fis.available()];
				while(fis.read(fileData, 0, fileData.length) != -1) {
					dp_send.setData(fileData);
					fis.close();
					ds_server.send(dp_send);
				}
				
				/*BufferedReader br = new BufferedReader(new FileReader(str));
				char[] fileData = new char[30000];
				while(br.read(fileData, 0, fileData.length) != -1) {
					dp_send.setData(fileData);
				}
				*/
				DatagramPacket dp_send = new DatagramPacket(data, data.length);
				dp_send.setAddress(dp_receive.getAddress());
				dp_send.setPort(dp_receive.getPort());
				ds_server.send(dp_send);
				ds_server.close();
			}
			
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
