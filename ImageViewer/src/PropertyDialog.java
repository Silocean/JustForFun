import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;


public class PropertyDialog extends JDialog {
	
	PictureViewer mf = null;
	
	JLabel lName = new JLabel("", JLabel.CENTER);
	JLabel lSize = new JLabel("", JLabel.CENTER);
	JLabel lLocation = new JLabel("", JLabel.CENTER);
	JLabel lLength = new JLabel("", JLabel.CENTER);
	JLabel lTime = new JLabel("", JLabel.CENTER);
	
	File f = null;
	
	public PropertyDialog(PictureViewer mf) {
		f = new File(mf.imgList.get(mf.indexOfNow));
		this.mf = mf;
		this.setLayout(new GridLayout(5, 1));
		this.add(lName);
		this.add(lSize);
		this.add(lLocation);
		this.add(lLength);
		this.add(lTime);
		lName.setText("名称："+ f.getName());
		lSize.setText("图片尺寸：" + mf.img.getWidth(null) + "X" + mf.img.getHeight(null) + " 像素（宽X高）");
		lLocation.setText("位置：" + f.getAbsolutePath());
		lLength.setText("文件大小：" + f.length()/1024 + "KB");
		lTime.setText("修改时间：" + this.getTime());
		this.setBounds(500, 300, 400, 200);
	}
	
	public String getTime() {
		Calendar c = Calendar.getInstance();
		long lastTime = f.lastModified();
		c.setTimeInMillis(lastTime);
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		return sdf.format(d);
	}
	
}
