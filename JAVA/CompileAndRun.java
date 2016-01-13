import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class CompileAndRun implements ActionListener
{
	JFrame f;
	JFileChooser fc;
	JButton browse,compile,run;
	JTextField tf;
	JTextArea ta;
	JLabel l;
	
	File selectedFile, path;
	String name, filePath;
	
		CompileAndRun()
		{
			f=new JFrame("Compile And Run");
			fc=new JFileChooser("C:");
			
			l= new JLabel("Choose the file: ");
			l.setBounds(50,50,100,50);
			f.add(l);
			
			tf=new JTextField();
			tf.setBounds(200,50,100,50);
			tf.setEnabled(false);
			f.add(tf);
			
			browse=new JButton("BROWSE");
			browse.setBounds(350,50,100,50);
			browse.addActionListener(this);
			f.add(browse);
			
			ta=new JTextArea();
			ta.setBounds(50,200,400,300);
			ta.setEnabled(false);
			f.add(ta);
			
			compile=new JButton("COMPILE");
			compile.setBounds(100,600,100,50);
			compile.setEnabled(false);
			compile.addActionListener(this);
			f.add(compile);
			
			run=new JButton("RUN");
			run.setBounds(300,600,100,50);
			run.setEnabled(false);
			run.addActionListener(this);
			f.add(run);
			
			f.setLayout(null);
			f.setSize(500,700);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==browse)
			{
				int x=fc.showOpenDialog(null);
			
				if(x==JFileChooser.APPROVE_OPTION)
				{
					selectedFile=fc.getSelectedFile();
					filePath=selectedFile.getAbsolutePath();
					path=fc.getCurrentDirectory();
					name=fc.getName(selectedFile);
					tf.setText(name);
					
					System.out.println(path.getAbsolutePath());
					compile.setEnabled(true);
				}
			}
			if(e.getSource()==compile)
			{
				try 
				{
					Runtime.getRuntime().exec("javac "+filePath);
					ta.setText("Compiled Successfully..!!!!");
					run.setEnabled(true);
					//Runtime.getRuntime().exec("java C:/HelloWorld > C:/out.txt");
                }
				catch (Exception exp) 
				{
				}
			}
			if(e.getSource()==run)
			{
				ta.setText("");
			
				try
				{
					name=name.replaceAll(".java", "");
					Process p=Runtime.getRuntime().exec("java -cp "+path.getAbsolutePath()+" "+name);
					System.out.println("java -cp "+path.getAbsolutePath()+" "+name);
					InputStreamReader isr=new InputStreamReader(p.getInputStream());
				
					BufferedReader br=new BufferedReader(isr);
					String text="";
					String sample=br.readLine();
					
					System.out.println(sample);
					while(sample!=null)
					{
						text=text+sample+"\n";
						sample=br.readLine();
					}
					ta.setText(text);
				}
				catch(Exception exp1){
					System.out.println(exp1);
				}
			}
		}
		
	


	public static void main(String... s)
		{
			new CompileAndRun();
		}
}
