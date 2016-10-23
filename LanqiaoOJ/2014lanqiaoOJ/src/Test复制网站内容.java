import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;


public class Test¸´ÖÆÍøÕ¾ÄÚÈÝ {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url= new URL("http://www.baidu.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inString;
		File outfile=new File("test.html");	  
		PrintWriter out=new PrintWriter(new FileWriter(outfile));
		while ((inString=in.readLine())!=null){ 
               out.println(inString);
		}
		in.close(); 
		out.close();
	}

}
