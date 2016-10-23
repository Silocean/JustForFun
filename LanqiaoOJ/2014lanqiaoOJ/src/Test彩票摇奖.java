import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Test彩票摇奖 {
	
	private static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("F:\\java workplace1\\蓝桥杯练习题目\\src\\彩票.txt")));
		int length = Integer.parseInt(br.readLine());
		// System.out.println(length);
		String[] answerStr = br.readLine().split(" ");
		int[] answer = new int[answerStr.length];
		for(int i=0; i<answer.length; i++) {
			answer[i] = Integer.parseInt(answerStr[i]);
		}
		for(int i=0; i<length; i++) {
			String str = br.readLine();
			analysize(str, answer);
		}
		print(list);
	}

	private static void analysize(String str, int[] answer) {
		int count = 0;
		String[] string = str.split(" ");
		int[] arr = new int[string.length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(string[i]);
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i] == answer[j]) {
					count ++;
				}
			}
		}
		// System.out.println(count);
		list.add(count);
	}

	private static void print(List<Integer> list2) {
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				int a = list.get(i);
				int b = list.get(j);
				if(a<b) {
					list.set(i, b);
					list.set(j, a);
				}
			}
		}
		int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0;
		for(int i=0; i<list.size(); i++) {
			switch(list.get(i)) {
			case 7:
				c7 ++;
				if(!(i<list.size()-1&&list.get(i+1)==7))
				System.out.println("特等奖" + c7);
				break;
			case 6:
				c6 ++;
				if(!(i<list.size()-1&&list.get(i+1)==6)) 
				System.out.println("一等奖" + c6);
				break;
			case 5:
				c5 ++;
				if(!(i<list.size()-1&&list.get(i+1)==5)) 
				System.out.println("二等奖" + c5);
				break;
			case 4:
				c4 ++;
				if(!(i<list.size()-1&&list.get(i+1)==4)) 
				System.out.println("三等奖" + c4);
				break;
			case 3:
				c3 ++;
				if(!(i<list.size()-1&&list.get(i+1)==3)) 
				System.out.println("四等奖" + c3);
				break;
			case 2:
				c2 ++;
				if(!(i<list.size()-1&&list.get(i+1)==2)) 
				System.out.println("五等奖" + c2);
				break;
			case 1:
				c1 ++;
				if(!(i<list.size()-1&&list.get(i+1)==1)) {
					System.out.println("六等奖" + c1);
				}
				break;
			case 0:
				break;
			}
				
		}
	}

}
