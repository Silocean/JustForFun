
/**
A��B��C��D��E��F��G��H��I��J ��10��ѧ���п��ܲμӱ��μ����������Ҳ���ܲ��μӡ���Ϊĳ��ԭ�������Ƿ�����ܵ�����������Լ����

   1. ���A�μӣ�BҲ�μӣ�
   2. ���C���μӣ�DҲ���μӣ�
   3. A��C��ֻ����һ���˲μӣ�
   4. B��D�����ҽ���һ���˲μӣ�
   5. D��E��F��G��H ��������2�˲μӣ�
   6. C��G���߶��μӣ����߶����μӣ�
   7. C��E��G��I������ֻ��2�˲μ�   
   8. ���E�μӣ���ôF��GҲ���μӡ�
   9. ���F�μӣ�G��H�Ͳ��ܲμ�
   10. ���I��J�����μӣ�H����μ�

���̸�����Щ�����ж���10��ͬѧ�в���������������ж��ֿ��ܣ���������еĿ��������ÿ�����ռһ�С�����ͬѧ����ĸ�������У��ÿո�ָ���

���磺
C D G J
����һ�ֿ��ܵ������

���������ǰ��˳����Ҫ
 */
public class Test�߼��ƶ� {

	
	public static int[] arr = {0,0,0,0,0,0,0,0,0,0};

	public static void main(String[] args) {
		print(0);
	}
	
	public static boolean check() {
		// ���A�μӣ�BҲ�μ� (A->B <==> ~A��B)
		boolean condition1 = arr[0]==0 || arr[1]==1;
		// ���C���μӣ�DҲ���μ�
		boolean condition2 = arr[2]==1 || arr[3]==0;
		// A��C��ֻ����һ���˲μ�
		boolean condition3 = arr[0] + arr[2] <=1;
		// B��D�����ҽ���һ���˲μ�
		boolean condition4 = arr[1] + arr[3] == 1;
		// D��E��F��G��H ��������2�˲μ�
		boolean condition5 = arr[3] + arr[4] + arr[5] + arr[6] + arr[7]>= 2;
		// C��G���߶��μӣ����߶����μ�
		boolean condition6 = arr[2]+arr[6]==2 || arr[2]+arr[6]==0;
		// C��E��G��I������ֻ��2�˲μ�
		boolean condition7 = arr[2] + arr[4] + arr[6] + arr[8] <=2;
		// ���E�μӣ���ôF��GҲ���μ�
		boolean condition8 = arr[4]==0 || arr[5]+arr[6]==2;
		// ���F�μӣ�G��H�Ͳ��ܲμ�
		boolean condition9 = arr[5]==0 || arr[6]+arr[7]==0;
		// ���I��J�����μӣ�H����μ�
		boolean condition10 = arr[8]+arr[9]>0 || arr[7]==1;
		
		return condition1&&condition2&&condition3&&condition4&&condition5&&condition6&&condition7&&condition8&&condition9;
		
	}
	
	/*public static void print() {
		for(int a = 0; a<2; a++) {
			for(int b=0; b<2; b++) {
				for(int c=0; c<2; c++) {
					for(int d=0; d<2; d++) {
						for(int e=0; e<2; e++) {
							for(int f=0; f<2; f++) {
								for(int g=0; g<2; g++) {
									for(int h=0; h<2; h++) {
										for(int i=0; i<2; i++) {
											for(int j=0; j<2; j++) {
												arr[0] = a;
												arr[1] = b;
												arr[2] = c;
												arr[3] = d;
												arr[4] = e;
												arr[5] = f;
												arr[6] = g;
												arr[7] = h;
												arr[8] = i;
												arr[9] = j;
												if(check()) {
													for(int n=0; n<arr.length; n++) {
														if(arr[n] == 1) {
															switch(n) {
															case 0: System.out.print("A ");
																break;
															case 1: System.out.print("B ");
																break;
															case 2: System.out.print("C ");
																break;
															case 3: System.out.print("D ");
																break;
															case 4: System.out.print("E ");
																break;
															case 5: System.out.print("F ");
																break;
															case 6: System.out.print("G ");
																break;
															case 7: System.out.print("H ");
																break;
															case 8: System.out.print("I ");
																break;
															case 9: System.out.print("J ");
																break;
															}
														}
														// System.out.print(arr[n] + " ");
													}
													System.out.println();
												}
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}*/
	
	public static void print(int index) {
		if(index == 10) {
			if(check()) {
				for(int n=0; n<arr.length; n++) {
					if(arr[n] == 1) {
						System.out.print((char)(n + 'A') + " ");
					}
					// System.out.print(arr[n] + " ");
				}
				System.out.println();
		}
		} else {
			arr[index] = 1;
			print(index + 1);
			arr[index] = 0;
			print(index + 1);
		}
	}

}
