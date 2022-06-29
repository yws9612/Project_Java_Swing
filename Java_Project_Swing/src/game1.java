import java.awt.BorderLayout;
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
	public void set_length(int w_length) {
		this.w_length=w_length;
		System.out.println(w_length);
	}	
	
	game1() {
		setLayout(new GridLayout(w_length,5));		
		
		input=new char[w_length];
		grading=new boolean[w_length];

		// textfield 글자수 제한+자동포커스 이동
		/*
		input_field[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 1) {
					ke.consume();
					input_field[1].requestFocus();
				}
			}
		});
		input_field[1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 1) {
					ke.consume();
					input_field[2].requestFocus();
				}
			}
		});
		input_field[2].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 1) {
					ke.consume();
					input_field[3].requestFocus();
				}
			}
		});
		input_field[3].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 1) {
					ke.consume();
					input_field[4].requestFocus();
				}
			}
		});
		input_field[4].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 1) {
					ke.consume();
					input_field[5].requestFocus();
				}
			}
		});
		input_field[5].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 1) {
					ke.consume();
					//채점 들어가야 함 
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
				//채점으로 넘어가야 한다.
			}
		});
		
		input_field[5].setFocusTraversalKeysEnabled(false);
		input_field[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					//채점으로 넘어가야 한다.
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
					//채점 기준으로 넘어가야 한다.
				}
			}
		});
		*/
		
		
		
		for(int i=0; i<w_length; i++) {
			input_field[i]=new JTextField();
			add(input_field[i]);
			add(b[i]);
			add(c[i]);
			add(d[i]);
			add(e[i]);
		}
		
		setSize(w_length*30, (30*5)+(10*4));
		setVisible(true);
	}

	public static void main(String[] args) {

		game1 g1=new game1();
		g1.set_length(5);
		
		JFrame tmp=new JFrame();
		tmp.setLayout(new BorderLayout());
		tmp.add(g1,BorderLayout.CENTER);
		tmp.setSize(700, 700);
		tmp.setVisible(true);
		tmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
