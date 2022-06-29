import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class game1 {

	public static void main(String[] args) {
		String getword1 = null;
		
		int w_length=getword1.length();
		
		JFrame tmp=new JFrame();
		tmp.setLayout(new GridLayout(w_length,5));
		
		JLabel [] a=new JLabel[w_length];
		JLabel [] b=new JLabel[w_length];
		JLabel [] c=new JLabel[w_length];
		JLabel [] d=new JLabel[w_length];
		JLabel [] e=new JLabel[w_length];
		JTextField [] input_field=new JTextField[6];
		char [] input=new char[w_length];
		boolean [] grading=new boolean[w_length];

		// textfield 글자수 제한+자동포커스 이동
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
				//채점 기준으로 넘어가야 한다.
			}
		});
		
		input_field[5].setFocusTraversalKeysEnabled(false);
		input_field[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					//채점 기준으로 넘어가야 한다.
				}
			}
		});
		
		//단어 끝칸
		input_field[w_length-1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//마지막 칸 엔터쳤을 때 이벤트 > 채점+다음 시도로 넘기기				
			}
		});
		
		input_field[w_length-1].setFocusTraversalKeysEnabled(false);
		input_field[w_length-1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					//채점 기준으로 넘어가야 한다.
				}
			}
		});
	}

}
