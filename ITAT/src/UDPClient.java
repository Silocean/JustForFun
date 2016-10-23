import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UDPClient extends JFrame implements ActionListener {
	
	Button b = new Button("»ñÈ¡Í¼Ïñ");
	JLabel l = new JLabel();
	DatagramSocket ds_client = null;
	DatagramPacket dp_send = null;
	DatagramPacket dp_receive = null;
	ImageIcon image = null;
	byte[] data = new byte[300000];

	public UDPClient() {
		this.setBounds(400, 300, 300, 200);
		this.setVisible(true);
		b.addActionListener(this);
		this.add(b, BorderLayout.NORTH);
		this.add(l, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			ds_client = new DatagramSocket(1234);
			byte[] buf = "hello".getBytes();
			dp_send = new DatagramPacket(buf, buf.length,
					new InetSocketAddress("localhost", 5678));
			ds_client.send(dp_send);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new UDPClient();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			dp_receive = new DatagramPacket(data, data.length);
			ds_client.receive(dp_receive);
			image = new ImageIcon(dp_receive.getData());
			l.setIcon(image);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
