
import java.io.*;
public class DisplayTransactionDetails extends DisplayDetails 
{
	public static void Transaction_Details(int uid)throws IOException,InterruptedException
	{
		int ind = -1;
		for(int i=0;i<Variable_class.UID.length;i++)
		{
			if(Variable_class.UID[i] == uid)
			{
				ind = i;
				break;
			}
		}
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br4 = new BufferedReader(read);
		DisplayDetails.User_Details(uid);
		int ctr_var = 0;
		do
		{
			System.out.println("\n\tWHICH DETAILS DO YOU WANT TO KNOW?\n");
			System.out.println("\t1.CURRENT BALANCE\n\t2.PREVIOUS TRANSACTION\n\t3.TRANSACTION HISTORY\n\t4.EXIT");
			int tra_var = Integer.parseInt(br4.readLine());
			if(tra_var == 1 || tra_var == 2 || tra_var == 3)
			{
				System.out.print("RETRIEVING INFORMATION...");
				for(int j = 0;j<6;j++)
				{
					System.out.print(".");
					Thread.sleep(1000);
				}
				Thread.sleep(1000);
				System.out.print("DONE.\n");
				System.out.println();
			}
			switch(tra_var)
			{
			case 1:
				System.out.println("CURRENT BALANCE: Rs."+Variable_class.curr_bal[ind]);
				break;
			case 2:
				int cnt = Variable_class.transaction_arr_count[ind] - 1;
				String str = Variable_class.transaction_arr_Str[ind][cnt];
				if(str.contains("Deposit"))
				{
					System.out.println("DEPOSITED Rs."+Variable_class.transaction_arr[ind][cnt]+"\tTRANSACTION DATE AND TIME: "+Variable_class.transaction_arr_DateTime[ind][cnt]);
				}
				else if(str.contains("Withdraw"))
				{
					System.out.println("WITHDREW Rs."+Variable_class.transaction_arr[ind][cnt]+"\tTRANSACTION DATE AND TIME: "+Variable_class.transaction_arr_DateTime[ind][cnt]);
				}
				else
				{
					System.out.println(Variable_class.transaction_arr_Str[ind][cnt]+"\tDate and time: "+Variable_class.transaction_arr_DateTime[ind][cnt]);
				}
				break;
			case 3:
				int count = Variable_class.transaction_arr_count[ind];
				System.out.println("TRANSACTION HISTORY: \n");
				for(int i = 0;i < count;i++)
				{
					String str2 = Variable_class.transaction_arr_Str[ind][i];
					if(str2.contains("Deposit"))
					{
						System.out.println("DEPOSITED Rs."+Variable_class.transaction_arr[ind][i]+"\tTRANSACTION DATE AND TIME: "+Variable_class.transaction_arr_DateTime[ind][i]);
					}
					else if(str2.contains("Withdraw"))
					{
						System.out.println("WITHDREW Rs."+(-1)*Variable_class.transaction_arr[ind][i]+"\tTRANSACTION DATE AND TIME: "+Variable_class.transaction_arr_DateTime[ind][i]);
					}
					else
					{
						System.out.println(Variable_class.transaction_arr_Str[ind][i]+"\tTRANSACTION DATE AND TIME: "+Variable_class.transaction_arr_DateTime[ind][i]);
					}
				}
				break;
			case 4:
				ctr_var = 1;
				break;
			}
		}while(ctr_var == 0);
	}
}
