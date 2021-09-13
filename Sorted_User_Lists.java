
import java.util.*;
public class Sorted_User_Lists 
{
	String Name;
	int UID;
	double Bal;
	Sorted_User_Lists(String name,int Uid1,double bal)
	{
		Name = name;
		UID = Uid1;
		Bal = bal;
	}
	public String toString()
	{
		return UID + "  \t  " + Name + "  \t  " + Bal+"\n";
	}
}
class Sort_Bal implements Comparator<Sorted_User_Lists>
{
	public int compare(Sorted_User_Lists a, Sorted_User_Lists b)
	{
		double a1,b1;
		a1 = a.Bal;
		b1 = b.Bal;
		if(a1>b1)
			return 1;
		else
			return -1;
	}
	
}
class Sort_Name implements Comparator<Sorted_User_Lists>
{
	public int compare(Sorted_User_Lists a, Sorted_User_Lists b)
	{
		String a1,b1;
		a1 = a.Name;
		b1 = b.Name;
		if(a1.compareTo(b1) > 0)
			return 1;
		else
			return -1;
	}
	
}
class Sorted_Lists
{
	public static void main(String args[])throws NullPointerException
	{
		TreeSet<Sorted_User_Lists> ts1 = new TreeSet<Sorted_User_Lists>(new Sort_Bal());
		TreeSet<Sorted_User_Lists> ts2 = new TreeSet<Sorted_User_Lists>(new Sort_Name());
		int Set_choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\tON WHAT BASIS DO YOU WANT TO SEE THE DETAILS:");
		System.out.println("\t1.ALPHABETICAL ORDER\n\t2.BALANCE");
		Set_choice = sc.nextInt();
		switch(Set_choice)
		{
		case 1:
			for(int i = 0;i<Variable_class.arr_cnt;i++)
			{
				Sorted_User_Lists ob = new Sorted_User_Lists(Variable_class.name_arr[i],Variable_class.UID[i],Variable_class.curr_bal[i]);
				ts2.add(ob);
			}
			System.out.println("\nUSERID\tNAME\tBALANCE");
			for(Sorted_User_Lists o : ts2)
			{
				System.out.print(o);
			}
			break;
		case 2:
			for(int i = 0;i<Variable_class.arr_cnt;i++)
			{
				Sorted_User_Lists ob = new Sorted_User_Lists(Variable_class.name_arr[i],Variable_class.UID[i],Variable_class.curr_bal[i]);
				ts1.add(ob);
			}
			System.out.println("\nUSERID\tNAME\tBALANCE");
			for(Sorted_User_Lists o : ts1)
			{
				System.out.print(o);
			}
			break;
		default:
			System.out.println("WRONG CHOICE!!");
			break;
		}
	}
}