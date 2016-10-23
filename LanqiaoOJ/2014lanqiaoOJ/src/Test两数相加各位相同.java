
public class Test两数相加各位相同 {
	
	public static void main(String[] args) {
		for(int i=1; i<=20; i++) {
			for(int j=1; j<=20; j++) {
				int num = i + j;
				if(num>10) {
					if(num/10 == num%10) {
						System.out.println(i + "+" + j + "=" + num);
					}
				}
			}
		}
	}

}
