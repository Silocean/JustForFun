import java.util.Scanner;


public class Test½Ç¹È²½Êý {

	public static int count = 0;
	
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int index = 1;
		boolean flag = true;
		while(flag) {
			if(countSteps(index) == n) {
				System.out.println(index);
				flag = false;
			} else {
				index ++;
				count = 0;
			}
		}
	}
	
	public static int countSteps(int index) {
		if(index == 1) {
			return 0;
		}
		boolean flag = true;
		while(flag) {
			if(index == 1) {
				return count;
			}
			if(index%2==1) {
				index = index * 3 + 1;
				count ++;
			} else if(index%2==0) {
				index = index / 2;
				count ++;
			}
		}
		return 0;
	}

}
