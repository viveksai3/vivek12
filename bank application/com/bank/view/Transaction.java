package com.bank.view;

import java.util.Scanner;

public class Transaction extends Bank{
	private static double balance=0;
	static Scanner sc=new Scanner(System.in);
	
	public static void select() {
		
		start:
			while(true) {	
				System.out.println("Enter choice :\n1)Debit\n2)Deposit\n3)Exit");
				int ch=sc.nextInt();		
				switch(ch) {
				case 1:debit();
					break;
				case 2:deposit();
					break;
				case 3:exit();
					break start;
			}
		}
		System.out.println("Thank You for Banking with us");
	}
	
	public static void debit() {
		System.out.println("Enter amount to withdraw :");
		double amount=sc.nextDouble();
		if(amount<=balance) {
			balance=balance-amount;
			System.out.println("Amount debited.\nAvailable balance is :"+balance);
		}
		else
			System.out.println("Insufficient funds");
	}
	
	public static boolean exit() {
		return false;
	}
	
	public static void deposit() {
		System.out.println("Enter amount to deposit :");
		double amount=sc.nextDouble();
		balance=balance+amount;
		System.out.println("Amount deposited.\nAvailable balance is :"+balance);
	}
	
}
