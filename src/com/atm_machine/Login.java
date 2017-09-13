package com.atm_machine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField pinField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	// file holds the name of the password text
	String file = "Password.txt";
	BufferedReader buffer = null;
	// line will hold the line read from text
	String line = "";
	Scanner scan = new Scanner(System.in);
	// string array to hold the account number and account password
	String []arr;
	private JButton btnExit;

	
	
	
public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("ATM");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/atm_machine/resources/empty_atm.png")));
		
		initComponents();
		createEvents();
	
	}
	//////////////////////////////////////////////////////////////////////
	//initialize components
	/////////////////////////////////////////////////////////////////////

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPinNumber = new JLabel("Pin Number:");
		
		pinField = new JTextField();
		pinField.setText("");
		pinField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		passwordField = new JPasswordField();
		
		btnLogin = new JButton("Login");
		
		btnExit = new JButton("Exit");
		
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPinNumber)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addComponent(pinField))
					.addGap(221))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(194)
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPinNumber)
						.addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(169)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnLogin))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	//////////////////////////////////////////////////////////////////////
	//create events 
	//////////////////////////////////////////////////////////////////////
	
	private void createEvents() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get account number and pass from text field
				String pin = pinField.getText();
				String pass = passwordField.getText();
				System.out.println("button was clicked");
				System.out.println(pin);
				System.out.println(pass);
				
				// i tells us what line in password text the account num and pass is located
				int i = 0;
				
				// read in file line by line and check if inputed account num and pass match from password file
				try{
					buffer = new BufferedReader(new FileReader(file));
					line = buffer.readLine();
					line = buffer.readLine();
				
				
					while (line!=null){
						// split line into array index 0 hold account number and 1 holds account password
						String [] arr = line.split(" ");
						i++;
						if((pass.trim().equals(arr[1])) && (pin.trim().equals(arr[0]))){
							System.out.println("login complete");
							// output message to show login was successful
							JOptionPane.showMessageDialog(null, "Login Successful");
							System.out.println(arr[0]+" "+arr[1]);
							// create frame for atm 
							ATM frame = new ATM(arr[0], arr[1], i);
							frame.setVisible(true);
							// delete login in frame
							Login.this.dispose();
						
							//ChangeLineInFile changeFile = new ChangeLineInFile();
							//changeFile.changeALineInATextFile(file, newLineContent, lineToBeEditied);
							
							//changeLine changeFile = new changeLine();
							//changeFile.changeText(file, newLineContent, lineToBeEditied);
						}
						line = buffer.readLine();
					}

					System.out.println("number of lines "+i);
					}catch(Exception a){
						System.out.println(a);
					}
				
				/*if ((pass.equals("123")) && (pin.equals("12014"))){
					System.out.println("login complete");
					JOptionPane.showMessageDialog(null, "Login Successful");
					ATM frame = new ATM();
					frame.setVisible(true);
					Login.this.dispose();
				}*/
			}
		});
		
		// if user clicks exit terminate program
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	

}
