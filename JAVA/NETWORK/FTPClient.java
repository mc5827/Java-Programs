import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FTPClient implements ActionListener
{
	Socket s;
	DataOutputStream dos;
	DataInputStream dis,dis1;
	JFrame jf;
	JFileChooser jfc;
	JLabel l;
	JButton browse, send;
	JTextField tb;
	File selectedFile;
	String selectedFileName, fileData;
	
	FTPClient(String name)
	{
		jf=new JFrame(name);
		jfc=new JFileChooser("C:");
		
		
		
		l=new JLabel("Chose the file to transfer: ");
		jf.add(l,BorderLayout.WEST);
		
		tb=new JTextField();
		jf.add(tb,BorderLayout.CENTER);
		
		browse=new JButton("Browse");
		browse.addActionListener(this);
		jf.add(browse,BorderLayout.EAST);
		
		
		send=new JButton("Send");
		send.addActionListener(this);
		jf.add(send,BorderLayout.SOUTH);
		
		jf.setSize(400,200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try
		{
			s=new Socket("localhost",100);
			dos=new DataOutputStream(s.getOutputStream());
			dis=new DataInputStream(s.getInputStream());
			System.out.println(s);
			
		}
		catch(Exception e){}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==browse)
		{
			int x=jfc.showOpenDialog(null);
			
			if(x==JFileChooser.APPROVE_OPTION)
			{
				selectedFile=jfc.getSelectedFile();
				String path=selectedFile.getAbsolutePath();
				tb.setText(path);
				tb.setEnabled(false);
				selectedFileName=selectedFile.getName();
				System.out.println(selectedFileName);
			}
		}
		
		if(e.getSource()==send)
		{
			try
			{
				dos.writeUTF(selectedFileName);
				System.out.println(selectedFileName);
				
				if(dis.readUTF().equals("begin"))
				{
					dos.flush();
					System.out.println("begin");
					dis1=new DataInputStream(new FileInputStream(selectedFile));
					fileData="";
					while(fileData!=null)
					{
						fileData=dis1.readLine();
						if(fileData!=null)
						{
							System.out.println(fileData);
							dos.writeUTF(fileData);
						}
						else
						{
							
							break;
						}
					}
					
				}
				System.out.println("syapa");
				System.exit(0);
			}
			catch(Exception e1)
			{
			}
		}
	}
	public static void main(String... s)
	{
		new FTPClient("FTP CLIENT");
	}
}