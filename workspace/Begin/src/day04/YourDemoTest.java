package day04;
/*
 *static메서드 안에서 접근 가능한 변수
 *		static 변수[o] - 클래스명.변수
 *		static매서드[o]
 *		instance 변수[x] - 객체 먼저 생성해줘야함 객체명.변수
 *		인스턴스 메서드[x]
 * */
public class YourDemoTest {
	
	boolean z=true;
	static boolean r=false;

	public static void main(String[] args) {
		//YourDemo를 생성하고
		//str, pi값 출력
		YourDemo yd1=new YourDemo();//static 저장공간은 따로 있기때문에 객체를 한번 선언해줘야 한다.
		System.out.println("yd1.str: "+yd1.str);
		System.out.println("yd1.pi: "+yd1.pi);
		
		//CMD값 출력
		System.out.println(YourDemo.CMD);//CMD가 static이기 때문에 객체 생성 안해도 됨
		System.out.println(yd1.CMD);//객체명+변수도 가능하지만 접근방식 error
//		System.out.println(CMD);//=>main()의 CMD라고 인식하기때문에 error
		
		//r값 출력
		System.out.println("r: "+YourDemoTest.r);
		System.out.println("r: "+r);
		//z값 출력
		YourDemoTest ydt=new YourDemoTest();//instance변수는 객체 생성해줘야 함
		System.out.println("z: "+ydt.z);
	}

}
