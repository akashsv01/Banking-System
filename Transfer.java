
import java.io.*;
import java.time.*;
public class Transfer 
{
	public static void TransferAmount(int giver_id)throws IOException,InterruptedException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br3 = new BufferedReader(read);
		int giver_ind = -1;
		for(int i=0;i<Variable_class.UID.length;i++)
		{
			if(Variable_class.UID[i] == giver_id)
			{
				giver_ind = i;
				break;
			}
		}
		int rec_ind = -1;
		do
		{
			int rec_id;
			System.out.println("ENTER THE USER ID TO WHICH YOU WANT TO TRANSFER TO: ");
			rec_id = Integer.parseInt(br3.readLine());
			int ind1 = -1;
			for(int i=0;i<Variable_class.UID.length;i++)
			{
				if(Variable_class.UID[i] == rec_id)
				{
					ind1 = i;
					break;
				}
			}
			if(ind1 >= 0)
			{
				rec_ind = ind1;
				break;
			}
			else
			{
				System.out.println("\tUSER ID NOT FOUND :(\n\tDO YOU WANT TO TRY AGAIN?\n\t1.YES\t2.NO");
				int ch = Integer.parseInt(br3.readLine());
				if(ch == 1)
				{
					continue;
				}
				else
					break;
			}
			
		}while(true);
		if(rec_ind >=0)
		{
			System.out.println("CURRENT BALANCE: Rs."+ Variable_class.curr_bal[giver_ind]);
			double tran_amt = 0;
			do
			{
				System.out.println("ENTER THE AMOUNT YOU WANT TO TRANSFER: ");
				tran_amt = Double.parseDouble(br3.readLine());
				if(tran_amt <= Variable_class.curr_bal[giver_ind])
				{
					break;
				}
				else
				{
					System.out.println("INSUFFICIENT BALANCE :(\nTRY AGAIN");
					continue;
				}
			}while(true);
			int existing_vars = Variable_class.transaction_arr_count[giver_ind];
			Variable_class.transaction_arr[giver_ind][existing_vars] = (-1)*tran_amt;
			Variable_class.transaction_arr_Str[giver_ind][existing_vars] = "TRANSFERRED Rs."+tran_amt+" TO USER: "+Variable_class.UID[rec_ind];
			LocalDateTime ob = LocalDateTime.now();
			Variable_class.transaction_arr_DateTime[giver_ind][existing_vars] = ob;
			Variable_class.curr_bal[giver_ind] += (-1)*tran_amt;
			Variable_class.transaction_arr_count[giver_ind]++;
			
			int existing_vars1 = Variable_class.transaction_arr_count[rec_ind];
			Variable_class.transaction_arr[rec_ind][existing_vars1] = tran_amt;
			Variable_class.transaction_arr_Str[rec_ind][existing_vars1] = "RECEIVED Rs."+tran_amt+" FROM USER: "+Variable_class.UID[giver_ind];
			//LocalDateTime ob = LocalDateTime.now();
			Variable_class.transaction_arr_DateTime[rec_ind][existing_vars1] = ob;
			Variable_class.curr_bal[rec_ind] += tran_amt;
			Variable_class.transaction_arr_count[rec_ind]++;
			System.out.print("\nPROCESSING");
			for(int j = 0;j<8;j++)
			{
				System.out.print(".");
				Thread.sleep(1000);
			}
			System.out.print("DONE.\n");
			Thread.sleep(1000);
			System.out.print("TRANSACTION SUCCESSFUL :)\n");
		}
		
	}
}
