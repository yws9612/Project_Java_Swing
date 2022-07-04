import javax.swing.*;

public class life_image {
	
	JLabel life_label=new JLabel();
	int life;
	ImageIcon img;
	
	life_image(int a) {
		life=a;
	}
	
	public JLabel setLifeimg() {
		switch(life) {
		case 0:
			img=new ImageIcon("img/heart_0.png");
			life_label.setIcon(img);
			return life_label;
			
		case 1:
			img=new ImageIcon("img/heart_1.png");
			life_label.setIcon(img);
			return life_label;
			
		case 2:
			img=new ImageIcon("img/heart_2.png");
			life_label.setIcon(img);
			return life_label;
			
		case 3:
			img=new ImageIcon("img/heart_3.png");
			life_label.setIcon(img);
			return life_label;
			
		case 4:
			img=new ImageIcon("img/heart_4.png");
			life_label.setIcon(img);
			return life_label;
			
		case 5:
			img=new ImageIcon("img/heart_5.png");
			life_label.setIcon(img);
			return life_label;
			
		default:
			img=new ImageIcon("img/heart_5.png");
			life_label.setIcon(img);
			return life_label;				
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
