import java.awt.*;
import java.util.HashSet;

import javax.swing.*;

class panel extends JPanel {
	TextField id_field=new TextField();
	TextField pw_field=new TextField();
	TextField pw2_field=new TextField();
	TextField name_field=new TextField();
	TextField email_field=new TextField();
	String id=id_field.getText();
	String pw=pw_field.getText();
	String pw2=pw2_field.getText();
	String name=name_field.getText();
	String email=email_field.getText();
	
	JButton id_check=new JButton("�ߺ�Ȯ��");
	JButton email_chech=new JButton("�ߺ�Ȯ��");
	JButton complete=new JButton("���ԿϷ�");
	
	JLabel id_label=new JLabel("���̵�");
	JLabel pw_label=new JLabel("��й�ȣ");
	JLabel pw2_label=new JLabel("��й�ȣ Ȯ��");
	JLabel name_label=new JLabel("�̸�");
	JLabel email_label=new JLabel("�̸���");
	JLabel id_checklabel=new JLabel();
	JLabel pw_checklabel=new JLabel();
	JLabel email_checklabel=new JLabel();	
	
	panel() {
		setLayout(null);
		add(id_field);
		add(pw_field);
		add(pw2_field);
		add(name_field);
		add(email_field);
		setSize(500, 500);
		setVisible(true);
	}
}

public class sign_up {

	public static void main(String[] args) {
		
		HashSet<String> set_id=new HashSet<>();
		HashSet<String> set_email=new HashSet<>();

	}

}
