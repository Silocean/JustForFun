import java.util.ArrayList;
import java.util.List;

/**
 �ҵ�2~n��n��50��֮�䳤������ɵȲ����е������������
 */
public class Test�Ȳ�����_���� {
	
	private static List<Integer> primeList = new ArrayList<Integer>();
	

	public static void main(String[] args) {
		getPrime();
		toFindAndPrint();
	}
	
	private static void toFindAndPrint() {
		int first = 0;
		int d = 0;
		// ���ڴ�ŵȲ����е���ʱlist
		List<String> tempList = new ArrayList<String>();
		
		for(int i=0; i<primeList.size()-2; i++) {
			// ���ڴ��ÿ���Ȳ����е���ʱ�ַ���
			String str = "";
			// �Ȳ����е�����
			first = primeList.get(i);
			// �Ȳ����еĹ���
			d = primeList.get(i+1) - first;
			int temp = 0;
			str += (first + " " + primeList.get(i+1));
			while((first+d*(temp+2)) == primeList.get(i+2)) {
				temp ++;
				str += (" " + primeList.get(i+2));
			}
			tempList.add(str);
		}
		int count = 0;
		int max = 0;
		// ����tempList���ҵ���ĵȲ����еĳ���
		for(int i=0; i<tempList.size(); i++) {
			// System.out.println(tempList.get(i));
			String[] splitStr = tempList.get(i).split(" ");
			count = splitStr.length;
			if(count>max) {
				max = count;
			}
		}
		// ����tempList�����tempList.get(i)�ĵȲ����еĳ�����������
		for(int i=0; i<tempList.size(); i++) {
			if(tempList.get(i).split(" ").length == max) {
				System.out.println(tempList.get(i));
			}
		}
	}
	
	/*
	 * �ҵ����е�����,������primeList��
	 */
	private static void getPrime() {
		for(int i=2; i<=100; i++) {
			boolean flag = false;
			for(int j=2; j<=i/2; j++) {
				if(i%j==0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				// System.out.print(i + " ");
				primeList.add(i);
			}
		}
	}

}
