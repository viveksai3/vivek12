package ecommerce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;
 class InvalidPasswordException extends Exception{
	public InvalidPasswordException(String s)
	{
		super(s);
	}
}

public class Ecommerce {

	static private String password;
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Registration> arrayobject=new ArrayList<Registration>();
	
	public static void registration() throws Exception {
		Registration customer=new Registration();
		System.out.println("Enter firstname :");
		customer.setFirstName(sc.next());
		System.out.println("Enter lastname :");
		customer.setLastName(sc.next());
		System.out.println("Enter Address :");
		customer.setAddress(sc.next());
		System.out.println("Enter phoneNo :");
		customer.setPhoneNo(sc.nextLong());
		System.out.println("Enter Password :");
		customer.setPassword(sc.next());
		Random account=new Random();
		customer.setregNo(account.nextInt(999999999));
		arrayobject.add(customer);
		
		System.out.println("Your registration number is :" +customer.getregNo());
		serializeArray();
		login();
	}
	
	public static void serializeArray() {
		 try {
				FileOutputStream file=new FileOutputStream("D:\\Bank\\ecommerce.txt");
				ObjectOutputStream object=new ObjectOutputStream(file);
				object.writeObject(arrayobject);
				object.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	static  ArrayList<Registration> deserialiseArray() throws Exception {
		
		
		 FileInputStream file = new FileInputStream("D:\\Bank\\ecommerce.txt");
		 ObjectInputStream object1=new ObjectInputStream(file);
		 ArrayList<Registration> arrayobject=(ArrayList<Registration>)object1.readObject();
		return arrayobject; 
	 }
	
	public static void login() throws Exception {
		
	//	Registration customer=new Registration();
		System.out.println("Enter your registration number :");
		long registrationNo=sc.nextLong();
		String password;
		System.out.println("Enter Your Password");
		password=sc.next();
		
			for(Registration reg : deserialiseArray()) {
				if(reg.getregNo()==registrationNo) {
					if(reg.getPassword().equals(password)) {
						//Transactions obj=new Transactions();
						category();
						break;
					}
					else  throw new InvalidPasswordException("entered credentials are wrong");

						
				}
			 }
		} 
	
	private static void category() {
		System.out.println("enter category :\n1)Male\n2)Female\n3)Child");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1: shopping();
				break;
		case 2: shopping();
				break;
		case 3: shopping();
				break;
		}
		
	}

	private static void shopping() {
		System.out.println("select your choice :\n1)Fashion(clothes,shoes,bags)\n2)Home and kitchen\n3)Electronics");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:fashion();
			break;
		case 2:homeNKitchen();
			break;
		case 3:electronics();
			break;
		}
		
	}

	private static void electronics() {
		System.out.println("Enter your choice :\n1)Television\n2)refrigerator");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:	television();
				break;
		case 2: refrigerator();		
				break;
		}
	}

	private static void homeNKitchen() {
		System.out.println("Enter your choice :\n1)airconditioner\n2)chimney");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:	airconditioner();
				break;
		case 2: chimney();
				break;
		}
		
	}

	private static void airconditioner() {
		String name="VOLTAS airconditioner";
		long price=40000;
		long itemno=5;
		System.out.println("name:"+" "+name+" "+"price:"+" "+price+" "+"itemno :"+itemno);
	}

	private static void chimney() {
		String name="ELICA chimney";
		long price=35000;
		long itemno=6;
		System.out.println("name:"+" "+name+" "+"price:"+" "+price+" "+"itemno :"+itemno);
		
	}

	private static void refrigerator() {
		String name="SAMSUNG refrigerator";
		long price=25000;
		long itemno=3;
		System.out.println("name:"+" "+name+" "+"price:"+" "+price+" "+"itemno :"+itemno);
		
	}

	private static void television() {
		String name="SONY television";
		long price=50000;
		long itemno=4;
		System.out.println("name:"+" "+name+" "+"price:"+" "+price+" "+"itemno :"+itemno);
		
	}

	private static void fashion() {
		System.out.println("Enter your choice :\n1)clothes\n2)bags");
		int ch=sc.nextInt();
		switch(ch) {
		case 1: clothes();
				break;
		case 2: bags();
				break;
		}
		
	}

	private static void bags() {
		String name="VIP bag";
		long price=3000;
		long itemno=2;
		System.out.println("name:"+" "+name+" "+"price:"+" "+price+" "+"itemno :"+itemno);
		
	}

	private static void clothes() {
		String name="USPA shirt";
		long price=2000;
		long itemno=1;
		System.out.println("name:"+" "+name+" "+"price:"+" "+price+" "+"itemno :"+itemno);
		
	}

	static void select() throws Exception {
		
		System.out.println("Enter choice :\n1)Registration\n2)Login");
		int ch=sc.nextInt();
		switch(ch) {
		case 1: registration();
				break;
		case 2: login();
				break;
		
		}
	}
	public static void main(String[] args) throws Exception {
		select();
	}
	
}
