
public class TestººÅµËþ {
	
	static int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(7);
		System.out.println(count);
	}
	
	public static void hanoi(int n) {
		count ++;
		if(n==1) {
			move();
		} else {
			hanoi(n-1);
			move();
			hanoi(n-1);
		}
	}
	
	public static void move() {
		
	}

}
