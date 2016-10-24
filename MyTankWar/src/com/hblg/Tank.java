package com.hblg;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Tank {
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	int x, y;
	
	int oddX = x;
	int oddY = y;
	
	private boolean bL = false, bU = false, bR = false, bD = false;
	
	private boolean live = true;
	private boolean good;
	
	private int life = 100;
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public boolean isGood() {
		return good;
	}

	private static Random r = new Random();
	private static int step = r.nextInt(30) + 3;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	Direction dir = Direction.STOP;
	Direction ptDir = Direction.U;
	
	TankClient tc;
	
	public Tank(int x, int y, boolean good, Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		if(!live) {
			tc.tanks.remove(this);
			return;
		}
		Color c = g.getColor();
		if(good) g.setColor(Color.red);
		if(!good) g.setColor(Color.blue);
		g.fillOval(x, y, WIDTH, HEIGHT);
		if(good) {
			g.setColor(Color.red);
			g.drawRect(x, y-10, WIDTH, 8);
			int w = WIDTH * life / 100;
			g.fillRect(x, y-10, w, 8);
		}
		
		g.setColor(Color.white);
		switch(ptDir) {
		case L :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT / 2);
			break;
		case LU :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y);
			break;
		case U :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y);
			break;
		case RU :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);
			break;
		case R :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);
			break;
		case RD :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT);
			break;
		case D :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y + Tank.HEIGHT);
			break;
		case LD :
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT);
			break;
		}
		
		g.setColor(c);

		move();
	}

	private void move() {
		this.oddX = x;
		this.oddY = y;
		
		switch(dir) {
		case L :
			x -= 5;
			break;
		case LU :
			x -= 5;
			y -= 5;
			break;
		case U :
			y -= 5;
			break;
		case RU :
			x += 5;
			y -= 5;
			break;
		case R :
			x += 5;
			break;
		case RD :
			x += 5;
			y += 5;
			break;
		case D :
			y += 5;
			break;
		case LD :
			x -= 5;
			y += 5;
			break;
		case STOP :
			break;
		}
		
		if(this.dir != Direction.STOP) {
			this.ptDir = this.dir;
		}
		
		if(x <= 0) x = 0;
		if(y <= 50) y = 47;
		if(x >= TankClient.WINDOW_WIDTH - Tank.WIDTH) x = TankClient.WINDOW_WIDTH - Tank.WIDTH;
		if(y >= TankClient.WINDOW_HEIGHT - Tank.HEIGHT) y = TankClient.WINDOW_HEIGHT - Tank.HEIGHT;
		
		if(!good) {
			Direction[] dirs = Direction.values();
			if(step == 0) {
				step = r.nextInt(30) + 3;
				int rn = r.nextInt(dirs.length);
				dir = dirs[rn];
			}
			step --;
			
			if(r.nextInt(40) > 37) {
				fire();
			}
		}
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_F2 :
			if(this.live==false) {
				this.setLive(true);
				this.setLife(100);
			}
			break;
		case KeyEvent.VK_A :
			bL = true;
			break;
		case KeyEvent.VK_W :
			bU = true;
			break;
		case KeyEvent.VK_D :
			bR = true;
			break;
		case KeyEvent.VK_S :
			bD = true;
			break;
		}
		locateDirection();
	}
	
	private void locateDirection() {
		if(bL && !bU && ! bR && !bD) dir = Direction.L;
		else if(bL && bU && ! bR && !bD) dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && bU && bR && !bD) dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && bR && bD) dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(bL && !bU && !bR && bD) dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_I :
			superFire();
			break;
		case KeyEvent.VK_J :
			fire();
			break;
		case KeyEvent.VK_A :
			bL = false;
			break;
		case KeyEvent.VK_W :
			bU = false;
			break;
		case KeyEvent.VK_D :
			bR = false;
			break;
		case KeyEvent.VK_S :
			bD = false;
			break;
		}
		locateDirection();
	}
	
	private Missile fire() {
		if(!live) return null;
		
		int x = this.x + Tank.WIDTH / 2 -Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 -Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, good, ptDir, tc);
		tc.missiles.add(m);
		return m;
	}
	
	private Missile fire(Direction dir) {
		if(!live) return null;
		
		int x = this.x + Tank.WIDTH / 2 -Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 -Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, good, dir, tc);
		tc.missiles.add(m);
		return m;
	}
	
	private void superFire() {
		Direction[] dirs = Direction.values();
		for(int i=0; i<8; i++) {
			fire(dirs[i]);
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public boolean beHitted(Missile m) {
		if(this.getRect().intersects(m.getRect()) && m.isLive()) {
			m.setLive(false);
			this.setLive(false);
			return true;
		}
		return false;
	}
	
	public boolean hitWall(Wall w) {
		if(this.isLive() && this.getRect().intersects(w.getRect())) {
			this.stay();
			return true;
		}
		return false;
	}
	
	public  boolean collidesWithTank(List<Tank> tanks) {
		for(int i=0; i<tanks.size(); i++) {
			Tank t = tanks.get(i);
			if(this != t) {
				if(this.isLive() && t.isLive() && this.getRect().intersects(t.getRect())) {
					this.stay();
					return true;
				}
			}
		}
		return false;
	}

	private void stay() {
		x = this.oddX;
		y = this.oddY;
	}
	
	public void eatBlood(Blood b) {
		if(this.isLive() && b.isLive() && this.getRect().intersects(b.getRect())) {
			b.setLive(false);
			this.setLife(100);
		}
	}
	
}










