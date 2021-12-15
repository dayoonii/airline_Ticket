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
		setTitle("아이디찾기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(112, 53, 62, 18);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(185, 50, 116, 24);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("핸드폰번호");
		lblNewLabel_1.setBounds(96, 99, 78, 18);
		panel.add(lblNewLabel_1);
		
		txtphoneNum = new JTextField();
		txtphoneNum.setBounds(185, 96, 116, 24);
		panel.add(txtphoneNum);
		txtphoneNum.setColumns(10);
		
		
		
		
		
		JButton btnsearchID = new JButton("찾기");
		btnsearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String hp = txtphoneNum.getText();
				PassengerDAO dao = new PassengerDAO();
				JOptionPane.showMessageDialog(null, "고객님 아이디는" + dao.search_ID(name, hp) + "입니다.");
				login = new login();
				setVisible(false);
				setResizable(false);
			}
		});
		btnsearchID.setBounds(91, 172, 105, 27);
		panel.add(btnsearchID);
		
		
		
		
		
		
		JButton btncancel = new JButton("취소");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
			}
		});
		btncancel.setBounds(210, 172, 105, 27);
		panel.add(btncancel);
		
		setTitle("아이디찾기");
		setSize(426,312);
	      setLocation(750,350);
	      setVisible(true);
	}

}
