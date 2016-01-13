import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingInternalFrame 
{
	JFrame jf;
	JPanel jp1,jp2;
	JDesktopPane jdp;
	JInternalFrame jif;
	JButton jb;
	
	SwingInternalFrame(String s)
	{
		jf=new JFrame(s);
		jb=new JButton("qwqw");
		
		jp1=new JPanel();
		jp1.add(jb);
		
		
		jp2=new JPanel();
				
		jdp=new JDesktopPane();
		jdp.setLayout(new BorderLayout());
		jdp.add(jp1,BorderLayout.NORTH);
		jdp.add(jp2);
		jdp.setBackground(Color.GREEN);
		
		jf.add(jdp);
		
		for(int i=0;i<5;i++)
		{
			jif=new JInternalFrame(("Internal Frame"+i),true,true,false,false);
			jif.setLocation(i*50+10, i*50+10);
			jif.setSize(200,150);
			jif.setBackground(Color.RED);
			jif.setVisible(true);
			jp2.add(jif);
			jif.moveToBack();
		}
	jf.setSize(400,400);
	jf.setVisible(true);
}

public static void main(String... s)
{
	new SwingInternalFrame("Internal Frame");
}
}