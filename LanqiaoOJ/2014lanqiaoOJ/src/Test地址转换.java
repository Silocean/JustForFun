import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**

  Excel是最常用的办公软件。每个单元格都有唯一的地址表示。比如：第12行第4列表示为：“D12”，第5行第255列表示为“IU5”。
    
    事实上，Excel提供了两种地址表示方法，还有一种表示法叫做RC格式地址。 第12行第4列表示为：“R12C4”，第5行第255列表示为“R5C255”。

    你的任务是：编写程序，实现从RC地址格式到常规地址格式的转换。

【输入、输出格式要求】

    用户先输入一个整数n（n<100），表示接下来有n行输入数据。

    接着输入的n行数据是RC格式的Excel单元格地址表示法。

    程序则输出n行数据，每行是转换后的常规地址表示法。

    例如：用户输入：
2
R12C4
R5C255

    则程序应该输出：
D12
IU5

 */
public class Test地址转换 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");map.put(2, "B");map.put(3, "C");map.put(4, "D");map.put(5, "E");
		map.put(6, "F");map.put(7, "G");map.put(8, "H");map.put(9, "I");map.put(10, "G");
		map.put(11, "K");map.put(12, "L");map.put(13, "M");map.put(14, "N");map.put(15, "O");
		map.put(16, "P");map.put(17, "Q");map.put(18, "R");map.put(19, "S");map.put(20, "T");
		map.put(21, "U");map.put(22, "V");map.put(23, "W");map.put(24, "X");map.put(25, "Y");
		map.put(26, "Z");
		
		int row = 0;
		int col = 0;
		
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] strArr = new String[num];
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = scan.nextLine();
		}
		for(int i=0; i<strArr.length; i++) {
			int start = 0,end = 0;
			for(int j=0; j<strArr[i].length(); j++) {
				if(strArr[i].charAt(j) == 'R') {
					start = j;
				}
				if(strArr[i].charAt(j) == 'C') {
					end = j;
				}
			}
			row = Integer.parseInt(strArr[i].trim().substring(start+1, end));
			col = Integer.parseInt(strArr[i].trim().substring(end+1));
			//System.out.println(row + " " + col);
			if(col<=26) {
				System.out.println(map.get(col) + row);
			} else {
				System.out.println(map.get(col/26)+map.get(col%26)+row);
			}
		}
	}

}
