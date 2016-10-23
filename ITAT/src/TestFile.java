import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.*;

public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("F:\\java workplace\\ITAT\\src");
		File[] listFiles = f.listFiles();
		//String[] fileNames = new String[listFiles.length];
		Set<String> fileNames = new HashSet<String>();
		for(File file : listFiles) {
			if(file.getName().endsWith(".java")) {
				fileNames.add(file.getName());
			}
		}
		Iterator<String> it = fileNames.iterator();
		
		while(it.hasNext()) {
			String name = (String) it.next();
			System.out.println(name);
			FileOutputStream fos = null;
			FileInputStream fis = null;
			int b = 0;
			try {
				fos = new FileOutputStream("d:\\test\\" + name);
				fis = new FileInputStream("F:\\java workplace\\ITAT\\src\\" + name);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				while((b=fis.read()) != -1) {
					fos.write(b);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
