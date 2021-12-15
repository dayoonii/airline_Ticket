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
		
		T.add("예약고객조회",tab1);
		T.add("고객정보조회",tab2);
		
		add(T);
		 setTitle("관리자");
		 setSize(1000,800);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      setVisible(true);
	 
	      
	    
	}
}
