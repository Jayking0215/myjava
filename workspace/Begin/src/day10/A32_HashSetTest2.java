package day10;
//9일자 Person.java 활용
import java.util.*;

public class A32_HashSetTest2 {//데이터 중복저장을 허용하지 않는다

	public static void main(String[] args) {
		// Person객체 3개 생성해서
		Person p1=new Person("홍길동",10);
		Person p2=new Person("홍길서",20);
		Person p3=new Person("홍길남",30);
		// HashSet에 저장한 뒤
		HashSet<Person> hs=new HashSet<>();
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		// 반복문 이용해서 사람 정보를 출력하세요(이름, 나이)
		for(Person ps:hs) {
			System.out.println(ps.getName()+": "+ps.getAge());
		}
		System.out.println("***********************************");
		
		Person p4=new Person("홍길서", 20);//중복데이터, 주소가 다른 새로운 객체
		hs.add(p4);
		System.out.println("hs.size(): "+hs.size());//4 출력...중복데이터로 간주 안함(주소값이 다르기 때문에)
		
		Person p5=p1;//p5와 p1이 같은 객체 가리킴
		hs.add(p5);
		System.out.println("hs.size(): "+hs.size());//4출력...중복값으로 처리됨

		for(Person ps:hs) {
			System.out.println(ps.getName()+"@ "+ps.getAge());
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}
