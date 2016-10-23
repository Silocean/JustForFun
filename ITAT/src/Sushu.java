
public class Sushu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag;
		for(int i=1; i<=100; i++) {
			flag = true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j == 0) {
					flag = false;
				}
			}
			if(flag == false) continue;
			System.out.println(i);
		}
	}

}
