import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Egg {
	int row, col;
	int w = Yard.BLOCK_SIZE, h = Yard.BLOCK_SIZE;
	static Random r = new Random();
	public Egg(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public Egg () {
		this(r.nextInt(Yard.ROWS-5) + 3, r.nextInt(Yard.COLS-5) + 2);
	}
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fill3DRect(col*Yard.BLOCK_SIZE, row*Yard.BLOCK_SIZE, w, h, true);
		g.setColor(c);
	}
	public Rectangle getRect() {
		return new Rectangle(col*Yard.BLOCK_SIZE, row*Yard.BLOCK_SIZE, w, h);
	}
	public void reAppear() {
		this.row = r.nextInt(Yard.ROWS-5) + 3;
		this.col = r.nextInt(Yard.COLS-5) + 2;
	}
}
