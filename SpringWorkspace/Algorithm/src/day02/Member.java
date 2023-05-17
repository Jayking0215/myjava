package day02;
//객체를 비교할 수 있도록 만들기 위해서는 Comparable인터페이스를 상속받아 compareTo()메서드를 재정의해야 한다
//또는 Comparator인터페이스를 상속받아 compare()메서드를 재정의해야 한다.
/* Comparable과 Comparator의 차이는?
[1] Comparable의 compareTo(T o) 메소드 
[2] Comparator의 compare(T o1, T o2) 메소드

- Comparable은 "자기 자신과 매개변수 객체를 비교"하는 것이고, 
- Comparator는 "두 매개변수 객체를 비교"한다는 것이다.

쉽게 말하자면, Comparable은 자기 자신과 파라미터로 들어오는 객체를 비교하는 것이고, 
Comparator는 자기 자신의 상태가 어떻던 상관없이 파라미터로 들어오는 두 객체를 
비교하는 것이다. 즉, 본질적으로 비교한다는 것 자체는 같지만, 비교 대상이 다르다는 것이다.
* */
public class Member implements Comparable<Member> {
	
	private String name;
	private int age;
	private int height;
	
	public Member() {
		
	}
	//setter역할
	public Member(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	//getter역할
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member user=(Member)obj;
			if(this.name.equals(user.name)&& this.age==user.age && this.height==user.height) {
				return true;
			}
			
		}//if----
		return false;
	}
	//나이를 기준으로 오름차순 정렬하고자 한다면
	//this.age와 obj.age 같으면 0을 반환한다
	//0을 반환하면 두 값이 같음
	//양수(1)를 반환하면 두 값의 위치를 교환함
	//음수(-1)를 반환하면 그대로 둔다
	@Override
	public int compareTo(Member obj) {
		/*
		if(this.age == obj.age) {
			return 0;
		}else if(this.age<obj.age) {//(this.age> obj.age):  오름차순일때, (this.age<obj.age):내림차순일떄
			return 1;
		}else {
			return -1;
		}
		*/
		return this.age-obj.age;//오름차순
		//return obj.age -this.age;//내림차순
	}
	

}/////////////////////////////////////




