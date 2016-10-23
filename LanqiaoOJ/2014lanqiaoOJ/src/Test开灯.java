
public class Test¿ªµÆ {

	public static void main(String[] args) {
		int[] lights = new int[10];
		for(int i=0; i<lights.length; i++) {
			if(i==0) {
				for(int m=0; m<lights.length; m++) {
					lights[m] = 1;
				}
			}
			if(i==1) {
				for(int m=0; m<lights.length; m++) {
					if((m+1)%2==0) {
						lights[m] = 0;
					}
				}
			}
			if(i>=2) {
				for(int m=0; m<lights.length; m++) {
					if((m+1)%(i+1)==0) {
						if(lights[m]==0) {
							lights[m] = 1;
						} else {
							lights[m] = 0;
						}
					}
					
				}
			}
		}
		for(int i=0; i<lights.length; i++) {
			System.out.print(lights[i] + " ");
		}
	}

}
