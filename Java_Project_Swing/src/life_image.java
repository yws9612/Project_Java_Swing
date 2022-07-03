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
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;
			
		case 1:
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;
			
		case 2:
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;
			
		case 3:
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;
			
		case 4:
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;
			
		case 5:
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;
			
		default:
			img=new ImageIcon("");
			life_label.setIcon(img);
			return life_label;				
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
