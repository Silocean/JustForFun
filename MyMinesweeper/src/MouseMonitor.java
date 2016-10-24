import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


public class MouseMonitor implements ActionListener {
	
	MainFrame mf;
	int row, col;
	
	public MouseMonitor(MainFrame mf, int row, int col) {
		this.mf = mf;
		this.row = row;
		this.col = col;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			setType(row, col);
	}
	
	public void setType(int row, int col) {
		MyButton button = mf.getMyButton()[row][col];
		Border bor = BorderFactory.createLoweredBevelBorder();

		if(button.getBorder() != bor) {
			MainFrame.jishu ++;
			//System.out.println(mf.jishu);
		}
		button.setIcon(null);
		//button.setEnabled(false);
		button.setBorder(bor);
		
		
		//判断是不是点到了雷
		if(mf.isBoomPosi(row, col, mf.getRows(), mf.getRandomPosi())) {
			//把所有的雷标示出来
			for(int i=0; i<mf.getRows(); i++) {
				for(int j=0; j<mf.getCols(); j++) {
					int posi = mf.getPosi(i, j, mf.getRows());
					System.out.println(posi);
					for(int a=0; a<mf.getBoomNum(); a++) {
						if(posi == mf.getRandomPosi()[a]) {
							mf.getMyButton()[i][j].setText("");
							mf.getMyButton()[i][j].setIcon(new Image().dilei_image);
							//mf.getMyButton()[i][j].setBackground(Color.red);
							mf.getMyButton()[i][j].setBorder(bor);
							//mf.getMyButton()[i][j].setEnabled(false);
						}
					}
				}
			}
			JOptionPane.showMessageDialog(mf, "o(╯□╰)o  完蛋了吧", "游戏结束", JOptionPane.INFORMATION_MESSAGE , new Image().info_lose_image);
			//button.setBackground(Color.yellow);
		} else if(MainFrame.jishu == (mf.getRows()*mf.getCols() - mf.getBoomNum())) {
			JOptionPane.showMessageDialog(mf, "好吧，你赢了", "游戏结束", JOptionPane.INFORMATION_MESSAGE , new Image().info_win_image);
		} else {
			int count = mf.getBoomCount(row, col);
			if(count>0) {
				if(count == 1) button.setIcon(new Image().button_image1);
				if(count == 2) button.setIcon(new Image().button_image2);
				if(count == 3) button.setIcon(new Image().button_image3);
				if(count == 4) button.setIcon(new Image().button_image4);
				if(count == 5) button.setIcon(new Image().button_image5);
				if(count == 6) button.setIcon(new Image().button_image6);
				if(count == 7) button.setIcon(new Image().button_image7);
				if(count == 8) button.setIcon(new Image().button_image8);
				//button.setText(count+"");
			} else {
				int[][] aroundPos = mf.aroundPosi(row, col);
				for (int i = 0; i < aroundPos.length; i++) {
					if(mf.isLegal(aroundPos[i][0], aroundPos[i][1], mf.getRows(), mf.getCols())) {
						if(mf.getMyButton()[aroundPos[i][0]][aroundPos[i][1]].getBorder() != bor) {
							setType(aroundPos[i][0], aroundPos[i][1]);
						}
					}
				}
			}
		}
	}
	
}
