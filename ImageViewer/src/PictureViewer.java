import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


public class PictureViewer extends JFrame implements ActionListener,KeyListener {
	
	/**
	 * author Silocean
	 */
	private static final long serialVersionUID = 7249010546054183791L;
	// �˵���
	JMenuBar mb = new JMenuBar();
	// �ļ��˵�
	JMenu fileMenu = new JMenu("�ļ�");
	// ���ļ��˵���
	JMenuItem openMenuItem = new JMenuItem("��");
	// �˳�����˵���
	JMenuItem exitMenuItem = new JMenuItem("�˳�");
	// ���ڲ˵�
	JMenu aboutMenu = new JMenu("����");
	// ���ڲ˵���
	JMenuItem aboutMenuItem = new JMenuItem("^(oo)^");
	// ��һ��ͼƬ��ť	
	JButton bLast = new JButton("��һ��");
	// ͼƬ������ǩ
	JLabel lCount = new JLabel();
	// ��һ��ͼƬ��ť
	JButton bNext = new JButton("��һ��");
	// ��ʾͼƬ�������
	MyPanel mp = new MyPanel();
	// �ײ����
	JPanel pSouth = new JPanel();
	// �Ҽ��˵�
	JPopupMenu pm = new JPopupMenu();
	// ɾ��ͼƬ�˵���
	JMenuItem deleteMenuItem = new JMenuItem("ɾ��");
	// ͼƬ���Բ˵���
	JMenuItem propertyMenuItem = new JMenuItem("����");
	// �ļ��Ի���
	FileDialog dialog = new FileDialog(this, "���ļ�", FileDialog.LOAD);
	// Ĭ�Ϲ��߰�
	Toolkit tk = Toolkit.getDefaultToolkit();
	// Ҫ��ʾ��ͼƬ
	Image img = null;
	// ���ڱ����ļ���������ͼƬ
	File[] files = null;
	// ͼƬ·��
	String fileDir = null;
	// ��ǰͼƬλ��
	int indexOfNow = 0;
	// ���ͼƬ��ʽ������
	List<String> imgPatternList = new ArrayList<String>();
	// ���ͼƬ·���ļ���
	List<String> imgList = new ArrayList<String>();
	// ��ǰ�ļ���������ͼƬ������
	int amount = 0;
	// �����һ�����ñ���
	static PictureViewer pv = null;
	
