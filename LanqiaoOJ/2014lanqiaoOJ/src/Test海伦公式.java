
public class Testº£Â×¹«Ê½ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double arr[][] = {{52.1, 33.4, 68.2},{68.2,57.2,71.9},{71.9,51.9,43.5}};
		double m = 0.0;
		for(int i=0; i<3; i++) {
			m += area(arr[i][0], arr[i][1], arr[i][2]);
		}
		System.out.println(m);
	}
	
	public static double area(double a, double b, double c) {
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

}
