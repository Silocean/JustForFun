import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TestMergeFiles {

	public static void main(String[] args) {
		try {
			File file = new File("E:\\书籍\\韩寒作品\\韩寒全部博文");
			File targetFile = new File("D:\\韩寒博文集.txt");
			File[] files = file.listFiles();
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			BufferedReader br = null;
			int count = 0;
			for(File f : files) {
				if(f.isFile()) {
					br = new BufferedReader(new FileReader(f));
					String str = "";
						bw.write("============" + f.getName().toString().substring(0, f.getName().toString().length()-4) + "============");
						bw.newLine();
						while((str = br.readLine()) != null) {
							bw.write(str);
							bw.newLine();
						}
						bw.flush();
						count ++;
						System.out.println(f.getName());
				}
			}
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
