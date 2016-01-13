import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FolderDelete implements ActionListener
{
	JFrame jf;
	JFileChooser jfc;
	JLabel l;
	JButton browse, delete;
	JTextField tb;
	File allFiles[];
	File selectedDirectory;
	
	FolderDelete(String s)
	{
		jf=new JFrame("Folder Delete");
		jfc=new JFileChooser("C:");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		l=new JLabel("Chose the folder to delete: ");
		jf.add(l, BorderLayout.WEST);
		
		tb=new JTextField();
		jf.add(tb,BorderLayout.CENTER);
		
		browse=new JButton("Browse");
		browse.addActionListener(this);
		jf.add(browse,BorderLayout.EAST);
		
		
		delete=new JButton("Delete");
		delete.addActionListener(this);
		jf.add(delete,BorderLayout.SOUTH);
		
		try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){}
		
		jf.setSize(400,200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==browse)
		{
			int x=jfc.showOpenDialog(null);
			
			if(x==JFileChooser.APPROVE_OPTION)
			{
				selectedDirectory=jfc.getSelectedFile();
				String path=selectedDirectory.getAbsolutePath();
				tb.setText(path);
				tb.setEnabled(false);
				System.out.println(path);
				allFiles=selectedDirectory.listFiles();
			}
			
		}
		if(e.getSource()==delete)
		{
			deleteFolder(allFiles);			
			selectedDirectory.delete();
			
		}
	}
	
	public void deleteFolder(File[] file)
	{
		for(int i=0;i<file.length;i++)
		{
			if(file[i].isFile())
			{
				file[i].delete();
			}
			else
			{
				File[] newFile=file[i].listFiles();
				deleteFolder(newFile);
				file[i].delete();
			}
		}
	}
	public static void main(String... s)
	{
		new FolderDelete("Folder Delete");
	}
}
		
		
	