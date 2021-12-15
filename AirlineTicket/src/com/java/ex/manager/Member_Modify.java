package com.java.ex.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.PassengerDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Member_Modify extends JFrame {

	public JPanel contentPane;
	public JTextField txtID;
	public JPasswordField txtPW;
	public JTextField txtName;
	public JTextField txtphoneNum;
	public JTextField txtEmail;
	public JTextField txtAddress;
	public final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Member_Modify frame = new Member_Modify();
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
	public Member_Modify() {
		setTitle("ȸ����������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblID = new JLabel("���̵�");
		lblID.setBounds(41, 78, 62, 18);
		panel.add(lblID);

		JLabel lblPW = new JLabel("��й�ȣ");
		lblPW.setBounds(42, 113, 62, 18);
		panel.add(lblPW);

		JLabel lblName = new JLabel("�̸�");
		lblName.setBounds(41, 45, 62, 18);
		panel.add(lblName);

		JLabel lblphoneNum = new JLabel("�ڵ�����ȣ");
		lblphoneNum.setBounds(42, 149, 84, 18);
		panel.add(lblphoneNum);

		JLabel lblEmail = new JLabel("�̸���");
		lblEmail.setBounds(42, 187, 62, 18);
		panel.add(lblEmail);

		JLabel lblAddress = new JLabel("�ּ�");
		lblAddress.setBounds(42, 232, 62, 18);
		panel.add(lblAddress);

		JLabel lblNation = new JLabel("����");
		lblNation.setBounds(42, 279, 62, 18);
		panel.add(lblNation);

		JLabel lblGender = new JLabel("����");
		lblGender.setBounds(42, 322, 62, 18);
		panel.add(lblGender);

		txtID = new JTextField();
		txtID.setBounds(134, 75, 116, 24);
		panel.add(txtID);
		txtID.setColumns(10);

		txtPW = new JPasswordField();
		txtPW.setBounds(135, 110, 116, 24);
		panel.add(txtPW);

		txtName = new JTextField();
		txtName.setBounds(134, 42, 116, 24);
		panel.add(txtName);
		txtName.setColumns(10);

		txtphoneNum = new JTextField();
		txtphoneNum.setBounds(135, 146, 116, 24);
		panel.add(txtphoneNum);
		txtphoneNum.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(135, 184, 116, 24);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JComboBox cmbEmail = new JComboBox();
		cmbEmail.setModel(new DefaultComboBoxModel(new String[] { "@naver.com", "@daum.net", "@hanmail.net" }));
		cmbEmail.setBounds(265, 184, 118, 24);
		panel.add(cmbEmail);

		txtAddress = new JTextField();
		txtAddress.setBounds(135, 229, 116, 24);
		panel.add(txtAddress);
		txtAddress.setColumns(10);

		JComboBox cbNation = new JComboBox();
		cbNation.setModel(new DefaultComboBoxModel(new String[] { "�ѱ�", "�߱�", "�̱�" }));
		cbNation.setBounds(135, 276, 116, 24);
		panel.add(cbNation);

		JRadioButton rdMan = new JRadioButton("��");
		buttonGroup.add(rdMan);
		rdMan.setBounds(135, 318, 62, 27);
		panel.add(rdMan);

		JRadioButton rdWoman = new JRadioButton("��");
		buttonGroup.add(rdWoman);
		rdWoman.setBounds(200, 318, 52, 27);
		panel.add(rdWoman);

		JButton btnSave = new JButton("����");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String pw = txtPW.getText();
				String hp = txtphoneNum.getText();
				String email = txtEmail.getText();
				String address = txtAddress.getText();
				String id = txtID.getText();
				
				PassengerDAO dao = new PassengerDAO();
				
				dao.pUpdate(name, pw, hp, email, address,id);
				
				setVisible(false);

			}
		});
		
		btnSave.setBounds(149, 392, 105, 27);
		panel.add(btnSave);

		setTitle("ȸ����������");
		setSize(450, 542);
		setLocation(750, 350);
	 setVisible(true);
	}
}
