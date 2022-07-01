import java.awt.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class game_frame extends JFrame{
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
	
	game_frame(){
		Container c=getContentPane();
		
		//단어, 힌트 가져오기를 포함한 쓰레드 불러오기
		
		hint.setText(hint_t);
		
		c.add(hint);
		c.add(g1);
		c.add(score_label);
		
		while (true) {
			boolean[] return_grade1 = new boolean[word_l];
			return_grade1 = grade.grade_panel(g1.input1);
			if (grade.grade_case()) {
				score+=10;
				score_label.setText(String.format("%06d", score));
				//단어, 힌트 새로 가져오기
				g1=new game1(word_l);
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
								// 하트 깍임
								life--;
							}
						}
					}
				}
			}
			if(life==0) {
				//dialog
				if() {//dialog-retry
					life=5;
					continue;
				}
				else {
					this.input_playlog(score);
					break;
				}
			}
		}//while문 끝
		
	}//생성자 끝

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
