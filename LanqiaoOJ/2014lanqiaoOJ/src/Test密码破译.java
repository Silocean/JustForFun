import java.util.Scanner;
/*
 * ��num1�������ҳ����������������num2������λ��
 */

public class Test�������� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = Integer.parseInt(scan.nextLine());
		int num2 = Integer.parseInt(scan.nextLine());
		int[] arr = new int[num1];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(scan.nextLine());
		}
		for(int i=0; i<arr.length-1; i++) {
			int temp = 1;
			while(temp<arr.length-i) {
				if(arr[i] + arr[i+temp] == num2) {
					System.out.println(i+1);
					System.out.println(i+temp+1);
					break;
				}
				temp ++;
			}
		}
	}

}
