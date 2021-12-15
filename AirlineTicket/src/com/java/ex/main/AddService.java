package com.java.ex.main;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import com.java.ex.DB.add_passengerDTO;
import com.java.ex.DB.routeDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class AddService extends JFrame {

	private JPanel contentPane;
	private JTextField txtSeatLevel;
	private JTextField txtSeatNum;
	private JTextField listCount;
	
	private int seatPrice;
	private int servicePrice;
	
	private String meal = "";
	private int total = 0;

//	public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				AddService frame = new AddService(null, null);
//				frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//}
	
	/**
	 * Create the frame.
	 */
	public AddService(routeDTO route, add_passengerDTO addDTO) {
		
		List<Map<String, String>> seats = new ArrayList<Map<String, String>>();
		Map<String, String> seat = new HashMap<String, String>();
		seat.put("seatNum", "B301");
		seat.put("seatLevel", "슈퍼로우");
		seat.put("seatPrice", "40000");
		seats.add(seat);
		Map<String, String> seat1 = new HashMap<String, String>();
		seat1.put("seatNum", "B302");
		seat1.put("seatLevel", "슈퍼로우");
		seat1.put("seatPrice", "40000");
		seats.add(seat1);
		Map<String, String> seat2 = new HashMap<String, String>();
		seat2.put("seatNum", "B201");
		seat2.put("seatLevel", "지니");
		seat2.put("seatPrice", "27000");
		seats.add(seat2);
		Map<String, String> seat3 = new HashMap<String, String>();
		seat3.put("seatNum", "B202");
		seat3.put("seatLevel", "지니");
		seat3.put("seatPrice", "27000");
		seats.add(seat3);
		
		System.out.println(route);
		System.out.println(addDTO);
		
		setTitle("부가서비스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(106, 90, 205));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtSeatLevel = new JTextField();
		txtSeatLevel.setBounds(344, 86, 116, 24);
		panel.add(txtSeatLevel);
		txtSeatLevel.setColumns(10);
		
		txtSeatNum = new JTextField();
		txtSeatNum.setBounds(344, 122, 116, 24);
		panel.add(txtSeatNum);
		txtSeatNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("사전좌석지정");
		lblNewLabel.setBounds(32, 63, 99, 18);
		panel.add(lblNewLabel);
		
		CheckboxGroup chgroup = new CheckboxGroup();
		
		Button B101 = new Button("");
		B101.setName("B101");
		B101.setBackground(SystemColor.activeCaption);
		B101.setForeground(new Color(0, 0, 0));
		B101.setBounds(141, 86, 43, 25);
		panel.add(B101);
		
		
		Button B201 = new Button("");
		B201.setName("B201");
		B201.setForeground(Color.BLACK);
		B201.setBackground(Color.YELLOW);
		B201.setBounds(195, 86, 43, 25);
		panel.add(B201);
		
		
		Button B301 = new Button("");
		B301.setName("B301");
		B301.setForeground(Color.BLACK);
		B301.setBackground(Color.PINK);
		B301.setBounds(250, 86, 43, 25);
		panel.add(B301);
		
		
		Button B102 = new Button("");
		B102.setName("B102");
		B102.setForeground(Color.BLACK);
		B102.setBackground(SystemColor.activeCaption);
		B102.setBounds(141, 122, 43, 25);
		panel.add(B102);
		
		
		Button B202 = new Button("");
		B202.setName("B202");
		B202.setForeground(Color.BLACK);
		B202.setBackground(Color.YELLOW);
		B202.setBounds(195, 122, 43, 25);
		panel.add(B202);
		
		
		Button B302 = new Button("");
		B302.setName("B302");
		B302.setForeground(Color.BLACK);
		B302.setBackground(Color.PINK);
		B302.setBounds(250, 122, 43, 25);
		panel.add(B302);
		
		
		JLabel lblNewLabel_1 = new JLabel("기내식");
		lblNewLabel_1.setBounds(32, 256, 62, 18);
		panel.add(lblNewLabel_1);
		
		JButton btnMeal = new JButton("밀");
		btnMeal.setBounds(113, 252, 105, 46);
		panel.add(btnMeal);
		
		JButton btnkidsMeal = new JButton("키즈밀");
		btnkidsMeal.setBounds(223, 252, 105, 46);
		panel.add(btnkidsMeal);
		
		JLabel lblNewLabel_2 = new JLabel("초과수화물");
		lblNewLabel_2.setBounds(32, 372, 85, 18);
		panel.add(lblNewLabel_2);
		
		JComboBox cmbBaggage = new JComboBox();
		
		cmbBaggage.setModel(new DefaultComboBoxModel(new String[] {"초과수화물 추가 선택", "5KG(+KRW 35,000)", "10KG(+KRW 70,000)"}));
		cmbBaggage.setBounds(150, 369, 178, 24);
		panel.add(cmbBaggage);
		
		JButton btnNext = new JButton("바로 결제");
		btnNext.setBounds(391, 447, 105, 27);
		panel.add(btnNext);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.activeCaptionBorder);
		separator.setBounds(125, 153, 335, 12);
		panel.add(separator);
		
		Listener listener = new Listener(seats, txtSeatLevel, txtSeatNum, seatPrice);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Map<String, String> selectedSeat = listener.getSeat();
				
				System.out.println(selectedSeat);
				System.out.println(total);
				System.out.println(addDTO);
				
				new paymentComplete(route, addDTO, selectedSeat, total);
			}
		});
		
		listCount = new JTextField();
		listCount.setBounds(261, 448, 116, 24);
		panel.add(listCount);
		listCount.setColumns(10);
		
		JButton btnConfirm = new JButton("선택확인");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int baggage = cmbBaggage.getSelectedIndex();
				servicePrice = 0;
				
				if(meal.equals("Meal")) {
					if(baggage == 1) {
						servicePrice = 35000;
					} else if(baggage == 2) {
						servicePrice = 70000;
					}
				} else if(meal.equals("kidsMeal"))  {
					if(baggage == 1) {
						servicePrice = 35000;
					} else if(baggage == 2) {
						servicePrice = 70000;
					}
				}
				System.out.println(servicePrice);
				
				seatPrice = listener.getPrice();
				total = seatPrice + servicePrice;
				listCount.setText(String.valueOf(total));
			}
		});
		btnConfirm.setBounds(391, 408, 105, 27);
		panel.add(btnConfirm);
		
		JCheckBox chkNoCheck = new JCheckBox("선택안함");
		chkNoCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox chk = (JCheckBox) e.getSource();
				if(chk.isSelected()) {
					txtSeatLevel.setText("");
					txtSeatLevel.setEditable(false);
					txtSeatNum.setText("");
					txtSeatNum.setEditable(false);
					btnkidsMeal.setEnabled(false);
					btnMeal.setEnabled(false);
					cmbBaggage.setEnabled(false);
					listener.setPrice(0);
					meal = "";
				} else {
					txtSeatLevel.setText("");
					txtSeatLevel.setEditable(true);
					txtSeatNum.setText("");
					txtSeatNum.setEditable(true);
					btnkidsMeal.setEnabled(true);
					btnMeal.setEnabled(true);
					cmbBaggage.setEnabled(true);
				}
			}
		});
		chkNoCheck.setBounds(141, 8, 131, 27);
		panel.add(chkNoCheck);
		
		
		btnMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meal = "Meal";
			}
		});
		
		btnkidsMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meal = "kidsMeal";
			}
		});
		
		B101.addActionListener(listener);
		B201.addActionListener(listener);
		B301.addActionListener(listener);
		B102.addActionListener(listener);
		B202.addActionListener(listener);
		B302.addActionListener(listener);
		
		setTitle("부가서비스");
		setSize(574,566);
	      setLocation(750,350);
	      setVisible(true);
	
		
		
	}
}

class Listener implements ActionListener {
	
	private List<Map<String, String>> seats;
	private Map<String, String> seat;
	private JTextField txtSeatLevel;
	private JTextField txtSeatNum;
	private int seatPrice;
	
	public Listener(List<Map<String, String>> seats, JTextField txtSeatLevel, JTextField txtSeatNum, int seatPrice) {
		this.seats = seats;
		this.txtSeatLevel = txtSeatLevel;
		this.txtSeatNum = txtSeatNum;
		this.seatPrice = seatPrice;
	}
	
	public int getPrice() {
		return seatPrice;
	}
	
	public void setPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	public Map<String, String> getSeat(){
		return seat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String seatName = btn.getName();
		System.out.println(seatName);
		
		for (Map<String, String> seat : seats) {
			if(seat.get("seatNum").equals(seatName)) {
				System.out.println(seat);
				this.seat = seat;
				if(txtSeatLevel.isEditable()) {
					txtSeatLevel.setText(seat.get("seatLevel"));
					txtSeatNum.setText(seat.get("seatNum"));
					seatPrice = Integer.parseInt(seat.get("seatPrice"));
				} else {
					seatPrice = 0;
				}
				break;
			}
		}

		
	}
}

