package day10;
//도매인 객체(VO객체-Value Object or DTO객체-Data Transfer Object)
/*
* - 해시셋은 객체를 저장하기 전에 객체의 hashCode()를 호출해서 해시코드를 얻어낸다. 
* 	 그리고 이미 저장되어 있는 객체들의 해시코드와 비교한다. 
*   만약 동일한 해시코드가 있다면 다시 equals()메소드로 두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고 중복 저장을 하지 않는다.
* */
public class Person {
	private String name;//캡슐화...+setter/getter함께 쓰임
	private int age;
	
	public Person() {//기본생성자
		this("아무개",1);//초기값 전달
	}
	public Person(String n, int a) {//overload
		name=n;
		age=a;
	}
	
	//setter getter
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	
	//day10일차!!!
	/*
	 * 이름과 나이가 같으면 HashSet에 중복 저장되지 않게하기 위해 hashCode()와 equals()를 재정의
	 * */
	
	//HashCode()오버라이드해서 같은값 반환하게 만들
	@Override
	public int hashCode() {//이름과 나이 출력
		return name.hashCode()+age;	
	}
	
	@Override
	public boolean equals(Object obj) {//두 비교값이 같으면 true반환
		if(obj instanceof Person) {//obj가 Person의 객체면 true
			Person user=(Person)obj;
			boolean bool=this.name.equals(user.name) && (this.age==user.age);
			return bool;
		}else {
			return false;
		}
	}
	
}
