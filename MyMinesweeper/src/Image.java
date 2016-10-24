import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Image {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Icon button_image = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/0.gif")));
	Icon button_image1 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/1.gif")));
	Icon button_image2 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/2.gif")));
	Icon button_image3 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/3.gif")));
	Icon button_image4 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/4.gif")));
	Icon button_image5 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/5.gif")));
	Icon button_image6 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/6.gif")));
	Icon button_image7 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/7.gif")));
	Icon button_image8 = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/8.gif")));
	Icon dilei_image = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/DiLei.gif")));
	Icon info_win_image = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/info_win.gif")));
	Icon info_lose_image = new ImageIcon(tk.getImage(Image.class.getClassLoader().getResource("images/info_lose.jpg")));
}
