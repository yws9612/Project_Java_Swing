import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class Ranking extends JFrame{


	JLabel mRanking;
	
	JButton ranExit;
	
	JPanel Panel, Panel1, rankPanel;
	
	JScrollPane jsp;
	
	
	
	
	//랭킹 테이블 세팅
	String col [] = {"순위", "ID", "날짜", "점수"};//테스트값
	Object obj[][] = {{"1","asdf","2012-11-11","800"},
			          {"2","asdf1","2013-11-11","900"},
			          {"3","asdf2","2014-11-11","1000"},
			          {"4","asdf3","2015-11-11","1200"},
			          {"5","asdf4","2016-11-11","1300"}};//new obj[0][29];
	DefaultTableModel model;
	JTable rank;
	//불러올 칼럼 이름
	//순위는 rownum으로 뽑아오고, id date score에서 각각 뽑아오면 될듯함
	
	
	
	
	//DB연동
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		setLayout(null);
		setSize(450,650);
	
		Container c = getContentPane();
		
		ranExit = new JButton("메인으로");
		
		mRanking = new JLabel("현재 순위");
		mRanking.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		
		
		//JTable 중앙 배치
		Panel = new JPanel();
		Panel1 = new JPanel();
		rankPanel = new JPanel();
		
		
		
		model = new DefaultTableModel(obj,col); //1)데이터 저장[][], 2)칼럼 이름
		rank = new JTable(model);
		jsp = new JScrollPane(rank);
		
		ranExit.setBackground(Color.gray);
		
		Panel.setBounds(10, 10, 65, 65);
		Panel.add(ranExit);
		
		Panel1.setBounds(150, 10,100, 100);
		Panel1.add(mRanking);
		
		
		jsp.setBounds(50,120,300,450);
		
		c.add(Panel);
		c.add(Panel1);
		c.add(jsp);
		
		setVisible(true);
		
		
		
		ranExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//DB 접속 후 select 문장을 사용해 JTable에 보여주는 구문
//		connect();
//		select();
//		
//		this.addWindowListener(new WindowAdapter() {
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				try {
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
//				con = DriverManager.getConnection(url, "SYW", "dusdns12!");
//				System.out.println("접속 : " + con);
//			}catch(Exception e) {
//				System.out.println("DB접속 오류 : " + e);
//			}
//		}
//		
//		public void select() {
//			try {
//				String sql = "select num, id, score, playdate from member natural join score";
//				pstmt = con.prepareStatement(sql);
//				System.out.println("pstmt : " + pstmt);
//				rs = pstmt.executeQuery();
//				System.out.println("rs : " + rs);
//				
//				//테이블에서 값 불러오기
//				while(rs.next()) {
//					int rank = rs.getInt(1);
//					String id = rs.getString(2);
//					int score = rs.getInt(3);
//					java.sql.Date date = rs.getDate(4); 
//					
//					Object data[] =  {rank, id, score, date};
//					model.addRow(data);
//					System.out.println(rank + " " + id + " " + score + " " + date);
//				}
//			}catch(Exception e) {
//				System.out.println("select() 실행 오류 : " + e);
//			}
		}




		

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}
}
