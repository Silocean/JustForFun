import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	public static final int WINDWO_WIDTH = 800 - 4;
	public static final int WINDWO_HEIGHT = 600 - 10;
	public static final int BLOCK_SIZE = 15;

	Icon startIcon = new ImageIcon(MainFrame.class.getClassLoader()
			.getResource("images/start.png"));
	Icon pause_1 = new ImageIcon(MainFrame.class.getClassLoader().getResource(
			"images/pause-1.png"));
	Icon pause_2 = new ImageIcon(MainFrame.class.getClassLoader().getResource(
			"images/pause-2.png"));
	Icon reStart = new ImageIcon(MainFrame.class.getClassLoader().getResource(
			"images/reStart.png"));
	AudioClip ac = Applet.newAudioClip(this.getClass().getResource(
			"music/Nujabes - Aruarian Dance.wav"));
	public static int score = 0;

	Yard yard = new Yard(this);

	JPanel pRight = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JLabel labelScore = new JLabel("得分:", JLabel.CENTER);
	JLabel labelState = new JLabel("(*∩_∩*)", JLabel.CENTER);
	Choice difficultChoice = new Choice();
	JButton bStart = new JButton(startIcon);
	JButton bPause = new JButton(pause_2);
	JButton bRestart = new JButton(reStart);

	public void launch() {
		ac.loop();
		difficultChoice.add("简单");
		difficultChoice.add("中等");
		difficultChoice.add("巨难");
		p1.setLayout(new GridLayout(2, 1));
		p1.add(labelScore);
		p1.add(labelState);
		p1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		p2.setLayout(new GridLayout(3, 1));
		// p2.add(difficultChoice);
		p2.add(bStart);
		p2.add(bPause);
		p2.add(bRestart);
		bRestart.setEnabled(false);
		bPause.setEnabled(false);
		bStart.addActionListener(this);
		bPause.addActionListener(this);
		bRestart.addActionListener(this);
		p2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pRight.setLayout(new GridLayout(2, 1));
		pRight.add(p1);
		pRight.add(p2);
		this.add(yard, BorderLayout.CENTER);
		this.add(pRight, BorderLayout.EAST);
		this.setTitle("`(*∩_∩*)′");
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(
						MainFrame.class.getClassLoader().getResource(
								"images/icon.png")));
		this.setSize(MainFrame.WINDWO_WIDTH, MainFrame.WINDWO_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		yard.requestFocus(); // 注意不能写在setVisible()之前
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(yard.getSize());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MainFrame().launch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		yard.actionPerformed(e);
	}

}
