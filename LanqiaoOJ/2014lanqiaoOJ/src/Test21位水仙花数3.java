import java.math.BigInteger;
import java.util.Arrays;

public class Test21λˮ�ɻ���3 {
	private static int num = 21;
	private static BigInteger[] table = new BigInteger[10];
	private static BigInteger[] store = new BigInteger[1000];
	private static int nTotal = 0;
	private static int[] nums;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			table[i] = BigInteger.valueOf(i).pow(num);

		// long time = System.currentTimeMillis();
		for (int i = 0; i < 10; i++)
			table[i] = BigInteger.valueOf(i).pow(num);
		nums = new int[num];
		for (int j = 0; j < 10; j++)
			find(nums, 0, j);
		if (0 == nTotal)
			System.out.println("û�з�������������");
		else {
			Arrays.sort(store, 0, nTotal);
			for (int i = 0; i < nTotal; i++)
				System.out.println(store[i]);
		}
		// time = System.currentTimeMillis() - time;
		// System.out.println(time / 1000.0 + "s");

	}

	public static void find(int[] nums, int level, int num) {
		nums[level] = num;
		if (level == nums.length - 1) {
			BigInteger big = sum(nums);// ��levelΪ20ʱ����ʾnums�����±�Ϊ20��21λ����������ͣ�
			int[] temp = getArray(big);// ���õ���21λ����ת��Ϊ�������飻�����أ�
			if (check(nums, temp))// �����Ƿ���21λ���������鸴�Ƹ�nums���飻
			{
				store[nTotal] = big;// ����big����
				nTotal++;
			}
			return;
		}
		for (int i = num; i < 10; i++)
			// �ݹ飻����21λ���ַ�������������
			find(nums, level + 1, i);
	}

	public static boolean check(int[] a1, int[] a2) {
		if (a1.length != a2.length)
			return false;
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

	/**
	 * 449177399146038697307 128468643043731391252 �õ�nums���������Ϊtable�±�����ĺ͡������أ�
	 * 
	 * @param nums
	 * @return
	 */
	public static BigInteger sum(int[] nums) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < nums.length; i++)
			sum = sum.add(table[nums[i]]);
		return sum;
	}

	/**
	 * ��BigIntegerת��Ϊint[]�������ݣ�
	 * 
	 * @param big
	 * @return
	 */
	public static int[] getArray(BigInteger big) {
		String s = String.valueOf(big);
		char[] ch = s.toCharArray();
		int[] res = new int[ch.length];
		for (int i = 0; i < ch.length; i++)
			res[i] = ch[i] - '0';
		return res;
	}
}
