import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

public class TCPServerA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = null;
			Socket s = null;
			ss = new ServerSocket(4700);
			s = ss.accept(); 
			
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			String year = String.valueOf(c.get(Calendar.YEAR));
			String month = String.valueOf(c.get(Calendar.MONTH)+1);
			String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			String week = String.valueOf(c.get(Calendar.DAY_OF_WEEK)-1);
			
			String time = year + "年" + month + "月" + day + "日" + "  " + "星期" + week;
			
			DataOutputStream dos = null;
			dos = new DataOutputStream(s.getOutputStream());

			dos.writeUTF(time + "   " + new Date());
			dos.flush();
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
