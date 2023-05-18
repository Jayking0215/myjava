package day03;

import java.util.Stack;

import day02.Member;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<String> sk1=new MyStack<>();
		sk1.push("Java");
		sk1.push("JSP");
		sk1.push("Oracle");
		sk1.push("Spring");
		
		System.out.println(sk1.peek());
		
		String item=sk1.pop();
		System.out.println("삭제된 데이터: "+item);
		System.out.println(sk1.peek());
		
		sk1.pop();
		sk1.pop();
		System.out.println(sk1.peek());
		System.out.println(sk1.isEmpty());
		
		sk1.pop();
		//System.out.println(sk1.peek());
		System.out.println(sk1.isEmpty());
		
		MyStack<Integer> sk2=new MyStack<>();
		sk2.push(10);
		sk2.push(20);
		sk2.push(30);

		//[1] 반복문 이용해서 스택에 저장된 값을 출력하세요
		while(!sk2.isEmpty()) {
			System.out.println(sk2.pop());
		}
		//[2] Member객체 3개 생성해서 스택에 저장하세요
		// 반복문 이용해서 스택에 저장된 값을 출력하세요	 
		Member m1=new Member("홍길동",26,168);
		Member m2=new Member("고길동",33, 175);
		Member m3=new Member("황순원", 28, 177);
		
		MyStack<Member> sk3=new MyStack<>();
		sk3.push(m1);
		sk3.push(m2);
		sk3.push(m3);
		
		while(!sk3.isEmpty()) {
			System.out.println(sk3.pop());
		}
		
		Stack<String> sk4=new Stack<String>();
		sk4.push("Hello");
		sk4.push("Hi");
		System.out.println(sk4.peek());
		System.out.println(sk4.pop());
		
		
	}

}






