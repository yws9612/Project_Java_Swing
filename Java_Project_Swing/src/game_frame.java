import java.awt.*;
import javax.swing.*;

public class game_frame extends JFrame{
	JLabel hint=new JLabel();
	String hint_t;
	int word_l;
	game1 g1=new game1(word_l);
	
	game_frame(){
		hint.setText(hint_t);
		if(grading1) {
			
		}
		else {
			game2 g2=new game2(word_l,g1.input1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
