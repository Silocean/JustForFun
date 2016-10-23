import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
1��һ���ַ����У��ĸ��Ӵ�������Ҫ����ڵ���2���ظ����ִ�����࣬����ж���Ӵ��ظ�������ͬ��ȡ���������Ӵ���
���磺��abcfabcdabce���С�abc������3�Σ��������
*/

public class Test����ظ���������ִ� {
	// ��Ž�ȡ���Ӵ��ļ���
	public static Map<String, Integer> strList = new HashMap<String, Integer>();
	// ĳ�����������ַ����ĸ���
	public static int count = 0;
	
	public static void main(String[] args) {
		String str = "abcdeabcdeabcde";
		mySubstring(str);
		printMax();
	}
	/*
	 * ��ӡ�����ִ������������ַ���
	 */
	private static void printMax() {
		Set<Entry<String, Integer>> set = strList.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		// �ҳ�ĳ����ĳ�������ִ��������ַ������ֵĴ���
		int max = 0;
		int m = 0;
		while(it.hasNext()) {
			m = it.next().getValue();
			if(m>max) {
				max = m;
			}
		}
		
		System.out.println(m);
		// ��ʱ�����ڴ�ų��ִ��������ַ���
		List<String> list = new ArrayList<String>();
		String maxStr = "";
		// ����map
		for (Map.Entry<String, Integer> entry : strList.entrySet()) {  
			String key = entry.getKey().toString();
			int value = entry.getValue();
			if(value == 3) {
				// System.out.println(key);
				list.add(key);
			}
			// �ҳ����ִ��������ַ���������Ǹ�
			String tempStr = "";
			for(int i=0; i<list.size(); i++) {
				tempStr = list.get(i);
				if(tempStr.length()>maxStr.length()) {
					maxStr = tempStr;
				}
			}
			// System.out.println("key=" + key + " value=" + value);  
		}  
		System.out.println(maxStr);

	}
	/*
	 * �ݹ鷽�������ڽ�ȡ�Ӵ�
	 */
	private static void mySubstring(String str) {
		String subStr = "";
		if(str.length() >= 2) {
			for(int i=2; i<=str.length(); i++) {
				subStr = str.substring(0, i);
				if(strList.containsKey(subStr)) {
					count = strList.get(subStr);
					strList.put(subStr, count + 1);
				} else {
					strList.put(subStr, 1);
				}
			}
		}
		if(str.length()<2) {
			return;
		} else {
			mySubstring(str.substring(1, str.length()));
		}
	}

}
