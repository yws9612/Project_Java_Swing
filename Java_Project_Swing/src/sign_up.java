import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.*;	

public class sign_up extends JFrame {
	Connection conn=null; 
	PreparedStatement psmt=null;
	
	String id, pw, pw2, name, email;
	
	TextField id_field=new TextField(30);
	TextField pw_field=new TextField(30);
	TextField pw2_field=new TextField(30);
	TextField name_field=new TextField(30);
	TextField email_field=new TextField(30);	
	
	JButton id_check=new JButton("�ߺ�Ȯ��");
	JButton pw_check=new JButton("��й�ȣȮ��");
	JButton email_check=new JButton("�ߺ�Ȯ��");
	JButton complete=new JButton("���ԿϷ�");
	
	JLabel id_label=new JLabel("���̵�");
	JLabel pw_label=new JLabel("��й�ȣ");
	JLabel pw2_label=new JLabel("��й�ȣ Ȯ��");
	JLabel name_label=new JLabel("�̸�");
	JLabel email_label=new JLabel("�̸���");
	JLabel id_checklabel=new JLabel();
	JLabel pw_checklabel=new JLabel();
	JLabel email_checklabel=new JLabel();
	JLabel last_checklabel=new JLabel();	
	
	sign_up() {
		setLayout(new GridLayout(6,6));
		add(id_label);
		add(id_field);
		add(id_checklabel);
		add(id_check);
		add(pw_label);
		add(pw_field);
		add(pw2_label);
		add(pw2_field);
		add(pw_checklabel);
		add(pw_check);
		add(name_label);
		add(name_field);
		add(email_label);
		add(email_field);
		add(email_checklabel);
		add(email_check);
		add(complete);
		add(last_checklabel);
		
		//��й�ȣ Ȯ��(��ư, ����, ��)
		pw2_field.setFocusTraversalKeysEnabled(false);
		pw_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw=pw_field.getText();
				pw2=pw2_field.getText();
				if(pw.equals(pw2)) {
					pw_checklabel.setText("Ȯ��");
				}
				else {
					pw_checklabel.setText("��й�ȣ�� �ٸ��ϴ�.");
				}
			}
		});		
		pw2_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw=pw_field.getText();
				pw2=pw2_field.getText();
				if(pw.equals(pw2)) {
					pw_checklabel.setText("Ȯ��");
				}
				else {
					pw_checklabel.setText("��й�ȣ�� �ٸ��ϴ�.");
				}
			}
		});	
		pw2_field.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_TAB) {
					pw=pw_field.getText();
					pw2=pw2_field.getText().replace("\t", "");
					if(pw.equals(pw2)) {
						pw_checklabel.setText("Ȯ��");
						pw_check.requestFocus();
						String re_input
							=pw2.replace("\t", "");
						pw2_field.setText(re_input);
					}
					else {
						String re_input
							=pw2.replace("\t", "");
						pw2_field.setText(re_input);
						pw_checklabel.setText("��й�ȣ�� �ٸ��ϴ�.");
					}
				}
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_TAB) {
					String re_input
						=pw2.replace("\t", "");
					pw2_field.setText(re_input);
				}
			}
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_TAB) {
					String re_input
						=pw2.replace("\t", "");
					pw2_field.setText(re_input);
				}
			}
		});
		
		//���̵� �ߺ�Ȯ��
		id_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String que="execute id_check";
					psmt=conn.prepareStatement(que); //sql����
					boolean rs=psmt.execute();
					if(rs) {
						id_checklabel.setText
							("�̹� �����ϴ� ���̵��Դϴ�.");
					}
					else {
						id_checklabel.setText
							("����� �� �ִ� ���̵��Դϴ�.");
					}
				} catch (Exception e_id_check) {
					
				}
			}
		});
		
		//�̸��� �ߺ�Ȯ��
		email_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String que="execute email_check";
				psmt=conn.prepareStatement(que); //sql����
				boolean rs=psmt.execute();
				if(rs) {
					email_checklabel.setText
						("�̹� �����ϴ� �̸����Դϴ�.");
				}
				else {
					email_checklabel.setText
						("����� �� �ִ� �̸����Դϴ�.");
				}	
				} catch (Exception e_email_check) {
					
				}
			}
		});
		
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id_checklabel.getText().equals("")) {
					last_checklabel.setText
						("���̵� �ߺ��˻簡 �ʿ��մϴ�.");
					id_field.requestFocus();
				}
				else if(pw_checklabel.getText()
							.equals("��й�ȣ�� �ٸ��ϴ�.")) {
					last_checklabel.setText
						("��й�ȣ�� Ȯ���� �ּ���.");
					pw_field.requestFocus();
				}
				else if(pw_checklabel.getText().equals("")) {
					last_checklabel.setText
						("��й�ȣ�� Ȯ���� �ּ���.");
					pw_field.requestFocus();
				}
				else if(email_checklabel.getText().equals("")) {
					last_checklabel.setText
						("�̸��� �ߺ��˻簡 �ʿ��մϴ�.");
					email_field.requestFocus();
				}
				else {
					try {
						id=id_field.getText();
						pw=pw_field.getText();
						pw2=pw2_field.getText();
						name=name_field.getText();
						email=email_field.getText();
						String que
							="insert into member values"
									+ "(mem_sq.nextval,?,?,?,?,N)";
						psmt=conn.prepareStatement(que);
						psmt.setString(2,id);
						psmt.setString(3,pw);
						psmt.setString(4,name);
						psmt.setString(5,email);
					
						dispose();
						setDefaultCloseOperation
							(JFrame.EXIT_ON_CLOSE);
					} catch (Exception e_complete) {
						System.out.println("fail");
					}
				}
			}
		});
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {		
		new sign_up();
	}

}
