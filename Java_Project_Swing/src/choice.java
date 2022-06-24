import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class choice extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choice frame = new choice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public choice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ch01Button = new JButton("\uC21C\uC6B0\uB9AC\uB9D0 \uB9DE\uCD94\uAE30");
		ch01Button.setBounds(300, 140, 300, 70);
		contentPane.add(ch01Button);
		
		JButton ch02Button = new JButton("\uC21C\uD654\uC5B4 \uB9DE\uCD94\uAE30");
		ch02Button.setBounds(300, 280, 300, 70);
		contentPane.add(ch02Button);
		
		JButton ch03Button = new JButton("\uB0B4\uB7AD\uD0B9");
		ch03Button.setBounds(300, 420, 300, 70);
		contentPane.add(ch03Button);
		
		JButton ch03Button_1 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		ch03Button_1.setBounds(710, 542, 150, 35);
		contentPane.add(ch03Button_1);
		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
