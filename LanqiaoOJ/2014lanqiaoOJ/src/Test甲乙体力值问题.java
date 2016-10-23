/**
某游戏规则中，甲乙双方每个回合的战斗总是有一方胜利，一方失败。游戏规定：
失败的一方要把自己的体力值的1/4加给胜利的一方。例如：如果双方体力值当前都是4，则经过一轮战斗后，
双方的体力值会变为：5，3。
现在已知：双方开始时的体力值甲：1000，乙：2000。
假设战斗中，甲乙获胜的概率都是50%
求解：双方经过4个回合的战斗，体力值之差小于1000的理论概率。
*/

public class Test甲乙体力值问题 {
	
	public static int count = 0;
	
	public static int pass = 0;
	
	public static void main(String[] args) {
		f(1000, 2000, 0);
		System.out.println("概率为：" + ((double)pass/(double)count)*100 + "%");
		System.out.println(count);
	}
	
	public static void f(double a, double b, int index) {
		if(index == 4) {
			if(Math.abs(a-b)<1000) {
				pass ++;
			}
			count ++;
			return;
		} else {
			// 甲方获胜
			a = a + b*1/4;
			b = b - b*1/4;
			f(a, b, index+1);
			
			// 乙方获胜
			a = a - a*1/4;
			b = b + a*1/4;
			f(a, b, index+1);
		}
	}

}
