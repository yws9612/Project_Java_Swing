import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class game3 extends JPanel {
	JLabel[] a = new JLabel[6];
	JLabel[] b = new JLabel[6];
	JLabel[] c = new JLabel[6];
	JLabel[] d = new JLabel[6];
	JLabel[] e = new JLabel[6];;
	JTextField[] input_field = new JTextField[6];
	public char[] input3;
	boolean[] grading;
	int w_length;

	public void set_grading(boolean[] boo) {
		for (int i = 0; i < w_length; i++) {
			grading[i] = boo[i];
		}
	}

	public game3(int length, char g1[], char g2[], 
			boolean g1_b[], boolean g2_b[]) {
		this.w_length = length;
		setLayout(new GridLayout(5, w_length));

		input3 = new char[w_length];
		grading = new boolean[w_length];

		for (int i = 0; i < 6; i++) {
			input_field[i] = new JTextField();
		}

		for (int i = 0; i < w_length; i++) {
			a[i] = new JLabel();
			a[i].setText(Character.toString(g1[i]));
			if(g1_b[i]) {
				a[i].setBackground(Color.green);
			}
			else {
				a[i].setBackground(Color.pink);
			}
			add(a[i]);
		}
		for (int i = 0; i < w_length; i++) {
			b[i] = new JLabel();
			b[i].setText(Character.toString(g2[i]));
			if(g2_b[i]) {
				a[i].setBackground(Color.green);
			}
			else {
				a[i].setBackground(Color.pink);
			}
			add(b[i]);
		}
		for (int i = 0; i < w_length; i++) {
			add(input_field[i]);
		}
		for (int i = 0; i < w_length; i++) {
			d[i] = new JLabel();
			add(d[i]);
		}
		for (int i = 0; i < w_length; i++) {
			e[i] = new JLabel();
			add(e[i]);
		}

		// textfield 글자수 제한+자동포커스 이동
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

		input_field[w_length - 1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					for (int i = 0; i < 6; i++) {
						input3[i] = input_field[i].getText().charAt(0);
					}
					// 채점+다음 시도로 넘기기
				}
			}
		});

		// 단어 끝칸_엔터
		input_field[w_length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < w_length; i++) {
					input3[i] = input_field[i].getText().charAt(0);
				}
				// 채점+다음 시도로 넘기기
			}
		});

		// 단어 끝칸_탭
		input_field[w_length - 1].setFocusTraversalKeysEnabled(false);
		input_field[w_length - 1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					for (int i = 0; i < 6; i++) {
						input3[i] = input_field[i].getText().charAt(0);
					}
					// 채점+다음 시도로 넘기기
				}
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

	}

}
