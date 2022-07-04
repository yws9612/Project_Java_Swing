import javax.swing.*;

public class life_image extends ImageIcon {
	
	//int life;
	ImageIcon img;
	
	life_image(int a) {
		
		switch(a) {
		case 0:
			img=new ImageIcon("image/heart_0.png");
			break;
			
		case 1:
			img=new ImageIcon("image/heart_1.png");
			break;
			
		case 2:
			img=new ImageIcon("image/heart_2.png");
			break;
			
		case 3:
			img=new ImageIcon("image/heart_3.png");
			break;
			
		case 4:
			img=new ImageIcon("image/heart_4.png");
			break;
			
		case 5:
			img =new ImageIcon("image/heart_5.png");
			break;
			
		default:
			img=new ImageIcon("image/heart_5.png");
			break;				
		}
	}
	
	/*
	public JLabel setLifeimg() {
		switch(a) {
		case 0:
			img=new ImageIcon(life_image.class.getResource("img/heart_0.png"));
			life_label.setIcon(img);
			return life_label;
			
		case 1:
			img=new ImageIcon(life_image.class.getResource("img/heart_1.png"));
			life_label.setIcon(img);
			return life_label;
			
		case 2:
			img=new ImageIcon(life_image.class.getResource("img/heart_2.png"));
			life_label.setIcon(img);
			return life_label;
			
		case 3:
			img=new ImageIcon(life_image.class.getResource("img/heart_3.png"));
			life_label.setIcon(img);
			return life_label;
			
		case 4:
			img=new ImageIcon(life_image.class.getResource("img/heart_4.png"));
			life_label.setIcon(img);
			return life_label;
			
		case 5:
			img=new ImageIcon(life_image.class.getResource("img/heart_5.png"));
			life_label.setIcon(img);
			return life_label;
			
		default:
			img=new ImageIcon(life_image.class.getResource("img/heart_5.png"));
			life_label.setIcon(img);
			return life_label;				
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
