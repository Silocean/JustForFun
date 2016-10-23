
public class Test¸îÔ² {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("±ê×¼ " + Math.PI);
		
		double a = 1; 
		int n = 6;
		
		for(int i=0; i<10; i++)
		{
			double b = Math.sqrt(1-(a/2)*(a/2));
			a = Math.sqrt((1-b)*(1-b) + (a/2)*(a/2));
			
			n = (int) (6*Math.pow(2,i+1)); //Ìî¿Õ
			
			System.out.println(n + "  " + (n*a)/(2*1));  // Ìî¿Õ
		}
	}

}
