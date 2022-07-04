import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class ManageW2 extends JFrame {
	
	ImageIcon buttonimg1 = new ImageIcon("image/70_30_button.png");
	ImageIcon buttonimg2 = new ImageIcon("image/70_30_button_select.png");
	
	Connect conn = new Connect();
	JTable jtb;
	Object obj[][] = new Object[0][7];
	DefaultTableModel model;
	JScrollPane js;
	String column[] = { "선택", "단어번호", "단어", "뜻"};
	JButton addButton = new JButton("추가",buttonimg1);
	JButton del = new JButton("삭제",buttonimg1);
	JButton close = new JButton("닫기",buttonimg1);
	JLabel jl_w2 = new JLabel("단어 : ");
	JTextField jf_w2 = new JTextField(20);
	JLabel jl_w2_h = new JLabel("뜻 : ");
	JTextField jf_w2_h = new JTextField(40);
	Connection conne = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};
	
	JLabel title = new JLabel("순화어 관리");
	

	ManageW2() {
		setLayout(null);

		Container c = getContentPane();
		model = new DefaultTableModel(obj, column);
		jtb = new JTable(model);
		js = new JScrollPane(jtb);

		conne = conn.get();

		try {
			String que = "select * from w2_table order by w2_no";
			pstmt = conne.prepareStatement(que);
			rs = pstmt.executeQuery();
			
			
			jtb.getColumn("선택").setCellRenderer(dtcr);
			JCheckBox c_box = new JCheckBox();
			jtb.getColumn("선택").setCellEditor(new DefaultCellEditor(c_box));
			jtb.getColumn("선택").setPreferredWidth(40);
			jtb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			c_box.setHorizontalAlignment(JLabel.CENTER);

			Gs gs = new Gs();

			while (rs.next()) {
				int s_w2_no = rs.getInt(1);
				String s_w2 = rs.getString(2);
				String s_w2_h = rs.getString(3);

				Object data[] = { false, s_w2_no, s_w2, s_w2_h };
				model.addRow(data);
				System.out.println(
						s_w2_no + " " + s_w2 + " " + s_w2_h);

			}
			
			del.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (c_box.isSelected()) {
						int answer = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
						int row = jtb.getSelectedRow();
						for (int i = 0; i < jtb.getColumnCount(); i++) {
							System.out.println(jtb.getModel().getValueAt(row, i));
						}
						if (answer == JOptionPane.YES_OPTION) {
							try {
								String quer = "delete w2_table where w2_no = ?";
								pstmt = conne.prepareStatement(quer);
								int index = jtb.getSelectedRow();
								int w2_no = (int)jtb.getModel().getValueAt(index, 1);
								pstmt.setInt(1,  w2_no);
								int n = pstmt.executeUpdate();
								System.out.println(n > 0 ? "성공" : "실패");
								//테이블 리셋하기
								model.setNumRows(0);
								//다시 테이블 조회
								String que = "select * from w2_table order by w2_no";
								pstmt = conne.prepareStatement(que);
								rs = pstmt.executeQuery();
								while (rs.next()) {
									int s_w2_no = rs.getInt(1);
									String s_w2 = rs.getString(2);
									String s_w2_h = rs.getString(3);

									Object data[] = { false, s_w2_no, s_w2, s_w2_h };
									model.addRow(data);
									System.out.println(
											s_w2_no + " " + s_w2 + " " + s_w2_h);

								}
								
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
					String w2_add = jf_w2.getText();
					String w2_h_add = jf_w2_h.getText();
					System.out.println(w2_add + " "+ w2_h_add);
					
					if(w2_add != null) {
						int answer = JOptionPane.showConfirmDialog(null, "추가하시겠습니까?", "추가", JOptionPane.YES_NO_OPTION);
						if (answer == JOptionPane.YES_OPTION) {
							try {
								String quer = "insert into w2_table values (w2_sq.nextval,'"+w2_add+"','"+w2_h_add+"')";
								pstmt = conne.prepareStatement(quer);
								int a = pstmt.executeUpdate();
								System.out.println("성공"+a);
								//테이블 리셋하기
								model.setNumRows(0);
								//다시 테이블 조회
								String que = "select * from w2_table order by w2_no";
								pstmt = conne.prepareStatement(que);
								rs = pstmt.executeQuery();
								while (rs.next()) {
									int s_w2_no = rs.getInt(1);
									String s_w2 = rs.getString(2);
									String s_w2_h = rs.getString(3);

									Object data[] = { false, s_w2_no, s_w2, s_w2_h };
									model.addRow(data);
									System.out.println(
											s_w2_no + " " + s_w2 + " " + s_w2_h);

								}
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
		jl_w2.setBounds(100,510,50,30);
		jl_w2.setForeground(Color.white);
		jf_w2.setBounds(150,510,150,30);
		jl_w2_h.setBounds(310,510,40,30);
		jl_w2_h.setForeground(Color.white);
		jf_w2_h.setBounds(340,510,220,30);
		addButton.setBounds(570, 510, 70, 30);
		del.setBounds(650, 510, 70, 30);
		close.setBounds(730,510,70,30);
		jl_w2.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		jf_w2.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		jl_w2_h.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		jf_w2_h.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		addButton.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		addButton.setHorizontalTextPosition(JButton.CENTER);
		addButton.setRolloverIcon(buttonimg2);
		addButton.setBorderPainted(false);
		addButton.setContentAreaFilled(false);
		addButton.setFocusPainted(false);
		addButton.setForeground(Color.black);
		del.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		del.setHorizontalTextPosition(JButton.CENTER);
		del.setRolloverIcon(buttonimg2);
		del.setBorderPainted(false);
		del.setContentAreaFilled(false);
		del.setFocusPainted(false);
		del.setForeground(Color.black);
		close.setFont(new Font("DungGeunMo",Font.PLAIN,12));
		close.setHorizontalTextPosition(JButton.CENTER);
		close.setRolloverIcon(buttonimg2);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		close.setForeground(Color.black);
		title.setBounds(300,30,300,50);
		title.setFont(new Font("DungGeunMo",Font.PLAIN,40));
		title.setForeground(Color.white);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(title);
		
		

		c.add(js);
		c.add(del);
		c.add(close);
		c.add(addButton);
		c.add(jl_w2);
		c.add(jf_w2);
		c.add(jl_w2_h);
		c.add(jf_w2_h);
		
		addButton.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			addButton.setForeground(Color.white);
			    }
			 @Override
			public void mouseExited(MouseEvent e) {
			addButton.setForeground(Color.black);
			    }
			});
		
		del.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			del.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			del.setForeground(Color.black);
			    }
			});
		
		close.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			close.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			close.setForeground(Color.black);
			    }
			});
		
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
		new ManageW2();
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
