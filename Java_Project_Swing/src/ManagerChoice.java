import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ManagerChoice extends JFrame{
	
	ImageIcon buttonimg1 = new ImageIcon("image/big_button.png");
	ImageIcon buttonimg2 = new ImageIcon("image/big_button_select.png");
	ImageIcon buttonimg3 = new ImageIcon("image/medium_button_.png");
	ImageIcon buttonimg4 = new ImageIcon("image/medium_button_select.png");

	
	JButton mem = new JButton("회원 관리", buttonimg1);
	JButton mw1 = new JButton("순우리말 관리", buttonimg1);
	JButton mw2 = new JButton("순화어 관리", buttonimg1);
	JButton log_out = new JButton("로그아웃", buttonimg3);
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/manager_background.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(back, 0, 0, null);
		}
	};
	
	ManagerChoice(){
		Container c = getContentPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		c = new JPanel();
		((JComponent) c).setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(c);
		c.setLayout(null);
		
		
		mem.setBounds(300, 140, 300, 70);
		mem.setHorizontalTextPosition(JButton.CENTER);
		mem.setRolloverIcon(buttonimg2);
		mem.setBorderPainted(false);
		mem.setContentAreaFilled(false);
		mem.setFocusPainted(false);
		mem.setForeground(Color.black);
		mem.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		c.add(mem);
		
		mw1.setBounds(300, 280, 300, 70);
		mw1.setHorizontalTextPosition(JButton.CENTER);
		mw1.setRolloverIcon(buttonimg2);
		mw1.setBorderPainted(false);
		mw1.setContentAreaFilled(false);
		mw1.setFocusPainted(false);
		mw1.setForeground(Color.black);
		mw1.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		c.add(mw1);
		
		mw2.setBounds(300, 420, 300, 70);
		mw2.setHorizontalTextPosition(JButton.CENTER);
		mw2.setRolloverIcon(buttonimg2);
		mw2.setBorderPainted(false);
		mw2.setContentAreaFilled(false);
		mw2.setFocusPainted(false);
		mw2.setForeground(Color.black);
		mw2.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		c.add(mw2);
		
		log_out.setBounds(710, 542, 150, 35);
		log_out.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		log_out.setHorizontalTextPosition(JButton.CENTER);
		log_out.setRolloverIcon(buttonimg4);
		log_out.setBorderPainted(false);
		log_out.setContentAreaFilled(false);
		log_out.setFocusPainted(false);
		log_out.setForeground(Color.black);
		c.add(log_out);
		
		
		setSize(900,640);
		
		background.setLayout(null);
		background.setBounds(0, 0, 900, 640);
		add(background);
		

		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //창크기 고정 하기
		setVisible(true);

		mem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageMember();
				dispose();
			}
			
		});
		
		mem.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			mem.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			mem.setForeground(Color.black);
			    }
			});

		
		mw1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageW1();
				dispose();
			}
			
		});
		
		mw1.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			mw1.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			mw1.setForeground(Color.black);
			    }
			});
		
		mw2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageW2();
				dispose();
			}
			
		});
		
		mw2.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			mw2.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			mw2.setForeground(Color.black);
			    }
			});
		
		log_out.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new login();
				dispose();
			}
			
		});
		
		log_out.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			log_out.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			log_out.setForeground(Color.black);
			    }
			});

		setVisible(true);
		setLayout(null);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerChoice();
	}

}
