//Class Banking_main

import java.time.*;
import java.util.*;
import java.io.*;
final class Variable_class implements Serializable
{
	static int runs = 0;
	static String name_arr[] = new String[20];
	static String phone[] = new String[20];
	static String userName_arr[] = new String[20];
	static int UID[] = new int[20];
	static int pass_shift_arr[] = new int[20];
	static String password_arr[] = new String[20];
	static int arr_cnt = 0;
	static double transaction_arr[][] = new double[20][100];
	static int transaction_arr_count[]  = new int[20];
	static LocalDateTime transaction_arr_DateTime[][] = new LocalDateTime[20][100];
	static String transaction_arr_Str[][] = new String[20][100];
	static double curr_bal[] = new double[20];
}


public class Banking_main implements Serializable
{
	static void init_var()throws ClassNotFoundException,FileNotFoundException,IOException
	{
		BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\pc\\Desktop\\BANKING_DATA.txt"));
		Variable_class.runs = Integer.parseInt(read.readLine());
		System.out.println("runs : " + Variable_class.runs);
		if(Variable_class.runs == 0)
			return;
		String nameString = read.readLine();
		StringTokenizer tok = new StringTokenizer(nameString,";");
		int i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.name_arr[i] = tok.nextToken();
			i++;
		}
		String phoneString = read.readLine();
		tok = new StringTokenizer(phoneString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.phone[i] = tok.nextToken();
			i++;
		}
		String unameString = read.readLine();
		tok = new StringTokenizer(unameString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.userName_arr[i] = tok.nextToken();
			i++;
		}
		String uidString = read.readLine();
		tok = new StringTokenizer(uidString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.UID[i] = Integer.parseInt(tok.nextToken());
			i++;
		}
		String shiftString = read.readLine();
		tok = new StringTokenizer(shiftString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.pass_shift_arr[i] = Integer.parseInt(tok.nextToken());
			i++;
		}
		String passString = read.readLine();
		tok = new StringTokenizer(passString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.password_arr[i] = tok.nextToken();
			i++;
		}
		String arrcnt = read.readLine();
		StringTokenizer st = new StringTokenizer(arrcnt,";");
		Variable_class.arr_cnt = Integer.parseInt(st.nextToken());
		for(int j = 0 ; j < 20 ; j++)
		{
			String row_String = read.readLine();
			int k = 0;
			tok = new StringTokenizer(row_String,";");
			while(tok.hasMoreTokens())
			{
				Variable_class.transaction_arr[j][k] = Double.parseDouble(tok.nextToken());
				k++;
			}
		}
		
		String tranArrcountString = read.readLine();
		tok = new StringTokenizer(tranArrcountString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.transaction_arr_count[i] = Integer.parseInt(tok.nextToken());
			i++;
		}
		//-------------------------------------------
		//System.out.println(Variable_class.transaction_arr_count[0]);
		//-------------------------------------------
		for(int j = 0; j < Variable_class.arr_cnt ; j++)
		{
			String row_String = read.readLine();
			int k = 0;
			tok = new StringTokenizer(row_String,";");
			while(tok.hasMoreTokens() && k < Variable_class.transaction_arr_count[j])
			{
				Variable_class.transaction_arr_DateTime[j][k] = LocalDateTime.parse(tok.nextToken());
				k++;
			}
		}
		
		int rem = 20-Variable_class.arr_cnt;
		String garbageString;
		for(int l = 1;l<=rem;l++)
			garbageString = read.readLine();
		
		System.out.println(Variable_class.transaction_arr_DateTime[19][0]);
		
		for(int j = 0 ; j < 20 ;j++)
		{
			String row_String = read.readLine();
			int k = 0;
			tok = new StringTokenizer(row_String,";");
			while(tok.hasMoreTokens() && k < Variable_class.transaction_arr_count[j])
			{
				Variable_class.transaction_arr_Str[j][k] = tok.nextToken();
				k++;
			}
		}
		String currbalString = read.readLine();
		
		System.out.println(currbalString);
		
