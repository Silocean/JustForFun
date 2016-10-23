
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student4 s = new Student4(2011,"Scott",18,04,"man");
		System.out.println(s.getID());
		System.out.println(s.getClassNO());
		System.out.println(s.getAge());
		s.setAge(102);
		System.out.println(s.getAge());
	}

}

class Student4 {
	int id;
	String name;
	int age;
	int classno;
	String sex;
	public Student4(int id, String name, int age, int classno, String sex) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.classno = classno;
		this.sex = sex;
	}
	
	public int getID() {
		return id;
	}
	public int getClassNO() {
		return classno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}