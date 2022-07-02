import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.*;

public class sign_up extends JFrame {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	CallableStatement cstmt = null;

	String id, pw, pw2, name, email;

	JTextField id_field = new JTextField();
	JPasswordField pw_field = new JPasswordField();
	JPasswordField pw2_field = new JPasswordField();
	JTextField name_field = new JTextField();
	JTextField email_field = new JTextField();

	JButton id_check = new JButton("아이디 확인");
	JButton pw_check = new JButton("비밀번호 확인");
	JButton email_check = new JButton("이메일 확인");
	JButton complete = new JButton("가입");

	JLabel title = new JLabel("회원가입");
	JLabel id_label = new JLabel("아이디");
	JLabel pw_label = new JLabel("비밀번호");
	JLabel pw2_label = new JLabel("비밀번호 확인");
	JLabel name_label = new JLabel("이름");
	JLabel email_label = new JLabel("이메일");
	JLabel id_checklabel = new JLabel();
	JLabel pw_checklabel = new JLabel();
	JLabel email_checklabel = new JLabel();
	JLabel last_checklabel = new JLabel();
	
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};

	public sign_up() {
		Container c = getContentPane();
		c.setLayout(null);

		title.setBackground(Color.ORANGE);
		title.setOpaque(true);
		title.setFont(new Font("DungGeunMo",Font.PLAIN,16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setLocation(30, 25);
		title.setSize(435, 40);
		c.add(title);

		id_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		id_label.setLocation(30, 80);
		id_label.setSize(100, 30);
		c.add(id_label);

		id_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		id_field.setLocation(140, 80);
		id_field.setSize(180, 30);
		c.add(id_field);

		id_checklabel.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		id_checklabel.setLocation(140, 110);
		id_checklabel.setSize(250, 30);
		c.add(id_checklabel);

		id_check.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		id_check.setSize(125, 30);
		id_check.setLocation(340, 80);
		c.add(id_check);

		pw_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		pw_label.setLocation(30, 150);
		pw_label.setSize(100, 30);
		c.add(pw_label);

		pw_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		pw_field.setLocation(140, 150);
		pw_field.setSize(180, 30);
		c.add(pw_field);

		pw2_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		pw2_label.setLocation(30, 185);
		pw2_label.setSize(100, 30);
		c.add(pw2_label);

		pw2_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		pw2_field.setLocation(140, 185);
		pw2_field.setSize(180, 30);
		c.add(pw2_field);

		pw_checklabel.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		pw_checklabel.setLocation(140, 215);
		pw_checklabel.setSize(250, 30);
		c.add(pw_checklabel);

		pw_check.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		pw_check.setSize(125, 30);
		pw_check.setLocation(340, 185);
		c.add(pw_check);

		name_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		name_label.setLocation(30, 255);
		name_label.setSize(100, 30);
		c.add(name_label);

		name_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		name_field.setLocation(140, 255);
		name_field.setSize(180, 30);
		c.add(name_field);

		email_label.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		email_label.setLocation(30, 295);
		email_label.setSize(100, 30);
		c.add(email_label);

		email_field.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		email_field.setLocation(140, 295);
		email_field.setSize(180, 30);
		c.add(email_field);

		email_checklabel.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		email_checklabel.setLocation(140, 325);
		email_checklabel.setSize(250, 30);
		c.add(email_checklabel);

		email_check.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		email_check.setSize(125, 30);
		email_check.setLocation(340, 295);
		c.add(email_check);

		complete.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		complete.setSize(65, 30);
		complete.setLocation(400, 365);
		c.add(complete);

		last_checklabel.setFont(new Font("DungGeunMo",Font.PLAIN,13));
		last_checklabel.setLocation(30, 365);
		last_checklabel.setSize(350, 30);
		c.add(last_checklabel);
		
		

		// 비밀번호 확인 순서대로 확인 버튼, pw2_field에서 엔터, 탭
		pw2_field.setFocusTraversalKeysEnabled(false);
		// 탭 눌렀을 때 커서 이동이 아닌 탭이 입력되게 하는 명령어
		pw_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw = pw_field.getText();
				pw2 = pw2_field.getText();
				if (pw.equals("") || pw2.equals("")) {
					pw_checklabel.setText("비밀번호를 입력하세요.");
				} else if (pw.equals(pw2)) {
					pw_checklabel.setText("확인");
				} else {
					pw_checklabel.setText("비밀번호가 다릅니다.");
				}
			}
		});
		pw2_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw = pw_field.getText();
				pw2 = pw2_field.getText();
				if (pw.equals("") || pw2.equals("")) {
					pw_checklabel.setText("비밀번호를 입력하세요.");
				} else if (pw.equals(pw2)) {
					pw_checklabel.setText("확인");
				} else {
					pw_checklabel.setText("비밀번호가 다릅니다.");
				}
			}
		});
		pw2_field.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					pw = pw_field.getText();
					pw2 = pw2_field.getText();
					if (pw.equals("") || pw2.equals("")) {
						pw_checklabel.setText("비밀번호를 입력하세요.");
					} else if (pw.equals(pw2)) {
						pw_checklabel.setText("확인");
						pw_check.requestFocus();
					} else {
						pw_checklabel.setText("비밀번호가 다릅니다.");
					}
				}
			}
		});

		// 아이디 중복 확인
		id_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_field.getText();
				if (id.equals("")) {
					id_checklabel.setText("아이디를 입력하세요.");
				} else {
					try {
						String que = "{ ? = call fu_id_check(?)}";
						conn = Connect.get();
						cstmt = conn.prepareCall(que);
						cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
						cstmt.setString(2, id);
						cstmt.execute();
						int rsl = cstmt.getInt(1);
						if (rsl != 0) {
							id_checklabel.setText("이미 사용하고 있는 아이디입니다.");
						} else {
							id_checklabel.setText("사용할 수 있는 아이디입니다.");
						}
					} catch (Exception e_id_check) {
						e_id_check.printStackTrace();
						System.out.println("id check fail");
					}
				}
			}
		});

		// 이메일 중복 확인
		email_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = email_field.getText();
				if (email.equals("")) {
					email_checklabel.setText("이메일을 입력하세요.");
				} else {
					try {
						String quer = "{ ? = call fu_email_check(?)}";
						conn = Connect.get();
						cstmt = conn.prepareCall(quer);
						cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
						cstmt.setString(2, email);
						cstmt.execute();
						int rslt = cstmt.getInt(1);
						if (rslt != 0) {
							email_checklabel.setText("이미 사용하고 있는 이메일입니다.");
						} else {
							email_checklabel.setText("사용할 수 있는 이메일입니다.");
						}
					} catch (Exception e_email_check) {
						System.out.println("email check fail");
					}
				}

			}
		});

		// 가입완료 버튼
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!id_checklabel.getText().equals("사용할 수 있는 아이디입니다.")) {
					last_checklabel.setText("아이디를 확인해 주세요.");
					id_field.requestFocus();
				} else if (!pw_checklabel.getText().equals("확인")) {
					last_checklabel.setText("비밀번호를 확인해 주세요.");
					pw_field.requestFocus();
				} else if (!email_checklabel.getText().equals("사용할 수 있는 이메일입니다.")) {
					last_checklabel.setText("이메일을 확인해 주세요.");
					email_field.requestFocus();
				} else {
					last_checklabel.setText("");
					try {
						
						id=id_field.getText();
						pw=pw_field.getText();
						name=name_field.getText();
						email=email_field.getText();
						conn=Connect.get(); 
//						
//
//						
//						int success=psmt.executeUpdate();

						cstmt = conn.prepareCall("{call pr_member_join(?,?,?,?)}");
						cstmt.setString(1, id);
						cstmt.setString(2, pw);
						cstmt.setString(3, name);
						cstmt.setString(4, email);

						cstmt.execute();

//						cstmt.close();
//						conn.close();

						JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.", "", JOptionPane.PLAIN_MESSAGE);
						dispose();
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					} catch (Exception e_complete) {
						e_complete.printStackTrace();
						System.out.println("signup_fail");
					}
				}
			}
		});

		setSize(510, 460);
		
		background.setLayout(null);
		background.setBounds(0, 0, 510, 460);
		add(background);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new sign_up();
	}

}
