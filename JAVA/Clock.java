import javax.swing.*;
import java.awt.*;

class MyCanvas extends Canvas
{
	int radius=100;
	int xcenter=100;
	int ycenter=100;
	public void paint(Graphics g)
	{
		g.drawOval(xcenter-radius, ycenter-radius, radius,radius);
		//g.drawString("9",290,200);

	}
}
	
class Clock
{
	Clock()
	{
		JFrame f=new JFrame("Clock");
		
		MyCanvas c=new MyCanvas();
		
		f.add(c);
		f.setVisible(true);
		f.setSize(200,200);
		//f.pack();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String... s)
	{
		new Clock();
	}
}