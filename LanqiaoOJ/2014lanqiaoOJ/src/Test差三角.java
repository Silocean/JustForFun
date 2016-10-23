import java.util.ArrayList;
import java.util.List;

/**
���⣺���������

��ϸ�۲������������ɵ������Σ�

    3
   1 4
  5 6 2

����ʲô������
���ȣ���������1~6������������
��Ҫ���ǣ�ÿ�����ֶ������·����ڵ��������ֵĲ��Ȼ�Ǵ�����ȥС����
�������������������Σ���Ϊ�������ǡ�

����������ҳ�1~15��������ɵ�һ������Ĳ����ǡ������磺

      ?
     4 ?
    ? ? ?
   * ? ? ?
  ? ? ? ? ?

���У�ֻ������һ��ȷ�������֣�4
��ȷ������*�� ��������ĸ�һ�����֡�
 */
public class Test������ {
	
	public static int[][] map = new int[5][5];
	
	public static boolean[] appear = new boolean[16];
	
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static List<Integer> bottomList = new ArrayList<Integer>();

	public static void main(String[] args) {
		restore();
		for(int i=0; i<15; i++) {
			list.add(i+1);
		}
		go(0);
	}
	
	private static void restore() {
		for(int i=0; i<appear.length; i++) {
			appear[i] = false;
		}
	}

	private static void go(int index) {
		if(index == 5) {
			deal(bottomList);
			restore();
			return;
		} else {
			for(int i=0; i<list.size(); i++) {
				int m = list.get(i);
				list.remove(i);
				bottomList.add(m);
				go(index+1);
				bottomList.remove(bottomList.size()-1);
				list.add(i, m);
			}
		}
	}

	private static void deal(List<Integer> bottomList) {
		for(int i=0; i<bottomList.size(); i++) {
			map[4][i] = bottomList.get(i);
			appear[bottomList.get(i)] = true;
		}
		for(int i=3; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				int m = Math.abs(map[i+1][j] - map[i+1][j+1]);
				if(appear[m] == false) {
					map[i][j] = m;
					appear[m] = true;
				} else {
					return;
				}
			}
		}
		if(map[1][0] == 4) {
			System.out.println(map[3][0]);
		}
	}

}
