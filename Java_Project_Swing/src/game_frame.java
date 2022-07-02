import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class game_frame extends JFrame{
	
	int frame_w=600;
	int frame_h=600;
	
	JLabel countdown=new JLabel();
	JLabel countdown_image=new JLabel();
	
	JLabel hint=new JLabel();
	String hint_t;
	
	int word_l;
	int life=5;
	
	int score=0;	
	JLabel score_label=new JLabel(String.format("%06d", score));
	
	JButton pause=new JButton("일시정지");
	JButton next=new JButton("다음 문제");

	grading grade=new grading();
	
	game1 g1=new game1(word_l);
	game2 g2;
	game3 g3;
	game4 g4;
	game5 g5;
	int g_width;
	
	public void input_playlog(int scr) {
		Connection conn=null;
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

		thread_word new_word=new thread_word(countdown, countdown_image);
		new_word.start();
		
		hint_t=new_word.getHint();

		hint.setText(hint_t);

		c.add(hint);
		c.add(g1);

		c.add(score_label);

		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread();
				t.start();
				try {
					t.join();
				} catch (Exception e_pause) {
					System.out.println("pause dialog");
					e_pause.printStackTrace();
				}
				int pause_i = JOptionPane.showConfirmDialog(null, "정말 종료하시나요ㅠㅠ?", "일시정지", JOptionPane.YES_NO_OPTION);
				if (pause_i == JOptionPane.YES_OPTION) {
					t.interrupt();
					JFrame frame = (JFrame) e.getSource();
					frame.dispose();
					new Choice();
				} else {
					t.interrupt();
				}
			}
		});

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life--;
				JFrame frame = (JFrame) e.getSource();
				new game_frame(life);
				frame.dispose();
			}
		});

		setSize(frame_w, frame_h);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		while (true) {
			boolean[] return_grade1 = new boolean[word_l];
			return_grade1 = grade.grade_panel(g1.input1);
			if (grade.grade_case()) {
				score += 10;
				score_label.setText(String.format("%06d", score));
				// 단어, 힌트 새로 가져오기
				g1 = new game1(word_l);
			} else {
				c.add(g2);
				c.remove(g1);
				boolean[] return_grade2 = new boolean[word_l];
				g2 = new game2(word_l, g1.input1, return_grade1);
				return_grade2 = grade.grade_panel(g2.input2);

				if (grade.grade_case()) {

				} else {
					c.add(g3);
					c.remove(g2);
					g3 = new game3(word_l, g1.input1, g2.input2, return_grade1, return_grade2);
					boolean[] return_grade3 = new boolean[word_l];
					return_grade3 = grade.grade_panel(g3.input3);

					if (grade.grade_case()) {
						
					} else {
						c.add(g4);
						c.remove(g3);
						g4 = new game4(word_l, g1.input1, g2.input2, g3.input3, return_grade1, return_grade2,
								return_grade3);
						boolean[] return_grade4 = new boolean[word_l];
						return_grade4 = grade.grade_panel(g4.input4);

						if (grade.grade_case()) {

						} else {
							c.add(g5);
							c.remove(g4);
							g5 = new game5(word_l, g1.input1, g2.input2, g3.input3, g4.input4, return_grade1,
									return_grade2, return_grade3, return_grade4);
							boolean[] return_grade5 = new boolean[word_l];
							return_grade5 = grade.grade_panel(g5.input5);

							if (grade.grade_case()) {

							} else {
								life--;
								new game_frame(life);
							}
						}
					}
				}
			}
			if (life == 0) {
				this.input_playlog(score);

				int retry = JOptionPane.showConfirmDialog(null, "다시 도전 할까요? \n(단, 점수는 다시 0점부터 시작해요!)", "게임 오버!",
						JOptionPane.YES_NO_OPTION);
				if (retry == JOptionPane.YES_OPTION) {
					life = 5;
					score = 0;
					continue;
				} else {
					break;
				}
			}
		} // while문 끝

	}// 생성자 끝

	// 중간시작 생성자
	game_frame(int a) {
		Container c = getContentPane();

		life = a;

		// 단어, 힌트 가져오기를 포함한 쓰레드 불러오기

		hint.setText(hint_t);

		c.add(hint);
		c.add(g1);

		c.add(score_label);

		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread();
				t.start();
				try {
					t.join();
				} catch (Exception e_pause) {
					System.out.println("pause dialog");
					e_pause.printStackTrace();
				}
				int pause_i = JOptionPane.showConfirmDialog(null, "정말 종료하시나요ㅠㅠ?", "일시정지", JOptionPane.YES_NO_OPTION);
				if (pause_i == JOptionPane.YES_OPTION) {
					t.interrupt();
					JFrame frame = (JFrame) e.getSource();
					frame.dispose();
					new Choice();
				} else {
					t.interrupt();
				}
			}
		});

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				life--;
				new game_frame(life);
			}
		});

		setSize(frame_w, frame_h);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		while (true) {
			boolean[] return_grade1 = new boolean[word_l];
			return_grade1 = grade.grade_panel(g1.input1);
			if (grade.grade_case()) {
				score += 10;
				score_label.setText(String.format("%06d", score));
				// 단어, 힌트 새로 가져오기
				g1 = new game1(word_l);
			} else {
				g2 = new game2(word_l, g1.input1, return_grade1);
				c.add(g2);
				c.remove(g1);
				boolean[] return_grade2 = new boolean[word_l];
				return_grade2 = grade.grade_panel(g2.input2);

				if (grade.grade_case()) {

				} else {
					g3 = new game3(word_l, g1.input1, g2.input2, return_grade1, return_grade2);
					boolean[] return_grade3 = new boolean[word_l];
					return_grade3 = grade.grade_panel(g3.input3);

					if (grade.grade_case()) {

					} else {
						g4 = new game4(word_l, g1.input1, g2.input2, g3.input3, return_grade1, return_grade2,
								return_grade3);
						boolean[] return_grade4 = new boolean[word_l];
						return_grade4 = grade.grade_panel(g4.input4);

						if (grade.grade_case()) {

						} else {
							g5 = new game5(word_l, g1.input1, g2.input2, g3.input3, g4.input4, return_grade1,
									return_grade2, return_grade3, return_grade4);
							boolean[] return_grade5 = new boolean[word_l];
							return_grade5 = grade.grade_panel(g5.input5);

							if (grade.grade_case()) {

							} else {
								life--;
								new game_frame(life);
							}
						}
					}
				}
			}
			if (life == 0) {
				this.input_playlog(score);

				int retry = JOptionPane.showConfirmDialog(null, "다시 도전 할까요? \n(단, 점수는 다시 0점부터 시작해요!)", "게임 오버!",
						JOptionPane.YES_NO_OPTION);
				if (retry == JOptionPane.YES_OPTION) {
					life = 5;
					score = 0;
					continue;
				} else {
					break;
				}
			}
		} // while문 끝

	}//생성자_중간시작 끝

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new game_frame();
	}

}
