import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class TestDialog {
	
	/*public TestDialog() {
		JDialog d = new JDialog();
		d.setSize(300, 200);
		d.setVisible(true);
		d.setLocationRelativeTo(null);
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestDialog();
		showDialog();
	}
	
	public static void showDialog() {
		//int count = 0 ;
		int m = 1;
		String str = JOptionPane.showInputDialog(null,"请输入字符串:","消息",JOptionPane.QUESTION_MESSAGE);
		if(str != null) {
			char[] c = str.toCharArray();
			for(int i=0; i<c.length/2; i++) {
				if(c[i] != c[c.length-i-1]) {
					//count ++;
					m = 0;
					break;
				}
			}
			//if(count == c.length/2)
			if(m == 1)
			JOptionPane.showMessageDialog(null, str + "是一个回文串");
		}
		
	}

}
