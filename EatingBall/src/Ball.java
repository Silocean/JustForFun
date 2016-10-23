import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
	
	MainFrame mf;
	
	//�Լ��Ĵ�С
	int width = 20;
	int height = 20;
	//������������ܳ��ֵ���ɫ
	Color[] color = new Color[]{Color.red, Color.BLUE, Color.yellow, Color.CYAN, Color.green, Color.MAGENTA, Color.ORANGE, Color.pink};
	//�Լ���λ��
	int x = (int)(Math.random()*MainFrame.WIN_WIDTH-width);
	int y = 30 + (int)(Math.random()*MainFrame.WIN_HEIGHT-30-height);
	
	//����������������ɫ
	Color col = color[(int)(Math.random()*color.length)];
	
	int step = 0;
	boolean live = true;
	
	public Ball(MainFrame mf) {
		this.mf = mf;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(col);
		g.fillOval(x, y, width, height);
		g.setColor(c);
	}
	
	public boolean collideWithBall() {
		if(mf.getRect().intersects(this.getRect())) {
			return true;
		}
		return false;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
	
}
