package day09;

import java.util.*;//vector사용하려면 import해야함

public class A4_VectorTest2 {
	public static void main(String[] args) {
		//[1] A4_Person객체를 3개 생성
		A4_Person p1=new A4_Person("홍길동",20);
		A4_Person p2=new A4_Person("홍길서",22);
		A4_Person p3=new A4_Person("홍길남",23);
		//[2] A4_Person을 저장할 Vector 생성해서 3개 객체 저장
		Vector<A4_Person> v=new Vector<>();
		v.add(p1);
		v.addElement(p2);
		v.add(p3);
		//[3] for루프 이용해서 vector에 저장된 A4_Person의 이름과 나이를 출력
		for(A4_Person p:v) {
			System.out.println(p.getName()+":"+p.getAge()+"세");
		}

		/*Enumeration<E> elements()
		 * : 벡터에 저장된 객체들을 한꺼번에 꺼내오고자 할 때 사용.
		 * Enumeration과 Iterator인터페이스는 객체들을 집합체로 관리하도록 해주는 인터페이스이다.
		 * 이들 인터페이스에서는 각각의 객체들을 한 순간에 하나씩 처리할 수 있는 메소드를 제공한다.
		 * # Enumeration의 경우**********************************
		 * 	- boolean hasMoreElements() : 논리적 커서(첫번째 요소 직전에 위치=0번째) 이후에 요소들이 있는지 물어서 있으면true 없으면 false를 반환
		 *  - E nextElement(): 논리적 커서를 다음 요소로 이동하고 현재 가리키고 있는 요소를 반환한다.
		 * # Iterator의 경우**************************************
		 * 	- boolean hasNext()
		 *  - E next() 
		 * */
		System.out.println("--------------------------------");

		Enumeration<A4_Person> en=v.elements();
		
		while(en.hasMoreElements()) {//논리적 커서 boolean(t,f)
			A4_Person p=en.nextElement();//다음커러로 이동 후 요소 반환
			System.out.println(p.getName());
		}
		System.out.println("*********************************");
		//Iterator<E>	iterator() 메서드 활용해서 v의 요소들 이름#나이 출력하기
		Iterator<A4_Person> it=v.iterator();//코드가 짧아서 더 많이 쓰임
		for(int i=1; it.hasNext(); i++) {
			A4_Person p=it.next();//커서 이동
			System.out.println(i+": "+p.getName()+"#"+p.getAge());
		}
		
		//E firstElement()
		//E lastElement()
		//void clear(): 벡터에 저장된 객체 모두 지우기 or void removeElements()
		System.out.println("v.size(): "+v.size());
		v.clear();//모두 삭제
		System.out.println("------------clear이후--------------------");
		System.out.println("v.size(): "+v.size());
	}

}
