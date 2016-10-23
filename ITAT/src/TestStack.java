
public class TestStack {
	public static void main(String[] args) {
		System.out.println(f(10));
	}
	
	public static int f(int a) {
		if(a == 1) {
			return 3;
		} else if(a == 2) {
			return 8;
		} else {
			return (f(a-1) + f(a-2)) * 2;
		}
	}
}
