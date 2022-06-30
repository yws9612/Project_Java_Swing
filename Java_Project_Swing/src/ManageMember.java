import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class Gs {
	private int d_no;

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

}

class Delete extends JFrame{
	Connection conne = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connect conn = new Connect();
//	ManageMember mm = new ManageMember();
	Delete(){
		conne = conn.get();
		
		Gs gs = new Gs();
		int answer = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			try {
				String query2 = "select m_no from member order by m_no";
				pstmt = conne.prepareStatement(query2);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					gs.setD_no(rs.getInt(1));
				}
				String quer = "delete * from member where m_no = ?";
				pstmt.setInt(1,gs.getD_no());
				pstmt.executeUpdate(quer);
			} catch (Exception e) {
				System.out.println("삭제 쿼리문 오류" + e);
				e.printStackTrace();
			}
			System.out.println("회원이 삭제되었습니다.");
		} else {
			System.out.println("삭제를 취소하였습니다.");
		}
	}
}

public class ManageMember extends JFrame {

	Connect conn = new Connect();
	JTable jtb;
	Object obj[][] = new Object[0][7];
	DefaultTableModel model;
	JScrollPane js;
	String column[] = { "선택", "회원번호", "ID", "PW", "이름", "이메일", "가입일", "최근접속일" };
	JButton del = new JButton("삭제");
	Connection conne = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	ManageMember() {
		setLayout(null);

		Container c = getContentPane();
		model = new DefaultTableModel(obj, column);
		jtb = new JTable(model);
		js = new JScrollPane(jtb);

		conne = conn.get();

		// sql
		try {
			String query1 = "select * from member natural join manager order by m_no";
			pstmt = conne.prepareStatement(query1);
			rs = pstmt.executeQuery();

			jtb.getColumn("선택").setCellRenderer(dtcr);
			JCheckBox c_box = new JCheckBox();
			jtb.getColumn("선택").setCellEditor(new DefaultCellEditor(c_box));
			jtb.getColumn("선택").setPreferredWidth(40);
			c_box.setHorizontalAlignment(JLabel.CENTER);

			Gs gs = new Gs();

			while (rs.next()) {
				int s_no = rs.getInt(1);
				String s_id = rs.getString(2); // s_id = sql_id
				String s_pw = rs.getString(3);
				String s_name = rs.getString(4);
				String s_email = rs.getString(5);
				java.sql.Date r_date = rs.getDate(7);
				java.sql.Date l_date = rs.getDate(8);

				Object data[] = { false, s_no, s_id, s_pw, s_name, s_email, r_date, l_date };
				model.addRow(data);
				System.out.println(s_no +" " + s_id + " " + s_pw + " " + s_name + " " + s_email + " " + r_date
						+ " " + l_date);

			}
			
			
			del.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (c_box.isSelected()) {
						Delete delete = new Delete();
					}
				}

			});

		} catch (Exception e_sql) {
			System.out.println("Select Error" + e_sql);
		}

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conne != null) {
						conne.close();
					}

				} catch (Exception e2) {
					System.exit(DISPOSE_ON_CLOSE);
				}
			}
		});
		js.setBounds(250, 250, 700, 500);
		del.setBounds(50, 50, 100, 100);

		c.add(js);
		c.add(del);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManageMember();
	}

	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean hasFocus, boolean isSelected,
				int row, int column) {
			JCheckBox c_box = new JCheckBox();
			c_box.setSelected(((Boolean) value).booleanValue());
			c_box.setHorizontalAlignment(JLabel.CENTER);

			return c_box;
		}
	};

}
