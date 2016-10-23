import java.util.Scanner;

/**

��������Խ���֮�ϳ�Ϊ�������ǡ���
�������һ���������n�׷��������������ĳ������Ĺ����ǣ�ʹ��1��2��3��.����Ȼ���У������Ͻǿ�ʼ������˳ʱ�뷽��������䡣
���磺��n=3ʱ�������
   1   2   3
   6   4
   5
��n=4ʱ�������
   1   2   3   4
   9  10   5
   8   6
   7
��n=5ʱ�������
   1   2   3   4   5
  12  13  14   6 
  11  15   7
  10   8
   9

��������ʱ���ӱ�׼����������n��3~20��
�������������������ǲ��֡�
Ҫ���ʽ��ÿ�����ݿ��Ϊ4���Ҷ��롣

 */
public class Test�ݹ��������� {
	
	// �����һ������ֵ�����
	public static int[][] arr;
	
	public static void main(String[] args) {
		// ������
		int index = 1;
		// ����
		int row = 0;
		// �û��������ֵ����ʾ����ı߳�
		int n = Integer.parseInt(new Scanner(System.in).nextLine());
		// ��ʼ������
		arr = new int[n][n];
		// �ݹ���ã��������ݽ��ķ�ʽ��������
		find(index, row, n);
		// ��ӡ����ά�����ص�ÿһ��Ԫ��
		print(arr);
	}
	
	/*
	 * ��ӡ����ķ���
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
	 * �ݹ鷽��
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
