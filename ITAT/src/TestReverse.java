import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class TestReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile raf = new RandomAccessFile("d:\\新建文件夹\\input.txt", "rw");
			List<String> list = new ArrayList<String>();
			String str;
			while((str=raf.readLine()) != null) {
				list.add(str);
			}
			Collections.reverse(list);
			Iterator it = list.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
