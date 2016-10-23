import java.util.Scanner;


public class Test»ØÐýÊý×é {
	
	private static int[][] arr;
	
	int row = 0;

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int length = 2*n-1;
		arr = new int[length][length];
		huiXuan(length, 0, 1);
		printf();
	}

	private static void printf() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void huiXuan(int length, int row, int num) {
		for(int i=0; i<length; i++) {
			arr[row][row+i] = num;
		}
		for(int i=1; i<length; i++) {
			arr[row+i][row+length-1] = num;
		}
		for(int i=length-1; i>=0; i--) {
			arr[row+length-1][row+i] = num;
		}
		for(int i=length-1; i>0; i--) {
			arr[row+i][row] = num;
		}
		if(length<1) {
			return;
		}
		huiXuan(length-2, row+1, num+1);
	}

}
