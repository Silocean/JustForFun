public class Count3Quit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] a = new boolean[500];
		for (int i = 0; i < a.length; i++) {
			a[i] = true;
		}

		int amount = a.length;
		int count = 0;
		int index = 0;

		while (amount > 1) {
			if(a[index] == true) {
				count ++;
				if(count == 3) {
					count = 0;
					a[index] = false;
					amount --;
				}
			}
			index ++;
			if(index == a.length) {
				index = 0;
			}
		}
		
		for(int i=0; i<a.length; i++) {
			if(a[i] == true) {
				System.out.println(i);
			}
		}
		
		//System.out.println(index);

	}

}
