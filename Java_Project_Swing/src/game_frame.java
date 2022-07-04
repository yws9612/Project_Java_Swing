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
	Game_1 g_1;
	
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
	

	public game_frame() {
		Container c = getContentPane();
		c.setLayout(null);

		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);	

		//Dimension d=c.getSize(); (884*601)

		next.setBounds(770, 200, 100, 200);
		next.setFont(new Font("DungGeunMo", Font.PLAIN, 15));
		c.add(next);
		pause.setBounds(770, 560, 100, 30);
		pause.setFont(new Font("DungGeunMo", Font.PLAIN, 15));
		c.add(pause);

		score_label.setBounds(700, 10, 150, 50);
		//score_label.setBackground(Color.cyan);
		score_label.setOpaque(true);
		score_label.setHorizontalAlignment(SwingConstants.RIGHT);
		score_label.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		c.add(score_label);		
		score_label.setVisible(false);
		
		//하트
		life_img=new life_image(life);
		life_img.setOpaque(true);
		life_img.setBounds(5, 540, 280, 50);
		c.add(life_img);
		life_img.setVisible(false);

		
		
		//패널위치잡기
		JPanel tmp2=new JPanel();
		tmp2.setBackground(Color.pink);
		tmp2.setOpaque(true);
		tmp2.setBounds(237, 185, 410, 340);
		c.add(tmp2);
		tmp2.setVisible(false);
		
		
		
		//힌트위치잡기
		hint.setBackground(Color.yellow);
		hint.setOpaque(true);
		hint.setHorizontalAlignment(SwingConstants.CENTER);
		hint.setFont(new Font("DungGeunMo", Font.PLAIN, 20));
		hint.setBounds(50, 75, 784, 100);
		c.add(hint);
		hint.setVisible(false);


		c.add(countdown);
		c.add(countdown_image);
		countdown.setBounds(300, 150, 300, 300);
		countdown_image.setBounds(300, 150, 300, 300);
		countdown.setFont(new Font("DungGeunMo", Font.PLAIN, 20));
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

		life_img.setVisible(true);
		tmp2.setVisible(true);
		hint.setVisible(true);
		score_label.setVisible(true);

		word_arr = new_word.getWord_arr();
		word_l = word_arr.length;
		grade = new grading(word_arr);
		hint_t = new_word.getHint();

		hint.setText(hint_t);
		
		g_1=new Game_1(word_l);
		switch (word_l) {
		case 2:
			g_1.setBounds(237, 250, 410, 200);
			break;
		case 3:
			g_1.setBounds(237, 250, 410, 130);
			break;
		case 4:
			g_1.setBounds(237, 250, 410, 95);
			break;
		case 5:
			g_1.setBounds(237, 250, 410, 74);
			break;
		case 6:
			g_1.setBounds(237, 250, 410, 50);
			break;
		default:
			g_1.setBounds(237, 250, 410, 50);
			break;			
		}
		g_1.setOpaque(true);
		g_1.setVisible(true);
		c.add(g_1);
		

		//int g_x = (word_l * 60) + ((word_l - 1) * 10);

		
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
				new game_frame(life, score);				
				dispose();				
			}
		});

		while (true) {
			
			c.remove(life_img);
			life_img = new life_image(life);
			c.add(life_img);
			life_img.setVisible(false);
			life_img.setVisible(true);
			// life_label=life_img.setLifeimg();

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

			if (ctl1.getState() == Thread.State.NEW) {
				ctl1.start();
				try {
					tmp2.setVisible(false);
					g1 = new game1(word_l);
					g1.setBounds(237, 185, 410, 340);
					g1.setOpaque(true);
					g1.setVisible(true);
					c.add(g1);
					//ctl1.join();
					ctl1.sleep(10000000);
					System.out.println(life);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("create g1");
				}
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
				if (ctl2.getState() == Thread.State.NEW) {
					ctl2.start();
					try {
						g2 = new game2(word_l, g1.input1, return_grade1);
						g2.setBounds(237, 185, 410, 340);
						c.add(g2);
						g1.setVisible(false);
						ctl2.join();
					} catch (Exception e) {
						System.out.println("create g2");
						e.printStackTrace();
					}
				}
				boolean[] return_grade2 = new boolean[word_l];
				return_grade2 = grade.grade_panel(g2.input2);

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

					g2.setVisible(false);

					continue;

				} else {
					if (ctl3.getState() == Thread.State.NEW) {
						ctl3.start();
						try {
							g3 = new game3(word_l, g1.input1, g2.input2, return_grade1, return_grade2);
							g3.setBounds(237, 185, 410, 340);
							c.add(g3);
							g2.setVisible(false);
							ctl3.join();
						} catch (Exception e) {
							System.out.println("create g3");
							e.printStackTrace();
						}
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

						g3.setVisible(false);

						continue;

					} else {
						if (ctl4.getState() == Thread.State.NEW) {
							ctl4.start();
							try {
								g4 = new game4(word_l, g1.input1, g2.input2, g3.input3, return_grade1, return_grade2,
										return_grade3);
								g4.setBounds(237, 185, 410, 340);
								c.add(g4);
								g3.setVisible(false);
								ctl4.join();
							} catch (Exception e) {
								System.out.println("create g4");
								e.printStackTrace();
							}
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

							g4.setVisible(false);

							continue;

						} else {
							if (ctl5.getState() == Thread.State.NEW) {
								ctl5.start();
								try {
									g5 = new game5(word_l, g1.input1, g2.input2, g3.input3, g4.input4, return_grade1,
											return_grade2, return_grade3, return_grade4);
									g5.setBounds(237, 185, 410, 340);
									c.add(g5);
									g4.setVisible(false);
									ctl5.join();
								} catch (Exception e) {
									System.out.println("create g5");
									e.printStackTrace();
								}
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

								g5.setVisible(false);

								continue;

							} else {
								life--;
								g5.setVisible(false);
								continue;
							}
						}
					}
				}
			}
		} // while문 끝

	}// 생성자1 끝
	
	
	

	//생성자2 시작
	public game_frame(int life_new, int score_new) {
		Container c = getContentPane();
		c.setLayout(null);

		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);	

		//Dimension d=c.getSize(); (884*601)
		life=life_new;
		score=score_new;
		score_label.setText(String.format("%06d", score));

		next.setBounds(770, 200, 100, 200);
		next.setFont(new Font("DungGeunMo", Font.PLAIN, 15));
		c.add(next);
		pause.setBounds(770, 560, 100, 30);
		pause.setFont(new Font("DungGeunMo", Font.PLAIN, 15));
		c.add(pause);

		score_label.setBounds(700, 10, 150, 50);
		//score_label.setBackground(Color.cyan);
		score_label.setOpaque(true);
		score_label.setHorizontalAlignment(SwingConstants.RIGHT);
		score_label.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		c.add(score_label);		
		score_label.setVisible(false);
		
		//하트
		life_img=new life_image(life);
		life_img.setOpaque(true);
		life_img.setBounds(5, 540, 280, 50);
		c.add(life_img);
		life_img.setVisible(false);

		
		
		//패널위치잡기
		JPanel tmp2=new JPanel();
		tmp2.setBackground(Color.pink);
		tmp2.setOpaque(true);
		tmp2.setBounds(237, 185, 410, 340);
		c.add(tmp2);
		tmp2.setVisible(false);
		
		
		
		//힌트위치잡기
		hint.setBackground(Color.yellow);
		hint.setOpaque(true);
		hint.setHorizontalAlignment(SwingConstants.CENTER);
		hint.setFont(new Font("DungGeunMo", Font.PLAIN, 20));
		hint.setBounds(50, 75, 784, 100);
		c.add(hint);
		hint.setVisible(false);


		c.add(countdown);
		c.add(countdown_image);
		countdown.setBounds(300, 150, 300, 300);
		countdown_image.setBounds(300, 150, 300, 300);
		countdown.setFont(new Font("DungGeunMo", Font.PLAIN, 20));
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

		life_img.setVisible(true);
		tmp2.setVisible(true);
		hint.setVisible(true);
		score_label.setVisible(true);

		word_arr = new_word.getWord_arr();
		word_l = word_arr.length;
		grade = new grading(word_arr);
		hint_t = new_word.getHint();

		hint.setText(hint_t);		


		//int g_x = (word_l * 60) + ((word_l - 1) * 10);

		
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
				new game_frame(life, score);				
				dispose();				
			}
		});

		while (true) {
			
			c.remove(life_img);
			life_img = new life_image(life);
			c.add(life_img);
			life_img.setVisible(false);
			life_img.setVisible(true);
			// life_label=life_img.setLifeimg();

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

			if (ctl1.getState() == Thread.State.NEW) {
				ctl1.start();
				try {
					g1 = new game1(word_l);
					g1.setBounds(237, 185, 410, 340);
					c.add(g1);
					//ctl1.join();
					ctl1.sleep(10000000);
					System.out.println(life);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("create g1");
				}
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
				if (ctl2.getState() == Thread.State.NEW) {
					ctl2.start();
					try {
						g2 = new game2(word_l, g1.input1, return_grade1);
						g2.setBounds(237, 185, 410, 340);
						c.add(g2);
						c.remove(g1);
						ctl2.join();
					} catch (Exception e) {
						System.out.println("create g2");
						e.printStackTrace();
					}
				}
				boolean[] return_grade2 = new boolean[word_l];
				return_grade2 = grade.grade_panel(g2.input2);

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

					c.remove(g2);

					continue;

				} else {
					if (ctl3.getState() == Thread.State.NEW) {
						ctl3.start();
						try {
							g3 = new game3(word_l, g1.input1, g2.input2, return_grade1, return_grade2);
							g3.setBounds(237, 185, 410, 340);
							c.add(g3);
							c.remove(g2);
							ctl3.join();
						} catch (Exception e) {
							System.out.println("create g3");
							e.printStackTrace();
						}
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
						if (ctl4.getState() == Thread.State.NEW) {
							ctl4.start();
							try {
								g4 = new game4(word_l, g1.input1, g2.input2, g3.input3, return_grade1, return_grade2,
										return_grade3);
								g4.setBounds(237, 185, 410, 340);
								c.add(g4);
								c.remove(g3);
								ctl4.join();
							} catch (Exception e) {
								System.out.println("create g4");
								e.printStackTrace();
							}
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
							if (ctl5.getState() == Thread.State.NEW) {
								ctl5.start();
								try {
									g5 = new game5(word_l, g1.input1, g2.input2, g3.input3, g4.input4, return_grade1,
											return_grade2, return_grade3, return_grade4);
									g5.setBounds(237, 185, 410, 340);
									c.add(g5);
									c.remove(g4);
									ctl5.join();
								} catch (Exception e) {
									System.out.println("create g5");
									e.printStackTrace();
								}
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

	}// 생성자2 끝

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new game_frame();
	}

}
