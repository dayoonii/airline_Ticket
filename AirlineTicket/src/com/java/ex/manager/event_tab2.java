package com.java.ex.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java.ex.DB.AllmemberDAO;
import com.java.ex.DB.AllmemberDTO;
//tab2에서 ALL버튼 누르면 모든 정보 출력하게 하는 이벤트 
public class event_tab2 extends JPanel implements ActionListener{
	Manager_tab2 b;
	JTextField txtName2;
	JTextField txtID2;
	JButton btnAll2;
	JButton btnCheck2;
	DefaultTableModel dtm;
	
	public event_tab2(Manager_tab2 b) {
		this.b = b;
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		AllmemberDAO dao = new AllmemberDAO();
		
		if(e.getSource() == b.btnAll2) {
			int sum = b.dtm.getRowCount();
			for (int i = 0; i < sum; i++) {
				b.dtm.removeRow(0);
			}
			ArrayList<AllmemberDTO> dtos = dao.allSelect();
			
	
			for(int i = 0; i < dtos.size(); i++) {
				AllmemberDTO S_2 = dtos.get(i);
				b.dtm.addRow(new Object[] {
					S_2.getName(), S_2.getID(),S_2.getHP(),S_2.getTotal_boarding(),S_2.getTotal_price(),S_2.getMileage() });
			}
			
		}
	}
	
}
