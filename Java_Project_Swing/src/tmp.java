
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
		//게임 부분 구체적인 구현 전 생각나는 코드를 모두 작성합니다.(송이)
		
		//쓰레드실행
		thread t=new thread();
		t.start();
		
		//단어 가져와서 정답 비교를 위해 배열로 쪼개기
		

	}

}
