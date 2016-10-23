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
	// 菜单栏
	JMenuBar mb = new JMenuBar();
	// 文件菜单
	JMenu fileMenu = new JMenu("文件");
	// 打开文件菜单项
	JMenuItem openMenuItem = new JMenuItem("打开");
	// 退出程序菜单项
	JMenuItem exitMenuItem = new JMenuItem("退出");
	// 关于菜单
	JMenu aboutMenu = new JMenu("关于");
	// 关于菜单项
	JMenuItem aboutMenuItem = new JMenuItem("^(oo)^");
	// 上一张图片按钮	
	JButton bLast = new JButton("上一张");
	// 图片数量标签
	JLabel lCount = new JLabel();
	// 下一张图片按钮
	JButton bNext = new JButton("下一张");
	// 显示图片的主面板
	MyPanel mp = new MyPanel();
	// 底部面板
	JPanel pSouth = new JPanel();
	// 右键菜单
	JPopupMenu pm = new JPopupMenu();
	// 删除图片菜单项
	JMenuItem deleteMenuItem = new JMenuItem("删除");
	// 图片属性菜单项
	JMenuItem propertyMenuItem = new JMenuItem("属性");
	// 文件对话框
	FileDialog dialog = new FileDialog(this, "打开文件", FileDialog.LOAD);
	// 默认工具包
	Toolkit tk = Toolkit.getDefaultToolkit();
	// 要显示的图片
	Image img = null;
	// 用于保存文件夹中所有图片
	File[] files = null;
	// 图片路径
	String fileDir = null;
	// 当前图片位置
	int indexOfNow = 0;
	// 存放图片格式个集合
	List<String> imgPatternList = new ArrayList<String>();
	// 存放图片路径的集合
	List<String> imgList = new ArrayList<String>();
	// 当前文件夹中所有图片的数量
	int amount = 0;
	// 自身的一个引用变量
	static PictureViewer pv = null;
	
	/*
	 * 构造方法初始化窗体
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
		lCount.setText("共" + amount + "张" + "，当前第" + indexOfNow + "张");
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
		this.setTitle("照片查看器");
		this.setIconImage(tk.getImage(PictureViewer.class.getClassLoader().getResource("icon.png")));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openMenuItem) {
			// 打开文件
			this.openFile();
		} else if(e.getSource() == exitMenuItem) {
			// 退出程序
			this.exit();
		} else if(e.getSource() == aboutMenuItem) {
			// 显示关于程序对话框
			this.showAboutDialog();
		} else if(e.getSource() == bLast) {
			// 显示上一张图片
			this.lastImg();
		} else if(e.getSource() == bNext) {
			// 显示下一张图片
			this.nextImg();
		} else if(e.getSource() == deleteMenuItem) {
			// 删除图片
			this.deleteImg();
		} else if(e.getSource() == propertyMenuItem) {
			// 显示图片属性对话框
			this.showPropertyDialog();
		}
	}
	
	/*
	 * 判断该文件是否为图片
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
	 * 打开文件
	 */
	private void openFile() {
		dialog.setVisible(true);
		if(dialog.getFile() != null) {
			imgList.removeAll(imgList);
			fileDir = dialog.getDirectory();
			files = new File(fileDir).listFiles();
			
			if(!this.isImg(new File(dialog.getFile()))) {
				JOptionPane.showMessageDialog(this, "不支持所选图片格式！请重新选择");
			} else {
				img = tk.getImage(fileDir + dialog.getFile());
			}
			
			// 把所有属于图片的放在一个集合里
			for(int i=0; i<files.length; i++) {
				if(files[i].isFile()) {
					if(this.isImg(files[i])) {
						//System.out.println(files[i]);
						imgList.add(files[i].toString());
					}
				}
			}
			
			amount = imgList.size();
			
			// 找出当前图片所在顺序位置
			for(int i=0; i<imgList.size(); i++) {
				if(imgList.get(i).equals(fileDir+dialog.getFile())) {
					indexOfNow = i;
				}
			}
			
		}
	}
	
	/*
	 * 退出程序
	 */
	private void exit() {
		System.exit(0);
	}
	
	/*
	 * 显示关于程序对话框
	 */
	private void showAboutDialog() {
		JOptionPane.showMessageDialog(
				this,
				"一个简单的照片查看器" + "\n" + "by TracySilocean",
				"关于",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(PictureViewer.class.getClassLoader().getResource(
						"0.gif")));
	}
	
	/*
	 * 显示上一张图片
	 */
	private void lastImg() {
		if(dialog.getFile() != null) {
			if(indexOfNow<=0) {
				//JOptionPane.showMessageDialog(this, "已是第一张！");
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
	 * 显示下一张图片
	 */
	private void nextImg() {
		if(dialog.getFile() != null) {
			if(indexOfNow>=imgList.size()-1) {
				//JOptionPane.showMessageDialog(this, "已是最后一张！");
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
	 * 删除图片
	 */
	private void deleteImg() {
		int type = JOptionPane.showConfirmDialog(this, "确定要删除这张图片吗？", "删除文件", JOptionPane.YES_NO_OPTION);
		if(type == 0) {
			new File(imgList.get(indexOfNow)).delete();
			imgList.remove(indexOfNow);
			if(indexOfNow>=imgList.size()-1) {
				indexOfNow = 0;
			}
			img = tk.getImage(imgList.get(indexOfNow));
		} else if(type == 1) {
			// 不做任何处理
		}
	}
	
	/*
	 * 显示图片属性对话框
	 */
	private void showPropertyDialog() {
		PropertyDialog propertyDialog = new PropertyDialog(this);
		propertyDialog.setVisible(true);
	}
	
	public static void main(String[] args) {
		pv = new PictureViewer();
	}
	
	/*
	 * 显示图片的panel
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
					pv.setTitle("照片查看器—" + new File(imgList.get(indexOfNow)).getName());
				}
				//g.drawString("正在加载……", 450, 270);
				lCount.setText("共" + amount + "张" + "，当前第" + (indexOfNow+1) + "张");
				int width = img.getWidth(null);
				int height = img.getHeight(null);
				int centerX = (mp.getWidth()-width)/2;
				int centerY = (mp.getHeight()-height)/2;
				double scale1 = (double)width/(double)height;
				double scale2 = (double)mp.getWidth()/(double)mp.getHeight();
				// 根据图片尺寸按需显示图片
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
				pv.setTitle("照片查看器");
				img = tk.getImage(PictureViewer.class.getClassLoader().getResource("bg.png"));
				g.drawImage(img, 0, 0, mp.getWidth(), mp.getHeight(), null);
			}
		}
		
		
		/*
		 * 不断刷新图片面板的线程
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
