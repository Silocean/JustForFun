package À¶ÇÅÁ·Ï°;

import java.util.Scanner;

public class ²éÕÒÕûÊı {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int a = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == a) {
				System.out.println(i+1);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			System.out.println(-1);
		}
		sc.close();
	}

}
