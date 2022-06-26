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

import javax.swing.SwingConstants;

public class RankingButton extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
                new choice();
                dispose(); // 창 안보이게 하기 
            }
        });
		
		
		
		//DB 접속 후 select 문장을 사용해 출력하는 구문
//		connect();
//		select();
//		
//		this.addWindowListener(new WindowAdapter() {
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				try {//프로그램 종료 전에 메모리에 DB연동 부분 해제
//					if(rs!= null) {
//						rs.close();
//					}
//					if(pstmt != null) {
//						pstmt.close();
//					}
//					if(con != null) {
//						con.close();
//					}
//			}catch(Exception e1) {
//				System.exit(0);
//				}
//			}
//		});
//	}
		
		

//		private void connect() {
//			try {
//				//접속할 메모리 드라이버에 올림
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				String url = "jdbc:oracle:this@localhost:1521:xepdb1";
//				//접속하기 위한 메소드(접속 url, 계정명, 암호)
//				con = DriverManager.getConnection(url, 계정명, 암호);
//				System.out.println("접속 : " + con);
//			}catch(Exception e) {
//				System.out.println("DB접속 오류 : " + e);
//			}
//		}
//		
//		public void select() {
//			try {
//				String sql = "select id, score from (select id, score from member natural join order by score desc) where rownum <=5";
//				pstmt = con.prepareStatement(sql);
//				System.out.println("pstmt : " + pstmt);
//				rs = pstmt.executeQuery();
//				System.out.println("rs : " + rs);
//				
//				//테이블에서 값 불러오기
//				while(rs.next()) {
//					String id = rs.getString(1);
//					int score = rs.getInt(2);
//					java.sql.Date date = rs.getDate(3); 
//					System.out.println(rank + " " + id + " " + score + " " + date);
//				}
//			}catch(Exception e) {
//				System.out.println("select() 실행 오류 : " + e);
//			}
//		}
		
		setSize(900, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
