package com.atm_machine;

import java.awt.EventQueue;

public class Account {
	String accountNumber;
	int accountLine;
	
	String firstName;
	int firstNameLine;
	
	String lastName;
	int lastNameLine;
	
	int balance;
	int balanceLine;
	
	boolean accountStatus;
	int accountStatusLine;
	
	String password;
	
	
	// account number access functions
	public void setAccountNum(String a){
		this.accountNumber = a;
	}
	public String getAccountNum(){
		return accountNumber;
	}
	public void setAccountLine(int al){
		this.accountLine = al;
	}
	public int getAccountLine(){
		return accountLine;
	}
	// first name access functions
	public void setFirstName(String b){
		this.firstName = b;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstNameLine(int fl){
		this.firstNameLine = fl;
	}
	public int getFirstNameLine(){
		return firstNameLine;
	}
	// last name access functions
	public void setlastName(String c ){
		this.lastName = c;
	}
	public String getlastName(){
		return lastName;
	}
	public void setlastNameLine(int ll){
		this.lastNameLine = ll;
	}
	public int getlastNameLine(){
		return lastNameLine;
	}
	// balance access functions
	public void setBalance(int x){
		this.balance = x;
	}
	public int getBalance(){
		return balance;
	}
	public void setBalanceLine(int bl){
		this.balanceLine = bl;
	}
	public int getBalanceLine(){
		return balanceLine;
	}
	// status access functions
	public void setStatus(boolean bool){
		this.accountStatus = bool;
	}
	public boolean getStatus(){
		return accountStatus;
	}
	public void setStatusLine(int sl){
		this.accountStatusLine = sl;
	}
	public int getStatusLine(){
		return accountStatusLine;
	}
	public void setPass(String pass){
		this.password = pass;
	}
	public String getPass(){
		return password;
	}

	
}
