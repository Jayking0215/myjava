package day02;

public class Operator2 {
	public static void main(String[] args) {
		System.out.println("논리부정 연산자(!)----------");
		//논리식, 논리값에만 사용. true=>false false=>true
		boolean b1=false;
		print("b1="+b1);
		print("!b1="+!b1);
		/*
		 * = : 대입연산자
		 * == : 비교연산자
		 * === : java에 없음
		 * 비교연산자(==)
		 *	 [1] 기본자료형 : 값이 값은지 비교
		 *	 [2] 참조형 : 조수값이 같은지 비교
		 * != : 
		 *	 [1] 기본자료형 : 값이 다른가? 다르면true, 같으면 false
		 *	 [2] 참조형 : 주소값이 다른가?
		 * */
		
	
		int x=5;
		float y=5.1f;
		print("x==y: "+(x==y));
		print("x!=y: "+ (x!=y));
		
		String s1="Hello";//String에 literal값 할당 -> literal pool에 객체가 올라감
		String s2=new String("Hello");//참조형 -> Heap에 객체가 올라감
		print("s1==s2: "+(s1==s2));//참조형 변수의 비교는 주소값을 비교한다.
		print("s1!=s2: "+(s1!=s2));
		
		//String의 메서드
		//public boolean equals(object o) 
		// : 문자열의 내용을 비교(객체의 값이 같은지 참조변수도 비교가능...객체가 object형이기 때문)
		boolean bool=s1.equals(s2);
		print("s1.equals(s2): "+ bool);
		print("!s1.equals(s2): "+ !bool);
		print("!s1.equals(s2): "+(!s1.equals(s2)));
	}
	public static void print(String str) {
		System.out.println(str);
	}
}