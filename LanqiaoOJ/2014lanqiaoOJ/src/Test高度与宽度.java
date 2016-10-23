import java.util.Scanner;


public class Test高度与宽度 {
	
	public static int[][] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		arr = new int[2][num];
		String str = scan.nextLine();
		String[] splitArr = str.split(" ");
		/*for(int i=0; i<splitArr.length; i++) {
			System.out.println(splitArr[i]);
		}*/
		for(int i=0; i<arr[0].length; i++) {
			arr[0][i] = Integer.parseInt(splitArr[i]);
			arr[1][i] = 1;
		}
		
		for(int i=0; i<arr[0].length; i++) {
			for(int j=i+1; j<arr[0].length; j++) {
				if(arr[0][i] == arr[0][j]) {
					arr[1][i] ++;
				}
			}
		}
		int count = 0;
		int max = 0;
		for(int i=0; i<arr[0].length; i++) {
			if(arr[1][i]>max) {
				max = arr[1][i];
			}
		}
		for(int i=0; i<arr[0].length; i++) {
			if(arr[1][i] == max) {
				System.out.println("its width is " + max + ",its height is " + arr[0][i]);
			}
		}
	}

}
