import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TestÈ«ÅÅÁĞ {
	
	public static int n = 0;
	
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>(Arrays.asList("1","2","3","4","5"));
        listAll(list, "");
        System.out.println(n);
	}
	
	public static void listAll(List<String> list, String strNum) {
        if (list.isEmpty()) {
            n++;
            System.out.println(strNum);
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> temp = new LinkedList<String>(list);
            String c = temp.remove(i);
            listAll(temp, strNum + c);
        }
    }

}
