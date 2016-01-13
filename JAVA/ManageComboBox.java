import javax.swing.*;
import java.awt.event.*;

class  ManageComboBox implements ActionListener
{
	JFrame f1;
	JLabel l1,l2,l3;
	JComboBox cb3,cb4;
	JButton b1,b2;
	JTextField t;
	DemoComboBox dcb;
	DefaultComboBoxModel model;
	
	ManageComboBox(String s, DemoComboBox dcb)
	{
		this.dcb=dcb;
		f1=new JFrame(s);
		
		l1=new JLabel("STATE");
		l1.setBounds(50,50,100,50);
		f1.add(l1);
		
		cb3=new JComboBox(dcb.state);
		cb3.setBounds(250,50,100,50);
		cb3.addActionListener(this);
		f1.add(cb3);
		
		l2=new JLabel("NEW CITY");
		l2.setBounds(50,150,100,50);
		f1.add(l2);
		
		t=new JTextField();
		t.setBounds(250,150,100,50);
		f1.add(t);
		
		b1=new JButton("ADD");
		b1.setBounds(250,250,100,50);
		b1.addActionListener(this);
		f1.add(b1);
		
		l3=new JLabel("CITY");
		l3.setBounds(50,350,100,50);
		f1.add(l3);
		
		cb4=new JComboBox();
		cb4.setBounds(250,350,100,50);
		cb4.addActionListener(this);
		f1.add(cb4);
		
		b2=new JButton("REMOVE");
		b2.setBounds(250,450,100,50);
		b2.addActionListener(this);
		f1.add(b2);
		
		f1.setSize(400,550);
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cb3)
		{
			if(cb3.getSelectedItem()=="U.P.")
			{
				System.out.println("aaa");
				cb4.setModel(dcb.model1);
			}
			if(cb3.getSelectedItem()=="RAJASTHAN")
			{
				System.out.println("bbb");
				cb4.setModel(dcb.model2);
			}
			if(cb3.getSelectedItem()=="HARAYANA")
			{
				System.out.println("ccc");
				cb4.setModel(dcb.model3);
			}
		}
		
		if(e.getSource()==b1)
		{
			model=(DefaultComboBoxModel)cb4.getModel();
			model.addElement(t.getText());
			cb4.setModel(model);
			t.setText("");
		}
		
		if(e.getSource()==b2)
		{
			model=(DefaultComboBoxModel)cb4.getModel();
			model.removeElement(cb4.getSelectedItem());
			cb4.setModel(model);

		}
			
	}
}