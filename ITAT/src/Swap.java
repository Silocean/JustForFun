
public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 2;
		swap(a, b);
	}
	
	public static void swap(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println(a);
	}

}
