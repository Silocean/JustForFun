
/**
�����ֲ���ڣ�2012��3��12�գ���С�����������廹��С�����һ��ȥֲ������Ϣ��ʱ��С����ͬѧ������������ͣ�
������˵������˵����Ŀ��������˭�Ȳ³�������
�����ҳ�����������������ƴ��һ��8λ�����¡��ղ�����λǰ��0�����ÿ��Ա�������ꡢ�¡�����������
�������룬�ֲ��䵽�����ٸ�����ʾ������6�³����ġ���
������Щ��Ϣ�������С����һ�£�������ĳ��������ա�
��д�ڡ����.txt���У���Ҫд�����

��ʽ�����������ɵ�8λ����
���磬�����1948��6��12�գ���д��19480612

 */
public class Test������ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year, month, day;
		String date;
		for (int i = 1900; i <= 2012; i++) {
			for (int k = 1; k <= 30; k++) {
				year = i + "";
				month = "" + 0 + 6;
				if (k < 10) {
					day = "" + 0 + k;
				} else {
					day = k + "";
				}
				date = year + month + day;
				if (Integer.parseInt(date)%2012==0 && Integer.parseInt(date)%3==0 && Integer.parseInt(date)%12==0) {
					System.out.println(date);
				}
			}

		}
	}

}
