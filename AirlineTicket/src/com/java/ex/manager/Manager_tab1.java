package com.java.ex.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//예약고객 정보 탭 1 
//관리자 페이지 
public class Manager_tab1 extends JPanel{
	
	// JTabbedPane Tab;
	
	 //예약고객조회 패널----------------------------------------1번 
	   
	   JPanel jp1;     //예약고객조회 패널
	   JPanel jp1_1;   //예약고객조회 윗부분패널 
	   
	   public JTextField txtName1;
	   public JTextField txtReserveNum;
	   
	   JTextField txtphoneNum1;
	   //JTextField txtbirth1;     //예약조회페이지 
	   
	   public JButton btnCheck1;
	   
	   //JRadioButton rdMan1;
	   //JRadioButton rdWoman1;
	   //ButtonGroup btnGroup1; //성별 라디오버튼  
	   
	   JLabel lblName1;
	   JLabel lblphoneNum1;
	   JLabel lblReserveNum;
	   //JLabel lblbirth1;
	   //JLabel lblgender1;
	   
	   JTable table_1;
	   JScrollPane scroll_1;
	   
	   
	   DefaultTableModel dtm;
	
	   
	   private Object[] objColNms = new Object[] { "예약번호","이름", "날짜", "시간", "출발지","도착지","좌석등급","기내식","초과수화물" };
	   
	  
	   
	   public Manager_tab1() {
		   //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     
		    //  setSize(1000,600);
		     // setVisible(true);
		      
		      
		      
		      
		    //예약고객조회========
		      jp1 = new JPanel();
	          jp1_1 = new JPanel();
		   
	        //  Container c = getContentPane();
		     // c.setLayout(new FlowLayout());
		     // Tab = new JTabbedPane();      //탭생성
		     // Tab.add("예약고객조회", jp1);
		      jp1.setPreferredSize(new Dimension(900,500));
		      //c.add(Tab);
		
		      
		    //예약 고객 조회 생성----------------------1번 
		       lblName1 = new JLabel("이름");
		       txtName1 = new JTextField(5);
		       lblphoneNum1 = new JLabel("핸드폰번호");
		       txtphoneNum1 = new JTextField(10);
		       lblReserveNum = new JLabel("예약번호");
		       txtReserveNum = new JTextField(10);
		      // lblbirth1 = new JLabel("생년월일");
		       //txtbirth1 = new JTextField(10);
		       //lblgender1 = new JLabel("성별");
		       //rdMan1 = new JRadioButton("남");
		       //rdWoman1 = new JRadioButton("여");

		       //이벤트 처리 
		       btnCheck1 = new JButton("조회");  
		     
		       
		       
		       
		       //==============================================1번 
		       jp1_1.setLayout(new GridLayout(1,7));
		       jp1_1.add(lblReserveNum);
		       jp1_1.add(txtReserveNum);
		       jp1_1.add(lblName1);
		       jp1_1.add(txtName1);
		       jp1_1.add(lblphoneNum1);
		       jp1_1.add(txtphoneNum1);
		       //jp1_1.add(lblbirth1);
		       //jp1_1.add(txtbirth1);
		       //jp1_1.add(lblgender1);
		       //jp1_1.add(rdMan1);
		       //jp1_1.add(rdWoman1);
		       jp1_1.add(btnCheck1);
		       jp1_1.setPreferredSize(new Dimension(800,40));
		       
		       jp1.add(jp1_1);
		       
		       
		       dtm = new DefaultTableModel(new Object[][] { { }}, objColNms);
		       table_1 = new JTable(dtm);
		       scroll_1 = new JScrollPane(table_1);
		       
		       jp1.add(scroll_1);

		       Panel p1 = new Panel();
		       p1.setBounds(0, 517, 470, 33);
		       p1.setLayout(null);
		   
		       
		       jp1.add(p1,BorderLayout.AFTER_LAST_LINE);
	 
		       scroll_1.setPreferredSize(new Dimension(900,500));
		       jp1.setVisible(true);
		       add(jp1);
		       btnCheck1.addActionListener(new event_tab1(this));
		       
		       
		      
		       
		       
		      
		      
	   }
	   
	   
	   
	   

}
