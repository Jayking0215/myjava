package day04;

public class MyDemo {
	int x;//인스턴스 변수
	double y;
	
	//생성자를 구성하고 x,y의 초기값을 부여하기
	public MyDemo() {//기본 생성자(매개변수 없음)
		x=10;
		y=20.0;
	}
	public MyDemo(int a,double b) {//인자 생성자
		x=a;
		y=b;
		
	}
}
