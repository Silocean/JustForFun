import java.util.*;

public class TestTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new LinkedList();
		list.add("ĞÕÃû");
		list.add("Ñ§ºÅ");
		list.add("³É¼¨");
		list.add("ÕÔºÆÃñ");
		list.add(9012);
		list.add(80.0);
		list.add("Ç®ÏşÇì");
		list.add(9013);
		list.add(90.0);
		list.add("ËÕÀöÃ·");
		list.add(9014);
		list.add(78.0);
		list.add("ÖÜ×óÓÒ");
		list.add(9015);
		list.add(55.0);
		Iterator i = list.iterator();
		while(i.hasNext()) {
			for(int j=1; j<=list.size(); j++) {
				System.out.print(i.next() + "\t");
				if(j%3 == 0) System.out.println();
			}
		}
	}

}
