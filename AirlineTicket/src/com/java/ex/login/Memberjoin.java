package com.java.ex.login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.PassengerDAO;

public class Memberjoin extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPW;
	private JTextField txtName;
	private JTextField txtphoneNum;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public String gender;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Memberjoin frame = new Memberjoin();
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
	public Memberjoin() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(41, 49, 62, 18);
		panel.add(lblName);

		JLabel lblID = new JLabel("아이디");
		lblID.setBounds(41, 82, 62, 18);
		panel.add(lblID);

		JLabel lblPW = new JLabel("비밀번호");
		lblPW.setBounds(41, 124, 62, 18);
		panel.add(lblPW);

		JLabel lblphoneNum = new JLabel("핸드폰번호");
		lblphoneNum.setBounds(41, 160, 84, 18);
		panel.add(lblphoneNum);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(41, 198, 62, 18);
		panel.add(lblEmail);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setBounds(41, 243, 62, 18);
		panel.add(lblAddress);

		JLabel lblNation = new JLabel("국적");
		lblNation.setBounds(41, 290, 62, 18);
		panel.add(lblNation);

		JLabel lblGender = new JLabel("성별");
		lblGender.setBounds(41, 333, 62, 18);
		panel.add(lblGender);

		txtID = new JTextField();
		txtID.setBounds(134, 79, 116, 24);
		panel.add(txtID);
		txtID.setColumns(10);

		txtPW = new JPasswordField();
		txtPW.setBounds(134, 121, 116, 24);
		panel.add(txtPW);

		txtName = new JTextField();
		txtName.setBounds(134, 46, 116, 24);
		panel.add(txtName);
		txtName.setColumns(10);

		txtphoneNum = new JTextField();
		txtphoneNum.setBounds(134, 157, 116, 24);
		panel.add(txtphoneNum);
		txtphoneNum.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(134, 195, 116, 24);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JComboBox cmbEmail = new JComboBox();
		cmbEmail.setModel(new DefaultComboBoxModel(new String[] { "@naver.com", "@daum.net", "@hanmail.net" }));
		cmbEmail.setBounds(264, 195, 118, 24);
		panel.add(cmbEmail);

		txtAddress = new JTextField();
		txtAddress.setBounds(134, 240, 116, 24);
		panel.add(txtAddress);
		txtAddress.setColumns(10);

		JComboBox cbNation = new JComboBox();
		cbNation.setModel(new DefaultComboBoxModel(new String[] { "한국", "중국", "미국" }));
		cbNation.setBounds(134, 287, 116, 24);
		panel.add(cbNation);

		JRadioButton rdMan = new JRadioButton("남");
		buttonGroup.add(rdMan);
		rdMan.setBounds(134, 329, 62, 27);
		panel.add(rdMan);

		JRadioButton rdWoman = new JRadioButton("여");
		buttonGroup.add(rdWoman);
		rdWoman.setBounds(199, 329, 52, 27);
		panel.add(rdWoman);

		JButton btnUpdate = new JButton("회원가입");

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnUpdate) {
					PassengerDAO dao = new PassengerDAO();
					String name = txtName.getText();
					String id = txtID.getText();
					String pw = txtPW.getText();
					String hp = txtphoneNum.getText();

					String address = txtAddress.getText();

					String email = txtEmail.getText();
					email = email + String.valueOf(cmbEmail.getSelectedItem());

					// email = email+txtEmail.getText();

					// String nation = cbNation.getActionCommand();

					String nation = String.valueOf(cbNation.getSelectedItem());

					boolean Man = rdMan.isSelected();
					boolean Woman = rdWoman.isSelected();

					if (Man == true && Woman == false) {
						gender = "남";
					} else if (Man == false && Woman == true) {
						gender = "여";

					} else {
						JOptionPane.showMessageDialog(null, "성별을 선택하세요");
					}

					JOptionPane.showMessageDialog(null, "축하합니다! 가입이 완료되었습니다.");
					dao.pInsert(name, id, pw, hp, email, address, nation, gender);

					setVisible(false);
					dispose();
				}
			}

		});

		btnUpdate.setBounds(264, 391, 105, 27);
		panel.add(btnUpdate);

		setTitle("회원가입");
		setSize(444, 551);
		setLocation(750, 350);
		setVisible(true);
	}
}
