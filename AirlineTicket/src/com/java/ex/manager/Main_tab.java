package com.java.ex.manager;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Main_tab extends JFrame{
	
	JTabbedPane T;
	public Manager_tab1 tab1;
	public Manager_tab2 tab2;
	
	public Main_tab() {
		
		T=new JTabbedPane();
		
		tab1 = new Manager_tab1();
		tab2 = new Manager_tab2();
		
		T.add("�������ȸ",tab1);
		T.add("��������ȸ",tab2);
		
		add(T);
		 setTitle("������");
		 setSize(1000,800);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      setVisible(true);
	 
	      
	    
	}
}
