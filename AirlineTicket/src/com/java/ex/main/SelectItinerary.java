package com.java.ex.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.ex.DB.routeDAO;
import com.java.ex.DB.routeDTO;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SelectItinerary extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectItinerary frame = new SelectItinerary();
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
	public SelectItinerary() {
		setTitle("여정선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton rdbOne = new JRadioButton("편도");
		rdbOne.setBounds(298, 20, 66, 27);
		panel.add(rdbOne);
		
		JComboBox cmbDepart = new JComboBox();
		cmbDepart.setModel(new DefaultComboBoxModel(new String[] {"출발지", "인천", "김포"}));
		
		cmbDepart.setBounds(27, 107, 149, 27);
		panel.add(cmbDepart);
		
		JComboBox cmbArrive = new JComboBox();
		cmbArrive.setModel(new DefaultComboBoxModel(new String[] {"도착지", "제주도","중국","대만"}));
		cmbArrive.setBounds(207, 108, 149, 24);
		panel.add(cmbArrive);
		
		JComboBox cmbDepartDate = new JComboBox();
		cmbDepartDate.setModel(new DefaultComboBoxModel(new String[] {"2019-12-20", "2019-12-21"}));
		cmbDepartDate.setBounds(399, 108, 176, 24);
		panel.add(cmbDepartDate);
		
		
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource() == btnNext) {
					routeDAO dao = new routeDAO();
					String depart = String.valueOf(cmbDepart.getSelectedItem());
					String arrive = String.valueOf(cmbArrive.getSelectedItem());
					String departdate = String.valueOf(cmbDepartDate.getSelectedItem());
				
					ArrayList<routeDTO> dtos = dao.routeSelect1(depart, arrive, departdate);
					for (routeDTO dto : dtos) {
						System.out.println(dto);
					}
					new SelectFlight(dtos);
					setVisible(false);
					dispose();
					
				}
				
			}
		});
		btnNext.setBounds(488, 247, 105, 27);
		panel.add(btnNext);
		
		setTitle("여정선택");
		setSize(688,365);
	      setLocation(750,350);
	      setVisible(true);
		
		
		
	}
}
