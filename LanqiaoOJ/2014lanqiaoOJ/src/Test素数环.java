import java.util.ArrayList;
import java.util.List;

/**
	�Ѵ�1��20��20�����ڳ�һ������Ҫ�����ڵ��������ĺ���һ������
 */
public class Test������ {
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static int[] arr = new int[20];

	public static void main(String[] args) {
		for(int i=1; i<=20; i++) {
			list.add(i);
		}
		int index = 0;
		for(int i=0; i<list.size(); i++) {
			arr[index] = list.get(i);
			int m = list.remove(i);
			go(index+1, list);
			list.add(i, m);
			arr[index]=0; //��仰��дҲ��
		}
	}

	private static void go(int index, List<Integer> list) {
		if(index == 20) {
			int num = arr[0] + arr[index-1];
			if(isPrime(num)) {
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			return;
		} else {
			for(int i=0; i<list.size(); i++) {
				int num = list.get(i) + arr[index-1];
				if(isPrime(num)) {
					arr[index] = list.get(i);
					int m = list.remove(i);
					go(index+1, list);
					list.add(i, m);
				}
				
			}
		}
	}
	
	public static boolean isPrime(int num) {
		boolean flag = true;
		for(int i=2; i<num/2; i++) {
			if(num%i==0) {
				flag = false;
			}
		}
		if(flag) {
			return true;
		} else {
			return false;
		}
	}

}
