import java.util.Scanner;

/**

方阵的主对角线之上称为“上三角”。
请你设计一个用于填充n阶方阵的上三角区域的程序。填充的规则是：使用1，2，3….的自然数列，从左上角开始，按照顺时针方向螺旋填充。
例如：当n=3时，输出：
   1   2   3
   6   4
   5
当n=4时，输出：
   1   2   3   4
   9  10   5
   8   6
   7
当n=5时，输出：
   1   2   3   4   5
  12  13  14   6 
  11  15   7
  10   8
   9

程序运行时，从标准输入获得整数n（3~20）
程序输出：方阵的上三角部分。
要求格式：每个数据宽度为4，右对齐。

 */
public class Test递归三角螺旋 {
	
	// 定义个一存放数字的数组
	public static int[][] arr;
	
	public static void main(String[] args) {
		// 计数器
		int index = 1;
		// 行数
		int row = 0;
		// 用户输入的数值，表示矩阵的边长
		int n = Integer.parseInt(new Scanner(System.in).nextLine());
		// 初始化数组
		arr = new int[n][n];
		// 递归调用，以螺旋递进的方式给矩阵复制
		find(index, row, n);
		// 打印出二维数组重的每一个元素
		print(arr);
	}
	
	/*
	 * 打印数组的方法
	 */
	public static void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == 0) {
					System.out.print(" " + "\t");
				} else {
					System.out.print(arr[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}
	
	/*
	 * 递归方法
	 */
	public static void find(int index, int row, int n) {
		for(int i=0; i<n; i++) {
			arr[row][row+i] = index;
			index ++;
		}
		for(int i=0; i<n-1; i++) {
			arr[row+i+1][row+n-i-2] = index;
			index ++;
		}
		for(int i=0; i<n-2; i++) {
			arr[row+n-i-2][row] = index;
			index ++;
		}
		if(n<=2) {
			return;
		}
		find(index, row+1, n-3);
	}

}
