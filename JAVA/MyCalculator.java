import java.awt.*;
import java.awt.event.*;
class MyCalculator implements ActionListener
{
	Frame f;
	Button b[]=new Button[28];
	TextField tf;
	String s1[]={"MC","MR","MS","M+","M-","<-","CE","C","+-","UR","7","8","9","D","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};
	MyCalculator(String s)
	{
		int i,j,count=0,count1=27;
		f=new Frame(s);
		tf=new TextField();
		tf.setBounds(15,40,268,40);
		f.add(tf);
		for(i=0;i<6;i++)
		{
			for(j=0;(j<5 && count<28);j++)
			{
				if(i==5 && j==0)
				{
					b[count]=new Button(s1[count]);
					b[count].setBounds((15+j*(40+17)),94+i*(14+36),94,36);
					b[count].addActionListener(this);
					f.add(b[count++]);
					j++;
					
				}
				
				else if(i==4 && j==4)	
				{
					b[count]=new Button(s1[count]);
					b[count].setBounds((15+j*(40+17)),94+i*(14+36),40,86);
					b[count].addActionListener(this);
					f.add(b[count++]);
				}
				else
				{
					b[count]=new Button(s1[count]);
					b[count].setBounds((15+j*(40+17)),94+i*(14+36),40,36);
					b[count].addActionListener(this);
					f.add(b[count++]);
				}
			}
		}		
		f.setLayout(null);
		f.setSize(298,400);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	public static void main(String... s)
	{
		new MyCalculator("Calculator");
	}
}