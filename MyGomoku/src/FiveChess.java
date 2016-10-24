import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FiveChess extends JFrame {

	private static final int FRAME_WIDTH = 20 + 26 * 20;
	private static final int FRAME_HEIGHT = 20 + 22 * 20 + 30;

	private MyPanel panel = new MyPanel();

	public FiveChess() {
		this.add(panel);
		this.setTitle("单机版五子棋");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				FiveChess.class.getClassLoader().getResource("icon.png")));
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FiveChess();
	}

}
