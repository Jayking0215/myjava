package day07;
//도형 class
//추상클래스: 상속 받아서 @Override하기위함
abstract public class A2_Shape {
	int x, y;//인스턴스변수
	
	@Override
	public String toString() {
		return "나는 도형 클래스 Shape";
	}//toString
	abstract public void area(int w, int h);//추상메서드
}// 
//추상class를 상속받은 자식class는 반드시 추상메서드를 @Override해야 한다.
//만약 @Override하지 않는다면 자식class도 추상class여야한다

class Rectangle extends A2_Shape{
	@Override
	public void area(int w, int h) {
		int ra=w*h;//로컬변수
		System.out.println("사각형 면적: "+ra);
	}
}//Rectangle

class Triangle extends A2_Shape{
	@Override
	public void area(int s, int h) {
		int ta=s*h/2;
		System.out.println("직각삼각형 면적: "+ta);
	}
}//Triangle

abstract class Circle extends A2_Shape{//@Override하지 않고 자식클래스도 추상클래스로 만들기...but 결국 어딘가에서는 @override를 구현해야한다.
	double pi=3.14;
}//Circle

class SubCircle extends Circle{
	@Override
	public void area(int r, int b) {}
	//Override한것을 Overload하기
	public void area(int r) {//매개변수만 다르다.
		System.out.println("원의 면적: "+pi*r*r);
	}
}//SubCircle