import java.util.Scanner;

/**

    30��ĸĸ￪�ţ����й������˷��츲�صı仯��2011ȫ���й��ֻ�����ԼΪ11.72�ڲ����ֻ��Ѿ���Ϊ���յĻ�������Ʒ��

    ���ֻ�ѡ�������ֺüǵĺ������������˵���Ը������Դ���ޣ�ֻ�ܸ����г�ѡ�ŵķ����ˡ�

    ��������Ŀ�ľ��ǣ����ݸ������ֻ�β�ţ�4λ��������һ���Ĺ�������֡���������£�

    1. ����������ţ����������ǽ��򣬶���5�֡����磺5678,4321������ӷֱ�׼��

    2. ǰ����������ͬ���������������ͬ������3�֡����磺4888,6665,7777������ӷֵı�׼��ע�⣺7777��Ϊ����������׼���Σ��������������������6�֡�

    3. ����AABB����ABABģʽ�ļ�1�֡����磺2255,3939,7777���������ģʽ�����Զ����ӷ֡�ע�⣺7777��Ϊ����������׼���Σ�����������׼��������2�֡�

    4. ���У�6��8��9���κ�һ�����֣�ÿ����һ�μ�1�֡�����4326,6875,9918�����ϼӷֱ�׼�����У�6875����2�֣�9918����3�֡�

    β�����յ÷־���ÿ����׼�ļӷ��ܺͣ�

    Ҫ�����ӱ�׼����������ݣ��ڱ�׼�������������

    �����ʽΪ����һ����һ������n��<100������ʾ�±��ж��������У���������n��4λһ������ݣ����ǵȴ�����ӷֵ��ֻ�β�š�
    �����ʽΪ��n��������

    ���磬���룺
14
3045
0211
2345
6543
7777
8888
7878
7788
6688
2424
2244
9918
6789
8866
    �������
0
0
5
6
8
12
3
3
5
1
1
3
8
5
 */
public class Test�ֻ�β�� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//int num = scan.nextInt();		//������nextInt()��ԭ���Ǹ÷�������һ��int��������ͬʱ������һ�����з�
		int num = Integer.parseInt(scan.nextLine()); 
		String[] strNum = new String[num];
		int[] count = new int[strNum.length];
		for(int i=0; i<strNum.length; i++) {
			strNum[i] = scan.nextLine();
		}
		for(int i=0; i<strNum.length; i++) {
			jiafen(strNum[i], count[i]);
		}
		
	}
	
	public static void jiafen(String num, int count) {
		String[] str = num.split("");
		int[] arr = new int[str.length];
		for(int i=1; i<arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		if((arr[1]+1==arr[2]&&arr[1]+2==arr[3]&&arr[1]+3==arr[4]) || (arr[1]-1==arr[2]&&arr[1]-2==arr[3]&&arr[1]-3==arr[4])) {
			count += 5;
		}
		if(arr[1]==arr[2]&&arr[2]==arr[3]) {
			count += 3;
		}
		if(arr[2]==arr[3]&&arr[3]==arr[4]) {
			count += 3;
		}
		if(arr[1]==arr[2]&&arr[3]==arr[4]) {
			count += 1;
		}
		if(arr[1]==arr[3]&&arr[2]==arr[4]) {
			count += 1;
		}
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == 6) {
				count += 1;
			}
			if(arr[i] == 8) {
				count += 1;
			}
			if(arr[i] == 9) {
				count += 1;
			}
		}
		System.out.println(count);
	}
	
	
}
