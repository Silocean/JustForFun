import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
�ı��ļ�(names.txt)�д洢��30��ѧ�ż���������3�δ��г��3�����ֲ������Ҫ��ÿ���˵ĳ��и�����ͬ��
������1���˳���2�λ���3�Ρ�names.txt�ļ��������£�
11124021807,��С��
11124021808,�����
11124021802,������
11124021803,��ά�
11124021810,��÷
11124021813,������
11124021820,����
11124021817,������
11124021815,������
11124021821,������
11124021822,���ٵ�
11124021818,������
11124021819,���½�
11124021816,����˿
11124021824,�ܼ���
11124021823,�����
11124021825,�պ���
11124021827,����
11124021828,�麣��
11124021826,�쾴
11124021924,�ּ���
11124021916,������
11124021909,��ů
11124021917,���ֽ�
11124021921,������
11124021903,��ΰ��
11124021915,�̹���
11124021911,����÷
11124021922,������
11124021912,��·
 */
public class Test����㷨 {

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
