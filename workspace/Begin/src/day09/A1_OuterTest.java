package day09;
//static과 non-static의 차이를 이해하자.
//외부에서 inner클래스 사용할 경우
//외부클래스.내부클래스 변수명으로 객체 생성 후 접근
public class A1_OuterTest {

	public static void main(String[] args) {
		//[1] Outer클래스의 변수 a, b값을 출력하세요
		A1_Outer o1=new A1_Outer();
		System.out.println("o1.a: "+o1.a);//인스턴스변수는 객체를 먼저 생성해야 함
		
		System.out.println("o1.b:"+A1_Outer.b);//static 인스턴스는 객체생성 필요없이 class이름만 붙여주면 된다.
		//[2] Outer.Inner클래스의 변수 c값 출력, sub()호출

		A1_Outer o2=new A1_Outer();//outer객체 생성
		A1_Outer.Inner oi=o2.new Inner();//inner객체 생성
		System.out.println("oi.c: "+oi.c);
		oi.sub();
		//한줄로 객체 생성하기
		A1_Outer.Inner oi2=new A1_Outer().new Inner();
		System.out.println("oi2.c: "+oi2.c);
		
		//[3] Outer.SInner클래스의 d, e, foo(), bar()호출
		A1_Outer.SInner os=new A1_Outer.SInner();//한줄 객체 생성
		System.out.println("os.d: "+os.d);
		os.foo();
		
		System.out.println("Outer.SInner.e: "+A1_Outer.SInner.e);//static객체는 클래스명.객체명으로 호출 가능
		A1_Outer.SInner.bar();
	
		o1.test();
	}

}
