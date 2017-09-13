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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField OldPasswordTxt;
	private JTextField NewPasswordTxt;
	private JButton btnEnter;
	int arrayPos;
	int lineNumber;
	Account b[]; // create account object array to hold passed object array
	String OldPass; // string to hold old password
	String NewPass; // string to hold new password
	String file = "Password.txt";
	String newLineContent; // adds account num and password to make a line that will replace old line in password txt
	

	

	/**
	 * Create the frame.
	 */
	public ChangePassword(Account acc[], int array_position, int line_number) {
		setTitle("ATM");
		b = acc;
		lineNumber = line_number; // line number is position in password file
		arrayPos = array_position; // the position in array account is located
		
		initialize();
		createEvents();
		
		
	}



	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		
		JLabel lblNewPassword = new JLabel("New Password:");
		
		OldPasswordTxt = new JTextField();
		OldPasswordTxt.setColumns(10);
		
		NewPasswordTxt = new JTextField();
		NewPasswordTxt.setColumns(10);
		
		btnEnter = new JButton("Enter");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOldPassword)
							.addGap(18)
							.addComponent(OldPasswordTxt))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewPassword)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(NewPasswordTxt)
							.addGap(1)))
					.addGap(197))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(288, Short.MAX_VALUE)
					.addComponent(btnEnter)
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword)
						.addComponent(OldPasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(NewPasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addComponent(btnEnter)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}



	private void createEvents() {
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OldPass = OldPasswordTxt.getText(); // get old password
				OldPass.trim(); 
				NewPass = NewPasswordTxt.getText();
				NewPass.trim();
				if(b[arrayPos].getPass().trim().equals(OldPass)){
					b[arrayPos].setPass(NewPass);
					changeLine changeFile = new changeLine();
					
					String accountNum = b[arrayPos].getAccountNum();
					String accountPass = b[arrayPos].getPass();
					b[arrayPos].setAccountNum(accountNum.trim());
					b[arrayPos].setPass(accountPass.trim());
					
					System.out.println("account Num: "+b[arrayPos].getAccountNum());
					System.out.println("Pass Num: "+b[arrayPos].getPass());
					newLineContent = b[arrayPos].getAccountNum()+" "+b[arrayPos].getPass();
					//String newLine = newLineContent.replace("\t", "");
					//System.out.println(newLine);
					
					
					//newLineContent = new StringBuilder(14).append(accountNum).append(" ").append(accountPass).toString();
					//StringBuffer sBuffer = new StringBuffer(15);
			        //sBuffer.append(accountNum).append(" ").append(accountPass);
			        //newLineContent = sBuffer.toString();
					

					// other code which updates freshString
					


					System.out.println(newLineContent);
					
					changeFile.changeText(file, newLineContent, lineNumber);
					ChangePassword.this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Incorrect Password");
				}
			}
		});
		
	}

}
