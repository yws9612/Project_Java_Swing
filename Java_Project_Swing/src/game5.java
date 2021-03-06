import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class game5 extends JPanel {
	JLabel[] a = new JLabel[6];
	JLabel[] b = new JLabel[6];
	JLabel[] c = new JLabel[6];
	JLabel[] d = new JLabel[6];
	JLabel[] e = new JLabel[6];;
	JTextField[] input_field = new JTextField[6];
	public String[] input5;
	boolean[] grading;
	int w_length;
	

	public void set_grading(boolean[] boo) {
		for (int i = 0; i < w_length; i++) {
			grading[i] = boo[i];
		}
	}

	public game5(int length, String g1[], String g2[], String g3[], String g4[], boolean[] g1_b, boolean[] g2_b, boolean[] g3_b,
			boolean[] g4_b) {

		this.w_length = length;
		setLayout(new GridLayout(5, w_length, 10, 10));

		input5 = new String[w_length];
		grading = new boolean[w_length];

		for (int i = 0; i < 6; i++) {
			input_field[i] = new JTextField();
		}

		for (int i = 0; i < w_length; i++) {
			a[i] = new JLabel();
			a[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			a[i].setHorizontalAlignment(SwingConstants.CENTER);
			a[i].setText(g1[i]);
			if (g1_b[i]) {
				a[i].setBackground(Color.green);
			} else {
				a[i].setBackground(Color.pink);
			}
			add(a[i]);
		}
		for (int i = 0; i < w_length; i++) {
			b[i] = new JLabel();
			b[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			b[i].setHorizontalAlignment(SwingConstants.CENTER);
			b[i].setText(g2[i]);
			if (g2_b[i]) {
				b[i].setBackground(Color.green);
			} else {
				b[i].setBackground(Color.pink);
			}
			add(b[i]);
		}
		for (int i = 0; i < w_length; i++) {
			c[i] = new JLabel();
			c[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			c[i].setHorizontalAlignment(SwingConstants.CENTER);
			c[i].setText(g3[i]);
			if (g3_b[i]) {
				c[i].setBackground(Color.green);
			} else {
				c[i].setBackground(Color.pink);
			}
			add(c[i]);
		}
		for (int i = 0; i < w_length; i++) {
			d[i] = new JLabel();
			d[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			d[i].setHorizontalAlignment(SwingConstants.CENTER);
			d[i].setText(g4[i]);
			if (g4_b[i]) {
				d[i].setBackground(Color.green);
			} else {
				d[i].setBackground(Color.pink);
			}
			add(d[i]);
		}
		for (int i = 0; i < w_length; i++) {
			input_field[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			input_field[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(input_field[i]);
		}

		// textfield ????????? ??????+??????????????? ??????
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

		// ???????????? ??? ??????
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

		// ?????? ??????_???????????????
		input_field[w_length - 1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					for (int i = 0; i < 6; i++) {
						input5[i] = input_field[i].getText();
					}
					// ??????+?????? ????????? ?????????
					game_frame.ctl5.interrupt();
				}
			}
		});

		// ?????? ??????_??????
		input_field[w_length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < w_length; i++) {
					input5[i] = input_field[i].getText();
				}
				// ??????+?????? ????????? ?????????
				game_frame.ctl5.interrupt();
			}
		});

		// ?????? ??????_???
		input_field[w_length - 1].setFocusTraversalKeysEnabled(false);
		input_field[w_length - 1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					for (int i = 0; i < 6; i++) {
						input5[i] = input_field[i].getText();
					}
					// ??????+?????? ????????? ?????????
					game_frame.ctl5.interrupt();
				}
			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
