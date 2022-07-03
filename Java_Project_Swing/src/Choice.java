import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		
		ImageIcon buttonimg1 = new ImageIcon("image/big_button.png");
		ImageIcon buttonimg2 = new ImageIcon("image/big_button_select.png");
		ImageIcon buttonimg3 = new ImageIcon("image/medium_button_.png");
		ImageIcon buttonimg4 = new ImageIcon("image/medium_button_select.png");

		
		JButton bt_ch01 = new JButton("순우리말 맞추기", buttonimg1);
		bt_ch01.setBounds(300, 140, 300, 70);
		bt_ch01.setHorizontalTextPosition(JButton.CENTER); // 텍스트 가운데
		bt_ch01.setRolloverIcon(buttonimg2);
		bt_ch01.setBorderPainted(false);
		bt_ch01.setContentAreaFilled(false);
		bt_ch01.setFocusPainted(false);
		bt_ch01.setForeground(Color.black);
		bt_ch01.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		contentPane.add(bt_ch01);
		
		JButton bt_ch02 = new JButton("순화어 맞추기", buttonimg1);
		bt_ch02.setBounds(300, 280, 300, 70);
		bt_ch02.setHorizontalTextPosition(JButton.CENTER); // 텍스트 가운데
		bt_ch02.setRolloverIcon(buttonimg2);
		bt_ch02.setBorderPainted(false);
		bt_ch02.setContentAreaFilled(false);
		bt_ch02.setFocusPainted(false);
		bt_ch02.setForeground(Color.black);
		bt_ch02.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		contentPane.add(bt_ch02);

		
		JButton bt_ch03 = new JButton("내 랭킹", buttonimg1);
		bt_ch03.setBounds(300, 420, 300, 70);
		bt_ch03.setHorizontalTextPosition(JButton.CENTER); // 텍스트 가운데
		bt_ch03.setRolloverIcon(buttonimg2);
		bt_ch03.setBorderPainted(false);
		bt_ch03.setContentAreaFilled(false);
		bt_ch03.setFocusPainted(false);
		bt_ch03.setForeground(Color.black);
		bt_ch03.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		contentPane.add(bt_ch03);

		
		JButton bt_ch04 = new JButton("로그아웃", buttonimg3);
		bt_ch04.setBounds(710, 542, 150, 35);
		bt_ch04.setHorizontalTextPosition(JButton.CENTER);
		bt_ch04.setRolloverIcon(buttonimg4);
		bt_ch04.setBorderPainted(false);
		bt_ch04.setContentAreaFilled(false);
		bt_ch04.setFocusPainted(false);
		bt_ch04.setForeground(Color.black);
		bt_ch04.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		contentPane.add(bt_ch04);
		
		

		setSize(900,640);
		
		background.setLayout(null);
		background.setBounds(0, 0, 900, 640);
		add(background);
		
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		bt_ch01.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
					bt_ch01.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
				 	bt_ch01.setForeground(Color.black);
			    }
		});
		
		bt_ch02.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
					bt_ch02.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
				 	bt_ch02.setForeground(Color.black);
			    }
		});
		
		bt_ch03.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
					bt_ch03.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
				 	bt_ch03.setForeground(Color.black);
			    }
		});
		
		bt_ch04.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
					bt_ch04.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
				 	bt_ch04.setForeground(Color.black);
			    }
		});
		
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
