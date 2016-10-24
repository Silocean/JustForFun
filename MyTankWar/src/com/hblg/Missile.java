package com.hblg;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;

public class Missile {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	int x, y;
	Direction dir;
	TankClient tc;
	
	private boolean live = true;
	private boolean good;

	public boolean isGood() {
		return good;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Missile(int x, int y, boolean good, Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(!live) return;
		Color c = g.getColor();
		if(good) g.setColor(Color.red);
		if(!good) g.setColor(Color.blue);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
		move();
	}
	
	private void move() {
		switch(dir) {
		case L :
			x -= 10;
			break;
		case LU :
			x -= 10;
			y -= 10;
			break;
		case U :
			y -= 10;
			break;
		case RU :
			x += 10;
			y -= 10;
			break;
		case R :
			x += 10;
			break;
		case RD :
			x += 10;
			y += 10;
			break;
		case D :
			y += 10;
			break;
		case LD :
			x -= 10;
			y += 10;
			break;
		}
		
		if(x < 0 || y < 0 || x > tc.WINDOW_WIDTH || y > tc.WINDOW_HEIGHT) {
			tc.missiles.remove(this);
		}
	}
	
	public boolean hitTank(Tank t) {
		if(this.isLive() && this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood()) {
			if(t.isGood()) {
				t.setLife(t.getLife() - 20);
				if(t.getLife() <= 0) {
					t.setLive(false);
				}
			} else
				t.setLive(false);
			this.setLive(false);
			Explode e = new Explode(x, y, tc);
			tc.explodes.add(e);
			tc.missiles.remove(this);
			return true;
		}
		return false;
	}
	
	public boolean hitTanks(List<Tank> enemyTanks) {
		for(int i=0; i<enemyTanks.size(); i++) {
			if(hitTank(enemyTanks.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public boolean hitWall(Wall w) {
		if(this.isLive() && this.getRect().intersects(w.getRect())) {
			this.setLive(false);
			tc.missiles.remove(this);
			return true;
		}
		return false;
	}
	
//	public boolean hitMissile(Missile m) {
//		if(this.isLive() && m.isLive() && this.getRect().intersects(m.getRect()) && this.good != m.good) {
//			this.setLive(false);
//			m.setLive(false);
//			tc.missiles.remove(this);
//			tc.missiles.remove(m);
//			return true;
//		}
//		return false;
//	}

	
}








