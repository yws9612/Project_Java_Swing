import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class Ranking extends JFrame{


	JLabel mRanking;
	
	JButton ranExit;
	
	JPanel Panel;
	
	
	
	
	//��ŷ ���̺� ����
	Object obj[][] = new Object[0][4];
	DefaultTableModel model;
	JTable rank;
	String col [] = {"����", "ID", "��¥", "����"};//�ҷ��� Į�� �̸�
	//������ rownum���� �̾ƿ���, id date score���� ���� �̾ƿ��� �ɵ���
	
	
	
	
	//DB����
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		setLayout(null);
		Container c = getContentPane();
	
		
		
//		c.add(rankPanel);
		
		ranExit = new JButton("����");
		
		mRanking = new JLabel("���� ����");
		
		
		
		
		//JTable �߾� ��ġ
		Panel = new JPanel();
		
		JPanel rankPanel = new JPanel();
		
		
		model = new DefaultTableModel(obj,col); //1)������ ����[][], 2)Į�� �̸�
		rank = new JTable(model);
		
		//JTable�� ���� �гο� ���̴� ��İ� �ٸ�. JScrollPane����ؼ� �ٿ��� �ҵ���
		
		Panel.add(ranExit);
		Panel.add(mRanking);
		rankPanel.add(rank);
		
		
		Panel.setBounds(50,50,50,50);
		rankPanel.setBounds(250, 250, 250, 250);
		
		c.add(Panel);
		c.add(rank);
		rank.setBounds(500,500,500,500);
		
		
		
		setVisible(true);
		
		
		
		
		
		
		//DB ���� �� select ������ ����� JTable�� �����ִ� ����
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
//				//������ �޸� ����̹��� �ø�
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				String url = "jdbc:oracle:this@localhost:1521:xepdb1";
//				//�����ϱ� ���� �޼ҵ�(���� url, ������, ��ȣ)
//				con = DriverManager.getConnection(url, "SYW", "dusdns12!");
//				System.out.println("���� : " + con);
//			}catch(Exception e) {
//				System.out.println("DB���� ���� : " + e);
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
//				//���̺��� �� �ҷ�����
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
//				System.out.println("select() ���� ���� : " + e);
//			}
		}




		

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}

	

}
