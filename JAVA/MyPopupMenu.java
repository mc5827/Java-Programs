import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyPopupMenu extends MouseAdapter
{
	JFrame jf;
	JPopupMenu jpm;
	JMenuItem mi1,mi2,mi3,mi4;
	
	MyPopupMenu(String s)
	{
		jf=new JFrame(s);
		jpm=new JPopupMenu("POP");
		
		mi1=new JMenuItem("New");
		mi2=new JMenuItem("Open");
		mi3=new JMenuItem("Save");
		mi4=new JMenuItem("Close");
		
		jpm.add(mi1);
		jpm.add(mi2);
		jpm.add(mi3);
		jpm.add(mi4);
		
		jf.setVisible(true);
		jf.addMouseListener(this);
		jf.setSize(400,400);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		int x=e.getButton();
		
		if(x==MouseEvent.BUTTON3)
		{
			jpm.show(e.getComponent(),e.getX(),e.getY());
		}
	}
	
	public static void main(String... s)
	{
		new MyPopupMenu("POPUP MENU");
	}
}
	