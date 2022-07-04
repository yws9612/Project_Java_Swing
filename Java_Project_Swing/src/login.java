import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

class Getter {
	private String result;
	private String admin;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
}

public class login extends JFrame {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	static String id, pw;
	
	ImageIcon buttonimg3 = new ImageIcon("image/medium_button_.png");
	ImageIcon buttonimg4 = new ImageIcon("image/medium_button_select.png");

//	JLabel title = new JLabel("5dle,5dle");
	JLabel id_label = new JLabel("ID");
	JLabel pw_label = new JLabel("PW");
	JLabel alter = new JLabel();

	JTextField id_field = new JTextField();
	JPasswordField pw_field = new JPasswordField();

	JButton sign_up = new JButton("회원가입",buttonimg3);
	JButton log_in = new JButton("로그인", buttonimg3);
	JButton find_id = new JButton("아이디 찾기", buttonimg3);
	JButton find_pw = new JButton("비밀번호 찾기", buttonimg3);
	JPanel loginBack = new JPanel() {
		Image loginBackground = new ImageIcon("image/login_background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(loginBackground, 0, 0, null);
		}
	};
	
	

	login() {
//		setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		pw_label.setBounds(39, 203, 64, 35);
		
		pw_label.setForeground(Color.white);
		pw_label.setFont(new Font("DungGeunMo",Font.PLAIN,20));

		getContentPane().add(pw_label);
		pw_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_field.setBounds(115, 154, 233, 35);
		id_field.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(id_field);
		pw_field.setBounds(115, 204, 233, 35);
		pw_field.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(pw_field);
		sign_up.setBounds(39, 253, 150, 35);
		sign_up.setHorizontalTextPosition(JButton.CENTER);
		sign_up.setRolloverIcon(buttonimg4);
		sign_up.setBorderPainted(false);
		sign_up.setContentAreaFilled(false);
		sign_up.setFocusPainted(false);
		sign_up.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(sign_up);
		log_in.setBounds(201, 254, 150, 35);
		log_in.setHorizontalTextPosition(JButton.CENTER);
		log_in.setRolloverIcon(buttonimg4);
		log_in.setBorderPainted(false);
		log_in.setContentAreaFilled(false);
		log_in.setFocusPainted(false);
		log_in.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(log_in);
		find_id.setBounds(39, 303, 150, 35);
		find_id.setHorizontalTextPosition(JButton.CENTER);
		find_id.setRolloverIcon(buttonimg4);
		find_id.setBorderPainted(false);
		find_id.setContentAreaFilled(false);
		find_id.setFocusPainted(false);
		find_id.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(find_id);
		find_pw.setBounds(201, 303, 150, 35);
		find_pw.setHorizontalTextPosition(JButton.CENTER);
		find_pw.setRolloverIcon(buttonimg4);
		find_pw.setBorderPainted(false);
		find_pw.setContentAreaFilled(false);
		find_pw.setFocusPainted(false);
		find_pw.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(find_pw);
		id_label.setBounds(39, 153, 64, 35);
		id_label.setForeground(Color.white);
		id_label.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		getContentPane().add(id_label);
		alter.setBounds(85, 115, 240, 35);
		alter.setForeground(Color.white);
		alter.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		getContentPane().add(alter);
		
		
		loginBack.setLayout(null);
		loginBack.setBounds(0, 0, 390, 520);
		getContentPane().add(loginBack);
		setSize(405, 487);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		find_pw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new find_pw();
			}
		});

		find_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new find_id();
			}
		});

		log_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_field.getText();
				pw = pw_field.getText();

				if (id.equals("") || pw.equals("")) {
					alter.setText("id 혹은 비밀번호를 확인하세요.");
				} else {
					try {
						String que = "select pw, admin from member where id=? and enable = 'Y'";
						conn = Connect.get();
						psmt = conn.prepareStatement(que);
						psmt.setString(1, id);
						rs = psmt.executeQuery();
						Getter get = new Getter();
						while (rs.next()) {
							get.setResult(rs.getString(1));
							get.setAdmin(rs.getString(2));
						}

						if (pw.equals(get.getResult())) {
							if (get.getAdmin().equals("Y")) {
								new ManagerChoice();
//								dispose();
							} else {
								new Choice();
								dispose();
							}
						} else {
							alter.setText("id 혹은 비밀번호를 확인하세요.");
						}

					} catch (Exception e_compare) {
						System.out.println("e_compare_error");
					}

				}
			}
		});

		sign_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new sign_up();
			}
		});
		
		sign_up.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			sign_up.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			sign_up.setForeground(Color.black);
			    }
			});
		
		log_in.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			log_in.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			log_in.setForeground(Color.black);
			    }
			});

		find_id.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			find_id.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			find_id.setForeground(Color.black);
			    }
			});

		find_pw.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			find_pw.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			find_pw.setForeground(Color.black);
			    }
			});


		
		
	}

	public static void main(String[] args) {

		// 테스트용 임시프레임
//		JFrame log_in=new login();
		new login();

	}

}
