package com.atm_machine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ATM extends JFrame {

	private JPanel contentPane;
	private JButton btnBalance;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	// N holds the first line which tells us the number of accounts we will have
	int N;
	int k;
	// create array of objects so each account in text file is a object
	Account [] acc;
	String file = "AccountInformation.txt";
	BufferedReader buffer = null;
	String line = "";
	Scanner scan = new Scanner(System.in);
	String accNum;
	String pass;
	int lineNumber;
	// int l keeps track of which line each variable is located in AccountInformation.txt
	// using set function we assign l for each variable for every object
	int l = 0;
	String accountfileName = "AccountInformation.txt"; 
	private JButton btnTransfer;
	private JButton btnChangePass;
	private JButton btnLogOff;
	
	
	public ATM(String a, String b, int line_number) {
		setTitle("ATM");
		/////////////////////////////////
		//read file info into class array
		/////////////////////////////////
		accNum = a;
		pass = b;
		lineNumber = line_number;
	
		
		try{
		buffer = new BufferedReader(new FileReader(file));
		line = buffer.readLine(); // this is line 1 that tells how many objects to make
		//System.out.println(line+"  this is number of accounts total");
		l++;
		N = Integer.parseInt(line); // convert string to int
		System.out.println("total number of objects "+ N);
		System.out.println("the value for i passed from login is "+lineNumber);
	
		System.out.println("the line number in pass file"+lineNumber);
		acc = new Account[N];
		// for loop to enter in information from text file
		for(int i=0; i<N; i++){
			
			acc[i] = new Account(); 
			acc[i].setAccountNum(line = buffer.readLine()); // this is going to be line 2 in the file
			l++;
			acc[i].setAccountLine(l);
			System.out.println(acc[i].getAccountNum());
			
			acc[i].setFirstName(line = buffer.readLine());
			l++;
			acc[i].setFirstNameLine(l);
			System.out.println(acc[i].getFirstName());
			
			acc[i].setlastName(line = buffer.readLine());
			l++;
			acc[i].setlastNameLine(l);
			System.out.println(acc[i].getlastName());
			
			line = buffer.readLine();
			l++;
			acc[i].setBalanceLine(l);
			k = Integer.parseInt(line); // turn string into int
			acc[i].setBalance(k);
			System.out.println(acc[i].getBalance());
			
			line = buffer.readLine();
			l++;
			acc[i].setStatusLine(l);
			if (line.equals("Active")){
				acc[i].setStatus(true);
			}
			else if (line.equals("Disable")){
				acc[i].setStatus(false);
			}
		
			System.out.println(acc[i].getStatus());
			System.out.println(a);
			System.out.println(acc[i].getAccountNum());
		}
		}catch(Exception e){
			System.out.println(e);
		}
		acc[lineNumber-1].setPass(pass); // assign password to object
		System.out.println("this is the password "+acc[lineNumber-1].getPass());
		System.out.println("total lines in account txt "+l);
	
		
		initComponents();
		createEvents();
		
	
	}
	////////////////////////////////
	//initiate components 
	///////////////////////////////
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnBalance = new JButton("Check Balance");
		
		btnDeposit = new JButton("Deposit");
		
		btnWithdraw = new JButton("Withdraw");
		
		btnTransfer = new JButton("Transfer");
		
		btnChangePass = new JButton("Change Password");
		
		btnLogOff = new JButton("LogOff");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBalance, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addComponent(btnChangePass, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 149, Short.MAX_VALUE)
						.addComponent(btnDeposit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnTransfer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLogOff, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnWithdraw, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBalance, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnWithdraw, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangePass, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogOff, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	////////////////////////////////////
	// create events
	///////////////////////////////////

	private void createEvents() {
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(lineNumber-1);
				// lineNumber is the line in password text and each line corresponds to an object
				// if person's account is the third object then lineNumber-1 (3-1) will give array position
				// show message of balance instead of making new Jframe
				JOptionPane.showMessageDialog(null, "Your balance is: "+ acc[lineNumber-1].getBalance()); 
			}
		});
		
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create deposit frame with parameters
				Deposit frame = new Deposit(acc, lineNumber-1, accountfileName);
				frame.setVisible(true);
			}
		});
		
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create withdraw frame
				Withdraw frame = new Withdraw(acc, lineNumber-1, accountfileName);
				frame.setVisible(true);
			}
		});
		
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create transfer frame
				Transfer frame = new Transfer(acc, lineNumber-1, accountfileName, N);
				frame.setVisible(true);
			}
		});
		
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create change password frame
				ChangePassword frame = new ChangePassword(acc, lineNumber-1, lineNumber);
				frame.setVisible(true);
			}
		});
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete atm frame
				ATM.this.dispose();
				// create new login frame 
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		
		
	}
}
