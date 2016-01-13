import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class PublicChatClient implements ActionListener
{
	String name;
	JFrame f;
	JTextArea ta,ta1;
	JList l;
	JButton b,b1;
	Socket s;
	DataInputStream dis;
	
	
	
	
	DefaultListModel dlm=new DefaultListModel();
	
	PublicChatClient(String name)
	{
		this.name=name;
		dlm.addElement(name);
		
		f=new JFrame(name);
		
		ta=new JTextArea();
		ta.setBounds(50,50,200,200);
		ta.setEnabled(false);
		f.add(ta);
		
		ta1=new JTextArea();
		ta1.setBounds(50,350,200,100);
		f.add(ta1);
		
		l=new JList(dlm);
		l.setBounds(300,50,100,200);
		f.add(l);
		
		b=new JButton("SEND");
		b.setBounds(300,350,100,50);
		b.addActionListener(this);
		f.add(b);
		
		b1=new JButton("Logout");
		b1.setBounds(300,450,100,50);
		b1.addActionListener(this);
		f.add(b1);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(450,650);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{
		s=new Socket("localhost",10);
		dis=new DataInputStream(s.getInputStream());
		PrintStream ps=new PrintStream(s.getOutputStream());
		ps.println("*%add%* "+name);
		
		String recvText=dis.readLine();
		if(recvText.equals("*%appendList%*"))
		{	
			ObjectInputStream ois=new ObjectInputStream(dis);
			ArrayList alName=(ArrayList)ois.readObject();
			Iterator ir=alName.iterator();
			DefaultListModel dlm1=new DefaultListModel();
			while(ir.hasNext())
			{

				String recvName=(String)ir.next();
				System.out.println("Extracted Name: "+recvName);
				if(!(recvName.equals(name)))
				{
					System.out.println(name+":"+recvName);
					dlm1.addElement(recvName);
				}
			}
			l.setModel(dlm1);									
		}
			My m=new My(dis,l,ta,name);
			Thread t=new Thread(m);
			t.start();
		}
		catch(Exception e){}
	}
		
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			//My m=new My(dis,l,ta);
			//Thread t=new Thread(m);
			//t.start();
			
			String text=ta1.getText();
			ta1.setText("");
			
			ta.setText(ta.getText()+"\n"+"YOU: "+text);
			try
			{
			PrintStream ps1=new PrintStream(s.getOutputStream());
			ps1.println(name+" : "+text);
			System.out.println(name+" : "+text);
		
			}
			catch(Exception e1){}
		}

		if(e.getSource()==b1)
		{
		try
		{
		PrintStream ps2=new PrintStream(s.getOutputStream());
		ps2.println("*%del%* "+name);
		}
		catch(Exception exp){}
		f.setVisible(false);
		new LoginPage();
		}	
	}
	
}	

class My implements Runnable
{
	DataInputStream dis;
	JList l;
	JTextArea ta;
	String name;
	
	My(DataInputStream dis, JList l,JTextArea ta,String name)
	{
		this.dis=dis;
		this.l=l;
		this.ta=ta;
		this.name=name;
	}
	
	public void run()
	{
		while(true)
		{
			try 
			{
				String recvText=dis.readLine();
				System.out.println(recvText);
				if(recvText.equals("*%appendList%*"))
				{	
					ObjectInputStream ois=new ObjectInputStream(dis);
					ArrayList alName=(ArrayList)ois.readObject();
					Iterator ir=alName.iterator();
					DefaultListModel dlm1=new DefaultListModel();
					while(ir.hasNext())
					{
						String recvName=(String)ir.next();
						System.out.println("Extracted Name: "+recvName);
						if(!(recvName.equals(name)))
						{
							System.out.println(name+":"+recvName);
							dlm1.addElement(recvName);
						}
					}
					l.setModel(dlm1);									
				}
				else
				{
					ta.setText(ta.getText()+"\n"+recvText);
				}
			}
			catch(Exception e)
			{
			}
		}	
	}	
}