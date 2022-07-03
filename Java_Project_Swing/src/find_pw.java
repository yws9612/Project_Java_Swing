import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class find_pw extends JFrame {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	ImageIcon buttonimg1 = new ImageIcon("image/65_30_button.png");
	ImageIcon buttonimg2 = new ImageIcon("image/65_30_button_select.png");

	JTextField id_field = new JTextField();
	JTextField name_field = new JTextField();
	JTextField email_field = new JTextField();

	String id, name, email, pw;

	JLabel id_label = new JLabel("아이디");
	JLabel name_label = new JLabel("이름");
	JLabel email_label = new JLabel("이메일");
	JLabel result = new JLabel();

	JButton find = new JButton("찾기", buttonimg1);
	JButton close = new JButton("닫기", buttonimg1);

	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/find_pw_background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};

	public find_pw() {
		Container c = getContentPane();

		c.setLayout(null);

		id_label.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		id_label.setForeground(Color.white);
		id_label.setLocation(30, 80);
		id_label.setSize(60, 30);
		c.add(id_label);

		id_field.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		id_field.setLocation(90, 80);
		id_field.setSize(180, 30);
		c.add(id_field);

		name_label.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		name_label.setForeground(Color.white);
		name_label.setLocation(30, 125);
		name_label.setSize(60, 30);
		c.add(name_label);

		name_field.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		name_field.setLocation(90, 125);
		name_field.setSize(180, 30);
		c.add(name_field);

		email_label.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		email_label.setForeground(Color.white);
		email_label.setLocation(30, 170);
		email_label.setSize(60, 30);
		c.add(email_label);

		email_field.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		email_field.setLocation(90, 170);
		email_field.setSize(180, 30);
		c.add(email_field);

		find.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		find.setLocation(280, 170);
		find.setSize(65, 30);
		find.setHorizontalTextPosition(JButton.CENTER);
		find.setRolloverIcon(buttonimg2);
		find.setBorderPainted(false);
		find.setContentAreaFilled(false);
		find.setFocusPainted(false);
		c.add(find);

		result.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setForeground(Color.white);
		result.setLocation(30, 215);
		result.setSize(315, 50);
		c.add(result);

		close.setFont(new Font("DungGeunMo", Font.PLAIN, 13));
		close.setLocation(280, 280);
		close.setSize(65, 30);
		close.setHorizontalTextPosition(JButton.CENTER);
		close.setRolloverIcon(buttonimg2);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		c.add(close);

		// 찾기버튼
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = Connect.get();
				id = id_field.getText();
				name = name_field.getText();
				email = email_field.getText();

				ArrayList<FindUser> listpw = new ArrayList<>();

				if (id.equals("") || name.equals("") || email.equals("")) {
					String alert1 = "아이디, 이름 또는 이메일을";
					String alert2 = "모두 입력해 주세요.";
					result.setText("<html><body><center>" + alert1 + "<br>" + alert2 + "</body><html>");
				} else {
					try {
						String que = "select id, pw, name, email from member where enable = 'Y'";
						psmt = conn.prepareStatement(que);
						rs = psmt.executeQuery();

						while (rs.next()) {
							FindUser findpw = new FindUser();
							findpw.setId(rs.getString("id"));
							findpw.setName(rs.getString("name"));
							findpw.setEmail(rs.getString("email"));
							findpw.setPw(rs.getString("pw"));
							listpw.add(findpw);
						}

						for (int i = 0; i < listpw.size(); i++) {
							String getname = listpw.get(i).getName();
							String getemail = listpw.get(i).getEmail();
							String getid = listpw.get(i).getId();
							String getpw = listpw.get(i).getPw();
							if (name.equals(getname) && email.equals(getemail) && id.equals(getid)) {
								System.out.println(getpw);
								result.setText("비밀번호 : " + getpw);
								break;
							} else if (!name.equals(getname) || !email.equals(getemail) || !id.equals(getid)) {
								String alert1 = "아이디, 이름 또는 이메일을";
								String alert2 = "다시 한 번 확인해 주세요.";
								result.setText("<html><body><center>" + alert1 + "<br>" + alert2 + "</body><html>");
							}
						}

					} catch (Exception exe) {
						String alert1 = "아이디, 이름 또는 이메일을";
						String alert2 = "다시 한 번 확인해 주세요.";
						result.setText("<html><body><center>" + alert1 + "<br>" + alert2 + "</body><html>");
					}
				}
			}
		});

		// 닫기버튼
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				find.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				find.setForeground(Color.black);
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

		setSize(390, 370);

		background.setLayout(null);
		background.setBounds(0, 0, 390, 370);
		add(background);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new find_pw();
	}

}
