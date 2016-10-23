
public class Âí»¢µÄËãÊ½ {
	
	public static void main(String[] args) {
		int count = 0;
		for(int a = 1; a<=9; a++) {
			for(int b=1; b<=9; b++) {
				if(a==b) continue;
				for(int c=1;c<=9; c++) {
					if(b==c || a==c) continue;
					for(int d=1; d<=9; d++) {
						if(a==d || b==d || c==d) continue;
						for(int e=1; e<=9; e++) {
							if(a==e || b==e || c==e || d==e) continue;
							if((a*10+b)*(c*100+d*10+e) == (a*100+d*10+b)*(c*10+e)) {
								count ++;
								System.out.println(a+""+b+""+c+""+d+""+e);
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}
