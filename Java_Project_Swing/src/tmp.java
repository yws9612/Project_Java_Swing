import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class thread extends Thread {
	public void run() {
		try {
			for(int i=3; i>0; i--) {
				System.out.println(i);
				//라벨 구현 후 settext로 바꿔주세요
				sleep(1000); //1초
			}
		} catch(Exception e) {
			System.out.println("fail");
		}
		
	}
}

public class tmp {

	public static void main(String[] args) {

		Connection conn=null; 
		PreparedStatement psmt=null;
		ResultSet rs=null; 
		//게임 부분 구체적인 구현 전 생각나는 코드를 모두 작성합니다.(송이)
		
		//쓰레드실행
		thread t=new thread();
		t.start();
		
		//랜덤으로 단어 가져와서 정답 비교를 위해 배열로 쪼개기
		String getword1, hint1;
		char [] word1;
		try {
			conn=connecttoDB.get();
			String que1="select * from word1";
			psmt=conn.prepareStatement(que1);
			rs=psmt.executeQuery();
			rs.last();
			int row1=rs.getRow();
			int word1num=(int)(Math.random()*row1)+1;
			
			String que2="select w1, hint from word1 where w_no=?";
			psmt=conn.prepareStatement(que2);
			psmt.setInt(1,word1num);
			rs=psmt.executeQuery();
			getword1=rs.getString(1);
			hint1=rs.getString(2);
			word1=new char[getword1.length()];
			for(int i=0; i<getword1.length(); i++) {
				word1[i]=getword1.charAt(i);
			}			
		} catch(Exception e) {
			
		}
		
		//게임부분 라벨/인풋칸 생성
		int w_length=getword1.length();
		
		JFrame tmp=new JFrame();
		tmp.setLayout(new GridLayout(w_length,5));
		
		JLabel [] a=new JLabel[w_length];
		JLabel [] b=new JLabel[w_length];
		JLabel [] c=new JLabel[w_length];
		JLabel [] d=new JLabel[w_length];
		JLabel [] e=new JLabel[w_length];
		JTextField [] input_field=new JTextField[w_length];
		char [] input=new char[w_length];
		boolean [] grading=new boolean[w_length];
		
		//textfield 글자수 제한+자동포커스 이동
		for(int i=0; i<w_length; i++) {
			input_field[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent ke) {
					JTextField src=(JTextField)ke.getSource();
					if(src.getText().length()>1) {
						ke.consume();
						if(i<w_length) {
							input_field[i+1].requestFocus();
						}
					}
				}
			});
		}//포문으로 하면 안됨;; 
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
