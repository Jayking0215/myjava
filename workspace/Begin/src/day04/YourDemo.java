package day04;
/*
 * 맴버변수
 * [1] Instance 변수=non-static
 * [2] Class 변수-static
 * 
 * */
public class YourDemo {
	String str="YourDemo's Variable";//초기값 부여
	float pi;//instance변수 - "객체명.변수"식으로 접근
	//생성자 구성하고 pi의 초기값을 부여
	static String CMD="static Variable";
	//class 변수 - "클래스명.변수"식으로 접근한다
	
	public YourDemo() {
		pi=3.14f;
		
	}
}
