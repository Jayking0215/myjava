package day10;
/*
 * Thread구현 방법
 * [1] java.lang.Thread 클래스를 상속
 * [2] java.lang.Runnable 인터페이스를 상속
 * */

class SnailThread extends Thread{
	public SnailThread(String name) {//name을 갖도록 overload
		setName(name);//setName메서드로 name받기
	}
	@Override
	public void run() {//스레드가 할 일
		for(int i=0; i<5; i++) {
			System.out.println(this.getName()+" 스레드가 기어갑니다.");
			/*
			try {
				Thread.sleep(1000);//ms(1/1000)단위....1초간 잠을 잔다(Block상태가 된다)...exception발생
			}catch(InterruptedException e) {//스레드에 interrupt()메서드가 호출될때 예외가 발생
				e.printStackTrace();
				break;
			}
			*/
		}
	}//run()
}//

public class A8_ThreadTest2 {
	public static void main(String[] args) {
		SnailThread tr1=new SnailThread("똘똘이 달팽이");
		SnailThread tr2=new SnailThread("홀쭉이 달팽이");
		SnailThread tr3=new SnailThread("이쁜이 달팽이");
		//스레드 동작시키려면 run()호출[x]..반드시 start()를 호출해야한다
		
		//우선순위: 1(제일낮음) ~ 10(제일높음)
		tr1.setPriority(Thread.MIN_PRIORITY);//1
		tr2.setPriority(Thread.NORM_PRIORITY);//5
		tr3.setPriority(Thread.MAX_PRIORITY);//10
		
		tr1.start();//스레드 실행
		tr2.start();
		tr3.start();
		
//		tr2.interrupt();//InterruptedException이 발생
		
		//join()
		try {
			tr2.join();
			//tr2스레드가 작업을 끝낼때까지 tr2.join()호출한 스레드(여기선 main())가 Block상태가 된다.
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello World~~~");//실행할때마다 출력순서가 다르다
		
	}//main()

}//