		tok = new StringTokenizer(currbalString,";");
		i = 0;
		while(tok.hasMoreTokens())
		{
			Variable_class.curr_bal[i] = Double.parseDouble(tok.nextToken());
			i++;
		}
		read.close();
	}
	static void debug()
	{
		for(int i = 0;i<20;i++)
		{
			//System.out.print(Variable_class.name_arr[i] + '\t');
			//System.out.print(Variable_class.UID[i] + '\t');
			//System.out.print(Variable_class.password_arr[i]+'\n');
			//System.out.println(Variable_class.transaction_arr[i]);
		}
	}
	public static void main(String args[])throws IOException, InterruptedException, ClassNotFoundException
	{
		Banking_main.init_var();
		Banking_main.debug();
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(read);
		int login_var;
		do
		{
			System.out.println("\n\t*****YES BANK******\n");
			System.out.println("\t1.LOGIN\n\t2.REGISTER\n\t3.EXIT");
			login_var = Integer.parseInt(br.readLine());
			if(login_var == 1) 
			{
				int login_conf;
				System.out.println("ENTER YOUR DETAILS: ");
				System.out.println("USER ID: ");
				int user_id = Integer.parseInt(br.readLine());
				System.out.println("PASSWORD: ");
				String password = br.readLine();
				
				login_conf = login.Existing_user(user_id,password);//day1
				System.out.print("AUTHENTICATING..");
				for(int j = 0;j<4;j++)
				{
					System.out.print(".");
					Thread.sleep(1000);
				}
				Thread.sleep(500);
				System.out.print("DONE!!\n");
				if(login_conf == 1)
				{
					System.out.println("\nLOGIN SUCCESSFUL!!\n");
					System.out.print("GETTING STARTED");
					for(int j = 0;j<7;j++)
					{
						System.out.print(".");
						Thread.sleep(1000);
					}
					Thread.sleep(500);
					System.out.print("DONE!!\n");
					int check_ctr = 1;
					do
					{
						int switch_var;
						System.out.println("\n\tAVAILABLE OPTIONS IN OUR BANKING SYSTEMS:\n");
						System.out.println("\t1.DEPOSIT\n\t2.WITHDRAW\n\t3.TRANSFER TO ANOTHER USER\n\t4."
								+ "DISPLAY USER DETAILS\n\t5.DISPLAY TRANSACTION DETAILS\n\t6.DISPLAY CUSTOMER LIST\n\t7.LOG OUT");
						switch_var = Integer.parseInt(br.readLine());
						switch(switch_var)
						{
						case 1:
							//Implementing deposit Module;
							Transactions.Deposit(user_id);
							break;
						case 2:
							//Implementing withdraw module;
							Transactions.WithDraw(user_id);
							break;
						case 3:
							//Implementing transfer module;
							Transfer.TransferAmount(user_id);
							break;
						case 4:
							//Implementing user details display module;
							DisplayDetails.User_Details(user_id);
							break;
						case 5:
							//Implementing transaction details display module;
							DisplayTransactionDetails.Transaction_Details(user_id);
							break;
						case 6:
							Sorted_Lists.main(args);
							break;
						case 7:
							System.out.print("LOGGING OUT..");
							for(int j = 0;j<10;j++)
							{
								System.out.print(".");
								Thread.sleep(1000);
							}
							Thread.sleep(2000);
							System.out.print("DONE!!\n");
							System.out.println("THANK YOU FOR USING OUR SERVICES.\nLOOKING FORWARD TO HELP YOU :)");
							check_ctr = 0;
							break;
						}
					}while(check_ctr > 0);
				}
				else if(login_conf == 2)
				{
					System.out.println("INCORRECT PASSWORD :( \nPLEASE TRY AGAIN \n");
					continue;
				}
				else if(login_conf == 3)
				{
					System.out.println("USER ACCOUNT DOES NOT EXIST :(");
					int reg_conf;
					System.out.println("DO YOU WANT TO CREATE A NEW ACCOUNT?\n1.YES\t2.NO");
					reg_conf = Integer.parseInt(br.readLine());
					if(reg_conf == 1)
					{
						login.Register_user();
					}
					else
					{
						System.out.println("THANK YOU FOR USING OUR SERVICES.\nLOOKING FORWARD TO HELP YOU :)\n");
						
					}
				}
			}
			else if(login_var == 2)
			{
				System.out.println("HI , WELCOME TO YES BANK :)\n");
				login.Register_user();
				System.out.println();
			}
			else
			{
	
				System.out.println("THANK YOU!!");
				Variable_class.runs++;
				BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\pc\\Desktop\\BANKING_DATA.txt"));
				out.write(Integer.toString(Variable_class.runs));
				out.newLine();
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.name_arr[i]+";");
				}
				out.newLine();
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.phone[i]+";");
				}
				out.newLine();
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.userName_arr[i]+";");
				}
				out.newLine();
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.UID[i]+";");
				}
				out.newLine();
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.pass_shift_arr[i]+";");
				}
				out.newLine();
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.password_arr[i]+";");
				}
				out.newLine();
				out.write(Variable_class.arr_cnt+";");
				out.newLine();
				for(int i =0;i<20;i++)
				{
					for(int j = 0;j<100;j++) 
					{
						out.write(Variable_class.transaction_arr[i][j] + ";");
					}
					out.newLine();
				}
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.transaction_arr_count[i]+";");
				}
				out.newLine();
				for(int i =0;i<20;i++)
				{
					for(int j = 0;j<100;j++) 
					{
						out.write(Variable_class.transaction_arr_DateTime[i][j] + ";");
					}
					out.newLine();
				}
				for(int i =0;i<20;i++)
				{
					for(int j = 0;j<100;j++) 
					{
						out.write(Variable_class.transaction_arr_Str[i][j] + ";");
					}
					out.newLine();
				}
				for(int i = 0;i<20;i++)
				{
					out.write(Variable_class.curr_bal[i]+";");
				}
				//out.newLine();
				out.close();
				System.exit(0);
			}
		}while(true);
	}
	
}
