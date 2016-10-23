import java.text.DecimalFormat;
import java.util.Scanner;


public class Test«Û∫Õ {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		double sum = 0;
		double m = 1;
		for(int i=1; i<=n; i++) {
			m = m * (double)1/(double)i;
			sum = sum + m;
		}
		System.out.println(sum);
		DecimalFormat df = new DecimalFormat("##0.000000000000000");
		System.out.println(df.format(sum));
	}

}
