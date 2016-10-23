import java.util.ArrayList;
import java.util.List;

/**
串的处理
在实际的开发工作中，对字符串的处理是最常见的编程任务。本题目即是要求程序对用户输入的串进行处理。具体规则如下：
1. 把每个单词的首字母变为大写。
2. 把数字与字母之间用下划线字符（_）分开，使得更清晰
3. 把单词中间有多个空格的调整为1个空格。


例如：
用户输入：
you and     me what  cpp2005program
则程序输出：
You And Me What Cpp_2005_program


用户输入：
this is     a      99cat
则程序输出：
This Is A 99_cat
 */
public class Test串的简单处理 {
	
	//存放已格式化好的单词的List
	public static List<String> wordsList = new ArrayList<String>();
	
	public static void main(String[] args) {
		splitBySpace("    you and  me what  a99gramfa48f7a8feeee4a8ef4a5e4fae");
		print(wordsList);
	}
	
	/*
	 * 打印出所有单词
	 */
	private static void print(List<String> wordsList) {
		for(int i=0; i<wordsList.size(); i++) {
			System.out.print(wordsList.get(i) + " ");
		}
	}
	
	/*
	 * 将单词按空格分开
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
	 * 总的处理单词的方法
	 */
	public static void dealWithWord(String word) {
		boolean flag = false;
		// 检查单词中时否包含数字
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
	 * 处理不带数字的单词的方法
	 */
	public static void dealWithComnWord(String word) {
		char firstChar = word.charAt(0);
		if(firstChar >= 'a' && firstChar <= 'z') {
			word = (firstChar+"").toUpperCase() + word.substring(1);
			wordsList.add(word);
		}
	}
	
	/*
	 * 处理带数字的单词的方法
	 */
	public static void dealWithNumWord(String word) {
		// 记录字母的位置
		int letterCount = 0;
		// 记录数字的位置
		int numCount = 0;
		// 临时存放裁剪后的字符串的集合
		List<String> tempList = new ArrayList<String>();
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i)>='a' && word.charAt(i)<='z') {
				// 如果是字母，位置递增一
				letterCount ++;
				// 临时定义的用于查看下一个位置是否是数字的变量
				int temp = i + 1;
				
				if(temp == word.length()) {
					// 如果已到单词末尾，则从numCount开始裁剪到末尾
					tempList.add(word.substring(numCount));
				} else if(word.charAt(temp)>='0' && word.charAt(temp)<='9') {
					// 如果没到单词末尾，且下一个位置上的是数字，则按起始位置裁剪
					tempList.add(word.substring(numCount, letterCount));
					// 把字母的位置赋给数字
					numCount = letterCount;
				}
			} else if(word.charAt(i)>='0' && word.charAt(i)<='9') {
				// 如果是数字，位置递增一
				numCount ++;
				// 临时定义的用于查看下一个位置是否是字母的变量
				int temp = i + 1;
				
				if(temp == word.length()) {
					// 如果已到单词末尾，则从letterCount开始裁剪到末尾
					tempList.add(word.substring(letterCount));
				} else if(word.charAt(temp)>='a' && word.charAt(temp)<='z') {
					// 如果没到单词末尾，且下一个位置上的是字母，则按起始位置裁剪
					tempList.add(word.substring(letterCount, numCount));
					// 把数字的位置赋给字母
					letterCount = numCount;
				}
			}
		}
		// 定义一个临时字符串
		String string = "";
		// 把临时集合中的字符串用"_"拼接起来
		for(int i=0; i<tempList.size()-1; i++) {
			string += tempList.get(i) + "_";
		}
		string = string + tempList.get(tempList.size()-1);
		
		// 将单词首字母变成大写
		char firstChar = string.charAt(0);
		if(firstChar >= 'a' && firstChar <= 'z') {
			string = (firstChar+"").toUpperCase() + string.substring(1);
		}
		// 把格式化好的单词加入到单词集合中
		wordsList.add(string);
	}

}
