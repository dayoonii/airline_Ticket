package com.java.ex.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.main.SelectItinerary;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ManagerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPW;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerLogin frame = new ManagerLogin();
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
	public ManagerLogin() {
		setTitle("������ �α���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("���̵�");
		label.setBounds(49, 57, 62, 18);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("��й�ȣ");
		lblNewLabel.setBounds(49, 104, 62, 18);
		panel.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(125, 54, 143, 24);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JButton btnLogin = new JButton("�α���");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new String(txtID.getText()).equals("1234") && new String(txtPW.getPassword()).equals("1234")) {
					new Main_tab();
					}
					else {
					JOptionPane.showMessageDialog(null, "���̵�Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.", "�α��ο���", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnLogin.setBounds(122, 169, 105, 27);
		panel.add(btnLogin);
		
		txtPW = new JPasswordField();
		txtPW.setBounds(125, 101, 143, 24);
		panel.add(txtPW);
		
		
		setTitle("������ �α���");
		setSize(391,287);
	      setLocation(750,350);
	      setVisible(true);
	}
}
