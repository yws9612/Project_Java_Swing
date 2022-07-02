import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class ManageW1 extends JFrame {

	Connect conn = new Connect();
	JTable jtb;
	Object obj[][] = new Object[0][7];
	DefaultTableModel model;
	JScrollPane js;
	String column[] = { "선택", "단어번호", "단어", "뜻"};
	JButton addButton = new JButton("추가");
	JButton del = new JButton("삭제");
	JButton close = new JButton("닫기");
	JLabel jl_w1 = new JLabel("단어 : ");
	JTextField jf_w1 = new JTextField(20);
	JLabel jl_w1_h = new JLabel("뜻 : ");
	JTextField jf_w1_h = new JTextField(40);
	Connection conne = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};
	JLabel title = new JLabel("순우리말 관리");
	
	

	ManageW1() {
		setLayout(null);

		Container c = getContentPane();
		model = new DefaultTableModel(obj, column);
		jtb = new JTable(model);
		js = new JScrollPane(jtb);

		conne = conn.get();

		try {
			String que = "select * from w1_table order by w1_no";
			pstmt = conne.prepareStatement(que);
			rs = pstmt.executeQuery();

			jtb.getColumn("선택").setCellRenderer(dtcr);
			JCheckBox c_box = new JCheckBox();
			jtb.getColumn("선택").setCellEditor(new DefaultCellEditor(c_box));
			jtb.getColumn("선택").setPreferredWidth(40);
			c_box.setHorizontalAlignment(JLabel.CENTER);
			
			

			Gs gs = new Gs();

			while (rs.next()) {
				int s_w1_no = rs.getInt(1);
				String s_w1 = rs.getString(2);
				String s_w1_h = rs.getString(3);

				Object data[] = { false, s_w1_no, s_w1, s_w1_h };
				model.addRow(data);
				System.out.println(
						s_w1_no + " " + s_w1 + " " + s_w1_h);

			}
			
			del.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (c_box.isSelected()) {
						int answer = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);						
						if (answer == JOptionPane.YES_OPTION) {
							try {
								String quer = "delete w1_table where w1_no = ?";
								pstmt = conne.prepareStatement(quer);
								int index = jtb.getSelectedRow();
								int w1_no = (int)jtb.getModel().getValueAt(index, 1);
								pstmt.setInt(1,  w1_no);
								int n = pstmt.executeUpdate();
								System.out.println(n > 0 ? "성공" : "실패");
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
			close.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new ManagerChoice();
					dispose();
				}
				
			});
			
			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String w1_add = jf_w1.getText();
					String w1_h_add = jf_w1_h.getText();
					System.out.println(w1_add + " "+ w1_h_add);
					
					if(w1_add != null) {
						int answer = JOptionPane.showConfirmDialog(null, "추가하시겠습니까?", "추가", JOptionPane.YES_NO_OPTION);
						if (answer == JOptionPane.YES_OPTION) {
							try {
								String quer = "insert into w1_table values (w1_sq.nextval,'"+w1_add+"','"+w1_h_add+"')";
								pstmt = conne.prepareStatement(quer);
								int a = pstmt.executeUpdate();
								System.out.println("성공"+a);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						}
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
		js.setBounds(100, 100, 700, 400);
		jl_w1.setBounds(100,510,50,30);
		jf_w1.setBounds(150,510,150,30);
		jl_w1_h.setBounds(310,510,40,30);
		jf_w1_h.setBounds(340,510,220,30);
		addButton.setBounds(570, 510, 70, 30);
		del.setBounds(650, 510, 70, 30);
		close.setBounds(730,510,70,30);
		jl_w1.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		jf_w1.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		jl_w1_h.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		jf_w1_h.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		addButton.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		del.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		close.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		title.setBounds(300,30,300,50);
		title.setFont(new Font("DungGeunMo",Font.PLAIN,40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(title);
		

		c.add(js);
		c.add(del);
		c.add(close);
		c.add(addButton);
		c.add(jl_w1);
		c.add(jf_w1);
		c.add(jl_w1_h);
		c.add(jf_w1_h);
		
		setSize(900,640);
		
		background.setLayout(null);
		background.setBounds(0, 0, 900, 640);
		add(background);

		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManageW1();
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
