import java.util.ArrayList;
import java.util.List;

/**
 找到2~n（n≤50）之间长度最长、成等差数列的素数并做输出
 */
public class Test等差数列_素数 {
	
	private static List<Integer> primeList = new ArrayList<Integer>();
	

	public static void main(String[] args) {
		getPrime();
		toFindAndPrint();
	}
	
	private static void toFindAndPrint() {
		int first = 0;
		int d = 0;
		// 用于存放等差数列的临时list
		List<String> tempList = new ArrayList<String>();
		
		for(int i=0; i<primeList.size()-2; i++) {
			// 用于存放每个等差数列的临时字符串
			String str = "";
			// 等差数列的首项
			first = primeList.get(i);
			// 等差数列的公差
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
		// 遍历tempList，找到最长的等差数列的长度
		for(int i=0; i<tempList.size(); i++) {
			// System.out.println(tempList.get(i));
			String[] splitStr = tempList.get(i).split(" ");
			count = splitStr.length;
			if(count>max) {
				max = count;
			}
		}
		// 遍历tempList，如果tempList.get(i)的等差数列的长度最长，则输出
		for(int i=0; i<tempList.size(); i++) {
			if(tempList.get(i).split(" ").length == max) {
				System.out.println(tempList.get(i));
			}
		}
	}
	
	/*
	 * 找到所有的素数,并放入primeList中
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
