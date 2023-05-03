package day11;
//[2]import java.lang.Runnable 인터페이스를 상속받아 구현하는 경우
//sleep으로 다양한 thread발생시킬 수 있다.
//Thread는 그래픽 상황에서 눈에 잘 띄고 많이 쓰임..콘솔은 복수 출력이 안되기 때문에 잘 알 수 없음
class Snail implements Runnable{
	@Override
	public void run() {//추상메서드 상송은 반드시 오버라이드 필요->override한것은 throws불가
		for(int i=0; i<5; i++) {
			System.out.println("달팽이가 기어가요");
			int sec=(int)(Math.random()*2000);
			try {
				Thread.sleep(sec);//랜덤하게 sleep걸기...exception발생
			}catch(InterruptedException e) {
				System.out.println(e);
			}//
		}
	}
}//

public class A1_ThreadTest {

	public static void main(String[] args) {
		//1. Runnable객체 생성
		Snail r=new Snail();
		//2. Thread객체 생성 <= 이때 Runnable객체를 생성자에 매개변수로 전달
		Thread tr=new Thread(r);//Runnable객체 반드시 들어가야 함
		//3. Thread의 strat()호출
		tr.start();
		
		
		//Anonymous 클래스로 진행
		//1. Runnable 객체 생성...interface는 new안되서 상속받는 anonymous 클래스 생성
		final String name="뚤띠";
		Runnable r2=new Runnable() {
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println(name+"달팽이가 기어갑니다.");
					try {
						Thread.sleep(2000);
					}catch(Exception e) {}//귀찮으니까 부모예외처리
				}//for
			}//run()
		};//Anonymous class, 생성자 끝
		
		Thread tr2=new Thread(r2);
		tr2.start();
		
		//Lambda로 Thread 구현하기=코드가 줄어듬(추상메서드 1개 있는 경우 사용가능)->익명함수로 만들어 표현
		final String name2="뚜따띠";
		Thread tr3=new Thread(()->{//빈 Thread에 run()매서드 Lambda식으로 넣기...매개변수가 없어서 빈() 화살표 {수행문}
			for(int i=0; i<5; i++) {
				System.out.println(name2+"달팽이가 기어갑니다.");
				try {
					Thread.sleep(500);
				}catch(Exception e) {}
			}//for
		});
		tr3.start();
	}//main()

}
