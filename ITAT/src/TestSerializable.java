import java.io.*;

public class TestSerializable {
	public static void main(String[] args) throws Exception{
		Student1 s = new Student1();
		FileOutputStream fos = new FileOutputStream("d:\\data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		fos.close();
		FileInputStream fis = new FileInputStream("d:\\data.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student1 student = (Student1)ois.readObject();
		System.out.println(student.id +" " + student.name + " " + student.age + " " + student.department);
	}
}

class Student1 implements Serializable{
	int id = 2011;
	String name = "蘇打綠";
	int age = 18;
	String department = "湖北理工";
}
