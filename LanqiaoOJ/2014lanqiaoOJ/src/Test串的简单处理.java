import java.util.ArrayList;
import java.util.List;

/**
���Ĵ���
��ʵ�ʵĿ��������У����ַ����Ĵ���������ı�����񡣱���Ŀ����Ҫ�������û�����Ĵ����д�������������£�
1. ��ÿ�����ʵ�����ĸ��Ϊ��д��
2. ����������ĸ֮�����»����ַ���_���ֿ���ʹ�ø�����
3. �ѵ����м��ж���ո�ĵ���Ϊ1���ո�


���磺
�û����룺
you and     me what  cpp2005program
����������
You And Me What Cpp_2005_program


�û����룺
this is     a      99cat
����������
This Is A 99_cat
 */
public class Test���ļ򵥴��� {
	
	//����Ѹ�ʽ���õĵ��ʵ�List
	public static List<String> wordsList = new ArrayList<String>();
	
	public static void main(String[] args) {
		splitBySpace("    you and  me what  a99gramfa48f7a8feeee4a8ef4a5e4fae");
		print(wordsList);
	}
	
	/*
	 * ��ӡ�����е���
	 */
	private static void print(List<String> wordsList) {
		for(int i=0; i<wordsList.size(); i++) {
			System.out.print(wordsList.get(i) + " ");
		}
	}
	
	/*
	 * �����ʰ��ո�ֿ�
	 */
	public static void splitBySpace(String str) {
		String[] strs = str.split(" ");
		for(String s : strs) {
			if(!s.equals("")) {	
				//System.out.print(s + " ");
				dealWithWord(s);
			}
		}
	}
	
	/*
	 * �ܵĴ����ʵķ���
	 */
	public static void dealWithWord(String word) {
		boolean flag = false;
		// ��鵥����ʱ���������
		for(int i=0; i<word.length(); i++) {
			if("0123456789".indexOf(word.charAt(i)) != -1) {
				flag = true;
			}
		}
		if(flag) {
			dealWithNumWord(word);
		} else {
			dealWithComnWord(word);
		}
	}
	
	/*
	 * ���������ֵĵ��ʵķ���
	 */
	public static void dealWithComnWord(String word) {
		char firstChar = word.charAt(0);
		if(firstChar >= 'a' && firstChar <= 'z') {
			word = (firstChar+"").toUpperCase() + word.substring(1);
			wordsList.add(word);
		}
	}
	
	/*
	 * ��������ֵĵ��ʵķ���
	 */
	public static void dealWithNumWord(String word) {
		// ��¼��ĸ��λ��
		int letterCount = 0;
		// ��¼���ֵ�λ��
		int numCount = 0;
		// ��ʱ��Ųü�����ַ����ļ���
		List<String> tempList = new ArrayList<String>();
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i)>='a' && word.charAt(i)<='z') {
				// �������ĸ��λ�õ���һ
				letterCount ++;
				// ��ʱ��������ڲ鿴��һ��λ���Ƿ������ֵı���
				int temp = i + 1;
				
				if(temp == word.length()) {
					// ����ѵ�����ĩβ�����numCount��ʼ�ü���ĩβ
					tempList.add(word.substring(numCount));
				} else if(word.charAt(temp)>='0' && word.charAt(temp)<='9') {
					// ���û������ĩβ������һ��λ���ϵ������֣�����ʼλ�òü�
					tempList.add(word.substring(numCount, letterCount));
					// ����ĸ��λ�ø�������
					numCount = letterCount;
				}
			} else if(word.charAt(i)>='0' && word.charAt(i)<='9') {
				// ��������֣�λ�õ���һ
				numCount ++;
				// ��ʱ��������ڲ鿴��һ��λ���Ƿ�����ĸ�ı���
				int temp = i + 1;
				
				if(temp == word.length()) {
					// ����ѵ�����ĩβ�����letterCount��ʼ�ü���ĩβ
					tempList.add(word.substring(letterCount));
				} else if(word.charAt(temp)>='a' && word.charAt(temp)<='z') {
					// ���û������ĩβ������һ��λ���ϵ�����ĸ������ʼλ�òü�
					tempList.add(word.substring(letterCount, numCount));
					// �����ֵ�λ�ø�����ĸ
					letterCount = numCount;
				}
			}
		}
		// ����һ����ʱ�ַ���
		String string = "";
		// ����ʱ�����е��ַ�����"_"ƴ������
		for(int i=0; i<tempList.size()-1; i++) {
			string += tempList.get(i) + "_";
		}
		string = string + tempList.get(tempList.size()-1);
		
		// ����������ĸ��ɴ�д
		char firstChar = string.charAt(0);
		if(firstChar >= 'a' && firstChar <= 'z') {
			string = (firstChar+"").toUpperCase() + string.substring(1);
		}
		// �Ѹ�ʽ���õĵ��ʼ��뵽���ʼ�����
		wordsList.add(string);
	}

}
