import java.util.HashSet;
import java.util.Set;

/**
5.	��ȥ�η���
��Ȼ����ƽ�����ǣ�1 4 9 16 25 ��
��Ȼ�����������ǣ�1 8 27 64 125 ��
��Ȼ����4�η����ǣ�1 16 81 256 ��
��
��Щ���ֶ����Գ�Ϊ�η�����
1~10000�У�ȥ�����еĴη�������ʣ�¶��ٸ����֣�

 */
public class Test��ȥ�η��� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Double> set = new HashSet<Double>();
		for(int index=1; index<=100; index++) {
			for(int n=2; n<=100; n++) {
				double m = Math.pow(index, n);
				if(m<=10000) {
					set.add(m);
				}
			}
		}
		System.out.println(10000-set.size());
	}

}
