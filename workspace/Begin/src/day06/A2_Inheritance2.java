package day06;

class Person{
	int no;
	String name;
 
	
	public Person(String n, int no) {//인자 생성자
		this.name=name;
		this.no=no;
	}
	
}//Person
class Student extends Person{
	String className;
	//자식 class의 생성자에서는 묵시적으로 super()호출// 부모의 defialt 생성자
	public Student() {
		//super();[x]
		super("홍길동", 1);//부모클래스가 가지고 있는 생성자를 명시적으로 호출해준다(부모에 기본생성자가 없을경우)
		this.className="1반";
	}
}//Student
class Teacher extends Person{
	String subject;
	public Teacher(String name, int no, String subject) {
		super(name, no);
		this.subject=subject;
		
	}
}//Teacher


public class A2_Inheritance2 {
	public static void main(String[] args) {
		Person p=new Teacher("라선생",100, "수학");
		Person p2=new Student();
		Person p3=new Person("주구마",1);
	}//main()

}//
