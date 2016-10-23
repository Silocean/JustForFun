import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TestÆË¿ËÅÆ {

	/**
	 * @param args
	 */
	public static List<String> moveCard(List<String> src) {
		if (src == null)
			return null;

		List<String> dst = new Vector<String>();
		for (;;) {
			if (src.size() < 1)
				break; // Ìî¿Õ
			src.add(src.remove(0));
			dst.add(src.remove(0)); // Ìî¿Õ
		}

		return dst;
	}

	public static void main(String[] args) {
		List<String> a = new Vector<String>();
		a.addAll(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "J", "Q", "K"));
		/*a.add(a.remove(0));
		System.out.println(a);
		System.out.println(a.get(0));*/
		System.out.println(moveCard(a));
	}

}
