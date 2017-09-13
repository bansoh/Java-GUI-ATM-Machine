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

public class Transfer extends JFrame {

	private JPanel contentPane;
	int arrayPos;
	String fName;
	Account b[];
	int arraySize;
	private JTextField AccountField;
	private JTextField AmountField;
	private JButton btnEnter;
	String transferAccount;
	int amountTransfer;
	int transferPos;
	int balance1;
	int balance2;


	

	/**
	 * Create the frame.
	 */
	public Transfer(Account acc[], int array_pos, String file_name, int array_size) {
		b = acc;
		arrayPos = array_pos;
		fName = file_name;
		arraySize = array_size;
		initialize();
		createEvents();
		
	}




	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTransferAccount = new JLabel("Transfer Account:");
		
		JLabel lblAmount = new JLabel("Amount:");
		
		AccountField = new JTextField();
		AccountField.setColumns(10);
		
		AmountField = new JTextField();
		AmountField.setColumns(10);
		
		btnEnter = new JButton("Enter");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTransferAccount)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(AccountField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAmount)
									.addGap(64)
									.addComponent(AmountField)))
							.addGap(186))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnEnter)
							.addGap(24))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransferAccount)
						.addComponent(AccountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(AmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(82)
					.addComponent(btnEnter)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}


	private void createEvents() {
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean status = false;
				String transferAccount = AccountField.getText();
				String a = AmountField.getText();
				amountTransfer = Integer.parseInt(a);
				for(int i=0; i<arraySize; i++){
					System.out.println(transferAccount);
					System.out.println(b[i].getAccountNum());
					if(b[i].getAccountNum().trim().equals(transferAccount)){
						System.out.println("if statmenet is working");
						transferPos = i;
						status = true;
					}
				}
				if(status==true){
					int balance1 = b[arrayPos].getBalance();
					System.out.println(balance1);
					int balance2 = b[transferPos].getBalance();
					if(balance1<amountTransfer){
						JOptionPane.showMessageDialog(null, "Insufficient Funds");
					}
					else if(balance1>=amountTransfer){
						b[arrayPos].setBalance(b[arrayPos].getBalance()-amountTransfer);
						b[transferPos].setBalance(b[transferPos].getBalance()+amountTransfer);
						System.out.println(b[arrayPos].getBalance());
						System.out.println(b[transferPos].getBalance());
						
						int lineToBeEditied =b[arrayPos].getBalanceLine();
						changeLine changeFile = new changeLine();
						String newLineContent = Integer.toString(b[arrayPos].getBalance());
						changeFile.changeText(fName, newLineContent, lineToBeEditied);
						
						int lineToBeEditied2 = b[transferPos].getBalanceLine();
						System.out.println("line to transfer  "+lineToBeEditied);
						changeLine changeFile2 = new changeLine();
						String newLineContent2 = Integer.toString(b[transferPos].getBalance());
						System.out.println("the new line is "+newLineContent2);
						changeFile2.changeText(fName, newLineContent2, lineToBeEditied2);
						
						JOptionPane.showMessageDialog(null, "Money has been transferred");
						Transfer.this.dispose();
					}
				}
				
				
			}
		});
		
	}

}
