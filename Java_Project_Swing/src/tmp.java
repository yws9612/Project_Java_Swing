import java.awt.GridLayout;
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
		String getword1;
		char [] word1;
		try {
			conn=connecttoDB.get();
			String que1="select * from word1";
			psmt=conn.prepareStatement(que1);
			rs=psmt.executeQuery();
			rs.last();
			int row1=rs.getRow();
			int word1num=(int)(Math.random()*row1)+1;
			
			String que2="select w1 from word1 where w_no=?";
			psmt=conn.prepareStatement(que2);
			psmt.setInt(1,word1num);
			rs=psmt.executeQuery();
			getword1=rs.getString(1);
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
		JTextField [] input=new JTextField[w_length];
		
		for(int i=0; i<w_length; i++) {
			tmp.add(input[i]);
			tmp.add(b[i]);
			tmp.add(c[i]);
			tmp.add(d[i]);
			tmp.add(e[i]);
		}
		

	}

}
