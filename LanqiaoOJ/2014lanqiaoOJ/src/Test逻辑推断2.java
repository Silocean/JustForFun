public class Test�߼��ƶ�2 {

	/**
	 * @param args
	 */
	public int zhuanhua1(String s) {
		int a=0;
		a=Integer.parseInt(s, 2);
		
		return a;

	}
	public String zhuanhua2(int a) {
		String s="";
		
		for(;a!=0;a=a/2)
			s+=a%2;
		//System.out.println(s);

		char[] b=s.toCharArray();
		String s1="";
		char k;
		for(int i=s.length()-1;i>=0;i--){
			k=(char) (74-i);
			if(b[i]=='1')
				
				s1+=k+" ";
			
		}
		return s1;

	}
	public void count() {
		for(int count = 0;count<1024;count++){
			//1. ���A�μӣ�BҲ�μӣ�
			boolean a1 = count/512%2==1?(count/256%2==1?true:false):true;
			//2. ���C���μӣ�DҲ���μӣ�
			boolean a2= count/128%2==0?(count/64%4==0?true:false):true;
			//3. A��C��ֻ����һ���˲μӣ�
			boolean a3 = (count/512%2+count/128%2)<=1?true:false;
			//4. B��D�����ҽ���һ���˲μӣ�
			boolean a4 = (count/256%2+count/64%2)<=1?true:false;
			//5. D��E��F��G��H ��������2�˲μӣ�
			boolean a5 = (count/4%2+count/8%2+count/16%2+count/32%2+count/64%2)>=2?true:false;
			//6. C��G���߶��μӣ����߶����μӣ�
			boolean a6 = count/128%2==1?(count/8%2==1?true:false):(count/8%2==0?true:false);
			//7. C��E��G��I������ֻ��2�˲μ�  
			boolean a7 = (count/2%2+count/8%2+count/32%2+count/128%2)<=2?true:false;
			//8. ���E�μӣ���ôF��GҲ���μӡ�
			boolean a8 = count/32%2==1?(count/8%4==3?true:false):true;
			//9. ���F�μӣ�G��H�Ͳ��ܲμ�
			boolean a9 = count/16%2==1?(count/4%4==0?true:false):true;      //a8��a9���Ժ���
			//10. ���I��J�����μӣ�H����μ�
			boolean a10 = count%4==0?(count/4%2==1?true:false):true;
			
			
			if(a1&&a2&&a3&&a4&&a5&&a6&&a7&&a8&&a9&&a10)
				{
				//System.out.println(count);
				System.out.println(new Test�߼��ƶ�2().zhuanhua2(count));
				
				}
			
		}
	}
	public static void main(String[] args) {
		
		new Test�߼��ƶ�2().count();

	}

}
