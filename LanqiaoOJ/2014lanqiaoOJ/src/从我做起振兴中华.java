import java.util.ArrayList;
import java.util.List;

/**

����: �����л�

    С���μ���ѧУ��Ȥζ�˶��ᣬ���е�һ����Ŀ�ǣ������ӡ�

    ���ϻ���һЩ���ӣ�ÿ��������дһ���֣�������ʾ����Ҳ�ɲμ�p.jpg��

����������
����������
����������
�������л�


    ����ʱ����վ�����Ͻǵ�д�š��ӡ��ֵĸ�������Ժ���������������ڵĸ���������������Խǵĸ��ӻ�����λ�á�
    һֱҪ�����������ֽ�����


    Ҫ��������·�߸պù��ɡ��������������л�����仰��

    �������С����һ����һ���ж����ֿ��ܵ���Ծ·���أ�
 */
public class �������������л� {
	
	public static String[][] map = {{"��","��","��","��","��"},
									{"��","��","��","��","��"},
									{"��","��","��","��","��"},
									{"��","��","��","��","��"}};
	
	public static int[] incrementX = {0, 1};
	public static int[] incrementY = {1, 0};
	
	public static int count = 0;
	
	public static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		go(0, 0);
		System.out.println(count);
	}
	
	public static void go(int x, int y) {
		int a, b;
		if(x == 4 && y == 3) {
			count ++;
			return;
		} else {
			for(int i=0; i<2; i++) {
				a = x + incrementX[i];
				b = y + incrementY[i];
				if(a>=0 && a<=4 && b>=0 && b<=3) {
					go(a, b);
				}
			}
		}
	}

}
