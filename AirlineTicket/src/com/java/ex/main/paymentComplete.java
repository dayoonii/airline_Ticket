package com.java.ex.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.add_passengerDTO;
import com.java.ex.DB.paymentDAO;
import com.java.ex.DB.paymentDTO;
import com.java.ex.DB.routeDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class paymentComplete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					paymentComplete frame = new paymentComplete();
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
	public paymentComplete(routeDTO route, add_passengerDTO addDTO, Map<String, String> seat, int total) {
		setTitle("결제완료");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String Flight_name = route.getFlight_name();
		String depart = route.getDepart();
		String arrive = route.getArrive();
		String departdate = route.getDepartdate();
		String departTime = route.getDepartTime();
		String arriveTime = route.getArriveTime();
		String totalTime = route.getTotalTime();
		
		String add_name = addDTO.getAdd_name();
		String add_birth = addDTO.getAdd_birth();
		String add_hp = addDTO.getAdd_hp();
		String add_email = addDTO.getAdd_email();
		
		String seatNum = seat.get("seatNum");
		String seatPrice = seat.get("seatPrice");
		String seatLevel = seat.get("seatLevel");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentDTO dto = new paymentDTO(null, add_birth, add_name, Flight_name, seatNum, total);
				boolean result = new paymentDAO().payment(dto);
				System.out.println(result);
				JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.");
			}
		});
		btnNewButton.setBounds(280, 424, 105, 27);
		panel.add(btnNewButton);
		
		JLabel NewLable = new JLabel("이름");
		NewLable.setBounds(14, 29, 62, 18);
		panel.add(NewLable);
		
		JLabel lblName = new JLabel(add_name);
		lblName.setBounds(127, 20, 170, 27);
		lblName.setOpaque(true);
		lblName.setBackground(Color.WHITE);
		panel.add(lblName);
		
		JLabel lblNewLabel = new JLabel("전화번호");
		lblNewLabel.setBounds(14, 79, 62, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("노선");
		lblNewLabel_1.setBounds(14, 129, 62, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("날짜");
		lblNewLabel_2.setBounds(14, 173, 62, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("편명");
		lblNewLabel_3.setBounds(14, 222, 62, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("좌석번호");
		lblNewLabel_4.setBounds(14, 267, 62, 18);
		panel.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("총결제금액");
		label_1.setBounds(14, 315, 85, 18);
		panel.add(label_1);
		
		JLabel lblphoneNum = new JLabel(add_hp);
		lblphoneNum.setOpaque(true);
		lblphoneNum.setBackground(Color.WHITE);
		lblphoneNum.setBounds(127, 70, 170, 27);
		panel.add(lblphoneNum);
		
		JLabel lblroute = new JLabel(depart + " - " + arrive);
		lblroute.setOpaque(true);
		lblroute.setBackground(Color.WHITE);
		lblroute.setBounds(127, 120, 170, 27);
		panel.add(lblroute);
		
		JLabel lblDate = new JLabel(departdate);
		lblDate.setOpaque(true);
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(127, 164, 170, 27);
		panel.add(lblDate);
		
		JLabel lblFlightNum = new JLabel(Flight_name);
		lblFlightNum.setOpaque(true);
		lblFlightNum.setBackground(Color.WHITE);
		lblFlightNum.setBounds(127, 213, 170, 27);
		panel.add(lblFlightNum);
		
		JLabel lblSeatNum = new JLabel(seatNum);
		lblSeatNum.setOpaque(true);
		lblSeatNum.setBackground(Color.WHITE);
		lblSeatNum.setBounds(127, 258, 170, 27);
		panel.add(lblSeatNum);
		
		JLabel lblTotalPrice = new JLabel(String.valueOf(total));
		lblTotalPrice.setOpaque(true);
		lblTotalPrice.setBackground(Color.WHITE);
		lblTotalPrice.setBounds(127, 306, 170, 27);
		panel.add(lblTotalPrice);
		
		setTitle("결제완료");
		setSize(450,547);
	      setLocation(750,350);
	      setVisible(true);
	}
}
