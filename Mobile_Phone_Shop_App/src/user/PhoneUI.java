package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import business.Phone;
import data.PhoneDP;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.ArrayList;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;


import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class PhoneUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtPhoneID;
	private JTextField txtName;
	private JTextField txtBrand;
	private JTextField txtPrice;
	private PhoneDP pDP;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneUI frame = new PhoneUI();
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
	public PhoneUI() {
		setTitle("Phone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 647);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pDP=new PhoneDP();
		
		JLabel lblPhoneID = new JLabel("Phone ID");
		lblPhoneID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneID.setBounds(37, 37, 94, 13);
		contentPane.add(lblPhoneID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(37, 80, 94, 13);
		contentPane.add(lblName);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrand.setBounds(37, 128, 94, 13);
		contentPane.add(lblBrand);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(38, 167, 94, 13);
		contentPane.add(lblPrice);
		
		txtPhoneID = new JTextField();
		txtPhoneID.setBounds(179, 33, 153, 25);
		contentPane.add(txtPhoneID);
		txtPhoneID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(179, 76, 153, 25);
		contentPane.add(txtName);
		
		txtBrand = new JTextField();
		txtBrand.setColumns(10);
		txtBrand.setBounds(179, 124, 153, 25);
		contentPane.add(txtBrand);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(179, 167, 153, 25);
		contentPane.add(txtPrice);
		
		final JTextPane txtDisplay =new JTextPane();
		txtDisplay.setBounds(37, 397, 336, 170);
		contentPane.add(txtDisplay);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int phoneID=Integer.valueOf(txtPhoneID.getText());
				String name=txtName.getText();
				String brand=txtBrand.getText();
				int price=Integer.valueOf(txtPrice.getText());
				Phone p=new Phone(phoneID,name,brand,price);
				boolean result=pDP.add(p);
				if(result) {
					JOptionPane.showMessageDialog(null, "The new phone is added");
				}else {
					JOptionPane.showMessageDialog(null, "The new phone is not added");
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(25, 278, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int phoneID=Integer.valueOf(JOptionPane.showInputDialog(null," Type Phone ID"));
				Phone p=pDP.get(phoneID);
				if(p!=null) {
					txtPhoneID.setText(String.valueOf(p.getPhoneID()));
					txtName.setText(p.getName());
					txtBrand.setText(p.getBrand());
					txtPrice.setText(String.valueOf(p.getPrice()));
				}else {
					JOptionPane.showMessageDialog(null, "The phone is not available");
				}
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind.setBounds(160, 278, 85, 21);
		contentPane.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int phoneID=Integer.valueOf(JOptionPane.showInputDialog(null," Type Phone ID"));
				boolean result=pDP.delete(phoneID);
				if(result) {
					JOptionPane.showInternalMessageDialog(null, "The phone is deleted");
				}else {
					JOptionPane.showInternalMessageDialog(null, "The phone is not deleted");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(288, 278, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int phoneID=Integer.valueOf(txtPhoneID.getText());
				String name=txtName.getText();
				String brand=txtBrand.getText();
				int price=Integer.valueOf(txtPrice.getText());
				Phone p=new Phone(phoneID,name,brand,price);
				boolean result=pDP.update(p);
				if(result) {
					JOptionPane.showMessageDialog(null, "The new phone is updated");
				}else {
					JOptionPane.showMessageDialog(null, "The new phone is not updated");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(25, 329, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText("");
				ArrayList<Phone> phoneList=pDP.getall();
				for(Phone p:phoneList) {
					String line=p.getPhoneID()+" "+p.getName()+" "+p.getBrand()+" "+p.getPrice()+"\n";
					txtDisplay.append(line);
				}
			}
		});
		btnDisplayAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDisplayAll.setBounds(149, 329, 112, 21);
		contentPane.add(btnDisplayAll);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(288, 329, 85, 21);
		contentPane.add(btnCancel);
		
		
		
		
		
		
	}
}
