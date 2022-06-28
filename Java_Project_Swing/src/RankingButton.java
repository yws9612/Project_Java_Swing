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

//		Connection conn = null; // DB와 연결하는 인터페이스
//
//		PreparedStatement psmt = null; // sql문 객체
//
//		ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장)
//
//		try {
//			String que = "select * from member";
//			conn = Connect.get(); // DB연결
//			psmt = conn.prepareStatement(que);
//			rs = psmt.executeQuery();
//
//			// select => executeQuery()
//
//			// DML(insert,update,delete) => executeUpdate();
//			while (rs.next()) {
//				String ID = rs.getString(2);
//				System.out.println(ID);
//				// DB에 있는 값들을 가져옴
//			}
//
//		}
//
//		catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//		rs.close();
//		psmt.close();
//		conn.close();

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
//		connect();
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
		lb_rk06.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk06.setBounds(375, 53, 150, 35);
		contentPane.add(lb_rk06);

		JLabel lb_rk01 = new JLabel("1.");
		lb_rk01.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk01.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk01.setBounds(300, 140, 300, 70);
		contentPane.add(lb_rk01);

		JLabel lb_rk02 = new JLabel("2.");
		lb_rk02.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk02.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk02.setBounds(300, 210, 300, 70);
		contentPane.add(lb_rk02);

		JLabel lb_rk03 = new JLabel("3.");
		lb_rk03.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk03.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk03.setBounds(300, 280, 300, 70);
		contentPane.add(lb_rk03);

		JLabel lb_rk04 = new JLabel("4.");
		lb_rk04.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk04.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk04.setBounds(300, 350, 300, 70);
		contentPane.add(lb_rk04);

		JLabel lb_rk05 = new JLabel("5.");
		lb_rk05.setHorizontalAlignment(SwingConstants.LEFT);
		lb_rk05.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_rk05.setBounds(300, 420, 300, 70);
		contentPane.add(lb_rk05);

		bt_rk01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Choice();
				dispose(); // 창 안보이게 하기
			}
		});

		// DB 접속 후 select 문장을 사용해 출력하는 구문

		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void select() {
		Connection conn=null; //DB와 연결하는 인터페이스

		PreparedStatement psmt=null; //sql문 객체

        ResultSet rs=null; //sql에 대한 반환(쿼리 실행에 대한 결과값 저장)
        
        
        try {
			String sql = "select id, scores from (select id, scores from member natural join score order by scores desc) where rownum <= 5";
			
			conn = Connect.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			//테이블에서 값 불러오기
			while(rs.next()) {
				String id = rs.getString(1);
				int scores = rs.getInt(2);
				System.out.println(id + " " + scores);
			}
		}catch(Exception e) {
			System.out.println("select() 실행 오류 : " + e);
		}
	}
}
