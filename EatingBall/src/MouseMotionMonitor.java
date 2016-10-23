import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseMotionMonitor implements MouseMotionListener {
	MainFrame mf;
	
	public MouseMotionMonitor(MainFrame mf) {
		this.mf = mf;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mf.x = e.getX();
		mf.y = e.getY();
		//System.out.println(e.getX() + " " + e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
