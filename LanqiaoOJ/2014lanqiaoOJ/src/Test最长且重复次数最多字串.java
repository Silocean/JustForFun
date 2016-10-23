import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
1、一个字符串中，哪个子串（长度要求大于等于2）重复出现次数最多，如果有多个子串重复次数相同，取长度最大的子串。
例如：“abcfabcdabce”中“abc”出现3次，而且最长。
*/

public class Test最长且重复次数最多字串 {
	// 存放截取的子串的集合
	public static Map<String, Integer> strList = new HashMap<String, Integer>();
	// 某个出现最多次字符串的个数
	public static int count = 0;
	
	public static void main(String[] args) {
		String str = "abcdeabcdeabcde";
		mySubstring(str);
		printMax();
	}
	/*
	 * 打印出出现次数最多且最长的字符串
	 */
	private static void printMax() {
		Set<Entry<String, Integer>> set = strList.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		// 找出某个或某几个出现次数最多的字符串出现的次数
		int max = 0;
		int m = 0;
		while(it.hasNext()) {
			m = it.next().getValue();
			if(m>max) {
				max = m;
			}
		}
		
		System.out.println(m);
		// 临时的用于存放出现次数最多的字符串
		List<String> list = new ArrayList<String>();
		String maxStr = "";
		// 遍历map
		for (Map.Entry<String, Integer> entry : strList.entrySet()) {  
			String key = entry.getKey().toString();
			int value = entry.getValue();
			if(value == 3) {
				// System.out.println(key);
				list.add(key);
			}
			// 找出出现次数最多的字符串中最长的那个
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
	 * 递归方法，用于截取子串
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
