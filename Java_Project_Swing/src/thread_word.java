import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

/*class Getters{
	private String word1,hint1;

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public String getHint1() {
		return hint1;
	}

	public void setHint1(String hint1) {
		this.hint1 = hint1;
	}*/

public class thread_word extends Thread {
	JLabel circle_label = new JLabel();
	JLabel countdown = new JLabel();
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	boolean ok=false;
	
	char[] word1_arr;
	
	String word1_string, hint1;
	
	//Getters get = new Getters();

	thread_word(JLabel l1, JLabel l2) {
		countdown = l1;
		circle_label = l2;
	}
	
	public char[] getWord() {
		return word1_arr;
	}
	public String getHint() {
		return hint1;
	}

	public void run() {
		try {
			sleep(1000);

			countdown.setVisible(true);
			circle_label.setVisible(true);

			while (!ok) {
				countdown.setText("단어를 고르고 있어요.");
				sleep(500);
				countdown.setText(countdown.getText().concat("."));
				sleep(500);
				countdown.setText(countdown.getText().concat("."));
				sleep(500);

				try {
					conn = Connect.get();
					String que2 = "select w1_no, w1, w1_h from w1_table where w1_no = "
							+ "(select trunc(dbms_random.value(1,150)) from dual)";
					psmt = conn.prepareStatement(que2);
					rs = psmt.executeQuery();
					while (rs.next()) {
						word1_string=rs.getString(2);
						hint1=rs.getString(3);
					}
					

					word1_arr = new char[word1_string.length()];
					for (int i = 0; i < word1_string.length(); i++) {
						word1_arr[i] = word1_string.charAt(i);
						//System.out.print(word1_arr[i]);
					}
					
					ok=false; //while문 끝내기
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			for (int i = 3; i > 0; i--) {
				countdown.setText(Integer.toString(i));
				sleep(1000); // 1초
			}
			countdown.setText("게임 시작!");
			sleep(1000);
			countdown.setVisible(false);
			circle_label.setVisible(false);
		} catch (Exception e) {
			System.out.println("fail");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
