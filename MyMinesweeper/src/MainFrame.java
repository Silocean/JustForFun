import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	int rows = 9, cols = 9;
	int boomNum = 10;
	
	static int jishu = 0;

	int[] randomPosi;
	
	MyButton[][] myButton = new MyButton[rows][cols];
	
	public MainFrame() {
		/*
		 * 修改界面风格
		 */
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//SwingUtilities.updateComponentTreeUI(this);
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
		
		for(int i=0; i<myButton.length; i++) {
			for(int j=0; j<myButton[i].length; j++) {
				myButton[i][j] = new MyButton();
				myButton[i][j].setIcon(new Image().button_image);
				myButton[i][j].addActionListener(new MouseMonitor(this, i, j));
				myButton[i][j].addMouseListener(new RightMouseMonitor());
				this.add(myButton[i][j]);
			}
		}
		
		randomPosi = getRandomBoomPosi(rows, cols, boomNum);
		for(int i=0; i<randomPosi.length; i++) {
			System.out.println(randomPosi[i]);
		}
		
		this.showAllBoom();
		
		this.setLayout(new GridLayout(rows, cols));
		this.setTitle("扫雷  by(Silocean)");
		this.setIconImage((Toolkit.getDefaultToolkit().getImage(MainFrame.class.getClassLoader().getResource("images/icon.jpg"))));
		this.setSize(cols*30, rows*30+30);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*
	 * 设置雷随机出现的位置
	 */	
	public int[] getRandomBoomPosi(int rows, int cols, int boomNum) {
		int[] boomPosi = new int[boomNum];
		
		int maxPosi = rows*cols;
		boolean flag = true;
		
		boomPosi[0] = (int)(Math.random()*maxPosi)+1;
		for(int i=1; i<boomPosi.length;) {
			int temp = (int)(Math.random()*maxPosi)+1;
			for(int j=0; j<i; j++) {
				if(temp==boomPosi[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				boomPosi[i] = temp;
				i++;
			}
		}
		
		return boomPosi;
	}
	
	/*
	 * 计算鼠标点下的位置
	 */
	public int getPosi(int row, int col, int rows) {
		return row*rows+col+1;
	}
	
	/*
	 * 判断鼠标是否是雷的位置
	 */
	public boolean isBoomPosi(int row, int col, int rows, int[] boomPosi) {
		int posi = this.getPosi(row, col, rows);
		for(int i=0; i<boomPosi.length; i++) {
			if(boomPosi[i]==posi) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 计算周围雷的个数
	 */
	public int getBoomCount(int row, int col) {
		int count = 0;
		
		//拿到周围按钮的坐标
		int[][] posi = aroundPosi(row, col);
		for (int i = 0; i < posi.length; i++) {
			if(isLegal(posi[i][0], posi[i][1], this.getRows(), this.getCols())) {
				if(isBoomPosi(posi[i][0], posi[i][1], rows, this.randomPosi)) {
					count ++;
				}
			}
			
		}
		
		return count;
	}
	
	/*
	 * 判断按钮是否合法
	 */
	public boolean isLegal(int row, int col, int rows, int cols) {
		if(row<0 || row>=rows || col<0 || col>=cols) {
			return false;
		}
		return true;
		
	}
 	
	/*
	 * 返回周围按钮的位置（依据做坐标计算）
	 */
	public int[][] aroundPosi(int row, int col) {
		return new int[][] {
				{row-1, col-1},
				{row-1, col},
				{row-1, col+1},
				{row, col+1},
				{row+1, col+1},
				{row+1, col},
				{row+1, col-1},
				{row, col-1}
		};
	}
	
	/*
	 * 后门——显示出所有雷的位置
	 */
	public void showAllBoom() {
		for(int i=0; i<this.getRows(); i++) {
			for(int j=0; j<this.getCols(); j++) {
				if(isBoomPosi(i, j, this.getRows(), this.randomPosi)) {
					System.out.print("*");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	
	public int[] getRandomPosi() {
		return randomPosi;
	}
	
	public void setRandomPosi(int[] randomPosi) {
		this.randomPosi = randomPosi;
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getBoomNum() {
		return boomNum;
	}

	public void setBoomNum(int boomNum) {
		this.boomNum = boomNum;
	}

	public MyButton[][] getMyButton() {
		return myButton;
	}

	public void setMyButton(MyButton[][] myButton) {
		this.myButton = myButton;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame().setVisible(true);
		
		
		
	}
	
	

}
