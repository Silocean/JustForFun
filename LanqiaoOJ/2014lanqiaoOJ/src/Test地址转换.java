import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**

  Excel����õİ칫�����ÿ����Ԫ����Ψһ�ĵ�ַ��ʾ�����磺��12�е�4�б�ʾΪ����D12������5�е�255�б�ʾΪ��IU5����
    
    ��ʵ�ϣ�Excel�ṩ�����ֵ�ַ��ʾ����������һ�ֱ�ʾ������RC��ʽ��ַ�� ��12�е�4�б�ʾΪ����R12C4������5�е�255�б�ʾΪ��R5C255����

    ��������ǣ���д����ʵ�ִ�RC��ַ��ʽ�������ַ��ʽ��ת����

�����롢�����ʽҪ��

    �û�������һ������n��n<100������ʾ��������n���������ݡ�

    ���������n��������RC��ʽ��Excel��Ԫ���ַ��ʾ����

    ���������n�����ݣ�ÿ����ת����ĳ����ַ��ʾ����

    ���磺�û����룺
2
R12C4
R5C255

    �����Ӧ�������
D12
IU5

 */
public class Test��ַת�� {

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
