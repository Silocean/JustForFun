 
public class CountChar {
 
   public static void main(String[] args) {
      int[] ori={1,3,4,7,2,1,1,5,2};
      int ori_len=ori.length;
      int[] count=new int[ori_len];
      int[] most=new int[ori_len];
      int count_max=count[0];
      int most_max=most[0];
     
      for(int i=0;i<ori_len;i++)
          for(int j=0;j<ori_len;j++)
             if(ori[i]==ori[j])
                count[i]++;
     
      //�鿴�������ֳ��ֵĴ���
      for(int i=0;i<count.length;i++)
            System.out.print(count[i]);
     
      System.out.print("\n");
     
        //���count��������ֵ
      for(int i=1;i<count.length;i++)
         if(count_max<count[i])
            count_max=count[i];
     
      //���count���ֵcount[i]��Ӧ��m[i]��m[i]�����ж����
      for(int i=0,j=0;i<count.length;i++)
         if(count[i]==count_max)
            most[j++]=ori[i];//�����ִ�������ori[i]����most���飨ori[i]�����ж����
     
      //�õ�most��������ֵ��
      for(int i=1;i<most.length;i++)
         if(most_max<most[i])
            most_max=most[i];
     
      System.out.print(most_max);
   }
 
}