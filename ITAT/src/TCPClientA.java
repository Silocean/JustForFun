import java.io.DataInputStream;
import java.net.Socket;

public class TCPClientA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = null;
			s = new Socket("localhost", 4700);
			DataInputStream dis = null;
			dis = new DataInputStream(s.getInputStream());

			System.out.println(dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
