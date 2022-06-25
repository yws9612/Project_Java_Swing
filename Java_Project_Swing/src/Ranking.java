import java.awt.Panel;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class Ranking extends JFrame{

	JLabel mRanking;
	
	JLabel l1, l2, l3, l4, l5;
	
	JButton ranExit;
	
	JPanel rankPanel;
	
	
	
	
	//랭킹 테이블 세팅
	Object obj[][] = new Object[0][4];
	DefaultTableModel model;
	JTable rank;
	JScrollPane jScroll;
	String col [] = {"순위", "ID", "날짜", "점수"};//불러올 칼럼 이름
	//순위는 rownum으로 뽑아오고, id date score에서 각각 뽑아오면 될듯함
	
	
	
	
	//DB연동
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		rankPanel.setLayout(null);
		
		ranExit = new JButton("종료");
		
		mRanking = new JLabel("현재 순위");
		
		l1 = new JLabel("1");
		l2 = new JLabel("2");
		l3 = new JLabel("3");
		l4 = new JLabel("4");
		l5 = new JLabel("5");
		
		rankPanel.add(jScroll)
		
		//JTable 중앙 배치
		rankPanel = new JPanel();
		model = new DefaultTableModel(obj,col); //1)데이터 저장[][], 2)칼럼 이름
		rank = new JTable(model);
	
		setBounds(250,250,300,300);
		setVisible(true);
		
		
		
		
		
		
		//DB 접속 후 select 문장을 사용해 JTable에 보여주는 구문
		connect();
		select();
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if(rs!= null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(con != null) {
						con.close();
					}
			}catch(Exception e1) {
				System.exit(0);
				}
			}
		});
	}
		
		

		private void connect() {
			try {
				//접속할 메모리 드라이버에 올림
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:this@localhost:1521:xepdb1";
				//접속하기 위한 메소드(접속 url, 계정명, 암호)
				con = DriverManager.getConnection(url, "SYW", "dusdns12!");
				System.out.println("접속 : " + con);
			}catch(Exception e) {
				System.out.println("DB접속 오류 : " + e);
			}
		}
		
		public void select() {
			try {
				String sql = "select num, id, score, playdate from member natural join score";
				pstmt = con.prepareStatement(sql);
				System.out.println("pstmt : " + pstmt);
				rs = pstmt.executeQuery();
				System.out.println("rs : " + rs);
				
				//테이블에서 값 불러오기
				while(rs.next()) {
					int rank = rs.getInt(1);
					String id = rs.getString(2);
					int score = rs.getInt(3);
					java.sql.Date date = rs.getDate(4); 
					
					Object data[] =  {rank, id, score, date};
					model.addRow(data);
					System.out.println(rank + " " + id + " " + score + " " + date);
				}
			}catch(Exception e) {
				System.out.println("select() 실행 오류 : " + e);
			}
		}




		

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}

	

}
