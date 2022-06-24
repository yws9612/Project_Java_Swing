import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class Ranking extends JPanel implements ActionListener{

	JLabel mRanking;
	JButton ranExit;
	
	JPanel rankPanel;
	
	
	
	
	//��ŷ ���̺� ����
	Object obj[][] = new Object[0][4];
	DefaultTableModel model;
	JTable rank;
	JScrollPane jScroll;
	String col [] = {"����", "ID", "��¥", "����"};//�ҷ��� Į�� �̸�
	
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
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:this@localhost:1521:xepdb1";
				
				con = DriverManager.getConnection(url, "SYW", "dusdns12!");
				System.out.println("���� : " + con);
			}catch(Exception e) {
				System.out.println("DB���� ���� : " + e);
			}
		}
		
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ranking();
	}

}
