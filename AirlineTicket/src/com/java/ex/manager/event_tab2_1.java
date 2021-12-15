package com.java.ex.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java.ex.DB.AllmemberDAO;
import com.java.ex.DB.AllmemberDTO;
//조회버튼 누르면 텍스트에 입력한 회원 정보 나오게하기 
@SuppressWarnings("serial")
public class event_tab2_1 extends JPanel implements ActionListener {
	Manager_tab2 b;
	JTextField txtName2;
	JTextField txtID2;
	// JButton btnAll2;
	JButton btnCheck2;
	DefaultTableModel dtm;
	String name = "";
	String ID = "";

	public event_tab2_1(Manager_tab2 b) {
		this.b = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AllmemberDAO dao = new AllmemberDAO();
		if(e.getSource() == b.btnCheck2) {
			int sum =b.dtm.getRowCount();
			for(int i = 0; i<sum; i++) {
				b.dtm.removeRow(0);
			}
//			if(b.txtName2.getText().equals("")) {
//				JOptionPane.showMessageDialog(null,"값을 입력하세요");
//			}
//			else {
				name = b.txtName2.getText();
				ID=b.txtID2.getText();
				System.out.println(name);
				
				//b = new Manager_tab2();
				ArrayList<AllmemberDTO> dtos = dao.partSelect(name, ID);
				
				for(int i =0; i< dtos.size(); i++) {
				 AllmemberDTO S_2 = dtos.get(i);
				 b.dtm.addRow(new Object[] { S_2.getName(), S_2.getID(),S_2.getHP(),S_2.getTotal_boarding(),S_2.getTotal_price(),S_2.
				 getMileage()}); }
				 
				
//			}
			
			
		}
	}

}
