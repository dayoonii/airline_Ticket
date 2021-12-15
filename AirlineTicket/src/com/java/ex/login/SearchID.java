package com.java.ex.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.PassengerDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchID extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtphoneNum;
	public login login;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SearchID frame = new SearchID();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SearchID() {
		setTitle("���̵�ã��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�̸�");
		lblNewLabel.setBounds(112, 53, 62, 18);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(185, 50, 116, 24);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("�ڵ�����ȣ");
		lblNewLabel_1.setBounds(96, 99, 78, 18);
		panel.add(lblNewLabel_1);
		
		txtphoneNum = new JTextField();
		txtphoneNum.setBounds(185, 96, 116, 24);
		panel.add(txtphoneNum);
		txtphoneNum.setColumns(10);
		
		
		
		
		
		JButton btnsearchID = new JButton("ã��");
		btnsearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String hp = txtphoneNum.getText();
				PassengerDAO dao = new PassengerDAO();
				JOptionPane.showMessageDialog(null, "���� ���̵��" + dao.search_ID(name, hp) + "�Դϴ�.");
				login = new login();
				setVisible(false);
				setResizable(false);
			}
		});
		btnsearchID.setBounds(91, 172, 105, 27);
		panel.add(btnsearchID);
		
		
		
		
		
		
		JButton btncancel = new JButton("���");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
			}
		});
		btncancel.setBounds(210, 172, 105, 27);
		panel.add(btncancel);
		
		setTitle("���̵�ã��");
		setSize(426,312);
	      setLocation(750,350);
	      setVisible(true);
	}

}
