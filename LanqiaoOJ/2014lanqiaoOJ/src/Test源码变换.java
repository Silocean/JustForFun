import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TestԴ��任 {
	
	static String[] keywords = new String[]{"public","private","protected","static",
								"void","class","import","return","break","case","default",
								"extend","extends","implements","throw","throws","final"};
	static BufferedReader br = null;
	static BufferedWriter bw = null;

	public static void main(String[] args) {
		File f = new File("a.txt");
		File file = new File("b.html");
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bw.write("<html><body>\n");
			String line = "";
			while((line=br.readLine()) != null) {
				convertLine(line);
			}
			bw.write("</body></html>");
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void convertLine(String line) throws Exception {
		//System.out.println(line);
		
		line = line.replaceAll("&", "&amp");
		line = line.replaceAll(" ", "&nbsp;");
		line = line.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		line = line.replaceAll("<", "&lt;");
		line = line.replaceAll(">", "&quot;");
		
		if(line.contains("//")) {
			int index = line.indexOf("//");
			String str1 = line.substring(0, index);
			String str2 = line.substring(index);
			if(str1.contains("\"") && str2.contains("\"")) {
				int index2 = line.lastIndexOf("//");
				if(index2 != index) {
					String string1 = line.substring(0, index2);
					String string2 = line.substring(index2+2);
					line = string1 + "<font color=green>//" + string2;
					//line = line.replaceAll("//", "<font color=green>//");
					line = line + "</font><br/>";
				} else {
					line = line + "</font><br/>";
				}
			} else {
				String string1 = line.substring(0, index);
				String string2 = line.substring(index+2);
				line = string1 + "<font color=green>//" + string2;
				//line = line.replaceAll("//", "<font color=green>//");
				line = line + "</font><br/>";
			}
		} else {
			for(int i=0; i<keywords.length; i++) {
				line = line.replaceAll(keywords[i], "<b>"+keywords[i]+"</b>");
			}
			line = line + "<br/>";
		}
		bw.write(line);
		System.out.println(line);
	}


}
