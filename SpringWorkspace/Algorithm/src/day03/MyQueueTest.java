package day03;

import day02.Member;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue q=new MyQueue(5);
		q.enque("Hello");
		q.enque("Hi");
		q.enque("Good");
		System.out.println(q.size());
		System.out.println(q.peek());
		q.enque("안녕");
		q.enque("방가");
		if(q.isEmpty())
			q.enque("Bye");
		
		System.out.println(q.deque());
		System.out.println("q.size(): "+q.size());
		System.out.println(q.peek());
		q.clear();//front=0; end=0; cnt=0;
		System.out.println("clear후 q.size(): "+q.size());
		if(!q.isEmpty())
			q.deque();
		
		//Member객체 3개 이상 생성해서 큐에 저장한 뒤
		//큐에 저장된 값을 모두 출력하세요
		Member m1=new Member("홍길동",22,177);
		Member m2=new Member("김철수",23,167);
		Member m3=new Member("이민아",24,170);
		
		q.enque(m1);
		q.enque(m2);
		q.enque(m3);
		
		q.printQueue();
		
		//검색해보기 김철수
		int i=q.indexOf(new Member("김철수",23,167));
		System.out.println("i: "+i);
		q.deque();
		q.deque();
		System.out.println("deque후------------");
		i=q.indexOf(new Member("김철수",23,167));
		System.out.println("i: "+i);
		
		q.printQueue();
		
		

	}

}
