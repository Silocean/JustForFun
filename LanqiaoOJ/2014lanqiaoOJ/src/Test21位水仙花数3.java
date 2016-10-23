import java.math.BigInteger;
import java.util.Arrays;

public class Test21位水仙花数3 {
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
			System.out.println("没有符合条件的数！");
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
			BigInteger big = sum(nums);// 当level为20时，表示nums数组下标为20即21位数字满后求和；
			int[] temp = getArray(big);// 将得到的21位数和转化为整形数组；并返回；
			if (check(nums, temp))// 测试是否是21位，并将数组复制给nums数组；
			{
				store[nTotal] = big;// 保存big数；
				nTotal++;
			}
			return;
		}
		for (int i = num; i < 10; i++)
			// 递归；查找21位数字符合条件的数；
			find(nums, level + 1, i);
	}

	public static boolean check(int[] a1, int[] a2) {
		if (a1.length != a2.length)
			return false;
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

	/**
	 * 449177399146038697307 128468643043731391252 得到nums数组的数做为table下标的数的和。并返回；
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
	 * 将BigInteger转化为int[]类型数据；
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
