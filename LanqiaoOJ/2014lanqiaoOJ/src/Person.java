import java.util.Scanner;


public class Person {
	public static void main(String[] args) {
		double a = new Scanner(System.in).nextDouble();
		if(a<0) {
			try {
				throw new Exception("你输入的数小于零");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Math.sqrt(a));
		}
	}
}

