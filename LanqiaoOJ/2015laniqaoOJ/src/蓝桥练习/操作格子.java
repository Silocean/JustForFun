package À¶ÇÅÁ·Ï°;

import java.util.ArrayList;
import java.util.Scanner;

public class ²Ù×÷¸ñ×Ó {

	public static int n, m, p, x, y;

	public static int arr[];
	
	public static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			p = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			operate(p, x, y);
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		sc.close();
	}

	private static void operate(int p, int x, int y) {
		//System.out.println(p + "," + x + "," + y);
		if (p == 1) {
			arr[x - 1] = arr[y - 1];
		} else if (p == 2) {
			int result = 0;
			for(int i=x-1; i<=y-1; i++) {
				result += arr[i];
			}
			list.add(result);
		} else if (p == 3) {
			int max = Integer.MIN_VALUE;
			for(int i=x-1; i<=y-1; i++) {
				if(arr[i] > max) {
					max = arr[i];
				}
			}
			list.add(max);
		}
	}

}
