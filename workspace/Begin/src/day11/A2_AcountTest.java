package day11;

public class A2_AcountTest {

	public static void main(String[] args) {
		A2_Account ac=new A2_Account();//객체 생성
		
		A21_UserIn user1=new A21_UserIn(ac, "개미");
		A22_UserOut user2=new A22_UserOut(ac, "배짱이");//ac객체 개미와 배짱이가 공유
		
		//Thread 동시 접근...결과 이상함->Synchronized필요
		//동기화 후 실행
		user2.start();
		user1.start();
		
	}

}
