package com.java.ex.manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.java.ex.DB.AllmemberDAO;
import com.java.ex.DB.AllmemberDTO;
import com.java.ex.DB.PassengerDAO;
import com.java.ex.DB.PassengerDTO;

public class Manager_tab2 extends JPanel {

	// JTabbedPane Tab;

	Member_Modify Member_Modify;

	// 고객정보조회 패널------------------------------------2번

	JPanel jp2; // 고객정보조회 패널
	JPanel jp2_1; // 고객정보조회 패널 1
	JPanel jp2_2; // 고객정보조회 패널 2

	JTextField txtName2;
	// JTextField txtphoneNum2;
	JTextField txtID2;

	// JComboBox<String> cmbNation2;
	// String[] cmb2 = {"한국", "중국", "미국"};
	JButton btnAll2;
	JButton btnCheck2;

	JLabel lblName2;
	// JLabel lblphoneNum2;
	JLabel lblId2;
	// JLabel lblNation2;
	// JLabel lblgender2;

	// JRadioButton rdMan2;
	// JRadioButton rdWoman2;

	JTable table_2;
	JScrollPane scroll_2;

	// ===================================================
	Object[] objColNms2 = new Object[] { "이름", "아이디", "핸드폰", "탑승누적횟수", "총 금액", "마일리지", "수정" };

	DefaultTableModel dtm = new DefaultTableModel(objColNms2, 0);

	public Manager_tab2() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			      setTitle("관리자");
//			      setSize(1000,600);
//			      setVisible(true);
//			      

		// 전체고객정보조회========

		jp2 = new JPanel();
		jp2_1 = new JPanel();
		jp2_2 = new JPanel();

		// Container c = getContentPane();
		// c.setLayout(new FlowLayout());
		// Tab = new JTabbedPane(); //탭생성
		jp2.setPreferredSize(new Dimension(900, 500));
		// Tab.add("고객정보조회", jp2);

		// c.add(Tab);

		// ===============================================2번

		lblName2 = new JLabel("이름");
		txtName2 = new JTextField(5);
		// lblphoneNum2 = new JLabel("핸드폰번호");
		// txtphoneNum2 = new JTextField(10);
		lblId2 = new JLabel("아이디");
		txtID2 = new JTextField(10);
		// lblNation2 = new JLabel("국적");
		// lblgender2 = new JLabel("성별");
		// rdMan2 = new JRadioButton("남");
		// rdWoman2 = new JRadioButton("여");
		btnAll2 = new JButton("모든고객조회");
		btnCheck2 = new JButton("조회");
		// cmbNation2 = new JComboBox<String>(cmb2);
		btnCheck2.addActionListener(new event_tab2_1(this));
		btnAll2.addActionListener(new event_tab2(this));

		// ==========================================

		jp2_1 = new JPanel();
		jp2_1.setLayout(new GridLayout(1, 2));
		jp2_1.add(lblName2);
		jp2_1.add(txtName2);
		jp2_1.add(lblId2);
		jp2_1.add(txtID2);
		// jp2_1.add(lblphoneNum2);
		// jp2_1.add(txtphoneNum2);
		// jp2_1.add(lblgender2);
		// jp2_1.add(rdMan2);
		// jp2_1.add(rdWoman2);

		jp2_1.setPreferredSize(new Dimension(400, 40));

		jp2.add(jp2_1);

		// =============================================

		jp2_2.setLayout(new GridLayout(1, 2));

		// jp2_2.add(lblNation2);
		// jp2_2.add(cmbNation2);
		jp2_2.add(btnCheck2);
		jp2_2.add(btnAll2);
		jp2_2.setPreferredSize(new Dimension(600, 40));
		jp2.add(jp2_2);

		// =================================================================
//
//		dtm = new DefaultTableModel(objColNms2, 0);
//		
//		
//		AllmemberDAO eventDao2 = new AllmemberDAO();
//		ArrayList<AllmemberDTO> dto;
//		dto = eventDao2.partSelet(name, ID);
//		int rowCount 
//
//		for (int i = 0; i < dtos.size(); i++) {
//
//		}

		table_2 = new JTable(dtm);

		scroll_2 = new JScrollPane(table_2);

		table_2.getColumnModel().getColumn(6).setCellRenderer(new TableCell(table_2));
		table_2.getColumnModel().getColumn(6).setCellEditor(new TableCell(table_2));
		jp2.add(scroll_2);

		Panel p2 = new Panel();
		p2.setBounds(0, 517, 470, 33);
		p2.setLayout(null);

		jp2.add(p2, BorderLayout.AFTER_LAST_LINE);

		scroll_2.setPreferredSize(new Dimension(900, 500));
		jp2.setVisible(true);
		add(jp2);

	}

} // end public void JTableRemoveRow()

class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	JButton btn_Update;
	JTable table;
	
	public TableCell(JTable t) {
		this.table = t;
		btn_Update = new JButton("수정하기");
		// btn_Update.addActionListener(new event_tab1());
		btn_Update.addActionListener(e -> {

			if (e.getSource() == btn_Update) {
				
				int sel = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object[] result = new Object[model.getColumnCount()];
				for(int i = 0; i < model.getColumnCount()-1; i++) {
					result[i] = model.getValueAt(sel,i);
				}
				
				PassengerDAO dao = new PassengerDAO();
				PassengerDTO dto = dao.btnModify(result[1].toString(), result[0].toString());
				
				Member_Modify Member_Modify = new Member_Modify();
				Member_Modify.txtName.setText(dto.getName());
				Member_Modify.txtID.setText(dto.getId());
				Member_Modify.txtPW.setText(dto.getPw());
				Member_Modify.txtphoneNum.setText(dto.getHp());
				Member_Modify.txtEmail.setText(dto.getEmail());
				Member_Modify.txtAddress.setText(dto.getAddress());
				
//				for (int i = 0; i < dtos.size(); i++) {
//					PassengerDTO dto = dtos.get(i);
//
//					Member_Modify.txtName.setText(dto.getName());
//					Member_Modify.txtID.setText(dto.getId());
//					Member_Modify.txtPW.setText(dto.getPw());
//					Member_Modify.txtphoneNum.setText(dto.getHp());
//					Member_Modify.txtEmail.setText(dto.getEmail());
//					Member_Modify.txtAddress.setText(dto.getAddress());
//
//				}
//				dtos = dao.pSelect();

				 Member_Modify.setVisible(true);

			}

		});
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table_2, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return btn_Update;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table_2, Object value, boolean isSelected, int row,
			int column) {
		return btn_Update;
	}
} // end class TableCell extends AbstractCellEditor implements TableCellEditor,
	// TableCellRenderer
