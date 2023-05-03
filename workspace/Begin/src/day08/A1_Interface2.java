package day08;

interface Inter1{
	void a();//추상메서드...public abstract가 자동으로 붙는다
	int b();
}//
interface Inter2{
	double PI=3.14;//public static final이 자동으로 붙는다
}//

//인터페이스가 인터페이스를 상속받을 때 extends로 받으며, 여러개 상속 가능
interface Inter3 extends Inter1, Inter2{
	void c();
}//

abstract class Absclass{//추상메서드를 갖는 class는 추상클래스
	abstract void d();//생략형 접근지정자... abstract를 명시해줘야함. 
}//

//[1] MyDemo클래스가 Absclass, Inter3을 상속받고, 컴파일 에러 없게 조치
class MyDemo extends Absclass implements Inter3{//클래스 상속은 extends, 인터페이스 상속은 implements
	@Override//추상클래스, 인터페이스는 상속하여 override하기 위함이다
	public void a() {
		System.out.println("a()###");
	}//implements해서 a,b,c()정의해야함...상속했으니 override필수
	//상수PI는 재정의가 불가능=override안함
	public int b() {
		return 0;
	}
	public void c() {//구현할게 없으면 빈블럭이라도 입력
	}
	void d() {
		System.out.println("d()@@@");
	}//extends해서 d()를 정의해야함==override
}//

public class A1_Interface2 {
	public static void main(String[] args) {
		//[2] MyDemo객체 생성해서 a(), b(), c() 호출하고 PI출력
		MyDemo my=new MyDemo();
		my.a();
		System.out.println(my.b());
		my.c();//아무것도 출력 안됨
		my.d();
		System.out.println("MyDemo.PI= "+MyDemo.PI);//상수는 class명으로 접근
		System.out.println("Inter2.PI="+Inter2.PI);
		
		Inter1 im=new MyDemo();
		Inter2 im2=new MyDemo();
		Inter3 im3=new MyDemo();
		Absclass ac=new MyDemo();
		
		im.a();
		System.out.println(im.b());
//		im.c();//접근불가..접근범위 오류
		
		im3.c();
		im3.a();
		im3.b();
		
//		im2.a();//접근불가
		ac.d();
//		ac.a();//접근불가
		((MyDemo)ac).a();//강제형변환으로 접근 가능해짐
		((Inter1)ac).a();
		
	}//main()

}//