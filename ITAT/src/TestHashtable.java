import java.util.*;

public class TestHashtable {
	static Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestHashtable t = new TestHashtable();
		Student5[] students = { new Student5("王晓琳", 199901, 46),
				new Student5("能林茂", 199902, 70),
				new Student5("多种林", 199903, 93),
				new Student5("围林蛤", 199904, 46),
				new Student5("夹茂林", 199905, 77),
				new Student5("降王林", 199907, 68),
				new Student5("纠林咯", 199908, 76) };
		for (int i = 0; i < students.length; i++) {
			ht.put(students[i].id, students[i].name + students[i].score);
		}
		System.out.println(t.getName(199902) + " " + 199902 + " "
				+ t.getScore(199902));
		System.out.println("散列表中现在有：" + students.length + "个元素");
		Set<Integer> key_set = ht.keySet();
		Iterator<Integer> i = key_set.iterator();
		while (i.hasNext()) {
			int key = i.next();
			System.out.println(t.getName(key) + " " + key + " "
					+ t.getScore(key));
		}
	}

	public String getName(int key) {
		String name = ht.get(key).substring(0, 3);
		return name;
	}

	public String getScore(int key) {
		String score = ht.get(key).substring(3, 5);
		return score;
	}

}

class Student5 {
	String name;
	int id;
	int score;

	public Student5(String name, int id, int score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}
}
