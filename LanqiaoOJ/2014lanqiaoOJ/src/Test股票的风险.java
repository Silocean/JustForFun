/**
股票风险

股票交易上的投机行为往往十分危险。假设某股票行为十分怪异，每天不是涨停（上涨10%）就是跌停（下跌10%）。
假设上涨和下跌的概率均等（都是50%）。再假设交易过程没有任何手续费

。某人在开始的时候持有总价值为x的该股股票，那么100个交易日后，他盈利的可能性是多少呢？
以下程序通过计算机模拟了该过程，一般的输出结果在0.3左右。请填写缺失的代码。
 */
public class Test股票的风险 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 10000;
		int n = 0;
		
		for(int i=0; i<N; i++)
		{
			double value = 1000.0;	
			for(int k=0; k<100; k++)
			{
				if(Math.random() > 0.5)
					value = value * 1.1;
				else
					value = value * 0.9;
			}
			if(value>1000.0) n++;
		}
		
		System.out.println(1.0*n/N);
	}

}
