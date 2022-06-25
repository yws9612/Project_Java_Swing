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
	
	
	
	
	//��ŷ ���̺� ����
	Object obj[][] = new Object[0][4];
	DefaultTableModel model;
	JTable rank;
	JScrollPane jScroll;
	String col [] = {"����", "ID", "��¥", "����"};//�ҷ��� Į�� �̸�
	//������ rownum���� �̾ƿ���, id date score���� ���� �̾ƿ��� �ɵ���
	
	
	
	
	//DB����
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		rankPanel.setLayout(null);
		
		ranExit = new JButton("����");
		
		mRanking = new JLabel("���� ����");
		
		l1 = new JLabel("1");
		l2 = new JLabel("2");
		l3 = new JLabel("3");
		l4 = new JLabel("4");
		l5 = new JLabel("5");
		
		rankPanel.add(jScroll)
		
		//JTable �߾� ��ġ
		rankPanel = new JPanel();
		model = new DefaultTableModel(obj,col); //1)������ ����[][], 2)Į�� �̸�
		rank = new JTable(model);
	
		setBounds(250,250,300,300);
		setVisible(true);
		
		
		
		
		
		
		//DB ���� �� select ������ ����� JTable�� �����ִ� ����
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
				//������ �޸� ����̹��� �ø�
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:this@localhost:1521:xepdb1";
				//�����ϱ� ���� �޼ҵ�(���� url, ������, ��ȣ)
				con = DriverManager.getConnection(url, "SYW", "dusdns12!");
				System.out.println("���� : " + con);
			}catch(Exception e) {
				System.out.println("DB���� ���� : " + e);
			}
		}
		
		public void select() {
			try {
				String sql = "select num, id, score, playdate from member natural join score";
				pstmt = con.prepareStatement(sql);
				System.out.println("pstmt : " + pstmt);
				rs = pstmt.executeQuery();
				System.out.println("rs : " + rs);
				
				//���̺��� �� �ҷ�����
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
				System.out.println("select() ���� ���� : " + e);
			}
		}




		

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}

	

}
