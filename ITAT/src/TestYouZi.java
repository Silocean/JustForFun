import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TestYouZi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<=5; i++) {
			for(int j=0; j<=4; j++) {
				if(i==0 && j==0) {
					continue;
				}
				int m = i*3 + j*5;
				set.add(m);
			}
		}
		
		System.out.println("一共有" + set.size() + "种邮资" );
		
		Integer[] ob = new Integer[set.size()];
		int index = 0;
		Iterator it = set.iterator();
		while(it.hasNext()) {
			ob[index] = (Integer)it.next();
			index ++;
		}
		
		int temp;
		for(int i=0; i<ob.length; i++) {
			for(int j=i+1; j<ob.length; j++) {
				if(ob[j] < ob[i]) {
					temp = ob[i];
					ob[i] = ob[j];
					ob[j] = temp;
				}
			}
		}
		for(int i=0; i<ob.length; i++) {
			System.out.print(ob[i] + " ");
		}
	}

}
