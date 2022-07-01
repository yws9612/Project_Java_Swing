import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

public class ManageMember extends JFrame {

	Connect conn = new Connect();
	JTable jtb;
	Object obj[][] = new Object[0][7];
	DefaultTableModel model;
	JScrollPane js;
	String column[] = { "선택", "회원번호", "ID", "PW", "이름", "이메일", "가입일", "최근접속일" };
	JButton del = new JButton("삭제");
	JButton exit = new JButton("닫기");
	JButton allsel = new JButton("전체 선택");
	JButton alldis = new JButton("전체 해제");

	Connection conne = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	ManageMember() {
		setLayout(null);
		setBounds(500, 100, 450, 300);

		Container c = getContentPane();
		model = new DefaultTableModel(obj, column);
		jtb = new JTable(model);
		js = new JScrollPane(jtb);

		conne = conn.get();

		// sql
		try {
			String query1 = "select * from member natural join manager where enable ='Y' order by m_no";
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
				java.sql.Date r_date = rs.getDate(8);
				java.sql.Date l_date = rs.getDate(9);

				Object data[] = { false, s_no, s_id, s_pw, s_name, s_email, r_date, l_date };
				model.addRow(data);
				System.out.println(s_no + " " + s_id + " " + s_pw + " " + s_name + " " + s_email + " " + r_date + " " + l_date);
			}

			del.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (c_box.isSelected()) {
						int answer = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
						if (answer == JOptionPane.YES_OPTION) {
							try {
								String quer = "update member set enable = 'N' where m_no = ?";
								pstmt = conne.prepareStatement(quer);
								int index = jtb.getSelectedRow();
								int mem_no = (int) jtb.getModel().getValueAt(index, 1);
								pstmt.setInt(1, mem_no);
								int n = pstmt.executeUpdate();
								System.out.println(n > 0 ? "성공" : "실패");

							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					}
				}

			});

			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new ManagerChoice();
					dispose();
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
		js.setBounds(60, 100, 700, 500);
		del.setBounds(590, 620, 75, 45);
		exit.setBounds(680, 620, 75, 45);
		allsel.setBounds(60, 20, 75, 30);
		alldis.setBounds(150, 20, 75, 30);

		setSize(850, 750);
		
		c.add(js);
		c.add(del);
		c.add(exit);
		

		setResizable(false);
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
