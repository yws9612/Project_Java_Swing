import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class game_frame extends JFrame {

	JLabel countdown = new JLabel();
	JLabel countdown_image = new JLabel();
	ImageIcon cd_image = new ImageIcon("image/thread_circle.png");

	JLabel hint = new JLabel();
	String hint_t;
	char[] word_arr;
	int word_l;
	thread_word new_word;

	int life = 5;
	JLabel life_label;
	life_image life_img;

	int score = 0;
	JLabel score_label = new JLabel(String.format("%06d", score));

	JButton pause = new JButton("일시정지");
	JButton next = new JButton("건너뛰기");

	grading grade;

	game1 g1;
	game2 g2;
	game3 g3;
	game4 g4;
	game5 g5;

	static game_control1 ctl1 = new game_control1();
	static game_control2 ctl2 = new game_control2();
	static game_control3 ctl3 = new game_control3();
	static game_control4 ctl4 = new game_control4();
	static game_control5 ctl5 = new game_control5();

	void input_playlog(int scr) {
		Connection conn = null;
		CallableStatement cstmt = null;

		try {
			String que = "{call pr_score_insert(?,?)}";
			conn = Connect.get();
			cstmt = conn.prepareCall(que);
			cstmt.setString(1, login.id);
			cstmt.setInt(2, scr);
			cstmt.execute();
		} catch (Exception e) {
			System.out.println("error input_score");
		}
	}

	game_frame() {
		Container c = getContentPane();
		c.setLayout(null);

		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);		

		//Dimension d=c.getSize(); (884*601)

		next.setBounds(770, 200, 100, 200);
		next.setFont(new Font("DungGeunMo", Font.PLAIN, 15));
		c.add(next);
		pause.setBounds(770, 560, 100, 30);
		pause.setFont(new Font("DungGeunMo", Font.PLAIN, 15));
		c.add(pause);
		
		//하트위치잡기
		JLabel tmp=new JLabel("aaaaaaa");
		tmp.setBackground(Color.green);
		tmp.setOpaque(true);
		tmp.setBounds(20, 530, 280, 50);
		c.add(tmp);
		//패널위치잡기
		JLabel tmp2=new JLabel("aaaaaaa");
		tmp2.setBackground(Color.pink);
		tmp2.setOpaque(true);
		tmp2.setBounds(237, 185, 410, 340);
		c.add(tmp2);
		//힌트위치잡기
		JLabel tmp3=new JLabel();
		tmp3.setBackground(Color.yellow);
		tmp3.setOpaque(true);
		tmp3.setBounds(50, 75, 784, 100);
		c.add(tmp3);

		score_label.setBounds(700, 20, 150, 50);
		score_label.setOpaque(true);
		score_label.setHorizontalAlignment(SwingConstants.RIGHT);
		score_label.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		c.add(score_label);

		life_img=new life_image(life);
		life_label=life_img.setLifeimg();
		life_label.setBounds(20, 530, 280, 50);
		c.add(life_label);
				
		c.add(countdown);
		c.add(countdown_image);
		countdown.setBounds(300, 150, 300, 300);
		countdown_image.setBounds(300, 150, 300, 300);
		countdown.setFont(new Font("DungGeunMo", Font.PLAIN, 50));
		countdown.setForeground(Color.white);
		countdown.setHorizontalAlignment(SwingConstants.CENTER);
		countdown_image.setIcon(cd_image);
		countdown.setVisible(false);
		countdown_image.setVisible(false);

		new_word = new thread_word(countdown, countdown_image);
		new_word.start();
		try {
			new_word.join();
		} catch (Exception e) {
			System.out.println("생성자 시작부분");
			e.printStackTrace();
		}
		c.remove(countdown);
		c.remove(countdown_image);

		word_arr = new_word.getWord_arr();
		word_l = word_arr.length;
		grade = new grading(word_arr);
		


		//int g_x = (word_l * 60) + ((word_l - 1) * 10);

		hint_t = new_word.getHint();
		hint.setFont(new Font("DungGeunMo", Font.PLAIN, 20));
		hint.setHorizontalAlignment(SwingConstants.CENTER);
		hint.setText(hint_t);
		hint.setBounds(50, 75, 784, 100);
		c.add(hint);

		
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread();
				t.start();
				try {
					t.join();
					int pause_i = JOptionPane.showConfirmDialog(null, "정말 종료하시나요ㅠㅠ?", "일시정지",
							JOptionPane.YES_NO_OPTION);
					if (pause_i == JOptionPane.YES_OPTION) {
						t.interrupt();
						JFrame frame = (JFrame) e.getSource();
						new Choice();
						frame.dispose();
					} else {
						t.interrupt();
					}
				} catch (Exception e_pause) {
					System.out.println("pause dialog");
					e_pause.printStackTrace();
				}
			}
		});

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life--;
				new game_frame();
				dispose();
			}
		});

		
		while (true) {

			life_img=new life_image(life);
			life_label=life_img.setLifeimg();

			if (life == 0) {
				this.input_playlog(score);

				int retry = JOptionPane.showConfirmDialog(null, "다시 도전 할까요? \n(단, 점수는 0점부터 다시 시작해요!)", "게임 오버!",
						JOptionPane.YES_NO_OPTION);
				if (retry == JOptionPane.YES_OPTION) {
					life = 5;
					score = 0;
					continue;
				} else {
					new Choice();
					dispose();
					break;
				}
			}

			ctl1.start();
			try {
				ctl1.join();
				g1 = new game1(word_l);
				g1.setBounds(237, 185, 410, 340);
				c.add(g1);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("create g1");
			}
			boolean[] return_grade1 = new boolean[word_l];
			return_grade1 = grade.grade_panel(g1.input1);
			if (grade.grade_case()) {
				score += 10;
				score_label.setText(String.format("%06d", score));

				new_word = new thread_word(countdown, countdown_image);
				new_word.start();

				word_arr = new_word.getWord_arr();
				word_l = word_arr.length;

				grade = new grading(word_arr);

				hint_t = new_word.getHint();
				hint.setText(hint_t);

				continue;
				
			} else {
				ctl2.start();
				try {
					ctl2.join();
					g2 = new game2(word_l, g1.input1, return_grade1);
					g2.setBounds(237, 185, 410, 340);
					c.add(g2);
					c.remove(g1);
				} catch (Exception e) {
					System.out.println("create g2");
					e.printStackTrace();
				}
				boolean[] return_grade2 = new boolean[word_l];
				return_grade2 = grade.grade_panel(g2.input2);

				if (grade.grade_case()) {
					score += 10;
					score_label.setText(String.format("%06d", score));

					new_word = new thread_word(countdown, countdown_image);
					new_word.start();

					word_arr = new_word.getWord_arr();
					word_l = word_arr .length;

					grade = new grading(word_arr);

					hint_t = new_word.getHint();
					hint.setText(hint_t);

					c.remove(g2);

					continue;
					
				} else {
					ctl3.start();
					try {
						ctl3.join();
						g3 = new game3(word_l, g1.input1, g2.input2, return_grade1, return_grade2);
						g3.setBounds(237, 185, 410, 340);
						c.add(g3);
						c.remove(g2);
					} catch (Exception e) {
						System.out.println("create g3");
						e.printStackTrace();
					}
					boolean[] return_grade3 = new boolean[word_l];
					return_grade3 = grade.grade_panel(g3.input3);

					if (grade.grade_case()) {
						score += 10;
						score_label.setText(String.format("%06d", score));

						new_word = new thread_word(countdown, countdown_image);
						new_word.start();

						word_arr = new_word.getWord_arr();
						word_l = word_arr.length;

						grade = new grading(word_arr);

						hint_t = new_word.getHint();
						hint.setText(hint_t);

						c.remove(g3);

						continue;
						
					} else {
						ctl4.start();
						try {
							ctl4.join();
							g4 = new game4(word_l, g1.input1, g2.input2, g3.input3, return_grade1, return_grade2,
									return_grade3);
							g4.setBounds(237, 185, 410, 340);
							c.add(g4);
							c.remove(g3);
						} catch (Exception e) {
							System.out.println("create g4");
							e.printStackTrace();
						}
						boolean[] return_grade4 = new boolean[word_l];
						return_grade4 = grade.grade_panel(g4.input4);

						if (grade.grade_case()) {
							score += 10;
							score_label.setText(String.format("%06d", score));

							new_word = new thread_word(countdown, countdown_image);
							new_word.start();

							word_arr = new_word.getWord_arr();
							word_l = word_arr.length;

							grade = new grading(word_arr);

							hint_t = new_word.getHint();
							hint.setText(hint_t);

							c.remove(g4);

							continue;
							
						} else {
							ctl5.start();
							try {
								ctl5.join();
								g5 = new game5(word_l, g1.input1, g2.input2, g3.input3, g4.input4, return_grade1,
										return_grade2, return_grade3, return_grade4);
								g5.setBounds(237, 185, 410, 340);
								c.add(g5);
								c.remove(g4);
							} catch (Exception e) {
								System.out.println("create g5");
								e.printStackTrace();
							}
							boolean[] return_grade5 = new boolean[word_l];
							return_grade5 = grade.grade_panel(g5.input5);

							if (grade.grade_case()) {
								score += 10;
								score_label.setText(String.format("%06d", score));

								new_word = new thread_word(countdown, countdown_image);
								new_word.start();

								word_arr = new_word.getWord_arr();
								word_l = word_arr.length;

								grade = new grading(word_arr);

								hint_t = new_word.getHint();
								hint.setText(hint_t);

								c.remove(g5);

								continue;
								
							} else {
								life--;
								c.remove(g5);
								continue;
							}
						}
					}
				}
			}
		} // while문 끝

	}// 생성자 끝

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new game_frame();
	}

}
