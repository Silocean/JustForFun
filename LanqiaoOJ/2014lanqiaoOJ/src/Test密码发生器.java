import java.util.Scanner;

/**
  �ڶ������˻�����ҪȨ�����������ʱ�����ǳ������������ķ��գ����Ϊ�˺ü������հɣ����ױ��ƽ⣬����ȫ��
  ������ò��üǵ����룬�ֵ����Լ�Ҳ�����ǣ����д��ֽ�ϣ�����ֽ�ű����˷��ֻ�Ū����...

    ��������������ǰ�һ��ƴ����ĸת��Ϊ6λ���֣����룩�����ǿ���ʹ���κκüǵ�ƴ����(�������֣���ϲ����
    ��д��wangximing)��Ϊ���룬�������6λ���֡�

    �任�Ĺ������£�

    ��һ��. ���ַ���6��һ���۵�����������wangximing���Ϊ��
    wangxi
    ming 

    �ڶ���. �����д�ֱ��ͬһ��λ�õ��ַ���ascii��ֵ��ӣ��ó�6�����֣�����������ӣ���ó���
    228 202 220 206 120 105

    ������. �ٰ�ÿ�����֡���λ���������ǰ�ÿ��λ��������ӣ��ó��������������һλ���֣�������λ��ֱ�����һλ����Ϊֹ������: 228 => 2+2+8=12 => 1+2=3

    �����������λ���Ϊ��344836, ����ǳ������յ���������

    Ҫ�����ӱ�׼����������ݣ��ڱ�׼�������������

    �����ʽΪ����һ����һ������n��<100������ʾ�±��ж��������У���������n���ַ��������ǵȴ��任���ַ�����
    �����ʽΪ��n�б任���6λ���롣

    ���磬���룺
5
zhangfeng
wangximing
jiujingfazi
woaibeijingtiananmen
haohaoxuexi

    �������
772243
344836
297332
716652
875843
 */
public class Test���뷢���� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] s = new String[num];

		for (int i = 0; i < s.length; i++) {
			s[i] = scan.nextLine();
		}
		String string;
		for (int a = 0; a < s.length; a++) {
			char[] c = new char[6];
			for (int i = 0; i < s[a].length(); i++) {
				c[i % 6] += s[a].charAt(i);
			}
			for (int i = 0; i < c.length; i++) {
				string = (int) c[i] + "";
				System.out.print(digui(string));
			}
			System.out.println();
		}

	}

	public static String digui(String s) {
		int num = 0;
		if (s.length() == 1)
			return s;
		if (s.length() > 1) {
			for (int i = 0; i < s.length(); i++) {
				num += Integer.parseInt(s.split("")[i + 1]);
			}
		}
		return digui(num + "");

	}

}
