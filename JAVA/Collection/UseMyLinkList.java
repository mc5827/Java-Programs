import java.io.*;
class UseMyLinkList
{
	MyLinkedList mll=new MyLinkedList();
	public void mainMenu() throws IOException
	{
		//clearScrean();
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Display");
		System.out.println("4. Exit");
		System.out.println("Enter the choice: ");
		DataInputStream dis=new DataInputStream(System.in);
		Scanner sc=new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: addMenu(); break;
		case 2: //removeMenu(); break;
		case 3: mll.display();break;
		case 4: System.exit(0);
		default: System.out.println("Invalid Key");
		}
	}
	
	public void addMenu() throws IOException
	{
		//clearScreen();
		System.out.println("1. Front");
		System.out.println("2. Rear");
		System.out.println("3. Back");
		DataInputStream dis=new DataInputStream(System.in);
		int choice = dis.readInt();
		
		switch(choice)
		{
		case 1: DataInputStream dis1=new DataInputStream(System.in);
				String value=dis1.readLine();
				mll.addFirst(value);
				break;
		case 2: DataInputStream dis2=new DataInputStream(System.in);
				String value1=dis2.readLine();
				mll.addLast(value1);
				break;
		case 3: mainMenu();break;
		default: System.out.println("Invalid Key");
		}
	}
	
	public static void main(String... s) throws IOException
	{
	UseMyLinkList umll=	new UseMyLinkList();
	umll.mainMenu();
	}
}