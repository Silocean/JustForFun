package ������ϰ;

import java.util.Scanner;

public class ͼ����ʾ {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int n = new Scanner(System.in).nextInt();
		while(n>=0) {
			for(int i=0; i<n; i++) {
				System.out.print("* ");
			}
			n --;
			System.out.println();
		}
	}

}
