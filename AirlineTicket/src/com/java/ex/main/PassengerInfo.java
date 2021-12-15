package com.java.ex.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.AllmemberDTO;
import com.java.ex.DB.PassengerDAO;
import com.java.ex.DB.PassengerDTO;
import com.java.ex.DB.add_passengerDAO;
import com.java.ex.DB.add_passengerDTO;
import com.java.ex.DB.routeDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtbrith;
	private JTextField txtEmail;
	private JTextField txtphoneNum;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PassengerInfo frame = new PassengerInfo();
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
	public PassengerInfo(routeDTO route) {
		System.out.println(route);
		setTitle("Å¾½Â°´Á¤º¸");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ÀÌ¸§");
		lblNewLabel.setBounds(53, 120, 62, 18);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(127, 117, 133, 24);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(53, 74, 62, 18);
		panel.add(lblNewLabel_1);
		
		txtbrith = new JTextField();
		txtbrith.setBounds(127, 71, 133, 24);
		panel.add(txtbrith);
		txtbrith.setColumns(10);
		
		JLabel label_1 = new JLabel("Å¾½Â°´Á¤º¸");
		label_1.setBounds(28, 12, 103, 18);
		panel.add(label_1);
		
		
		JLabel label_3 = new JLabel("ÀÌ¸ÞÀÏ");
		label_3.setBounds(316, 74, 62, 18);
		panel.add(label_3);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(381, 71, 116, 24);
		panel.add(txtEmail);
		
		
		JComboBox cmbEmail = new JComboBox();
		cmbEmail.setModel(new DefaultComboBoxModel(new String[] {"@naver.com", "@daum.net", "@hanmail.net"}));
		cmbEmail.setBounds(524, 71, 103, 24);
		panel.add(cmbEmail);
		
		JLabel label_5 = new JLabel("ÇÚµåÆù¹øÈ£");
		label_5.setBounds(289, 120, 84, 18);
		panel.add(label_5);
		
		txtphoneNum = new JTextField();
		txtphoneNum.setColumns(10);
		txtphoneNum.setBounds(381, 117, 116, 24);
		panel.add(txtphoneNum);
		
		JButton btnNext = new JButton("´ÙÀ½");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnNext) {
					//add_passengerDAO dao = new add_passengerDAO();
					String add_name = txtName.getText();
					String add_email = txtEmail.getText();
					add_email = add_email + String.valueOf(cmbEmail.getSelectedItem());
					String add_birth = txtbrith.getText();
					String add_hp = txtphoneNum.getText();
					
					add_passengerDTO dto = new add_passengerDTO(add_name, add_birth, add_hp, add_email);
					//dao.Insertadd(add_name, add_birth, add_hp, add_email);
					new AddService(route, dto);
					setVisible(false);
					dispose();
				}
			}
		});
		btnNext.setBounds(524, 256, 105, 27);
		panel.add(btnNext);
		
		
		
		
		
		setTitle("Å¾½Â°´Á¤º¸");
		setSize(688,365);
	      setLocation(750,350);
	      setVisible(true);
	}

}
