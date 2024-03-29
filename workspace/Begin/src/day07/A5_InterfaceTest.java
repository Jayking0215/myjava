package day07;

interface MyInter{
	void sub();//public 과 abstract가 자동으로 붙는다(추상메서드)
}//MyInter

interface YourInter{
	String STR="Hi";//public static final이 자동으롭 붙는다
	String bar();
}//YoutInter
//인터페이스는 다중상속이 가능하며, 상속받을 때는 implements로 받는다

class MyDemo implements MyInter, YourInter{
	//MyInter,YourInter를 상속받아서 컴파일 에러 없게 만드세요
	
	@Override
	public void sub() {//인터페이스 오버라이드는 public 필수!
		System.out.println("sub()~~~");
	}
	public String bar() {
		return "bar()~~";
	}
}

public class A5_InterfaceTest {

	public static void main(String[] args) {
//		MyInter mi=new MyInter();[x] : 추상메서드처럼 new는 불가능,,,클래스가 불완전하기 때문
		MyInter mi=new MyDemo();
		mi.sub();
//		mi.bar();[x]//MyInter로는 bar()에 접근 불가,,YourInter로는 가능
		System.out.println(((MyDemo)mi).bar());
		//YourInter타입의 변수 선언하고 MyDemo객체 생성해서
		//sub(), bar(), STR 출력
		
		System.out.println("------------------------");
		YourInter yi=new MyDemo();
		System.out.println(yi.bar());
		System.out.println("YourInter.STR: "+YourInter.STR);//static이 붙기 때문
		System.out.println("MyDemo.STR: "+MyDemo.STR);
		((MyDemo)yi).sub();
	}//main()

}//
