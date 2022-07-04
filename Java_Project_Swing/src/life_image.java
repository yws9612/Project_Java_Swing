import java.awt.Color;

import javax.swing.*;

public class life_image extends JLabel {
	
	life_image(int a) {
		
		switch(a) {
		case 0:
			setIcon(new ImageIcon("image/heart_0.png"));
			break;
			
		case 1:
			setIcon(new ImageIcon("image/heart_1.png"));
			break;
			
		case 2:
			setIcon(new ImageIcon("image/heart_2.png"));
			break;
			
		case 3:
			setIcon(new ImageIcon("image/heart_3.png"));
			break;
			
		case 4:
			setIcon(new ImageIcon("image/heart_4.png"));
			break;
			
		case 5:
			setIcon(new ImageIcon("image/heart_5.png"));
			break;
			
		default:
			setIcon(new ImageIcon("image/heart_5.png"));
			break;				
		}
	}


	public static void main(String[] args) {
		
	}

}
