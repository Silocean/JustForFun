import java.util.*;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		
		s1.add(new Integer(1));
		s1.add(new Integer(2));
		s1.add(new Integer(3));
		s1.add(new Integer(4));
		s2.add(new Integer(1));
		s2.add(new Integer(2));
		s2.add(new Integer(5));
		s2.add(new Integer(6));
		
		Set<Integer> su = new HashSet<Integer>(s1);
		su.addAll(s2);
		System.out.println(su);
		Set<Integer> sn = new HashSet<Integer>(s1);
		sn.retainAll(s2);
		System.out.println(sn);
		Iterator i = sn.iterator();
		while(i.hasNext()) {
			su.remove(i.next());
		}
		System.out.println(su);
		
	}

}
