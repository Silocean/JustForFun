import javax.swing.*;
public class TestException {
	public static void main(String[] args) {
		Student2 s = new Student2();
		try {
			s.speak(1024);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyException extends Exception {
	public MyException() {
		super("m的值必須<1000,請重新輸入！！");
		//JOptionPane.showMessageDialog(null, "cuowu");
	}
}

class Student2 {
	public void speak(int m) throws MyException {
		if(m>1000) {
			throw new MyException();
		}
	}
}
