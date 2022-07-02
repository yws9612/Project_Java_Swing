import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class thread extends Thread {
	JLabel circle_label=new JLabel();
	JLabel countdown=new JLabel();
	thread(JLabel l1, JLabel l2) {
		countdown=l1;
		circle_label=l2;
	}
	public void run() {
		try {
			sleep(1000);
			countdown.setVisible(true);
			circle_label.setVisible(true);
			for(int i=3; i>0; i--) {
				countdown.setText(Integer.toString(i));
				sleep(1000); //1초
			}
			countdown.setText("게임 시작!");
			sleep(1000);
			countdown.setVisible(false);
			circle_label.setVisible(false);
		} catch(Exception e) {
			System.out.println("fail");
		}
		
	}
	/* 프레임에 넣을 때
	 	class f extends JFrame {
	ImageIcon ii
		=new ImageIcon("C:/Users/soldesk/Desktop/SY/circle.png");
	JLabel l2=new JLabel();
	f() {
		//JPanel pp=new p();
		Container c=getContentPane();
		l2.setIcon(ii);
		l2.setSize(300, 300);
		JLabel ll=new JLabel();
		thread t=new thread(ll,l2);
		c.setLayout(null);
		ll.setSize(300, 300);
		ll.setHorizontalAlignment(JLabel.CENTER);
		ll.setFont(new Font("맑은 고딕",Font.PLAIN, 30));
		ll.setVisible(false);
		l2.setVisible(false);
		c.add(ll);
		c.add(l2);
		t.start();
		c.setBackground(Color.yellow);
		setVisible(true);
		setSize(600, 600);
	}
}*/
}

/*class Getters{
private String word1,hint1;

public String getWord1() {
	return word1;
}

public void setWord1(String word1) {
	this.word1 = word1;
}

public String getHint1() {
	return hint1;
}

public void setHint1(String hint1) {
	this.hint1 = hint1;
}*/
	
}

public class tmp {

	public static void main(String[] args) {

		Connection conn=null; 
		PreparedStatement psmt=null;
		ResultSet rs=null; 
		//게임 부분 구체적인 구현 전 생각나는 코드를 모두 작성합니다.(송이)
		
		//랜덤으로 단어 가져와서 정답 비교를 위해 배열로 쪼개기
		char [] word1;
		Getters get = new Getters();
		try {
			conn = Connect.get();		
			String que2="select w1_no, w1, w1_h from w1_table where w1_no = "+"(select trunc(dbms_random.value(1,150)) from dual)";
			psmt=conn.prepareStatement(que2);
			rs=psmt.executeQuery();
			while(rs.next()) {
				get.setWord1(rs.getString(2));
				get.setHint1(rs.getString(3));				
			}
			
			word1=new char[get.getWord1().length()];
			for(int i=0; i<get.getWord1().length(); i++) {
				word1[i]=get.getWord1().charAt(i);
				System.out.print(word1[i]);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//게임부분 라벨/인풋칸 생성
//		int w_length=get.getWord1().length();
//		
//		JFrame tmp=new JFrame();
//		tmp.setLayout(new GridLayout(w_length,5));
//		
//		JLabel [] a=new JLabel[w_length];
//		JLabel [] b=new JLabel[w_length];
//		JLabel [] c=new JLabel[w_length];
//		JLabel [] d=new JLabel[w_length];
//		JLabel [] e=new JLabel[w_length];
//		JTextField [] input_field=new JTextField[w_length];
//		char [] input=new char[w_length];
//		boolean [] grading=new boolean[w_length];
		
		//textfield 글자수 제한+자동포커스 이동
//		for(int i=0; i<w_length; i++) {
//			input_field[i].addKeyListener(new KeyAdapter() {
//				public void keyTyped(KeyEvent ke) {
//					JTextField src=(JTextField)ke.getSource();
//					if(src.getText().length()>1) {
//						ke.consume();
//						if(i<w_length) {
//							input_field[i+1].requestFocus();
//						}
//					}
//				}
//			});
//		}//포문으로 하면 안됨;; 
		//필드마다 따로 설정 넣어야 하고 키어뎁터를 클래스로 빼서 각각 깔끔하게 짜기
		
		input_field[w_length].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//마지막 칸 엔터쳤을 때 이벤트 > 채점+다음 시도로 넘기기				
			}
		});
		
		//게임시작 시 배치
		for(int i=0; i<w_length; i++) {
			tmp.add(input_field[i]);
			tmp.add(b[i]);
			tmp.add(c[i]);
			tmp.add(d[i]);
			tmp.add(e[i]);
		}
		input_field[0].requestFocus();
		
		//채점 -클래스로 빼는게 나을 듯
		for(int i=0; i<w_length; i++) {
			input[i]=input_field[i].getText().charAt(0);
			if(input[i]==word1[i]) {
				grading[i]=true;
			}
			else {
				grading[i]=false;
			}
		}
		
		
		//1~4 줄 오답시 배치
		for(int i=0; i<w_length; i++) {
			input_field[i].setText("");
			if(grading[i]) {
				a[i].setBackground(Color.green);
			} //이걸 먼저하고 재배치를 해야하나?
			tmp.add(a[i]);
			tmp.add(input_field[i]);
			tmp.add(c[i]);
			tmp.add(d[i]);
			tmp.add(e[i]);
		} //이걸 c~d도 반복
		

	}

}
