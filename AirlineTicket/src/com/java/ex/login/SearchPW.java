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

public class SearchPW extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
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
//					SearchPW frame = new SearchPW();
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
	public SearchPW() {
		setTitle("��й�ȣã��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���̵�");
		lblNewLabel.setBounds(87, 35, 62, 18);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("�ڵ�����ȣ");
		label.setBounds(87, 119, 85, 18);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("�̸�");
		lblNewLabel_1.setBounds(87, 77, 62, 18);
		panel.add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setBounds(185, 32, 116, 24);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("");
		txtName.setBounds(185, 74, 116, 24);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtphoneNum = new JTextField();
		txtphoneNum.setBounds(185, 116, 116, 24);
		panel.add(txtphoneNum);
		txtphoneNum.setColumns(10);
		
		
		
		JButton btnsearchPW = new JButton("ã��");
		btnsearchPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String name = txtName.getText();
				String hp = txtphoneNum.getText();
				PassengerDAO dao = new PassengerDAO();
				JOptionPane.showMessageDialog(null, "���� ��й�ȣ��" + dao.search_PW(id,name,hp) + "�Դϴ�.");
				login = new login();
				setVisible(false);
				setResizable(false);
			}
		});
		btnsearchPW.setBounds(79, 174, 105, 27);
		panel.add(btnsearchPW);
		
		
		
		JButton btncancel = new JButton("���");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
			}
		});
		btncancel.setBounds(216, 174, 105, 27);
		panel.add(btncancel);
		
	
		 setTitle("��й�ȣã��");
		 setSize(426,312);
	      setLocation(750,350);
	      setVisible(true);
	}

}
