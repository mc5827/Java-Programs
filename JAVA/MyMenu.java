import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyMenu implements ActionListener
{
	JTextField tf= new JTextField();
	JFrame jf= new JFrame("MY MENU");
	JMenuBar menuBar;
	JMenu menu, subMenu;
	JMenuItem menuItem, exit;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
	
	MyMenu()
	{
		jf.add(tf,BorderLayout.CENTER);
		
		menuBar=new JMenuBar();
		
		menu=new JMenu("FIRST ITEM");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);
		
		menuItem=new JMenuItem("A TEXT ONLY MENU ITEM", KeyEvent.VK_T);
		menuItem.addActionListener(this);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menu.addSeparator();
		
		ButtonGroup group=new ButtonGroup();
		
		rbMenuItem=new JRadioButtonMenuItem("A Radio Button Menu Item");
		rbMenuItem.setSelected(true);
		rbMenuItem.addActionListener(this);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem=new JRadioButtonMenuItem("Another Radio Button Menu Item");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		menu.addSeparator();
		
		cbMenuItem=new JCheckBoxMenuItem("A CheckBox Menu Item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);
		
		cbMenuItem=new JCheckBoxMenuItem("Another CheckBox Menu Item");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);
		
		subMenu=new JMenu("A Sub Menu");
		subMenu.setMnemonic(KeyEvent.VK_S);
		
		menuItem=new JMenuItem("An Item In Sub Menu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		subMenu.add(menuItem);
		
		menuItem=new JMenuItem("Another Item In Sub Menu");
		subMenu.add(menuItem);
		
		menu.add(subMenu);
		
		exit=new JMenu("Exit");
		exit.addActionListener(this);
		
		menu.add(exit);
		
		menu=new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		
		menuBar.add(menu);
		
		jf.setJMenuBar(menuBar);
		jf.setSize(300,400);
		jf.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("A TEXT ONLY MENU ITEM"));
		{
			tf.setText("Hello");
		}
		if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		if(e.getActionCommand().equals("A Radio Button Menu Item"))
		{
			System.out.println("mohit");
		}
	}
	public static void main(String... s)
	{
		new MyMenu();
	}
}