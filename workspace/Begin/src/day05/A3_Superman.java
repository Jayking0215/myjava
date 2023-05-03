package day05;

public class A3_Superman {
	String name;
	int height;
	int power;
	
	//생성자 오버로딩
	//this(): 생성자 호출(static메서드에서는 사용 불가)_자기 자신의 생성자를 호출할때 사용
	//this.변수: 자기자신의 매개변수를 호출하는 변수
	public A3_Superman() {//기본생성자(default constructor)
		this("아무개", 160, 100); //자기자신의 생성자를 호출
		/*
		 * this()는 생성자 안에서만 호출 가능
		 * 항상 첫번째 줄에 위치해야한다.
		 * super():부모의 생성자를 호출
		 * super와 this는 함께 사용할 수 없다.
		 * */
		
//		name="아무개";
//		height=160;
//		power=100;
	}
	public A3_Superman(String name) {
		this(name, 175, 200);
//		this.name=name;
//		height=165;
//		power=200;
	}
	public A3_Superman(String n, int h) {
		this(n, h, 300);
//		this.name=n;
//		this.height=h;
//		power=300;
	}
	public A3_Superman(String n, int h, int p) {//간략화 최종목적지=여기서 초기화할 예정(target이 된 이유:모든 객체를 갖고 있어서)
		name=n;
		height=h;
		power=p;
	}
	
	public String showInfo() {
		String str="---슈퍼맨 정보---\n";
		str+="이 름: "+name+"\n신 장: "+height+"\n초능력: "+power;
		return str;
	}
}
