package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	static String customername;
	static int customerid;
	static long accnumber;
	Customer(String name,int id,long accnumber)
	{
		this.customername=name;
		this.customerid=id;
		this.accnumber=accnumber;
	}
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		List<Customer> listobj=new ArrayList();

		String customername;
		 int customerid;
		 long accnumber;
		 int n=2;
		for(int i=0;i<n;i++)
		{
			  customername=s.nextLine();
			  customerid=s.nextInt();
			  accnumber=s.nextLong();
			 Customer ob=new Customer(customername,customerid,accnumber);
				listobj.add(ob);
			}
		
	//	ArrayList<Integer> arraylistobj=new ArrayList<Integer>();
		
		for(Customer sam:listobj)
		{
			System.out.println("customername:"+sam.customername+" "+"customerid:"+sam.customerid+" "+"customeraccno:"+sam.accnumber);
		}
	}

}
