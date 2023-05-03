package day09;
//제네릭
import java.util.*;
/*
 * Java Collection: 
 * List계열 - Vector, ArrayList(web에서 자주 쓰임,,동기화x), LinkedList
 * Map 계열 - Hashtable(동기화o), HashMap(web에서 자주 쓰임,,동기화x), Properties
 * Set 계열 - HashSet(web에서 자주 쓰임), TreeSet
 * 
 * 객체를 수집해서 저장,검색,삭제, 수정하는 역할수행
 * 
 * List계열 특징
 * - 입력 순서를 기억=인덱스를 기억한다
 * - 데이터 중복 저장을 허용한다
 * - 
 * 
 * 
 * Vector
 * - 객체유형의 데이터 저장가능
 * - 다른 종류의 데이터도 저장 가능
 * - 동적으로 저장 크기를 늘릴 수 있다.
 * - java.util.List인터페이스를 구현
 * - 유사한 클래스: ArrayList
 * */
public class A3_VectorTest {
	public static void main(String[] args) {
		//jdk1.4버전일때(구버전)
		Vector v=new Vector(5, 3);//default는 10개, 증가치 2개
		System.out.println("v의 현재 용량1: "+v.capacity());
		System.out.println("v의 현재 크기1: "+v.size());
		
		//초기용량:5, 증가치: 3
		//데이터가 꽉 차면 저장 영역을 3만큼 늘린다.
		//boolean add(Object o), void addElement(Object o)
		v.add("Hello");
		v.add(new String("Hi"));
		v.add(10);//Integer객체로 auto boxing되어 저장된다.
		v.add(Integer.valueOf(20));//fm방식으로 정수 저장
		System.out.println("v의 현재 용량2: "+v.capacity());
		System.out.println("v의 현재 크기2: "+v.size());
		//4개 1~4 반복문 이용해 저장하기
		for(int i=1; i<6; i++) {
			v.add(i);
		}
		System.out.println("v의 현재 용량3: "+v.capacity());
		System.out.println("v의 현재 크기3: "+v.size());
		
		//데이터 꺼내기
		//public Object get(int index)
		//public Object elementAt(int index)
		Object obj=v.get(0);
		System.out.println(obj);
//		System.out.println(obj.toUpperCase());//[x] toUpperCase는 String유형이기 때문에 Object유형인 obj에 적용 x
//		Object obj1=(String)v.get(0);//따라서 강제형변환 해야함
//		System.out.println(obj1.toUpperCase());
		
		//----사용해보니 다른 타입을 저장할 일이 별로 없다.
		//jdk5.0이후 Generic을 이용
		Vector<String> v2=new Vector<String>();//제네릭
		//String 유형만 저장하는 벡터를 생성함
		v2.add("Orange");
		v2.add("Apple");
		v2.add("Mango");
//		v2.add(10);//int는 선언한 제네릭과 달라서 저장안됨
		String str=v2.get(0);//제네릭 사용으로 형변환이 필요없다
		System.out.println(str.toLowerCase());
		
		//v2에 저장된 값을 for루프 이용해서 출력
		for(int i=0; i<v2.size(); i++) {
//			String s=v2.get(i);
			String s=v2.elementAt(i);
			System.out.println(s);
		}
		//확장for루프 버전_제네릭해야 가능
		for(String s:v2) {
			System.out.println(s.toUpperCase());
		}
		
		
		//[문제1] Float유형을 저장할 벡터 v3를 생성하고
		// Float객체 3개 저장하세요.
		// 확장 for루프를 이용해 v3에 저장된 값들의 합계를 구하세요
		Vector<Float> v3=new Vector<>();
		v3.add(1.1f);//auto boxing
		v3.add(new Float(2.2f));
		v3.add(Float.valueOf(3.3f));
		System.out.println("v3.size(): "+v3.size());
		float sum=0;
		for(Float f:v3) {
			sum+=f;//Float ==> float:auto unboxing
		}
		System.out.println("sum: "+sum);
		
	}

}
