
public class Test矩阵转置 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int juzhen[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int juzhen2[][] = new int[4][4];
		//转置矩阵
		for(int i=0; i<juzhen.length; i++) {
			for(int j=0; j<juzhen[i].length; j++) {
				juzhen2[i][j] = juzhen[j][i];	//注意i，j的顺序不能错
				System.out.print(juzhen2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
