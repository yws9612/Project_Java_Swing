import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ManagerChoice extends JFrame{

	JButton mem = new JButton("회원 관리");
	JButton mw1 = new JButton("순우리말 관리");
	JButton mw2 = new JButton("순화어 관리");
	JButton log_out = new JButton("로그아웃");
	
	ManagerChoice(){
		Container c = getContentPane();
		mem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageMember();
				dispose();
			}
			
		});
		
		mw1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageW1();
				dispose();
			}
			
		});
		
		mw2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ManageW2();
				dispose();
			}
			
		});
		
		log_out.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				new login();
				dispose();
			}
			
		});
	
		setLayout(null);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerChoice();
	}

}
