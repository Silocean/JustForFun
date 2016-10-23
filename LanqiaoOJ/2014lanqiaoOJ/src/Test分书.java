
public class Test分书 {

	public static void main(String[] args) {
		// a,b,c,d,e分别表示五个人
		for(int a='A'; a<='E'; a++) { 
			for(int b='A'; b<='E'; b++) {
				if(a==b) continue;
				for(int c='A'; c<'E'; c++) {
					if(c==b || c==a) continue;
					for(int d='A'; d<'E'; d++) {
						if(d==c || d==b || d==a) continue;
						for(int e='A'; e<'E'; e++) {
							if(e==d || e==c || e==b || e==a) continue;
							if((a=='C' || a=='D') && (b=='A'||b=='B'||b=='E') && (c=='B'||c=='C') && (d=='A'||d=='B'||d=='D') && (e=='B'||e=='E')) {
								System.out.println((char)a + " " + (char)b + " " + (char)c + " " + (char)d + " " + (char)e);
							}
						}
					}
				}
			}
		}
	}

}
