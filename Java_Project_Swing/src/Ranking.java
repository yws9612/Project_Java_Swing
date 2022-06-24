import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class Ranking extends JPanel implements ActionListener{

	JLabel mRanking;
	JButton ranExit;
	
	JPanel rankPanel;
	
	
	
	
	//랭킹 테이블 세팅
	Object obj[][] = new Object[0][4];
	DefaultTableModel model;
	JTable rank;
	JScrollPane jScroll;
	String col [] = {"순위", "ID", "날짜", "점수"};//불러올 칼럼 이름
	
	//DB연동
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		
		rankPanel = new JPanel();
		model = new DefaultTableModel(obj,col); //1)데이터 저장[][], 2)칼럼 이름
		rank = new JTable(model);
		jScroll = new JScrollPane(rank);
		this.add(jScroll);
		setBounds(250,250,300,300);
		setVisible(true);
		
		//DB 접속 후 select 문장을 사용해 JTable에 보여주는 구문
		connect();
		select();
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
	}
		
		private void connect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:this@localhost:1521:xepdb1";
				
				con = DriverManager.getConnection(url, "SYW", "dusdns12!");
				System.out.println("접속 : " + con);
			}catch(Exception e) {
				System.out.println("DB접속 오류 : " + e);
			}
		}
		
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}

}
