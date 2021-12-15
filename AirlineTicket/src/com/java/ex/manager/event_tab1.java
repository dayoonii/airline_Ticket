package com.java.ex.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java.ex.DB.reserveDAO;
import com.java.ex.DB.reserveDTO;

@SuppressWarnings("serial")
public class event_tab1 extends JPanel implements ActionListener {
	Manager_tab1 a;
	JTextField txtName1;
	JTextField txtReserveNum;
	JTextField txtphoneNum1;
	DefaultTableModel dtm;
	String reserve_id ="";
	String name1="";
	String hp="";

	public event_tab1(Manager_tab1 a) {
		this.a = a;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		reserveDAO dao = new reserveDAO();
		if (e.getSource() == a.btnCheck1) {
			int sum = a.dtm.getRowCount();
			for (int i = 0; i < sum; i++) {
				a.dtm.removeRow(0);
			}
			if (a.txtReserveNum.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "값을 입력하세요");
				// System.out.println();
			}

			else {

				reserve_id = a.txtReserveNum.getText();
				name1=a.txtName1.getText();
				hp=a.txtphoneNum1.getText();
				System.out.println(reserve_id);

				ArrayList<reserveDTO> dtos = dao.reserveSelect(reserve_id, name1, hp);

				for (int i = 0; i < dtos.size(); i++) {
					reserveDTO S_1 = dtos.get(i);
					a.dtm.addRow(
							new Object[] { S_1.getReserve_id(), S_1.getName(), S_1.getDepartdate(), S_1.getDepartTime(),
									S_1.getDepart(), S_1.getArrive(), S_1.getSeatLevel(),S_1.getMeal(), S_1.getBaggage() });

				}

			}

		}

	}

}
