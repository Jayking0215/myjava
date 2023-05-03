package day09;
//inner class
/*
 * [1]이너 맴버 클래스...맴버변수와 비슷
 * 		<1>static 이너 클래스
 * 		<2>non-static 이너 클래스
 * [2]이너 로컬 클래스(지역 클래스)
 * 		<1>Named Local inner class
 * 		<2>Anonymous inner class(주로 사용)
 * */
//비슷한 기능을 갖는 class끼리 묶어서 관리가 가능

public class A1_Outer {
	int a=10;//맴버변수...인스턴스변수...호출할때 객체 생성해야 함(new)
	static int b=20;//클래스변수(static이 붙어서)...호출할때 객체생성할 필요 x
	
	public void test() {//메서드에서 Inner클래스 호출하기
		System.out.println("---test()----");
		A1_Outer.Inner in=this.new Inner();//inner객체 생성//outer 객체는 this가 된다...this생략가능
		System.out.println("in.c: "+in.c);
		in.sub();
		
		Inner in2=new Inner();//outer클래스와 객체this생략
		System.out.println("in2.c: "+in2.c);
		in2.sub();
	}//test()
	
	class Inner{//Inner member -<2>non-static
		int c=30;
		public void sub() {//매서드...Inner class도 매서드를 갖을 수 있다.
			System.out.println("sub()***********");
		}
	}//Inner
	
	static class SInner{//Inner member - <1>static
		//원래 class앞에 static을 붙일 수 없다..Inner 클래스는 가능
		int d=40;
		static int e=50;//static클래스는 static 인스턴스를 갖을 수 있다
		void foo() {
			System.out.println("foo()$$$$$");
		}
		static void bar() {//static 맴버변수도 갖을 수 있다.
			System.out.println("bar()@@@@@@@@@");
		}
		
	}//SInner
	
}//Outer
