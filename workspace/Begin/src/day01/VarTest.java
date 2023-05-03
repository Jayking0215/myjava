package day01;

public class VarTest {

	int global=100; //인스턴스 변수(맴버변수)
	static int global2=200;//클래스변수(맴버변수)

	public static void main(String[] args){
		//변수(Variable, field, property)
		//변수 선언: 자료형 변수명;
		int num1; //num1 변수선언
		num1=10;//num1 초기화
		int num2 = 8;//선언과 동시에 초기화//지역변수

		System.out.printf("num1=%d, num2=%d%n",num1, num2);

		System.out.printf("global2=%d%n", global2);
		System.out.printf("VarTest.global2=%d%n", VarTest.global2);
	
		//정수형 변수 a,b 2개 선언하고 값 할당 후 printf()로 덧셈식 곱셈식 출력
		int a=10, b=20;
		int plus = a+b;
		int multi = a*b;
		System.out.printf("%d + %d = %d%n", a, b, plus);
		System.out.printf("%d x %d = %d%n", a, b, multi);

		int wordCount=5;
		int word_count=6;
		int 가1=10;
		int $$$=90;
		int _weight=55;
		int class_=7;
	}
}
