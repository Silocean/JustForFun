import java.util.Scanner;

/**

��N���˲μ�100�׶��ܱ������ܵ�Ϊ8��������������ǰ��վ���ʹÿ�������������ٵ�ԭ����顣
���磺
N=8ʱ���ֳ�1�鼴�ɡ�
N=9ʱ���ֳ�2�飺һ��5�ˣ�һ��4�ˡ�
N=25ʱ����4�飺7��6��6��6��

���̼���������֡�
Ҫ��ӱ�׼������һ����������1~100֮�䣬���ؿ��������������������ʾ������������
�������ÿ������������Ӵ�С˳�������ÿ������һ�С�

���磬
�û����룺25
���������
7
6
6
6

 */
public class Test�˶�Ա���� {

	public static void main(String[] args) {
		int m = new Scanner(System.in).nextInt();
		int n = m / 8 + 1;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = m / n;
		}
		for(int i=0;i<m%n;i++){
			arr[i]+=1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
