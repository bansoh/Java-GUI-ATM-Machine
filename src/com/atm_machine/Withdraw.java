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

public class Withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField withdrawField;
	private JButton btnEnter;
	int w;
	int arrayPos;
	String fName;
	Account b[];

	
	

	/**
	 * Create the frame.
	 */
	public Withdraw(Account acc[], int array_pos, String file_name) {
		arrayPos = array_pos;
		fName = file_name;
		b = acc;
		initialize();
		createEvents();
		
	}


	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAmount = new JLabel("Amount:");
		
		withdrawField = new JTextField();
		withdrawField.setColumns(10);
		
		btnEnter = new JButton("Enter");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAmount)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(withdrawField)
							.addGap(244))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnEnter)
							.addGap(35))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(withdrawField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(111)
					.addComponent(btnEnter)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents() {
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String withdraw = withdrawField.getText();
				w = Integer.parseInt(withdraw);
				if(b[arrayPos].getBalance()<w){
					JOptionPane.showMessageDialog(null, "Insufficient Funds");
				}
				else if(b[arrayPos].getBalance()>=w){
					b[arrayPos].setBalance(b[arrayPos].getBalance()-w);
					int lineToBeEditied =b[arrayPos].getBalanceLine();
					changeLine changeFile = new changeLine();
					String newLineContent = Integer.toString(b[arrayPos].getBalance());
					changeFile.changeText(fName, newLineContent, lineToBeEditied);
					JOptionPane.showMessageDialog(null, "Money has been withdrawn");
					Withdraw.this.dispose();
				}
			}
		});
		
	}
}
