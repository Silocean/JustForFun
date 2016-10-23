import java.util.ArrayList;
import java.util.List;

public class Test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showTotalCowNum(7);
	}

	public static void showTotalCowNum(int n) {
		List<Cow> list = new ArrayList<Cow>();
		list.add(new Cow());

		for (int i = 0; i < n; i++) {
			int cowCount = list.size();
			for (int j = 0; j < cowCount; j++) {
				Cow cow = list.get(j).afterYear();
				if (cow != null) {
					cowCount++;
					list.add(cow);
				}
			}
		}
		System.out.println(n + "年后，共有：" + list.size());
	}

}

class Cow {
	int age;

	public Cow afterYear() {
		age++;
		return age > 2 ? new Cow() : null;
	}

}