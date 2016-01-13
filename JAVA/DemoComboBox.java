import javax.swing.*;
import java.awt.event.*;

class DemoComboBox implements ActionListener
{
	JFrame f;
	JComboBox cb1, cb2;
	DefaultComboBoxModel model1, model2, model3;
	String state[]={"SELCT STATE","U.P.","RAJASTHAN","HARAYANA"};
	String city[][]={{"NOIDA","LUCKNOW","VARANASI","AGRA","KANPUR","ALIGARH"},
					 {"JAIPUR","AJMER","KOTA","JODHPUR","BIKANER","UDAIPUR"},
					 {"CHANDIGARH","REWARI","GURGAON","FARIDABAD","PANIPAT","ROHTAK"},};
					 
	JButton b;
	
	DemoComboBox(String s)
	{
		f=new JFrame(s);
		
		cb1=new JComboBox(state);
		cb1.setBounds(100,100,150,50);
		cb1.addActionListener(this);
		f.add(cb1);
		
		cb2=new JComboBox();
		cb2.setBounds(350,100,150,50);
		cb2.setVisible(false);
		//cb2.setVisibleRowCount(5);
		cb2.addActionListener(this);
		f.add(cb2);
		
		b=new JButton("MANAGE");
		b.setBounds(100,250,100,50);
		b.addActionListener(this);
		f.add(b);
		
		model1=new DefaultComboBoxModel(city[0]);
		model2=new DefaultComboBoxModel(city[1]);
		model3=new DefaultComboBoxModel(city[2]);
		
		f.setSize(600,350);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cb1)
		{
			if(cb1.getSelectedItem()=="U.P.")
			{
				cb2.setVisible(true);
				cb2.setModel(model1);
			}
			if(cb1.getSelectedItem()=="RAJASTHAN")
			{
				cb2.setVisible(true);
				cb2.setModel(model2);
			}
			if(cb1.getSelectedItem()=="HARAYANA")
			{
				cb2.setVisible(true);
				cb2.setModel(model3);
			}
		}
		if(e.getSource()==b)
		{
			new ManageComboBox("MANAGE",this);
		}
	}
	
	public static void main(String... s)
	{
		new DemoComboBox("COMBO BOX");
	}
}		
		
