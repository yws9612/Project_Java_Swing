import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Game_1 extends JPanel {
	JTextField[] input_field = new JTextField[6];
	public String[] input1=new String[6];
	boolean[] grading=new boolean[6];
	
	public Game_1(int length) {
		setLayout(new GridLayout(1, length, 10, 10));
		
		for (int i = 0; i < 6; i++) {
			input_field[i] = new JTextField();
		}

		for (int i = 0; i < length; i++) {
			input_field[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			input_field[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(input_field[i]);
		}
		
		input_field[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					input_field[1].requestFocus();
				}
			}
		});
		input_field[1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					input_field[2].requestFocus();
				}
			}
		});
		input_field[2].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					input_field[3].requestFocus();
				}
			}
		});
		input_field[3].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					input_field[4].requestFocus();
				}
			}
		});
		input_field[4].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					input_field[5].requestFocus();
				}
			}
		});

		// 엔터쳤을 때 액션
		input_field[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_field[1].requestFocus();
			}
		});
		input_field[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_field[2].requestFocus();
			}
		});
		input_field[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_field[3].requestFocus();
			}
		});
		input_field[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_field[4].requestFocus();
			}
		});
		input_field[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_field[5].requestFocus();
			}
		});

		// 단어 끝칸_글자수제한
		input_field[length - 1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 2) {
					ke.consume();
					for (int i = 0; i < 6; i++) {
						input1[i] = input_field[i].getText();
					}
					// 채점+다음 시도로 넘기기
					//game_frame.ctl1.interrupt();
					//game_frame.ctl1.notify();
				}
			}
		});

		// 단어 끝칸_엔터
		input_field[length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < length; i++) {
					input1[i] = input_field[i].getText();
				}
				// 채점+다음 시도로 넘기기
				//game_frame.ctl1.interrupt();
				//game_frame.ctl1.notify();
			}
		});

		// 단어 끝칸_탭
		input_field[length - 1].setFocusTraversalKeysEnabled(false);
		input_field[length - 1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					for (int i = 0; i < 6; i++) {
						input1[i] = input_field[i].getText();
					}
					// 채점+다음 시도로 넘기기
					//game_frame.ctl1.interrupt();
					//game_frame.ctl1.notify();
				}
			}
		});
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
