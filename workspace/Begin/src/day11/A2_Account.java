package day11;
//동기화

/*
 * save가 run하고 (flag=false, 대기x) money 증가하고 flag=true로 바뀌면서 wait pool에 대기하고 대기중인 thread 깨우기(첫 시작에는 없음)
 * get이 run하고 (flag=true, 대기x) money 감소하고 flag=false로 바뀌면서 wait pool에 대기하고 대기중이었던 save깨우고 다시 save run됨 반복
 * */
public class A2_Account {
	private int money=10;
	private boolean flag=false;//동기화 매서드(wait,notify..)를 위한 객체 생성
	
	public void save(int value) {
		synchronized(this) {//동기화 블럭 사용:객체의 lock을 쥐어야만 해당 블럭 수행//this=A2_Account
			if(flag) {
				try {
					wait();
				}catch(InterruptedException e) {}
			}
			money+=value;
			System.out.printf("입금액: %d, 입금후 잔액: %d%n",value, money);
			notify();//동기화 메서드:wait pool에 대기중인 thread하나를 깨워서 runnable상태로 전환
			//notifyAll():대기 중 thread 모두 깨움
			flag=true;
		}
	}//저축메서드
	
	synchronized public void get(int value) {//동기화클래스사용
		if(!flag) {
			try {
				wait();//동기화 메서드...:Thread는 수행 권한을 포기하고 wait pool에서 대기, 이때 rock을 반납하고 대기
			}catch(InterruptedException e) {}
		}
		if(money-value<0) {
			System.out.printf("잔액 부족!! 현재 잔액: %d, 요청금액 %d%n",money, value);
			flag=false;//wait pool에 있는 대상 깨우기
			notify();
			return;
		}
		money-=value;
		System.out.printf("출금액: %d, 출금후 잔액: %d%n",value, money);
		flag=false;//wait pool에 있는 대상 깨우기
		notify();
	}//출금메서드
}
