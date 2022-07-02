import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ManagerChoice extends JFrame{

	JLabel title = new JLabel("관리자 페이지");
	JButton m_page = new JButton("관리자 페이지");
	JButton mem = new JButton("회원 관리");
	JButton mw1 = new JButton("순우리말 관리");
	JButton mw2 = new JButton("순화어 관리");
	JButton log_out = new JButton("로그아웃");
	JPanel background = new JPanel() {
		Image back = new ImageIcon("image/background.png").getImage();

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
		
//		m_page.setBounds(300, 30, 300, 50);
//		m_page.setFont(new Font("DungGeunMo",Font.PLAIN,15));
//		c.add(m_page);
		
		
		title.setBounds(300,30,300,50);
		title.setFont(new Font("DungGeunMo",Font.PLAIN,40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(title);
		
		mem.setBounds(300, 140, 300, 70);
		mem.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		c.add(mem);
		
		mw1.setBounds(300, 280, 300, 70);
		mw1.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		c.add(mw1);
		
		mw2.setBounds(300, 420, 300, 70);
		mw2.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		c.add(mw2);
		
		log_out.setBounds(710, 542, 150, 35);
		log_out.setFont(new Font("DungGeunMo",Font.PLAIN,15));
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
		
		mw1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageW1();
				dispose();
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
		
		log_out.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				new login();
				dispose();
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
