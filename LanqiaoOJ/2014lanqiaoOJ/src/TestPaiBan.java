import java.util.ArrayList;
import java.util.List;


public class TestPaiBan {
	
	public static int number = 0;
	
	public static List<StringBuffer> strList = new ArrayList<StringBuffer>();
	
	
	public static List<List<StringBuffer>> list = new ArrayList<List<StringBuffer>>();

	public static void main(String[] args) {
		long m = System.currentTimeMillis();
		
		//listAll();
		
		listAll2();
		paiBan();
		
		dealWithList(list);
		
		//System.out.println(list.get(2).size());
		
		long n = System.currentTimeMillis();
		System.out.println("程序耗时：" + (n-m)/1000 + "秒");
	}
	
	public static void paiBan() {
		for(int a=0; a<strList.size(); a++) {
			for(int b=0; b<strList.size(); b++) {
				for(int c=0; c<strList.size(); c++) {
					for(int d=0; d<strList.size(); d++) {
						for(int e=0; e<strList.size(); e++) {
							StringBuffer strA = new StringBuffer(strList.get(a));
							StringBuffer strB = new StringBuffer(strList.get(b));
							StringBuffer strC = new StringBuffer(strList.get(c));
							StringBuffer strD = new StringBuffer(strList.get(d));
							StringBuffer strE = new StringBuffer(strList.get(e));
							List<StringBuffer> tempList = new ArrayList<StringBuffer>();
							tempList.add(strA);
							tempList.add(strB);
							tempList.add(strC);
							tempList.add(strD);
							tempList.add(strE);
							list.add(tempList);
							// System.out.println(tempList.size());
						}
					}
				}
			}
		}
	}
	
	public static void dealWithList(List<List<StringBuffer>> list) {
		for(int i=0; i<list.size(); i++) {
			List<StringBuffer> temp = list.get(i);
			//System.out.println(temp);
			boolean flag = false;
			for(int m=0; m<temp.size(); m++) {
				StringBuffer tempStr = temp.get(m);
				int countNum = 0;
				for(int n=0; n<tempStr.length(); n++) {
					char c = tempStr.charAt(n);
					if(c=='1') {
						countNum ++;
						if(countNum>3) {
							flag = true;
						}
					} else {
						countNum = 0;
					}
				}
				if(tempStr.charAt(0)=='1' && tempStr.charAt(tempStr.length()-3)=='1' && tempStr.charAt(tempStr.length()-2)=='1' && tempStr.charAt(tempStr.length()-1)=='1') {
					flag = true;
				}
				if(tempStr.charAt(0)=='1' && tempStr.charAt(1)=='1' && tempStr.charAt(tempStr.length()-2)=='1' && tempStr.charAt(tempStr.length()-1)=='1') {
					flag = true;
				}
				if(tempStr.charAt(0)=='1' && tempStr.charAt(1)=='1' && tempStr.charAt(2)=='1' && tempStr.charAt(tempStr.length()-1)=='1') {
					flag = true;
				}
			}
			if(flag) {
				continue;
			}
			int count1 = 0;
			for(int day=0; day<7; day++) {
				if(temp.get(0).charAt(day)+temp.get(1).charAt(day)+temp.get(2).charAt(day)+temp.get(3).charAt(day)+temp.get(4).charAt(day) == 245) {
					count1 ++;
				}
			}
			if(count1 != 3) {
				continue;
			}
			if(temp.get(0).charAt(2) == '0'|| temp.get(2).charAt(2) == '0') {
				continue;
			}
			if(temp.get(1).charAt(6)=='1' || temp.get(3).charAt(6)=='1' || temp.get(4).charAt(6)=='1') {
				continue;
			}
			int count2 = 0;
			for(int day=0; day<7; day++) {
				if(temp.get(0).charAt(day) + temp.get(2).charAt(day) == 98) {
					count2 ++;
				}
			}
			if(count2 < 4) {
				continue;
			}
			boolean flag2 = false;
			for(int day=0; day<7; day++) {
				if(temp.get(0).charAt(day)+temp.get(1).charAt(day)+temp.get(2).charAt(day)+temp.get(3).charAt(day) <= 193) {
					flag2 = true;
					break;
				}
			}
			if(flag2) {
				continue;
			}
			number ++;
			System.out.println("第" + number + "种情况===========");
			for(int k=0; k<temp.size(); k++) {
				System.out.println(temp.get(k));
			}
		}
		
	}
	
	public static void listAll2() {
		
		for (int i = 31; i < 127; i++) {
			int tmp = i;
			StringBuffer sb = new StringBuffer();
			boolean flag = false;
			int counter = 0;
			for (int c = 0; c < 7; c++) {
				if ((15 & tmp) == 15) {
					flag = true;
					break;
				}
				if ((1 & tmp) == 1) {
					counter++;
					sb.append(1);
				} else
					sb.append(0);
				tmp = tmp >> (1);
				// System.out.println("test"+tmp);
			}

			if (!flag && counter == 5) {
				strList.add(sb);
			}
		}
	}
	
	public static void listAll() {
		StringBuffer sb = new StringBuffer();
		diGui(0, sb);
	}
	
	public static void diGui(int index, StringBuffer sb) {
		if(index == 7) {
			int count = 0;
			for(int i=0; i<sb.length(); i++) {
				if(sb.charAt(i) == '1') {
					count ++;
				}
			}
			if(count == 5) {
				strList.add(sb);
				// System.out.println(sb);
			}
		} else {
			index ++;
			diGui(index, new StringBuffer(sb).append(0));
			diGui(index, new StringBuffer(sb).append(1));
		}
	}

}
