package verify;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

import model.CustomerDetails1;
class NameAlreadyExistsException extends Exception{
	public NameAlreadyExistsException(String s)
	{
		super(s);
}
}
public class Verify1 {
	String name1;
	long phno;
	String address1;
	long accno;
	Verify1(String name1,long phno,String address1,long accno)
	{
		this.name1=name1;
		this.phno=phno;
		this.address1=address1;
		this.accno=accno;
	}
	
public static void main(String[] args) throws NameAlreadyExistsException,ConcurrentModificationException{
	
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER NUMBER OF CUSTOMERS :");
		n=sc.nextInt();
		List<CustomerDetails1> details=new ArrayList<CustomerDetails1>();
		for(int i=0;i<n;i++) {
		System.out.println("enter CUSTOMER Name :");
		String name=sc.next();
		System.out.println("enter CUSTOMER PhoneNo :");
		long phoneNo=sc.nextLong();
		System.out.println("enter CUSTOMER Address :");
		String address=sc.next();
		System.out.println("enter CUSTOMER AccountNo :");
		long accountNo=sc.nextLong();
		CustomerDetails1 customer=new CustomerDetails1(name,phoneNo,address,accountNo);	
		details.add(customer);

		}
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter name of customer ::");
		String name1=sc1.nextLine();
		System.out.println("enter phno of customer");
		long phno=sc1.nextLong();
		
		
		System.out.println("enter address of customer");
		
		
		String address1=sc1.next();
		System.out.println("enter accno of customer");
		long accno=sc1.nextLong();
		Verify1 obj=new Verify1(name1,phno,address1,accno);
		try {
		
		CustomerDetails1 customer=new CustomerDetails1(name1,phno,address1,accno);	

		List<Verify1> verify=new ArrayList<Verify1>();
		
		for(CustomerDetails1 info:details)
		{
			if(!(info.accountNo==obj.accno && (info.name).equals(obj.name1)))
		{
				details.add(customer);				
		}
			else throw new NameAlreadyExistsException("this name alreaady exists");
			{
				
			}
		}

		for(CustomerDetails1 info: details) {
			System.out.println("NAME :"+info.name+"\t"+"PHONE_NUM :"+info.phoneNo+"\t"+"ADDRESS :"+info.address+"\t"+"ACCNO :"+info.accountNo);
			
		}
		}
		catch(ConcurrentModificationException e)
		{
			System.out.println(e);
		}
	}

}
