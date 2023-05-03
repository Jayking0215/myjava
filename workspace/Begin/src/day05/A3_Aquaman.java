package day05;

public class A3_Aquaman {
	String name;
	int height;
	double speed;
	//생성자 오버로드 2개 이상 만들기
	//기본생성자 없이 진행->컴파일러가 기본 생성자 제공함 but 생성자를 구성하면 더 이상 제공안됨.(=default사라짐)
	//=>오버로드 할때는 기본생성자를 꼭 만들어주도록 한다
	public A3_Aquaman(String name) {
		this.name=name;
		height=120;
		speed=15.54;
	}
	public A3_Aquaman(String name, int height, double speed) {
		this.name=name;
		this.height=height;
		this.speed=speed;
	}
	
	public String showInfo() {
		String str="---아쿠아맨 정보---\n";
		str+="이 름: "+name+"\n신 장: "+height+"\n스피트: "+speed;
		return str;
	}
}
