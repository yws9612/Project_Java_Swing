import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




public class Choice extends JFrame {

	private JPanel contentPane;
	
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/background-choice.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choice frame = new Choice();
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
	public Choice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bt_ch01 = new JButton("\uC21C\uC6B0\uB9AC\uB9D0 \uB9DE\uCD94\uAE30");
		bt_ch01.setBounds(300, 140, 300, 70);
		bt_ch01.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		contentPane.add(bt_ch01);
		
		JButton bt_ch02 = new JButton("\uC21C\uD654\uC5B4 \uB9DE\uCD94\uAE30");
		bt_ch02.setBounds(300, 280, 300, 70);
		bt_ch02.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		contentPane.add(bt_ch02);
		
		JButton bt_ch03 = new JButton("\uB0B4\uB7AD\uD0B9");
		bt_ch03.setBounds(300, 420, 300, 70);
		bt_ch03.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		contentPane.add(bt_ch03);
		
		JButton bt_ch04 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		bt_ch04.setBounds(710, 542, 150, 35);
		bt_ch04.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		contentPane.add(bt_ch04);
		
		setSize(900, 640);		
		
		background.setLayout(null);
		background.setBounds(0, 0, 900, 640);
		add(background);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		bt_ch03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RankingButton();
                dispose(); // â �Ⱥ��̰� �ϱ� 
            }
        });
		
		bt_ch04.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new login();
				dispose();
			}
		});
	}
}
