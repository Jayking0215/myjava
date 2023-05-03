package day09;
//도매인 객체(VO객체-Value Object or DTO객체-Data Transfer Object)
public class A4_Person {
	private String name;//캡슐화...+setter/getter함께 쓰임
	private int age;
	
	public A4_Person() {//기본생성자
		this("아무개",1);//초기값 전달
	}
	public A4_Person(String n, int a) {//overload
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
}
