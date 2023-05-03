package day06;
///복습!!!
class Super{//부모클래스
	int a=10;
	int b=20;
	
	void foo() {//생략형 접근지정자(default access modifier)
		System.out.println("foo()**************");
	}//foo
}//Super

class Sub extends Super{//자식 클래스
	int b=30;
	int c=40;
	
	@Override
	protected void foo() {
		System.out.println("foo()###############");
	}
}//Sub

public class A2_polymorphism2 {
	public static void main(String[] args) {
		//결과예측하기
		System.out.println("1.-----------------");
		Super sp=new Super();
		System.out.println("sp.a: "+sp.a);
		System.out.println("sp.b: "+sp.b);
		sp.foo();

		System.out.println("2.-----------------");
		Sub sb=new Sub();
		System.out.println("sb.a: "+sb.a);
		System.out.println("sb.b: "+sb.b);//type을 따라간다. 자기가 선언한 변수를 따라감
		System.out.println("sb.c: "+sb.c);
		sb.foo();
		
		System.out.println("3.-----------------");
		Super ss=new Sub();//super타입 sub객체
		System.out.println("ss.a: "+ss.a);
		System.out.println("ss.b: "+ss.b);
//		System.out.println("ss.c: "+ss.c);
		ss.foo();//오버라이드 된 객체는 우선적용
	}

}
