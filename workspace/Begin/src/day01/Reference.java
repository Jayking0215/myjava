package day01;
import java.util.Date;

public class Reference {
	/* Reference Type (참조형)
	 *  [1] 클래스형
	 *  [2] 인터페이스형
	 *  [3] 배열
	 *  - 참조형은 반드시 new 연산자로 객체를 생성해서 사용해야 한다.
	 *    다만 예외는 있다. String의 경우 자주 사용하기 때문에
	 *    기본자료형처럼 문자열값(literal)을 직접 할당하도록 하고 있다.
	 *    Integer, Float, Double,Character: 클래스유형
	 * */
	public static void main(String[] args){
		Date d=new Date();
		//Date:클래스, d:참조변수=>지역변수는 stack에 올라감, new Date():객체생성=>객체는 Heap에 올라감
		//Heap에 있는 객체를 stack의 d에 참조한다 =r reference
		System.out.println(d);
		
		String str=new String("Hello");
		String str2="Java";//리터럴 형식(Literal 메모리 영역에 올라감)
		System.out.println("str: "+str);
		System.out.println("str2: "+str2);
		
		//String의 경우 '+'연산자 사용하면 문자열 결합이 일어난다.
		System.out.println(str+str2);
		
		int m=20;
		int n=30;
		System.out.println(m+n+"<=합");
		System.out.println("합=>"+m+n);//연선 순서가 문자열이 먼저이면 문자열로 반환
		System.out.println("합=>"+(m+n));
		
		
		
	}
}
