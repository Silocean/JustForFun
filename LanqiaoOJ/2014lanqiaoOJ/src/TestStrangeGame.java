
/**
某电视台举办了低碳生活大奖赛。题目的计分规则相当奇怪：
每位选手需要回答10个问题（其编号为1到10），越后面越有难度。答对的，当前分数翻倍；答错了则扣掉与题号相同的分数（选手必须回答问题，不回答按错误处理）。
每位选手都有一个起步的分数为10分。
某获胜选手最终得分刚好是100分，如果不让你看比赛过程，你能推断出他（她）哪个题目答对了，哪个题目答错了吗？
如果把答对的记为1，答错的记为0，则10个题目的回答情况可以用仅含有1和0的串来表示。例如：0010110011 就是可能的情况。
你的任务是算出所有可能情况。每个答案占一行。
多个答案顺序不重要。

 */
public class TestStrangeGame {

	public static void main(String[] args) {
		f(0, 10);
	}

	static int[] arr = new int[10];

	public static void f(int time, int score) {
		if (time == 10) {
			if (score == 100) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}
		} else {
			arr[time] = 1;
			f(time + 1, score * 2);
			arr[time] = 0;
			f(time + 1, score - time - 1);
		}
	}

}
