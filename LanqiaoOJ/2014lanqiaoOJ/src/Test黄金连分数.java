import java.math.BigDecimal;
import java.math.BigInteger;

/**
    �ƽ�ָ���0.61803... �Ǹ����������������ʮ����Ҫ������๤�������л���֡���ʱ��Ҫ�����������úܾ�ȷ��
 
    ����ĳЩ���ܹ��̣������ľ��Ⱥ���Ҫ��Ҳ������˵������̫����Զ�������״����պ�ͷ�����һ���˹��ӹ����󣬶�����һ����Ȼ�����ʵֻ�Ǿ���ӹ�ʱ�б�ͷ��˿��ϸ��౶��һ��������ѣ�ȴʹ�����ˡ������ۡ�!!
 
    �Թ����������������ûƽ�ָ����ľ����ܾ�ȷ��ֵ�أ�����෽����
 
    �Ƚϼ򵥵�һ��������������
 
                  1
    �ƽ��� = ---------------------
                        1
             1 + -----------------
                          1
                 1 + -------------
                            1
                     1 + ---------
                          1 + ...
 
                           
 
    �������������ġ�������Խ�࣬����ֵԽ�ӽ��ƽ�ָ�����
 
    ����������һ���ԣ�����ƽ�ָ������㹻��ȷֵ��Ҫ���������뵽С�����100λ��
 
    С�����3λ��ֵΪ��0.618
    С�����4λ��ֵΪ��0.6180
    С�����5λ��ֵΪ��0.61803
    С�����7λ��ֵΪ��0.6180340
   ��ע��β����0�����ܺ��ԣ�
 
��������ǣ�д����ȷ��С�����100λ���ȵĻƽ�ָ�ֵ��
 
ע�⣺β�����������룡 β����0ҲҪ������

 */
public class Test�ƽ������� {

	public static BigDecimal bd = new BigDecimal(new BigInteger("1"));
	
	public static void main(String[] args) {
		System.out.println(f(1));
		// System.out.println(new BigDecimal(1.0).divide(new BigDecimal(7.0), 10 , BigDecimal.ROUND_HALF_UP));
	}
	
	public static BigDecimal f(int index) {
		if(index == 100) {
			return new BigDecimal(1.0);
		} else {
			return bd = bd.divide(bd.add(f(index+1)), 100, BigDecimal.ROUND_HALF_UP);
		}
	}

}
