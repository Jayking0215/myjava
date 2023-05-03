package day04;

public class OurDemo {

	int a=1;//instance 변수(생성자에서 초기화)
	int b;
	static int c;//class변수(static블럭에서 초기화)
	static int d;
	
	static {//static블럭: static 변수 초기화는 여기서 한다.
		//static intializer  : main()메서드 보다도 먼저 메모리에 올라간다
		d=4;
		System.out.println("static block");
	}
	
	public OurDemo() {
		b=2;
//		d=4//대체로 static을 생성자에서 초기화 하지 않는다=의미없기때문
		
	}
	
	public static void main(String[] args) {
		System.out.println("main()-------------");
		System.out.println(OurDemo.d);
		
	}

}
