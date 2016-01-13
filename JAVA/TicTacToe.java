import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.color.*;

public class TicTacToe implements ActionListener
{
	JFrame f;
	JPanel p2;
	JButton b[];
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	
	int typeOfGame=1;
	int i=0,i1=0;
	
	Icon cross = new ImageIcon("C:\\Users\\MOHIT\\Desktop\\cross.jpg");
	Icon zero = new ImageIcon("C:\\Users\\MOHIT\\Desktop\\zero.jpg");
	Icon you_win=new ImageIcon("C:\\Users\\MOHIT\\Desktop\\you_win.jpg");
	
	int array_pattern[]={123,456,789,147,258,369,159,357};
	
	int array_cross[]=new int[5], cross_count=0;
	
	int array_zero[]=new int[4], zero_count=0;
	
	int array_remaining[]={1,2,3,4,5,6,7,8,9},remaining_count=9 ;
	
	int array_occupied[]=new int[9], occupied_count=0;
	
	int random,min=1,max=9;
	
	int cross_result, zero_result;
	
	TicTacToe(String s)
	{
		f=new JFrame(s);
		menuBar=new JMenuBar();
		menu=new JMenu("MENU");
		menu.setMnemonic(KeyEvent.VK_M);
		menuBar.add(menu);
		
		menuItem=new JMenuItem("New Game",KeyEvent.VK_N);
		menuItem.addActionListener(this);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		menu.add(menuItem);
		
		menu.addSeparator();
		
		ButtonGroup group=new ButtonGroup();
		rbMenuItem=new JRadioButtonMenuItem("One Player");
		rbMenuItem.addActionListener(this);
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem=new JRadioButtonMenuItem("Two Player");
		rbMenuItem.addActionListener(this);
		rbMenuItem.setMnemonic(KeyEvent.VK_T);
		rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		menu.addSeparator();
		
		menuItem=new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,ActionEvent.CTRL_MASK));
		menu.add(menuItem);
		
		f.setJMenuBar(menuBar);
		
		b=new JButton[9];
		p2=new JPanel(new GridLayout(3,3));
		for(int i=0;i<9;i++)
		{
			b[i]=new JButton();
			b[i].addActionListener(this);
			p2.add(b[i]);
		}
		f.add(p2,BorderLayout.CENTER);
		
		f.setVisible(true);
		f.setSize(402,402);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("One Player"))
		{
			System.out.println("One Player");
			typeOfGame=1;
			
			
		}
		if(e.getActionCommand().equals("Two Player"))
		{
			System.out.println("Two Player");
			typeOfGame=2;
		}
		if(e.getSource()==b[0])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[0].setIcon(cross);
					b[0].setEnabled(false);
				}
			
				else
				{
					b[0].setIcon(zero);
					b[0].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();						
				}
			}
			else
			{
				b[0].setIcon(cross);
				b[0].setEnabled(false);
				System.out.println("Button clicked: 1");
				
				array_cross[cross_count++]=1;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(1);
				
				array_occupied[occupied_count++]=1;
				
				i1++;
				
					checkPattern();
					System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[1])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[1].setIcon(cross);
					b[1].setEnabled(false);
				}
				else
				{
					b[1].setIcon(zero);
					b[1].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{	
					checkPattern();								
				}
			}
			else
			{
				b[1].setIcon(cross);
				b[1].setEnabled(false);
				System.out.println("Button clicked: 2");
				
				array_cross[cross_count++]=2;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(2);
				
				array_occupied[occupied_count++]=2;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;	
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[2])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[2].setIcon(cross);
					b[2].setEnabled(false);
				}
				else
				{
					b[2].setIcon(zero);
					b[2].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();								
				}
			}
			else
			{
				b[2].setIcon(cross);
				b[2].setEnabled(false);
				System.out.println("Button clicked: 3");
				array_cross[cross_count++]=3;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(3);
				
				array_occupied[occupied_count++]=3;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[3])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[3].setIcon(cross);
					b[3].setEnabled(false);
				}
				else
				{
					b[3].setIcon(zero);
					b[3].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();								
				}
			}
			else
			{
				b[3].setIcon(cross);
				b[3].setEnabled(false);
				System.out.println("Button clicked: 4");
				
				array_cross[cross_count++]=4;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(4);
				
				array_occupied[occupied_count++]=4;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[4])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[4].setIcon(cross);
					b[4].setEnabled(false);
				}
				else
				{
					b[4].setIcon(zero);
					b[4].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();								
				}
			}
			else
			{
				b[4].setIcon(cross);
				b[4].setEnabled(false);
				System.out.println("Button clicked: 5");
				
				array_cross[cross_count++]=5;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(5);
				
				array_occupied[occupied_count++]=5;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					System.out.println("pata karu aaya ki nai");
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[5])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[5].setIcon(cross);
					b[5].setEnabled(false);
				}
				else
				{
					b[5].setIcon(zero);
					b[5].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();								
				}
			}
			else
			{
				b[5].setIcon(cross);
				b[5].setEnabled(false);
				System.out.println("Button clicked: 6");
				
				array_cross[cross_count++]=6;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(6);
				
				array_occupied[occupied_count++]=6;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[6])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[6].setIcon(cross);
					b[6].setEnabled(false);
				}
				else
				{
					b[6].setIcon(zero);
					b[6].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();					
				}
			}
			else
			{
				b[6].setIcon(cross);
				b[6].setEnabled(false);
				System.out.println("Button clicked: 7");
				
				array_cross[cross_count++]=7;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(7);
				
				array_occupied[occupied_count++]=7;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				System.out.println("pata nai kya syapa hai yaar........");
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;			
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[7])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[7].setIcon(cross);
					b[7].setEnabled(false);
				}
				else
				{
					b[7].setIcon(zero);
					b[7].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();								
				}
			}
			else
			{
				b[7].setIcon(cross);
				b[7].setEnabled(false);
				System.out.println("Button clicked: 8");
				
				array_cross[cross_count++]=8;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(8);
				
				array_occupied[occupied_count++]=8;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getSource()==b[8])
		{
			if(typeOfGame==2)
			{
				if(i%2==0)
				{
					b[8].setIcon(cross);
					b[8].setEnabled(false);
				}
				else
				{
					b[8].setIcon(zero);
					b[8].setEnabled(false);
				}
				i++;
				System.out.println(i);
				if(i>=5)
				{
					checkPattern();								
				}
			}
			else
			{
				b[8].setIcon(cross);
				b[8].setEnabled(false);
				System.out.println("Button clicked: 9");
				
				array_cross[cross_count++]=9;
				if(cross_count>1)
				{
					array_cross=arrayArrange(array_cross,cross_count);
				}
				
				array_remaining=arrayRemaining(9);
				
				array_occupied[occupied_count++]=9;
				
				i1++;
				checkPattern();
				System.out.println(i1);
				
				if(i1==1)
				{
				random=generateRandom();
				b[random-1].setIcon(zero);
				b[random-1].setEnabled(false);
				
				array_zero[zero_count++]=random;
				if(zero_count>1)
				{
					array_zero=arrayArrange(array_zero,zero_count);
				}
				array_remaining=arrayRemaining(random);
				array_occupied[occupied_count++]=random;
				i1++;
				}
				
				else if(i1==3)
				{
					cross_result=crossCheck();
					if(cross_result==-1)
					{
						random=generateRandom();
						b[random-1].setIcon(zero);
						b[random-1].setEnabled(false);
				
						array_zero[zero_count++]=random;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(random);
						array_occupied[occupied_count++]=random;
					}
					else
					{
						b[cross_result-1].setIcon(zero);
						b[cross_result-1].setEnabled(false);
						
						array_zero[zero_count++]=cross_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(cross_result);
						array_occupied[occupied_count++]=cross_result;
					}
					i1++;				
				}
				else
				{
					zero_result=zeroCheck();
					if(zero_result!=-1)
					{
						b[zero_result-1].setIcon(zero);
						b[zero_result-1].setEnabled(false);
						
						array_zero[zero_count++]=zero_result;
						if(zero_count>1)
						{
							array_zero=arrayArrange(array_zero,zero_count);
						}
						array_remaining=arrayRemaining(zero_result);
						array_occupied[occupied_count++]=zero_result;
						//checkPattern();
					}
					else
					{
						cross_result=crossCheck();
						if(cross_result==-1)
						{
							random=generateRandom();
							b[random-1].setIcon(zero);
							b[random-1].setEnabled(false);
				
							array_zero[zero_count++]=random;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(random);
							array_occupied[occupied_count++]=random;
							//checkPattern();
						}
						else
						{
							b[cross_result-1].setIcon(zero);
							b[cross_result-1].setEnabled(false);
						
							array_zero[zero_count++]=cross_result;
							if(zero_count>1)
							{
								array_zero=arrayArrange(array_zero,zero_count);
							}
							array_remaining=arrayRemaining(cross_result);
							array_occupied[occupied_count++]=cross_result;
							//checkPattern();
						}
						
					}
					i1++;	
					checkPattern();
					if(i1==8)
					{
						int w=array_remaining[0];
						b[w-1].setEnabled(false);
					}
					
				}
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		if(e.getActionCommand().equals("New Game"))
		{
			f.dispose();
			new TicTacToe("TicTacToe");
		}
	}
	public int zeroCheck()
	{
		int temp_zero[]=new int[zero_count+1];
		int temp_zero1[]=new int[zero_count+1];
		int temp_len=zero_count;
		int res,flag=0,position=-1;
		for(int i=0;i<zero_count;i++)
		{
			temp_zero[i]=array_zero[i];
		}
		for(int i=0;i<remaining_count;i++)
		{
			temp_zero[temp_len]=array_remaining[i];
			for(int j=0;j<(temp_len+1);j++)
			{
				temp_zero1[j]=temp_zero[j];
			}
			temp_zero1=arrayArrange(temp_zero1,temp_len+1);
			res=checkPattern1(temp_zero1,temp_len+1);
			if(res!=-1)
			{
				position=i;
				System.out.println("Position after zeroCheck"+position);
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println("In function crossCheck() and value returned: "+array_remaining[position]);
			return array_remaining[position];
		}
		else
		{
			System.out.println("In function crossCheck() and value returned: -1");
			return -1;
		}
	}
	public int crossCheck()
	{
		
		int temp_cross[]=new int[cross_count+1];
		int temp_cross1[]=new int[cross_count+1];
		int temp_len=cross_count;
		int res,flag=0,position=-1;
		for(int i=0;i<cross_count;i++)
		{
			temp_cross[i]=array_cross[i];
		}
		for(int i=0;i<remaining_count;i++)
		{
			temp_cross[temp_len]=array_remaining[i];
			for(int j=0;j<(temp_len+1);j++)
			{
				temp_cross1[j]=temp_cross[j];
			}
			temp_cross1=arrayArrange(temp_cross1,temp_len+1);
			res=checkPattern1(temp_cross1,temp_len+1);
			if(res!=-1)
			{
				position=i;
				System.out.println("Position after crossCheck"+position);
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println("In function crossCheck() and value returned: "+array_remaining[position]);
			return array_remaining[position];
		}
		else
		{
			System.out.println("In function crossCheck() and value returned: -1");
			return -1;
		}
	}	
	
	
	public int[] arrayArrange(int[] a_arrange, int counter)
	{
		System.out.println();
		System.out.print("In function arrayArrange(): ");
		int temp;
		for(int i=0;i<counter;i++)
		{
			for(int j=0;j<(counter-1);j++)
			{
				if(a_arrange[j]>a_arrange[j+1])
				{
						temp=a_arrange[j];
						a_arrange[j]=a_arrange[j+1];
						a_arrange[j+1]=temp;
				}
			}
		}
		for(int i=0;i<counter;i++)
		{
			System.out.print(a_arrange[i]+"\t");
		}
		return a_arrange;
	}
		public int generateRandom()
	{
		System.out.println();
		random=0;
		int random1=min + (int)(Math.random() * ((max - min) + 1));
		boolean occupied_check=true;
	    int flag=0;
		while(occupied_check)
		{
			flag=0;
			for(int q=0;q<occupied_count;q++)
			{
				if(random1==array_occupied[q])
				{
					flag=1;
					random1=min + (int)(Math.random() * ((max - min) + 1));
					break;
				}
			}
			if(flag==0)
			{
				occupied_check=false;
			}
		}
	System.out.print("Entered function generateRandom: "+random1);
	return random1;
	}
	
	public int[] arrayRemaining(int used_value)
	{
		System.out.println();
		System.out.print("Entered function arrayRemaining(): ");
		int position=-1;
		int i,j;
		for(i=0;i<remaining_count;i++)
		{
			if(array_remaining[i]==used_value)
			{
				position=i;
				break;
			}
		}
		for(j=position;j<remaining_count-1;j++)
		{
			array_remaining[j]=array_remaining[j+1];
		}
		remaining_count--;
		
		for(i=0;i<remaining_count;i++)
		{
			System.out.print(array_remaining[i]+"\t");
		}
		System.out.println("Out of function arrayRemaining()");
		return array_remaining;
	}
	
	public void checkPattern()
	{
		int p_array[]=new int[5];
		int count=0,res,q,r,once=0;
		if(i%2!=0 || i1%2!=0)
		{
			for(int j=0;j<9;j++)
			{
				if(b[j].getIcon()==cross)
				{
					p_array[count++]=j+1;
				}
			}
			res=checkPattern1(p_array,count);
			if(res!=-1&& once==0)
			{
				once=1;
				while(res>0)
				{
				q=res/10;
				r=res%10;
				for(int f=0;f<9;f++)
				{
					if(f==r-1)
					b[f].setIcon(you_win);
					else
					b[f].setEnabled(false);
				}
				res=q;
				}
			p2.setEnabled(false);
			}
			
		}
		else if(i%2==0 || i1%2==0)
		{
			for(int j=0;j<9;j++)
			{
				if(b[j].getIcon()==zero)
				{
					p_array[count++]=j+1;
				}
			}
			res=checkPattern1(p_array,count);
			if(res!=-1 && once==0)
			{
				once=1;
				while(res>0)
				{
				q=res/10;
				r=res%10;
				for(int f=0;f<9;f++)
				{
					if(f==r-1)
					b[f].setIcon(you_win);
					else
					b[f].setEnabled(false);
				}
				res=q;
				}
			p2.setEnabled(false);
			}
			else
			{
				return;
			}
		}
		else
		{
		}
	}
	
	public int checkPattern1(int[]a, int count)
	{
		System.out.println("pattern1: "+count);
		int l,j,k;
		int count1=0;
		int array_pattern1[]= new int[10];
		for(l=0;l<count-2;l++)
		{
			for(j=l+1;j<count-1;j++)
			{
				for(k=j+1;k<count;k++)
				{
				array_pattern1[count1++]=((a[l]*100)+(a[j]*10)+a[k]);
				System.out.println("Pattern"+array_pattern1[count1-1]);
				}
			}
		}
		int flag=0;
		int pointer=0;
		for(l=0;l<8;l++)
		{
			for(j=0;j<count1;j++)
			{
				if(array_pattern1[j]==array_pattern[l])
				{
					flag=1;
					pointer=j;
					break;
					
				}
			}
		}
		
		if(flag==1)
		{
			return array_pattern1[pointer];
		}
		else
		System.out.println("check pattern 1 returned value: -1");
		return -1;
	}
			
	
	
	public static void main(String... s)
	{
		new TicTacToe("TicTacToe");
	}
}
		
		