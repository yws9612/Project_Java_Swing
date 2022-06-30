import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class game1 extends JPanel {
	JLabel [] a=new JLabel[6];
	JLabel [] b=new JLabel[6];
	JLabel [] c=new JLabel[6];
	JLabel [] d=new JLabel[6];
	JLabel [] e=new JLabel[6];;
	JTextField [] input_field=new JTextField[6];
	char [] input;
	boolean [] grading;
	int w_length;
	
	public void set_grading(boolean [] boo) {
		for(int i=0; i<w_length; i++) {
			grading[i]=boo[i];
		}
	}	
	
	game1(int a) {
		w_length=a;
		setLayout(new GridLayout(5,w_length));		
		
		input=new char[w_length];
		grading=new boolean[w_length];
		
		for(int i=0;i<6;i++) {
			input_field[i] = new JTextField();				
		}
		
		for (int i = 0; i < w_length; i++) {
			add(input_field[i]);
		}
		for (int i = 0; i < w_length; i++) {
			b[i] = new JLabel();
			add(b[i]);
		}
		for (int i = 0; i < w_length; i++) {
			c[i] = new JLabel();
			add(c[i]);
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
		input_field[5].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 1) {
					ke.consume();
					//채점+다음 시도로 넘기기
				}
			}
		});
		
		//엔터쳤을 때 액션
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
		input_field[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//채점+다음 시도로 넘기기
			}
		});
		
		input_field[5].setFocusTraversalKeysEnabled(false);
		input_field[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					//채점+다음 시도로 넘기기
				}
			}
		});
		
		
		//단어 끝칸_엔터
		input_field[w_length-1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//채점+다음 시도로 넘기기				
			}
		});
		
		//단어 끝칸_탭
		input_field[w_length-1].setFocusTraversalKeysEnabled(false);
		input_field[w_length-1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					//채점+다음 시도로 넘기기
				}
			}
		});		

		setVisible(true);		
	}

	public static void main(String[] args) {

		game1 g1=new game1(4);
		//JPanel tmp2=g1;
		
		JFrame tmp=new JFrame();
		tmp.setLayout(new BorderLayout());
		tmp.add(new JLabel("abc"),BorderLayout.NORTH);
		tmp.add(g1,BorderLayout.CENTER);
		tmp.setSize(700, 700);
		tmp.setVisible(true);
		tmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
