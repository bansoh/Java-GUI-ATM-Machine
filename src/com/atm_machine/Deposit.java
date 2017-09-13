package com.atm_machine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JButton btnEnter;
	Account b[];
	int N;
	int arrayPos;
	int d;
	private JTextField depositField;
	String fName;

	public Deposit(Account a[], int k, String file_name) {
		initialize();
		createEvents();
		b = a;
		arrayPos = k;
		fName = file_name;
	}
	
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnEnter = new JButton("Enter");

		
		JLabel lblAmount = new JLabel("Amount:");
		
		depositField = new JTextField();
		depositField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(285)
					.addComponent(btnEnter, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(38))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAmount)
					.addGap(18)
					.addComponent(depositField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addGap(218))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(depositField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
					.addComponent(btnEnter)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents() {
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deposit = depositField.getText();
				d = Integer.parseInt(deposit);
				System.out.println(b[arrayPos].getBalance());
				b[arrayPos].setBalance(b[arrayPos].getBalance()+d);
				System.out.println(b[arrayPos].getBalance());
				// update text file to new balance
				int lineToBeEditied =b[arrayPos].getBalanceLine();
				changeLine changeFile = new changeLine();
				String newLineContent = Integer.toString(b[arrayPos].getBalance());
				changeFile.changeText(fName, newLineContent, lineToBeEditied);

				JOptionPane.showMessageDialog(null, "Money has been deposited");
				Deposit.this.dispose();
			}
		});
		
	}

	

}
