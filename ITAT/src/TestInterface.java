
public class TestInterface implements Student{
	public static void main(String[] args) {
		new TestInterface().getStudentName();
	}

	@Override
	public void getStudentName() {
		// TODO Auto-generated method stub
		for(String s : name) {
			System.out.println(s);
		}
	}
}

interface Student {
	String[] name = {"xiaonan","liming","zhengshuang","sudalv","jay","shaonian"};
	void getStudentName();
}