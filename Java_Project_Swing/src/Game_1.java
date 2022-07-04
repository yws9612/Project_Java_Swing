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
	int length;
	
	public Game_1(int length) {
		this.length=length;
		
		setLayout(new GridLayout(1, length, 10, 10));
		
		for (int i = 0; i < 6; i++) {
			input_field[i] = new JTextField();
			input_field[i].setOpaque(true);
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


		setVisible(true);
	}
	
	public String[] getinput() {
		for (int i = 0; i < length; i++) {
			input1[i]=input_field[i].getText();
		}
		return input1;
	}
	
	public void setTFcolor(boolean [] grade) {
		for(int i=0; i<length; i++) {
			if(grade[i]) {
				input_field[i].setBackground(Color.green);
			}
			else {
				input_field[i].setBackground(Color.red);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
