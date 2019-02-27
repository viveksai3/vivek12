package model;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerDetails {
	String name,address;
	long phoneNo,accountNo;
	
	public CustomerDetails(String name,long phoneNo,String address,long accountNo) {
		this.name=name;
		this.phoneNo=phoneNo;
		this.address=address;
		this.accountNo=accountNo;
	}
	
	public static void main(String[] args){
		String name,address;
		long phoneNo,accountNo;
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of customers :");
		n=sc.nextInt();
		List<CustomerDetails> details=new ArrayList<CustomerDetails>();
		
		for(int i=0;i<n;i++) {
		System.out.println("Name :");
		name=sc.next();
		System.out.println("PhoneNo :");
		phoneNo=sc.nextLong();
		System.out.println("Address :");
		address=sc.next();
		System.out.println("AccountNo :");
		accountNo=sc.nextLong();
		
		
		CustomerDetails customer=new CustomerDetails(name,phoneNo,address,accountNo);
			
		details.add(customer);
		}
		for(CustomerDetails obj: details) {
			System.out.println("Name :"+obj.name+"\t\t"+"Phone :"+obj.phoneNo+"\t\t"+"Address :"+obj.address+"\t\t"+"AccountNo :"+obj.accountNo);
		}
		sc.close();
	}
	
}

