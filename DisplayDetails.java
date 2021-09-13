
public class DisplayDetails
{
	public static void User_Details(int uid)
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
		System.out.println("\t*****USER DETAILS*****");
		System.out.println("\n\tNAME: "+Variable_class.name_arr[ind]);
		System.out.println("\tUSERNAME: "+Variable_class.userName_arr[ind]);
		System.out.println("\tUSER ID: "+Variable_class.UID[ind]);
		System.out.println("\tPASSWORD(encrypted): "+Variable_class.password_arr[ind]);
	}
}
