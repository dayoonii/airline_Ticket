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
//����� ���� �� 1 
//������ ������ 
public class Manager_tab1 extends JPanel{
	
	// JTabbedPane Tab;
	
	 //�������ȸ �г�----------------------------------------1�� 
	   
	   JPanel jp1;     //�������ȸ �г�
	   JPanel jp1_1;   //�������ȸ ���κ��г� 
	   
	   public JTextField txtName1;
	   public JTextField txtReserveNum;
	   
	   JTextField txtphoneNum1;
	   //JTextField txtbirth1;     //������ȸ������ 
	   
	   public JButton btnCheck1;
	   
	   //JRadioButton rdMan1;
	   //JRadioButton rdWoman1;
	   //ButtonGroup btnGroup1; //���� ������ư  
	   
	   JLabel lblName1;
	   JLabel lblphoneNum1;
	   JLabel lblReserveNum;
	   //JLabel lblbirth1;
	   //JLabel lblgender1;
	   
	   JTable table_1;
	   JScrollPane scroll_1;
	   
	   
	   DefaultTableModel dtm;
	
	   
	   private Object[] objColNms = new Object[] { "�����ȣ","�̸�", "��¥", "�ð�", "�����","������","�¼����","�⳻��","�ʰ���ȭ��" };
	   
	  
	   
	   public Manager_tab1() {
		   //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     
		    //  setSize(1000,600);
		     // setVisible(true);
		      
		      
		      
		      
		    //�������ȸ========
		      jp1 = new JPanel();
	          jp1_1 = new JPanel();
		   
	        //  Container c = getContentPane();
		     // c.setLayout(new FlowLayout());
		     // Tab = new JTabbedPane();      //�ǻ���
		     // Tab.add("�������ȸ", jp1);
		      jp1.setPreferredSize(new Dimension(900,500));
		      //c.add(Tab);
		
		      
		    //���� �� ��ȸ ����----------------------1�� 
		       lblName1 = new JLabel("�̸�");
		       txtName1 = new JTextField(5);
		       lblphoneNum1 = new JLabel("�ڵ�����ȣ");
		       txtphoneNum1 = new JTextField(10);
		       lblReserveNum = new JLabel("�����ȣ");
		       txtReserveNum = new JTextField(10);
		      // lblbirth1 = new JLabel("�������");
		       //txtbirth1 = new JTextField(10);
		       //lblgender1 = new JLabel("����");
		       //rdMan1 = new JRadioButton("��");
		       //rdWoman1 = new JRadioButton("��");

		       //�̺�Ʈ ó�� 
		       btnCheck1 = new JButton("��ȸ");  
		     
		       
		       
		       
		       //==============================================1�� 
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
