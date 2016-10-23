
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiThreadClock extends JFrame {

	public MultiThreadClock() {
		ClockPanel jp_clock = new ClockPanel();
		add(jp_clock);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		this.setLocationRelativeTo(null);
		setVisible(true);
		Thread ClockRun = new Thread(jp_clock);
		ClockRun.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generatedmethod stub
		new MultiThreadClock();
	}
}

class ClockPanel extends JPanel implements Runnable {
	private double CenterX, CenterY;
	private double Radius = 150;
	private double HPointX, HPointY, MPointX, MPointY, SPointX, SPointY;
	private int Year, Month, Day, WeekDay, Hour, Minute, Second;
	private final double PI = 3.1415926;

	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		CenterX = this.getWidth() / 2;
		CenterY = this.getHeight() / 2;
		double HRadian = (PI / 6) * Hour + (PI / 360) * Minute + (PI / 21600)
				* Second;
		double MRadian = (PI / 30) * Minute + (PI / 1800) * Second;
		double SRadian = (PI / 30) * Second;
		HPointX = CenterX + Radius * 0.6 * Math.sin(HRadian);
		HPointY = CenterY - Radius * 0.6 * Math.cos(HRadian);
		MPointX = CenterX + Radius * 0.8 * Math.sin(MRadian);
		MPointY = CenterY - Radius * 0.8 * Math.cos(MRadian);
		SPointX = CenterX + Radius * Math.sin(SRadian);
		SPointY = CenterY - Radius * Math.cos(SRadian);

		g.drawOval((int) (CenterX - Radius), (int) (CenterY - Radius),
				(int) (2 * Radius), (int) (2 * Radius));
		g.drawString("12", (int) (CenterX), (int) (CenterY - Radius) + 10);
		g.drawString("3", (int) (CenterX + Radius) - 6, (int) (CenterY));
		g.drawString("6", (int) (CenterX), (int) (CenterY + Radius));
		g.drawString("9", (int) (CenterX - Radius), (int) (CenterY));

		g.drawLine((int) (CenterX), (int) (CenterY), (int) (SPointX),
				(int) (SPointY));
		g.drawLine((int) (CenterX), (int) (CenterY), (int) (MPointX),
				(int) (MPointY));
		g.drawLine((int) (CenterX), (int) (CenterY), (int) (HPointX),
				(int) (HPointY));

		g.drawString(WeekDay + " " + Month + " " + Day + " " + Hour + ":"
				+ Minute + ":" + Second + " " + Year, 20, 350);
	}

	@Override
	public void run() {
		// TODO Auto-generatedmethod stub
		while (true) {
			try {
				setCurrentTime();
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		Year = calendar.get(Calendar.YEAR);
		Month = calendar.get(Calendar.MONTH);
		Day = calendar.get(Calendar.DAY_OF_MONTH);
		WeekDay = calendar.get(Calendar.DAY_OF_WEEK);
		Hour = calendar.get(Calendar.HOUR);
		Minute = calendar.get(Calendar.MINUTE);
		Second = calendar.get(Calendar.SECOND);

	}
}
