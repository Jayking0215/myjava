package day07;
//final + class : 상속받지 못한다.(자식이 없다)
final class Bas{
	int a=10;
}//Base
//class Sub extends Base{//final 클래스는 상속 불가
//}
class Demo{
	int a=10;
	final public static int b=20;//final + 변수: 값 할당을 할 수 없다.(값 변경 x)
	//final public static 3요소를 보통 같이 씀 : 상수로 만든다
	
	void foo() {
		System.out.println("foo()");
	}
	//final + 메서드: 오버라이드 불가능...마지막 메서드가 됨
	final void bar() {
		System.out.println("bar()");
	}
}

class Child extends Demo{
	@Override
	public void foo() {
		System.out.println("foo()###");
	}
//	public void bar() {//final메서드는 오버라이드 불가능
//		
//	}
}

public class A4_FinalTest {

	public static void main(String[] args) {
		Demo dm=new Demo();
		System.out.println(dm.a);
		System.out.println(Demo.b);
		dm.a=100;
//		Demo.a=200;//불가능...final은 상수화:상수는 값변경 x
		System.out.println(dm.a);
		System.out.println(Demo.b);
		
	}//main()

}//
