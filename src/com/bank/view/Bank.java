package com.bank.view;
import com.bank.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

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
		System.out.println("Enter Aadhar :");
		customer.setAadharNo(sc.nextLong());
		System.out.println("Enter Password :");
		customer.setPassword(sc.next());
		Random account=new Random();
		customer.setAccountNo(account.nextInt(999999999));
		arrayobject.add(customer);
		System.out.println("Your account number is :" +customer.getAccountNo());
		serializeArray();
		login();
	}
	
	public static void serializeArray() {
		 try {
				FileOutputStream file=new FileOutputStream("D:\\Bank\\application.txt");
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
		
		
		 FileInputStream file = new FileInputStream("D:\\Bank\\application.txt");
		 ObjectInputStream object1=new ObjectInputStream(file);
		 ArrayList<Registration> arrayobject=(ArrayList<Registration>)object1.readObject();
		return arrayobject; 
	 }
	
	public static void login() throws Exception {
		
		Registration customer=new Registration();
		System.out.println("Enter your account no :");
		long acntNo=sc.nextLong();
		String password;
		System.out.println("Enter Your Password");
		password=sc.next();
		for(Registration reg : deserialiseArray()) {
			if(reg.getAccountNo()==acntNo) {
				if(reg.getPassword().equals(password)) {
					//Transactions obj=new Transactions();
					Transaction.select();
					break;
				}
			}
			 else
				 System.out.println("Invalid credentials");
		 }
		
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
