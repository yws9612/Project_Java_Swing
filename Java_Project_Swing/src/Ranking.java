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
	
	
	
	
	//��ŷ ���̺� ����
	String col [] = {"����", "ID", "��¥", "����"};//�׽�Ʈ��
	Object obj[][] = {{"1","asdf","2012-11-11","800"},
			          {"2","asdf1","2013-11-11","900"},
			          {"3","asdf2","2014-11-11","1000"},
			          {"4","asdf3","2015-11-11","1200"},
			          {"5","asdf4","2016-11-11","1300"}};//new obj[0][29];
	DefaultTableModel model;
	JTable rank;
	//�ҷ��� Į�� �̸�
	//������ rownum���� �̾ƿ���, id date score���� ���� �̾ƿ��� �ɵ���
	
	
	
	
	//DB����
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public Ranking(){
		setLayout(null);
		setSize(450,650);
	
		Container c = getContentPane();
		
		ranExit = new JButton("��������");
		
		mRanking = new JLabel("���� ����");
		mRanking.setFont(new Font("���� ���", Font.PLAIN, 14));
		
		
		
		//JTable �߾� ��ġ
		Panel = new JPanel();
		Panel1 = new JPanel();
		rankPanel = new JPanel();
		
		
		
		model = new DefaultTableModel(obj,col); //1)������ ����[][], 2)Į�� �̸�
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
