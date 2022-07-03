import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class game1 extends JPanel {
	JLabel[] a = new JLabel[6];
	JLabel[] b = new JLabel[6];
	JLabel[] c = new JLabel[6];
	JLabel[] d = new JLabel[6];
	JLabel[] e = new JLabel[6];;
	JTextField[] input_field = new JTextField[6];
	public char[] input1;
	boolean[] grading;
	int w_length;	

	
	public void set_grading(boolean[] boo) {
		for (int i = 0; i < w_length; i++) {
			grading[i] = boo[i];
		}
	}

	public game1(int a) {

		w_length = a;
		setLayout(new GridLayout(5, w_length, 10, 10));

		input1 = new char[w_length];
		grading = new boolean[w_length];

		for (int i = 0; i < 6; i++) {
			input_field[i] = new JTextField();
		}

		for (int i = 0; i < w_length; i++) {
			input_field[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			input_field[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(input_field[i]);
		}
		for (int i = 0; i < w_length; i++) {
			b[i] = new JLabel();
			b[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			b[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(b[i]);
		}
		for (int i = 0; i < w_length; i++) {
			c[i] = new JLabel();
			c[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			c[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(c[i]);
		}
		for (int i = 0; i < w_length; i++) {
			d[i] = new JLabel();
			d[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			d[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(d[i]);
		}
		for (int i = 0; i < w_length; i++) {
			e[i] = new JLabel();
			e[i].setFont(new Font("DungGeunMo", Font.PLAIN, 20));
			e[i].setHorizontalAlignment(SwingConstants.CENTER);
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

		// 단어 끝칸_글자수제한
		input_field[w_length - 1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					for (int i = 0; i < 6; i++) {
						input1[i] = input_field[i].getText().charAt(0);
					}
					// 채점+다음 시도로 넘기기
					game_frame.ctl1.interrupt();
				}
			}
		});

		// 단어 끝칸_엔터
		input_field[w_length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < w_length; i++) {
					input1[i] = input_field[i].getText().charAt(0);
				}
				// 채점+다음 시도로 넘기기
				game_frame.ctl1.interrupt();
			}
		});

		// 단어 끝칸_탭
		input_field[w_length - 1].setFocusTraversalKeysEnabled(false);
		input_field[w_length - 1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					for (int i = 0; i < 6; i++) {
						input1[i] = input_field[i].getText().charAt(0);
					}
					// 채점+다음 시도로 넘기기
					game_frame.ctl1.interrupt();
				}
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		game1 g1 = new game1(4);
		// JPanel tmp2=g1;

		JFrame tmp = new JFrame();
		tmp.setLayout(new BorderLayout());
		tmp.add(new JLabel("abc"), BorderLayout.NORTH);
		tmp.add(g1, BorderLayout.CENTER);
		tmp.setSize(700, 700);
		tmp.setVisible(true);
		tmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
