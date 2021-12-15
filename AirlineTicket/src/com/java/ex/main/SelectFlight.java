package com.java.ex.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.routeDTO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.List;
import javax.swing.JTextPane;


public class SelectFlight extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtDepartTime;
	private JTextField txtArrTime;
	private routeDTO route = null;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectFlight frame = new SelectFlight();
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
	public SelectFlight(ArrayList<routeDTO> dtos) {
		

		
		
		setTitle("항공편 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD3B8\uBA85");
		lblNewLabel.setBounds(40, 46, 62, 18);
		panel.add(lblNewLabel);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PassengerInfo(route);
			}
		});
		btnNext.setBounds(527, 260, 105, 27);
		panel.add(btnNext);
		
		
		txtDepartTime = new JTextField();
		txtDepartTime.setEditable(false);
		txtDepartTime.setBounds(186, 113, 129, 24);
		panel.add(txtDepartTime);
		txtDepartTime.setColumns(10);
		
		txtArrTime = new JTextField();
		txtArrTime.setEditable(false);
		txtArrTime.setColumns(10);
		txtArrTime.setBounds(351, 113, 129, 24);
		panel.add(txtArrTime);
		
		List listFlightname = new List();
		
		for (routeDTO dto : dtos) {
			listFlightname.add(dto.getFlight_name());
		}
		
		listFlightname.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String flightName = ((List) e.getSource()).getSelectedItem();
				for (routeDTO dto : dtos) {
					if(dto.getFlight_name().equals(flightName)) {
						route = dto;
						txtDepartTime.setText(route.getDepartTime());
						txtArrTime.setText(route.getArriveTime());
					}
				}
			}
		});
		
		listFlightname.setBounds(32, 113, 116, 134);
		panel.add(listFlightname);
		
		JLabel label = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		label.setBounds(187, 46, 62, 18);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uCC29\uC2DC\uAC04");
		lblNewLabel_1.setBounds(352, 46, 62, 18);
		panel.add(lblNewLabel_1);
		

		
		setTitle("항공편 선택");
		setSize(688,365);
	      setLocation(750,350);
	      setVisible(true);
	}
}
