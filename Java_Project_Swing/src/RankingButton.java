import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.SwingConstants;

class Setter{
	
	private String ID;
	private int scores;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
}
class backimage extends JPanel{
	Image image=new ImageIcon("image/ranking.png").getImage();
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);		
	}
}
public class RankingButton extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingButton frame = new RankingButton();
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
	public RankingButton() {
		
		ImageIcon buttonimg1 = new ImageIcon("image/150_35_button.png");
		ImageIcon buttonimg2 = new ImageIcon("image/150_35_button_select.png");

		Link link = new Link();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bt_rk01 = new JButton("메인으로",buttonimg1);
		bt_rk01.setBounds(25, 20, 150, 35);
		bt_rk01.setHorizontalTextPosition(JButton.CENTER);
		bt_rk01.setRolloverIcon(buttonimg2);
		bt_rk01.setBorderPainted(false);
		bt_rk01.setContentAreaFilled(false);
		bt_rk01.setFocusPainted(false);
		bt_rk01.setForeground(Color.black);
		bt_rk01.setFont(new Font("DungGeunMo",Font.PLAIN,15));
		contentPane.add(bt_rk01);

		JLabel lb_rk06 = new JLabel("\uC21C\uC704\uD45C");
		lb_rk06.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rk06.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk06.setForeground(Color.white);
		lb_rk06.setBounds(375, 53, 150, 35);
		//contentPane.add(lb_rk06);

		JLabel lb_rk01 = new JLabel("1.");
		lb_rk01.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk01.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk01.setForeground(Color.white);
		lb_rk01.setBounds(300, 140, 100, 70);
		contentPane.add(lb_rk01);
		
		JLabel lb_rk11 = new JLabel("id1");
		lb_rk11.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk11.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk11.setForeground(Color.white);
		lb_rk11.setBounds(400, 140, 100, 70);
		contentPane.add(lb_rk11);
		
		JLabel lb_rk21 = new JLabel("scores1");
		lb_rk21.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk21.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk21.setForeground(Color.white);
		lb_rk21.setBounds(500, 140, 100, 70);
		contentPane.add(lb_rk21);

		JLabel lb_rk02 = new JLabel("2.");
		lb_rk02.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk02.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk02.setForeground(Color.white);
		lb_rk02.setBounds(300, 210, 100, 70);
		contentPane.add(lb_rk02);
		
		JLabel lb_rk12 = new JLabel("id2");
		lb_rk12.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk12.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk12.setForeground(Color.white);
		lb_rk12.setBounds(400, 210, 100, 70);
		contentPane.add(lb_rk12);
		
		JLabel lb_rk22 = new JLabel("scores2");
		lb_rk22.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk22.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk22.setForeground(Color.white);
		lb_rk22.setBounds(500, 210, 100, 70);
		contentPane.add(lb_rk22);
		
		

		JLabel lb_rk03 = new JLabel("3.");
		lb_rk03.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk03.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk03.setForeground(Color.white);
		lb_rk03.setBounds(300, 280, 100, 70);
		contentPane.add(lb_rk03);
		
		JLabel lb_rk13 = new JLabel("id3");
		lb_rk13.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk13.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk13.setForeground(Color.white);
		lb_rk13.setBounds(400, 280, 100, 70);
		contentPane.add(lb_rk13);
		
		JLabel lb_rk23 = new JLabel("scores3");
		lb_rk23.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk23.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk23.setForeground(Color.white);
		lb_rk23.setBounds(500, 280, 100, 70);
		contentPane.add(lb_rk23);

		JLabel lb_rk04 = new JLabel("4.");
		lb_rk04.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk04.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk04.setForeground(Color.white);
		lb_rk04.setBounds(300, 350, 100, 70);
		contentPane.add(lb_rk04);
		
		JLabel lb_rk14 = new JLabel("id4");
		lb_rk14.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk14.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk14.setForeground(Color.white);
		lb_rk14.setBounds(400, 350, 100, 70);
		contentPane.add(lb_rk14);
		
		JLabel lb_rk24 = new JLabel("scores4");
		lb_rk24.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk24.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk24.setForeground(Color.white);
		lb_rk24.setBounds(500, 350, 100, 70);
		contentPane.add(lb_rk24);

		JLabel lb_rk05 = new JLabel("5.");
		lb_rk05.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk05.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk05.setForeground(Color.white);
		lb_rk05.setBounds(300, 420, 100, 70);
		contentPane.add(lb_rk05);
		
		JLabel lb_rk15 = new JLabel();
		lb_rk15.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk15.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk15.setForeground(Color.white);
		lb_rk15.setBounds(400, 420, 100, 70);
		contentPane.add(lb_rk15);
		
		JLabel lb_rk25 = new JLabel("scores5");
		lb_rk25.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk25.setFont(new Font("DungGeunMo",Font.PLAIN,20));
		lb_rk25.setForeground(Color.white);
		lb_rk25.setBounds(500, 420, 100, 70);
		contentPane.add(lb_rk25);		

		JPanel background=new backimage();
		background.setSize(900, 640);
		contentPane.add(background);

		bt_rk01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Choice();
				dispose();
			}
		});

		

		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		bt_rk01.addMouseListener(new MouseAdapter() {
			 @Override
			    public void mouseEntered(MouseEvent e) {
			bt_rk01.setForeground(Color.white);
			    }
			 @Override
			    public void mouseExited(MouseEvent e) {
			bt_rk01.setForeground(Color.black);
			    }
			});

		
		Connection conn=null; 

		PreparedStatement psmt=null; 

        ResultSet rs=null; 
        
        ArrayList<Setter> set = new ArrayList<>();
        
        
        try {
			String sql = "select id, scores from (select id, scores from member natural join score order by scores desc) where rownum <= 5";
			
			conn = Connect.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				Setter sett = new Setter();
				sett.setID(rs.getString(1));
				sett.setScores(rs.getInt(2));			
				set.add(sett);
			}
			lb_rk11.setText(set.get(0).getID());
			lb_rk12.setText(set.get(1).getID());
			lb_rk13.setText(set.get(2).getID());
			lb_rk14.setText(set.get(3).getID());
			lb_rk15.setText(set.get(4).getID());
			
			lb_rk21.setText(set.get(0).getScores()+"");
			lb_rk22.setText(set.get(1).getScores()+"");
			lb_rk23.setText(set.get(2).getScores()+"");
			lb_rk24.setText(set.get(3).getScores()+"");
			lb_rk25.setText(set.get(4).getScores()+"");
			
				
		}catch(Exception e) {
			System.out.println("select() : " + e);
		}
        
		
	}
	

	public void select() {
		
	}
}
