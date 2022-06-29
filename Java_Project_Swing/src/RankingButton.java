import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;

import javax.swing.SwingConstants;

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
		select();

		Link link = new Link();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bt_rk01 = new JButton("\uBA54\uC778\uC73C\uB85C");
		bt_rk01.setBounds(25, 20, 150, 35);
		contentPane.add(bt_rk01);

		JLabel lb_rk06 = new JLabel("\uC21C\uC704\uD45C");
		lb_rk06.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rk06.setFont(new Font("留묒� 怨좊뵓", Font.PLAIN, 20));
		lb_rk06.setBounds(375, 53, 150, 35);
		contentPane.add(lb_rk06);

		JLabel lb_rk01 = new JLabel("1.");
		lb_rk01.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk01.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk01.setBounds(300, 140, 100, 70);
		contentPane.add(lb_rk01);
		
		JLabel lb_rk11 = new JLabel("id1");
		lb_rk11.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk11.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk11.setBounds(400, 140, 100, 70);
		contentPane.add(lb_rk11);
		
		JLabel lb_rk21 = new JLabel("scores1");
		lb_rk21.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk21.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk21.setBounds(500, 140, 100, 70);
		contentPane.add(lb_rk21);

		JLabel lb_rk02 = new JLabel("2.");
		lb_rk02.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk02.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk02.setBounds(300, 210, 100, 70);
		contentPane.add(lb_rk02);
		
		JLabel lb_rk12 = new JLabel("id2");
		lb_rk12.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk12.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk12.setBounds(400, 210, 100, 70);
		contentPane.add(lb_rk12);
		
		JLabel lb_rk22 = new JLabel("scores2");
		lb_rk22.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk22.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk22.setBounds(500, 210, 100, 70);
		contentPane.add(lb_rk22);
		
		

		JLabel lb_rk03 = new JLabel("3.");
		lb_rk03.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk03.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk03.setBounds(300, 280, 100, 70);
		contentPane.add(lb_rk03);
		
		JLabel lb_rk13 = new JLabel("id3");
		lb_rk13.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk13.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk13.setBounds(400, 280, 100, 70);
		contentPane.add(lb_rk13);
		
		JLabel lb_rk23 = new JLabel("scores3");
		lb_rk23.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk23.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk23.setBounds(500, 280, 100, 70);
		contentPane.add(lb_rk23);

		JLabel lb_rk04 = new JLabel("4.");
		lb_rk04.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk04.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk04.setBounds(300, 350, 100, 70);
		contentPane.add(lb_rk04);
		
		JLabel lb_rk14 = new JLabel("id4");
		lb_rk14.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk14.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk14.setBounds(400, 350, 100, 70);
		contentPane.add(lb_rk14);
		
		JLabel lb_rk24 = new JLabel("scores4");
		lb_rk24.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk24.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk24.setBounds(500, 350, 100, 70);
		contentPane.add(lb_rk24);

		JLabel lb_rk05 = new JLabel("5.");
		lb_rk05.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk05.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk05.setBounds(300, 420, 100, 70);
		contentPane.add(lb_rk05);
		
		JLabel lb_rk15 = new JLabel("id5");
		lb_rk15.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk15.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk15.setBounds(400, 420, 100, 70);
		contentPane.add(lb_rk15);
		
		JLabel lb_rk25 = new JLabel("scores5");
		lb_rk25.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk25.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk25.setBounds(500, 420, 100, 70);
		contentPane.add(lb_rk25);

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
	}

	public void select() {
		Connection conn=null; //DB占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙占쏙옙占싱쏙옙

		PreparedStatement psmt=null; //sql占쏙옙 占쏙옙체

        ResultSet rs=null; //sql占쏙옙 占쏙옙占쏙옙 占쏙옙환(占쏙옙占쏙옙 占쏙옙占썅에 占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙)
        
        
        try {
			String sql = "select id, scores from (select id, scores from member natural join score order by scores desc) where rownum <= 5";
			
			conn = Connect.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			//占쏙옙占싱븝옙占쏙옙 占쏙옙 占쌀뤄옙占쏙옙占쏙옙
			while(rs.next()) {
				String id = rs.getString(1);
				int scores = rs.getInt(2);
				System.out.println(id + " " + scores);
			}
		}catch(Exception e) {
			System.out.println("select() 占쏙옙占쏙옙 占쏙옙占쏙옙 : " + e);
		}
	}
}
