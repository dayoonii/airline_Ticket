package com.java.ex.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.PassengerDAO;
import com.java.ex.main.SelectItinerary;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

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
//					login frame = new login();
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
	public login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblID = new JLabel("아이디");
		lblID.setBounds(92, 51, 62, 18);
		panel.add(lblID);

		JLabel lblPW = new JLabel("비밀번호");
		lblPW.setBounds(92, 97, 62, 18);
		panel.add(lblPW);

		txtID = new JTextField();
		txtID.setBounds(190, 45, 131, 24);
		panel.add(txtID);
		txtID.setColumns(10);

		txtPW = new JPasswordField();
		txtPW.setBounds(190, 94, 131, 24);
		panel.add(txtPW);

		// 로그인
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PassengerDAO dao = new PassengerDAO();
				String id = txtID.getText();
				String pw = txtPW.getText();
				dao.pLogin(id, pw);

				if (dao.check == 1) {
					new SelectItinerary();

				} else {

					JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 잘못 입력되었습니다.");
				}
			}
		});

		btnLogin.setBounds(92, 187, 105, 27);
		panel.add(btnLogin);
		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Memberjoin();
			}
		});
		btnJoin.setBounds(211, 187, 105, 27);
		panel.add(btnJoin);

		JButton btnfindID = new JButton("ID찾기");
		btnfindID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchID();
			}
		});
		btnfindID.setBounds(95, 148, 105, 27);
		panel.add(btnfindID);

		JButton btnfindPW = new JButton("PW찾기");
		btnfindPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchPW();
			}
		});
		btnfindPW.setBounds(214, 148, 105, 27);
		panel.add(btnfindPW);

		setTitle("관리자");
		setSize(426, 312);
		setLocation(750, 350);
		setVisible(true);
	}
}
