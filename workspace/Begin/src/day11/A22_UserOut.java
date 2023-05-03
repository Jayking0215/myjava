package day11;
//인출클래스
//1~5만원 랜덤 인출하는 Thread
import java.util.Random;
public class A22_UserOut extends Thread{
	private A2_Account account;//통장
	public A22_UserOut(A2_Account ac, String name) {
		this.account=ac;
		setName(name);
	}
	
	@Override//어노테이션
	public void run() {
		Random ran=new Random();//util의 Random사용법..[1]일단 객체 생성
		for(int i=0; i<5; i++) {
			//int n=(int)(Math.random()*범위+시작수
//			int val=ran.nextInt(범위)+시작수;//[2]
			int val=ran.nextInt(5)+1;
			account.get(val);
		}
		
	}//
}
