class game_control1 extends Thread {
	public void run() {
		
	}
}

class game_control2 extends Thread {
	public void run() {
		
	}
}

class game_control3 extends Thread {
	public void run() {
		
	}
}

class game_control4 extends Thread {
	public void run() {
		
	}
}

class game_control5 extends Thread {
	public void run() {
		
	}
}


public class game_control extends Thread {
	
	public void run() {
		System.out.println(1);
		for(int i=2; i<11; i++) {
			try{
				sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		

	}

}
