package com.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ui.ImgPanel;

public class MouseMonitor implements MouseListener {
	
	ImgPanel ip;
	
	public MouseMonitor(ImgPanel ip) {
		this.ip = ip;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ip.startBut) {
			ip.setStart(true);
			ip.thread.start();
		} 
		if(e.getSource() == ip) {
			System.out.println("x" + e.getX() + " y" + e.getY());
			if(e.getX()>ip.hole.getX() && e.getX()<ip.hole.getX()+ip.mouseImg.getWidth() && e.getY()>ip.hole.getY() && e.getY()<ip.hole.getY()+ip.mouseImg.getHeight()) {
				ip.g.drawImage(ip.mouse_bgImg, ip.hole.getX(), ip.hole.getY(), null);
				ip.score += 10;
				ip.repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
