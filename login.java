//Class Login

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Arrays;
import java.util.*;
import java.util.Random;
public class login 
{
	public static int Existing_user(int uid,String pass)throws IOException
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
		if(ind >= 0)
		{
			String decrypt_pass = login.Decrypt(Variable_class.password_arr[ind],Variable_class.pass_shift_arr[ind]);
			if(decrypt_pass.equals(pass))
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		else
		{
			return 3;
		}
	}
	public static void Register_user()throws IOException,InterruptedException
	{
		String BUILDERSTRING = "1234567890";
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(read);
		System.out.print("PLEASE WAIT...");
		for(int j = 0;j<4;j++)
		{
			System.out.print(".");
			Thread.sleep(1000);
		}
		System.out.println();
		System.out.println("ENTER YOUR DETAILS: \n");
		System.out.println("ENTER YOUR NAME: ");
		Variable_class.name_arr[Variable_class.arr_cnt] = br1.readLine();
		
		System.out.println("ENTER YOUR PHONE NUMBER: ");
		Variable_class.phone[Variable_class.arr_cnt] = br1.readLine();
		
		System.out.println("SELECT YOUR USERNAME: ");
		Variable_class.userName_arr[Variable_class.arr_cnt] = br1.readLine();
		
		StringBuilder builder = new StringBuilder();
		int uid_len = 6;
		while (uid_len-- != 0) 
		{
			int character = (int)(Math.random()*BUILDERSTRING.length());
			builder.append(BUILDERSTRING.charAt(character));
		}
		int uid_gen = Integer.parseInt(builder.toString());
		System.out.println("YOU USER ID IS: "+uid_gen);
		Variable_class.UID[Variable_class.arr_cnt] = uid_gen;
		
		System.out.println("ENTER YOUR PASSWORD: ");
		String user_pass = br1.readLine();
		
		Random random = new Random();
		int rand_shift = (random.nextInt(50)-25);
		//int rand_shift = 25;
		String user_pass_encrypt = login.Encrypt(user_pass,rand_shift);
		//System.out.println("create user shift:"+rand_shift);
		Variable_class.pass_shift_arr[Variable_class.arr_cnt] = rand_shift;
		Variable_class.password_arr[Variable_class.arr_cnt] = user_pass_encrypt;
		System.out.print("PLEASE WAIT WHILE WE CREATE YOUR ACCOUNT...");
		for(int j = 0;j<6;j++)
		{
			System.out.print(".");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		System.out.print("ACCOUNT CREATED SUCCESSFULLY!!\n");
		System.out.println();
		Variable_class.arr_cnt += 1;
	}
	
	public static String Encrypt(String pass,int shift)
	{
		//System.out.println("Encrypt shift :" + shift);
		String Pass_encrypt = "";
		for(int i=0;i<pass.length();i++)
		{
			char alpha = pass.charAt(i);
			if(alpha >= 'a' && alpha <= 'z')
			{
				alpha = (char)(alpha + shift);
			
				if(alpha < 'a')
				{
					alpha = (char)(alpha-'a' +'z' +1);
				}
				if(alpha > 'z')
				{
					alpha = (char)(alpha + 'a' - 'z' +1);
				}
				Pass_encrypt += alpha;
			}
			else if(alpha >= 'A' && alpha <= 'Z')
			{
				alpha = (char)(alpha + shift);
				
				if(alpha < 'A')
				{
					alpha = (char)(alpha-'a'+'z'+1);
				}
				if(alpha > 'Z')
				{
					alpha = (char)(alpha + 'A' - 'Z' +1);
				}
				Pass_encrypt += alpha;
			}
			else
			{
				Pass_encrypt += alpha;
			}
		}
		//System.out.println(Pass_encrypt);
		return Pass_encrypt;
	}

	public static String Decrypt(String pass,int shift)
	{
		//System.out.println("Decrypt shift :" + shift+ "decrypt pass: "+pass);
		String Pass_decrypt = "";
		for(int i = 0;i < pass.length();i++)
		{
			char alpha = pass.charAt(i);
			if(alpha >= 'a' && alpha <= 'z')
			{
				alpha = (char)(alpha - shift);
			
				if(alpha < 'a')
				{
					alpha = (char)(alpha - 'a' + 'z' -1);
				}
				else if(alpha > 'z')
				{
					alpha = (char)(alpha + 'a' - 'z' - 1);
				}
				Pass_decrypt += alpha;
			}
			else if(alpha >= 'A' && alpha <= 'Z')
			{
				alpha = (char)(alpha - shift);
				
				if(alpha < 'A')
				{
					alpha = (char)(alpha - 'A' + 'Z' - 1);
				}
				if(alpha > 'Z')
				{
					alpha = (char)(alpha + 'A' - 'Z' - 1);
				}
				Pass_decrypt += alpha;
			}
			else
			{
				Pass_decrypt += alpha;
			}
		}
		//System.out.println(Pass_decrypt);
		return Pass_decrypt;
	}
}