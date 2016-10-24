package com.hblg;
import java.awt.*;

public class Explode {
	int x, y;
	TankClient tc;
	
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	int step = 0;
	int[] diameter = {4, 6, 12, 18, 29, 37, 25, 14, 6, 2};
	
	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(!live) return;
		Color c = g.getColor();
		g.setColor(Color.orange);
		g.fillOval(x, y, diameter[step], diameter[step]);
		g.setColor(c);
		step ++;
		if(step ==diameter.length) {
			live = false;
			step = 0;
			return;
		}
	}
	
}
