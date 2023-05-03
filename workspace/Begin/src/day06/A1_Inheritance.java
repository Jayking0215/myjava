package day06;
//하나의 파일에서 여러개의 class를 갖을경우 public은 1개만 있어야한다
//=파일 이름과 같은 public class만 존재(main()메서드를 갖는 class)

//extends Object(모든 클래스는 묵시적으로 Object를 상속받는다

/*
 * 부모 클래스: Super class, Base class
 * 상속받을 때는 extends를 이용한다
 * Java는 단일 상속만 허용
 * 
 * Method Override: 부모로부터 상속받은 method를 재정의해서 구현
 * [1] 매서드 이름은 부모와 동일하게 구성
 * [2] 매개변수도 부모와 동일하게 구성
 * [3] 반환타입도 부모와 동일하게 구성
 * [4] 접근지정자는 부모와 동일하거나 더 넓은 범위를 갖을 수 있다
 * [5] Exception은 부모와 동일하거나 더 구체적인 예외(자식예외)를 발생 가능
 * */
class Human{
	String name;
	int height;
	public String showInfo() {
		return "이  름: "+name+"\n신  장: "+height;
	}
}//Human

class Superman extends Human{
	int power;
	//생성자 만들기
	public Superman() {//기본생성자
		this("슈퍼맨", 190, 500);
	}
	public Superman(String n, int h, int p) {//Superman매서드 오버로딩
		name=n;
		height=h;
		power=p;
	}
	//오버라이드: 메서드 헤더는 부모와 동일하게 바디는 다르게 구성하는 것
	@Override//annotation을 붙인다(실수방지...Override 문법에 맞춰서 컴파일됨)
	public String showInfo() {
//		return "이 름: "+name+"\n신 장: "+height+"\n초능력: "+power;
		return super.showInfo()+"\n초능력: "+power;//부모Human에게서 "이름, 신장"을 받아온다.
	}
	//오버로딩-Overloadding:다중정의
	public String showInfo(String title) {//매개변수는 달라야한다.(나머지는 상관x)
		String str=title+"\n";
//		str+="이 름: "+name+"\n신 장: "+height+"\n초능력: "+power;
		str+=this.showInfo();
		return str;
	}
	//오버로드2
	public void showInfo(int pwu) {
		System.out.println(">>초능력 충전: "+pwu+"<<");
		this.power+=pwu;
		System.out.println(this.showInfo());//class내부의 showInfo()통해서 이름, 키, 초능력 받아옴
	}
}//Superman

//자식클래스 : Sub class, Derived class
//"is a"관계가 성립되어야 상속가능(Superman is a Human)

class Aquaman extends Human{
	double speed;
	//기본 생성자 생성
	public Aquaman() {
		this("아무개", 155, 55);
	}
	//생성자 만들기
	public Aquaman(String name, int height, double speed) {
		this.name=name;
		this.height=height;
		this.speed=speed;
	}
	//showInfo() 오버라이드
	@Override
	public String showInfo() {
		return super.showInfo()+"\n스피드: "+speed;
	}
	//showInfo() 오버로드
	public void showInfo(int spu) {
		System.out.println(">>초능력 충전: "+spu+"<<");
		this.speed+=spu;
		System.out.println(this.showInfo());
	}
}//Aquaman

public class A1_Inheritance {
	public static void main(String[] args) {
		Human h1=new Human();
		h1.name="홍길동";
		h1.height=166;
		System.out.println(h1.showInfo());
		System.out.println("-----------------");
		
		Superman s1=new Superman();
		s1.name="이슈퍼";
		s1.height=190;
		s1.power=150;
		System.out.println(s1.showInfo());
		System.out.println(s1.showInfo("##슈퍼맨 정보##"));
		s1.showInfo(20);//void는 syso사용 x
		System.out.println("-----------------");
		
		Aquaman a1=new Aquaman();
		System.out.println(a1.showInfo());
		System.out.println("-----------------");
		Aquaman a2=new Aquaman("인어공주", 160, 80);
		System.out.println(a2.showInfo());
		System.out.println("-----------------");
		a2.showInfo(50);
		
		
	}//main()

}//