	/*
	 * ���췽����ʼ������
	 */
	public PictureViewer() {
		this.setJMenuBar(mb);
		mb.add(fileMenu);
		fileMenu.add(openMenuItem);
		fileMenu.add(exitMenuItem);
		mb.add(aboutMenu);
		aboutMenu.add(aboutMenuItem);
		this.add(mp, BorderLayout.CENTER);
		this.add(pSouth, BorderLayout.SOUTH);
		lCount.setText("��" + amount + "��" + "����ǰ��" + indexOfNow + "��");
		pSouth.add(bLast);
		pSouth.add(lCount);
		pSouth.add(bNext);
		pm.add(deleteMenuItem);
		pm.add(propertyMenuItem);
		openMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		aboutMenuItem.addActionListener(this);
		bLast.addActionListener(this);
		bNext.addActionListener(this);
		bLast.addKeyListener(this);
		bNext.addKeyListener(this);
		deleteMenuItem.addActionListener(this);
		propertyMenuItem.addActionListener(this);
		imgPatternList.add("JPG");
		imgPatternList.add("PNG");
		imgPatternList.add("GIF");
		/*imgPatternList.add("ICO");
		imgPatternList.add("BMP");
		imgPatternList.add("TIF");
		imgPatternList.add("PCX");
		imgPatternList.add("TGA");*/
		this.setSize(1000, 650);
		this.setTitle("��Ƭ�鿴��");
		this.setIconImage(tk.getImage(PictureViewer.class.getClassLoader().getResource("icon.png")));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openMenuItem) {
			// ���ļ�
			this.openFile();
		} else if(e.getSource() == exitMenuItem) {
			// �˳�����
			this.exit();
		} else if(e.getSource() == aboutMenuItem) {
			// ��ʾ���ڳ���Ի���
			this.showAboutDialog();
		} else if(e.getSource() == bLast) {
			// ��ʾ��һ��ͼƬ
			this.lastImg();
		} else if(e.getSource() == bNext) {
			// ��ʾ��һ��ͼƬ
			this.nextImg();
		} else if(e.getSource() == deleteMenuItem) {
			// ɾ��ͼƬ
			this.deleteImg();
		} else if(e.getSource() == propertyMenuItem) {
			// ��ʾͼƬ���ԶԻ���
			this.showPropertyDialog();
		}
	}
	
	/*
	 * �жϸ��ļ��Ƿ�ΪͼƬ
	 */
	private boolean isImg(File f) {
		String postfix = f.toString().substring(f.toString().length()-3, f.toString().length());
		Iterator<String> it = imgPatternList.iterator();
		while(it.hasNext()) {
			String file = it.next();
			if(file.equalsIgnoreCase(postfix)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * ���ļ�
	 */
	private void openFile() {
		dialog.setVisible(true);
		if(dialog.getFile() != null) {
			imgList.removeAll(imgList);
			fileDir = dialog.getDirectory();
			files = new File(fileDir).listFiles();
			
			if(!this.isImg(new File(dialog.getFile()))) {
				JOptionPane.showMessageDialog(this, "��֧����ѡͼƬ��ʽ��������ѡ��");
			} else {
				img = tk.getImage(fileDir + dialog.getFile());
			}
			
			// ����������ͼƬ�ķ���һ��������
			for(int i=0; i<files.length; i++) {
				if(files[i].isFile()) {
					if(this.isImg(files[i])) {
						//System.out.println(files[i]);
						imgList.add(files[i].toString());
					}
				}
			}
			
			amount = imgList.size();
			
			// �ҳ���ǰͼƬ����˳��λ��
			for(int i=0; i<imgList.size(); i++) {
				if(imgList.get(i).equals(fileDir+dialog.getFile())) {
					indexOfNow = i;
				}
			}
			
		}
	}
	
	/*
	 * �˳�����
	 */
	private void exit() {
		System.exit(0);
	}
	
	/*
	 * ��ʾ���ڳ���Ի���
	 */
	private void showAboutDialog() {
		JOptionPane.showMessageDialog(
				this,
				"һ���򵥵���Ƭ�鿴��" + "\n" + "by TracySilocean",
				"����",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(PictureViewer.class.getClassLoader().getResource(
						"0.gif")));
	}
	
	/*
	 * ��ʾ��һ��ͼƬ
	 */
	private void lastImg() {
		if(dialog.getFile() != null) {
			if(indexOfNow<=0) {
				//JOptionPane.showMessageDialog(this, "���ǵ�һ�ţ�");
				indexOfNow = imgList.size() - 1;
			} else {
				indexOfNow -= 1;
			}
			if(imgList.size() != 0) {
				img = tk.getImage(imgList.get(indexOfNow));
			}
		}
	}
	
	/*
	 * ��ʾ��һ��ͼƬ
	 */
	private void nextImg() {
		if(dialog.getFile() != null) {
			if(indexOfNow>=imgList.size()-1) {
				//JOptionPane.showMessageDialog(this, "�������һ�ţ�");
				indexOfNow = 0;
			} else {
				indexOfNow += 1;
			}
			if(imgList.size() != 0) {
				img = tk.getImage(imgList.get(indexOfNow));
			}
		}
	}
	
	/*
	 * ɾ��ͼƬ
	 */
	private void deleteImg() {
		int type = JOptionPane.showConfirmDialog(this, "ȷ��Ҫɾ������ͼƬ��", "ɾ���ļ�", JOptionPane.YES_NO_OPTION);
		if(type == 0) {
			new File(imgList.get(indexOfNow)).delete();
			imgList.remove(indexOfNow);
			if(indexOfNow>=imgList.size()-1) {
				indexOfNow = 0;
			}
			img = tk.getImage(imgList.get(indexOfNow));
		} else if(type == 1) {
			// �����κδ���
		}
	}
	
	/*
	 * ��ʾͼƬ���ԶԻ���
	 */
	private void showPropertyDialog() {
		PropertyDialog propertyDialog = new PropertyDialog(this);
		propertyDialog.setVisible(true);
	}
	
	public static void main(String[] args) {
		pv = new PictureViewer();
	}
	
	/*
	 * ��ʾͼƬ��panel
	 */
	private class MyPanel extends JPanel implements MouseListener {
		
		public MyPanel() {
			this.addMouseListener(this);
			new Thread(new PaintThread()).start();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(dialog.getFile() != null) {
				if(pv.isImg(new File(dialog.getFile()))) { 
					pv.setTitle("��Ƭ�鿴����" + new File(imgList.get(indexOfNow)).getName());
				}
				//g.drawString("���ڼ��ء���", 450, 270);
				lCount.setText("��" + amount + "��" + "����ǰ��" + (indexOfNow+1) + "��");
				int width = img.getWidth(null);
				int height = img.getHeight(null);
				int centerX = (mp.getWidth()-width)/2;
				int centerY = (mp.getHeight()-height)/2;
				double scale1 = (double)width/(double)height;
				double scale2 = (double)mp.getWidth()/(double)mp.getHeight();
				// ����ͼƬ�ߴ簴����ʾͼƬ
				if(width>=mp.getWidth() && height<=mp.getHeight()) {
					g.drawImage(img, 0, (mp.getHeight()-(height*mp.getWidth()/width))/2, mp.getWidth(), height*mp.getWidth()/width, null);
				} else if(width<=mp.getWidth() && height>=mp.getHeight()) {
					g.drawImage(img, (mp.getWidth()-(width*mp.getHeight()/height))/2, 0, width*mp.getHeight()/height, mp.getHeight(), null);
				} else if(width>=mp.getWidth() && height>=mp.getHeight()) {
					if(scale1<scale2) {
						g.drawImage(img, (mp.getWidth()-(width*mp.getHeight()/height))/2, 0, width*mp.getHeight()/height, mp.getHeight(), null);
					} else {
						g.drawImage(img, 0, (mp.getHeight()-(height*mp.getWidth()/width))/2, mp.getWidth(), height*mp.getWidth()/width, null);
					}
				} else {
					g.drawImage(img, centerX, centerY, null);
				}
			} else {
				pv.setTitle("��Ƭ�鿴��");
				img = tk.getImage(PictureViewer.class.getClassLoader().getResource("bg.png"));
				g.drawImage(img, 0, 0, mp.getWidth(), mp.getHeight(), null);
			}
		}
		
		
		/*
		 * ����ˢ��ͼƬ�����߳�
		 */
		class PaintThread implements Runnable {

			@Override
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if(dialog.getFile() != null) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					pm.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_LEFT:
			this.lastImg();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_RIGHT:
			this.nextImg();
			break;
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
