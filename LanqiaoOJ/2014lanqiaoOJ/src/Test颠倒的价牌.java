
/**
    С��ĵ���ר�����������¼ܵ���Ʒ���ӻ����ɳ�Ϊ����Ʒ����ר���ꡣ
    ���۶���4λ���֣���ǧԪ���ȣ���
    С��Ϊ�˱�����������㣬ʹ����Ԥ�Ƶ���������ܵı��ǩ��ֻҪ����ɫ��Ϳ���־Ϳ����ˣ��μ�p1.jpg����
    ���ּ����и��ص㣬��һЩ���֣���������Ҳ�Ǻ�������֡��磺1 2 5 6 8 9 0 �����ԡ�����һ����������ӹҵ��ˣ�
    �п�����ȫ�������һ���۸񣬱��磺1958 ���ŹҾ��ǣ�8561�����˼�ǧԪ��!!
    ��Ȼ������������ܵ��������磬1110 �Ͳ��ܵ���������Ϊ0������Ϊ��ʼ���֡�
    ��һ�죬�������ڷ����ˡ�ĳ����Ա��С�İѵ����ĳ�����۸��Ƹ��ҵ��ˡ������������۸��Ƶĵ��ӻ�������ȥ��!
    ���ҵ��Ǽ۸���벻������һ����������2�ٶ࣬��һ������ȴ׬��8�ٶ࣬�ۺ�������������׬��558Ԫ��
    �������Щ��Ϣ���㣺��Ǯ���Ǹ�������ȷ�ļ۸�Ӧ���Ƕ��٣�
 */
public class Test�ߵ��ļ��� {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,5,6,8,9,0},
				{1,2,5,9,8,6,0}};
		int[][] array1 = new int[2][100];
		int[][] array2 = new int[2][100];
		int count1 = 0;
		int count2 = 0;
		for(int a=0; a<arr[0].length-1; a++) {
			for(int b=0; b<arr[0].length; b++) {
				for(int c=0; c<arr[0].length; c++) {
					for(int d=0; d<arr[0].length-1; d++) {
						int price = arr[0][a]*1000+ arr[0][b]*100 + arr[0][c]*10 + arr[0][d];
						int _price = arr[1][d]*1000+ arr[1][c]*100 + arr[1][b]*10 + arr[1][a];
						if(_price-price>=-300 && _price-price<=-200) {
							array1[0][count1] = price;
							array1[1][count1] = _price;
							count1 ++;
						}
						if(_price-price>=800 && _price-price<=900) {
							array2[0][count2] = price;
							array2[1][count2] = _price;
							count2 ++;
						}
					}
				}
			}
		}
		for(int i=0; i<array1[0].length; i++) {
			for(int j=0; j<array2[0].length; j++) {
				if((array1[1][i]-array1[0][i]) + (array2[1][j]-array2[0][j]) == 558) {
					System.out.println(array1[0][i] + " " + array1[1][i] + "====" + array2[0][j] + " " + array2[1][j]);
				}
			}
		}
	}

}
