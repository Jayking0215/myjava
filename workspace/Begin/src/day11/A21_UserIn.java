package day11;
//저축클래스
//1만원씩 저축하는 Thread
public class A21_UserIn extends Thread{
	private A2_Account account;//통장
	public A21_UserIn(A2_Account ac, String name) {
		this.account=ac;
		setName(name);
	}
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			account.save(1);//1만원씩 저축
		}
	}
	
}
