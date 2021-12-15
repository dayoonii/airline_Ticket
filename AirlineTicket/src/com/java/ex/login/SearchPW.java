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
		setTitle("비밀번호찾기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(87, 35, 62, 18);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("핸드폰번호");
		label.setBounds(87, 119, 85, 18);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
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
		
		
		
		JButton btnsearchPW = new JButton("찾기");
		btnsearchPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String name = txtName.getText();
				String hp = txtphoneNum.getText();
				PassengerDAO dao = new PassengerDAO();
				JOptionPane.showMessageDialog(null, "고객님 비밀번호는" + dao.search_PW(id,name,hp) + "입니다.");
				login = new login();
				setVisible(false);
				setResizable(false);
			}
		});
		btnsearchPW.setBounds(79, 174, 105, 27);
		panel.add(btnsearchPW);
		
		
		
		JButton btncancel = new JButton("취소");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
			}
		});
		btncancel.setBounds(216, 174, 105, 27);
		panel.add(btncancel);
		
	
		 setTitle("비밀번호찾기");
		 setSize(426,312);
	      setLocation(750,350);
	      setVisible(true);
	}

}
