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

�۲����ͼ�Σ�������һϵ�������ε��Ǻŷ���Ƕ�׶��ɡ�
���ϱߵ������У����ⷽ��ı߳�Ϊ11��

�����������Ǵӱ�׼������һ������n(1<n<100)
����������Ƕ���ŵĻ������Ǻŷ���������㷽��ı߳�Ϊn

���磺
���룺
5
���������
*****
*   *
* * *
*   *
*****

���룺6
���������
******
*    *
* ** *
* ** *
*    *
******

 */
public class Test����Ƕ�� {
	
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
