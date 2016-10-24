import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RightMouseMonitor extends MouseAdapter {

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger()) {
			MyButton but = (MyButton)e.getSource();
			if(but.getIcon() != null) {
				but.setIcon(null);
				but.setText("À×");
				//but.setEnabled(false);
			} else if(but.getText() == "À×") {
				but.setText("");
				but.setIcon(new Image().button_image);
				but.setEnabled(true);
			}
		}
	}
	
}
