
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
С������Сѧ��ѧ���˵�һ���˿��ơ�ħ�������������˱��ݡ�ħ���������������ģ�
����������һ���˿��ƣ�A��2��....J��Q��K һ��13�š������Լ�����������ǵ�˳��Ȼ�����泯�����ţ���ʼ���ݡ�
ֻ�����ȴ���������һ�ŷŵ������棬�ٴ���������һ�ŷ����������ϣ���A��Ȼ���ٴ���������һ�ŷŵ������棬�ٴ���������һ�ŷ����������ϣ���2��......���ѭ��ֱ������ֻ��һ���ƣ������������ϣ��պ���K��
��ʱ�������Ƶ�˳���ǣ�A,2,3,4,5,6,7,8,9,10,J,Q,K
�������һ�£�С���ʼ��ʱ�������Ƶ�˳���������ġ�
�ѽ��д���������ŷָС����ħ������ʼʱ������������������Ϊ��һ�����ݡ�
�������ṩ�˿��ƣ���ֻ���ü����ģ���ˣ�˺��ݸ�ֽģ���˿�����������Ϊ�����⣬����û�а�¼���ŷŹ�������Ȥ�ģ���ȥ���ԣ�

 */
public class TestPlayingCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		String[] arrStr = new String[]{"Q","J","10","9","8","7","6","5","4","3","2","A"};
		list.add("K");
		for(int i=0; i<arrStr.length; i++) {
			list.add(arrStr[i]);
			list.add(list.get(0));
			list.remove(0);
		}
		Iterator<String> it = ((LinkedList<String>) list).descendingIterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
