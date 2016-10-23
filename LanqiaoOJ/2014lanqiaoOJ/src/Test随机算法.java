import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
文本文件(names.txt)中存储了30个学号及人名，分3次从中抽出3个名字并输出，要求每个人的抽中概率相同，
不能有1个人抽中2次或者3次。names.txt文件内容如下：
11124021807,陈小坤
11124021808,黄灵峰
11124021802,梁爱玲
11124021803,马维婵
11124021810,杨梅
11124021813,刘淑瑶
11124021820,张明
11124021817,王凯祥
11124021815,邓行奇
11124021821,李永林
11124021822,黄琴丹
11124021818,曾雅琴
11124021819,陈媛洁
11124021816,刘娜丝
11124021824,周吉韶
11124021823,朱燕姣
11124021825,苏海燕
11124021827,王菲
11124021828,洪海洋
11124021826,徐敬
11124021924,林佳云
11124021916,黄龙金
11124021909,蓝暖
11124021917,杨林剑
11124021921,何梁荣
11124021903,樊伟彩
11124021915,盘桂淑
11124021911,廖丽梅
11124021922,李永慧
11124021912,李路
 */
public class Test随机算法 {

	public static void main(String[] args) {
		File f = new File("C:names.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			List<String> nameList = new ArrayList<String>();
			String str = "";
			while((str=br.readLine()) != null) {
				nameList.add(str.substring(12));
			}
			Random r = new Random();
			boolean flag = true;
			int arr[] = new int[3];
			arr[0] = r.nextInt(30);
			for(int i=0; i<3;) {
				int temp = r.nextInt(30);
				for(int j=0; j<i; j++) {
					if(arr[j] == temp) {
						flag = false;
						break;
					}
				}
				if(flag) {
					arr[i] = temp;
					i ++;
				}
			}
			for(int i=0; i<arr.length; i++) {
				System.out.println(nameList.get(arr[i]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
