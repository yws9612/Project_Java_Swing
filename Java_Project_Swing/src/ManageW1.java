import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

public class ManageW1 extends JFrame{

	Connect conn = new Connect();
	JTable jtb;
	Object obj [][] = new Object[0][7];
	DefaultTableModel model;
	JScrollPane js;
	String column[] = {"선택", "회원번호", "ID", "PW", "이름", "이메일", "가입일", "최근접속일"};
	JButton del;
	Connection conne = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	

	ManageW1(){
		setLayout(null);
		
		Container c = getContentPane();
		model = new DefaultTableModel(obj, column);
		jtb = new JTable(model);
		js = new JScrollPane(jtb);
		
		js.setBounds(250, 250, 700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		conne = conn.get();
		
		//sql
		try {
			String query = "select * from member natural join manager order by m_no";
			pstmt=conne.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			jtb.getColumn("선택").setCellRenderer(dtcr);
			JCheckBox c_box = new JCheckBox();
			jtb.getColumn("선택").setCellEditor(new DefaultCellEditor(c_box));
			jtb.getColumn("선택").setPreferredWidth(40);
			c_box.setHorizontalAlignment(JLabel.CENTER);
			
//			while(rs.next()) {
//				int m_no = rs.getInt(1);
//				String s_id = rs.getString(2); //s_id = sql_id
//				String s_pw = rs.getString(3);
//				String s_name = rs.getString(4);
//				String s_email = rs.getString(5);
//				java.sql.Date r_date = rs.getDate(7);
//				java.sql.Date l_date = rs.getDate(8);
//				
//				Object data[] = {false, m_no, s_id, s_pw, s_name, s_email, r_date, l_date};
//				model.addRow(data);
//				System.out.println(m_no + " " + s_id + " " + s_pw + " " + s_name + " " + s_email + " " + r_date + " " + l_date);
//				if(c_box.isSelected()) {
//					del.addActionListener(new ActionListener() {
//
//						@Override
//						public void actionPerformed(ActionEvent arg0) {
//							// TODO Auto-generated method stub
//							
//						}
//						
//					});
//				}
//			}
		}catch(Exception e_sql) {
			System.out.println("Select Error" + e_sql);
		}
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) { 
				try {
					if(rs!=null) {
						rs.close();
					}if(pstmt != null) {
						pstmt.close();
					}if(conne != null) {
						conne.close();
					}
						
					}catch(Exception e2) {
						System.exit(DISPOSE_ON_CLOSE);		
					}
				}
			});
		
		
		c.add(js);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManageW1();			
	}
	
//		int answer = JOptioinPane.showConfirmDialog(this,"삭제하시겠습니까?","confirm",JOptionPane.YES_NO_OPTION);
//		if(answer==JOptionPane.YES_OPTION) {
//			System.out.println("가 삭제되었습니다.");
//		}
//	}
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent
		(JTable table, Object value, boolean hasFocus, boolean isSelected, int row, int column) {
			JCheckBox c_box = new JCheckBox();
			c_box.setSelected(((Boolean)value).booleanValue());
			c_box.setHorizontalAlignment(JLabel.CENTER);
			
			return c_box;
		}
	};
}
