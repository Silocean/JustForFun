import java.util.Scanner;

/**

***********
*         *
* ******* *
* *     * *
* * *** * *
* * * * * *
* * *** * *
* *     * *
* ******* *
*         *
***********

观察这个图形，它是由一系列正方形的星号方框嵌套而成。
在上边的例子中，最外方框的边长为11。

本题的任务就是从标准输入获得一个整数n(1<n<100)
程序则生成嵌套着的回字型星号方框。其最外层方框的边长为n

例如：
输入：
5
程序输出：
*****
*   *
* * *
*   *
*****

输入：6
程序输出：
******
*    *
* ** *
* ** *
*    *
******

 */
public class Test回型嵌套 {
	
	public static char[][] arr;

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		arr = new char[n][n];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = ' ';
			}
		}
		go(n, 0);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void go(int length, int row) {
		if(length<0) {
			return;
		}
		for(int i=0; i<length; i++) {
			arr[row][row+i] = '*';
		}
		for(int i=0; i<length; i++) {
			arr[row+i][row+length-1] = '*';
		}
		for(int i=0; i<length; i++) { 
			arr[row+length-1][row+i] = '*';
		}
		for(int i=0; i<length; i++) {
			arr[row+i][row] = '*';
		}
		go(length-4, row+2);
	}

}
