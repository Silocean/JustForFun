
public class Test����ת�� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int juzhen[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int juzhen2[][] = new int[4][4];
		//ת�þ���
		for(int i=0; i<juzhen.length; i++) {
			for(int j=0; j<juzhen[i].length; j++) {
				juzhen2[i][j] = juzhen[j][i];	//ע��i��j��˳���ܴ�
				System.out.print(juzhen2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
