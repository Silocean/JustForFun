import java.io.*;

public class ListFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("d:/test");
		System.out.println(f.getName());
		/*File f1 = new File("d:/test/ÐÇÆÚÒ».txt");
		f1.getParentFile().mkdirs();
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		tree(f, 1);

	}

	private static void tree(File f, int level) {
		String s = "";
		for(int i=0; i<level; i++) {
			s = s + "     ";
		}
		File[] files = f.listFiles();
//		if(files == null) {
//			File f1 = new File("d:\\test\\a.txt");
//			try {
//				f1.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		for(int i=0; i<files.length; i++) {
			System.out.println(s + files[i].getName());
			if(files[i].isDirectory()) {
				tree(files[i], level+1);
			}
		}
	}

}
