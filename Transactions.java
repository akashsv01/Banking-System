
import java.io.*;
import java.time.*;
public class Transactions 
{
	public static void Deposit(int uid)throws IOException,InterruptedException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br2 = new BufferedReader(read);
		int ind = -1;
		for(int i=0;i<Variable_class.UID.length;i++)
		{
			if(Variable_class.UID[i] == uid)
			{
				ind = i;
				break;
			}
		}
		System.out.println("ENTER THE AMOUNT YOU WANT TO DEPOSIT: ");
		double add_bal = Double.parseDouble(br2.readLine());
		int existing_vars = Variable_class.transaction_arr_count[ind];
		//System.out.println("ex:"+existing_vars);
		Variable_class.transaction_arr[ind][existing_vars] = add_bal;
		Variable_class.transaction_arr_Str[ind][existing_vars] = "Deposit";
		LocalDateTime ob = LocalDateTime.now();
		Variable_class.transaction_arr_DateTime[ind][existing_vars] = ob;
		System.out.println("PREVIOUS BALANCE: Rs."+ Variable_class.curr_bal[ind]);
		Variable_class.curr_bal[ind] += add_bal;
		System.out.print("\nPROCESSING");
		for(int j = 0;j<6;j++)
		{
			System.out.print(".");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		System.out.print("DONE.\n");
		System.out.println("TRANSACTION SUCCESSFUL.\n");
		System.out.println();
		System.out.println("CURRENT BALANCE: Rs."+Variable_class.curr_bal[ind]);
		
		Variable_class.transaction_arr_count[ind]++;
	}
	public static void WithDraw(int uid)throws IOException,InterruptedException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br3 = new BufferedReader(read);
		int ind = -1;
		for(int i=0;i<Variable_class.UID.length;i++)
		{
			if(Variable_class.UID[i] == uid)
			{
				ind = i;
				break;
			}
		}
		System.out.println("CURRENT BALANCE: Rs."+ Variable_class.curr_bal[ind]);
		/*System.out.println("Enter the amount you want to Withdraw from your account:");*/
		double del_bal = 0.0;
		do
		{
			System.out.println("ENTER THE AMOUNT YOU WANT TO WITHDRAW: ");
			del_bal = Double.parseDouble(br3.readLine());
			if(del_bal <= Variable_class.curr_bal[ind])
			{
				break;
			}
			else
			{
				System.out.println("INSUFFICIENT BALANCE :( \nTRY AGAIN\n");
				continue;
			}
		}while(true);
		del_bal *= -1;
		int existing_vars = Variable_class.transaction_arr_count[ind];
		Variable_class.transaction_arr[ind][existing_vars] = del_bal;
		Variable_class.transaction_arr_Str[ind][existing_vars] = "Withdraw";
		LocalDateTime ob = LocalDateTime.now();
		Variable_class.transaction_arr_DateTime[ind][existing_vars] = ob;
		Variable_class.curr_bal[ind] += del_bal;
		System.out.print("PROCESSING...");
		for(int j = 0;j<6;j++)
		{
			System.out.print(".");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		System.out.print("DONE.\n");
		System.out.print("TRANSACTION SUCCESSFUL :)\n");
		System.out.println();
		System.out.println("NEW BALANCE: Rs."+Variable_class.curr_bal[ind]);
		Variable_class.transaction_arr_count[ind]++;
	}
}
