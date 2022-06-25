import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class Ranking extends JFrame implements ActionListener{

	JLabel mRanking;
	JButton ranExit;
	
	JPanel rankPanel;
	
	
	
	
	//��ŷ ���̺� ����
	Object obj[][] = new Object[0][3];
	DefaultTableModel model;
	JTable rank;
	JScrollPane jScroll;
	String col [] = {"ID", "��¥", "����"};//�ҷ��� Į�� �̸�
	
	//DB����
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		
		rankPanel = new JPanel();
		model = new DefaultTableModel(obj,col); //1)������ ����[][], 2)Į�� �̸�
		rank = new JTable(model);
		jScroll = new JScrollPane(rank);
		this.add(jScroll);
		setBounds(250,250,300,300);
		setVisible(true);
		
		//DB ���� �� select ������ ����� JTable�� �����ִ� ����
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
				String sql = "select id, score, playdate from member natural join score";
				pstmt = con.prepareStatement(sql);
				System.out.println("pstmt : " + pstmt);
				rs = pstmt.executeQuery();
				System.out.println("rs : " + rs);
				
				//���̺��� �� �ҷ�����
				while(rs.next()) {
					String id = rs.getString(1);
					int score = rs.getInt(2);
					java.sql.Date date = rs.getDate(3); 
					
				}
			}
		}




		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}

	

}
