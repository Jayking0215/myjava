package day02;
/*
 * 변수가 선언된 위치에 따른 변수 유형
 * [1] 맴버변수 : 초기화하지 않으면 0(default값)이 들어간다.
 * 		1> non-static변수: 인스턴스 변수 - "객체명-변수"식으로 입력...객체(instance)
 * 		2> static변수: 클래스 변수 - "클래스명.변수"식으로 입력
 * [2] 지역변수 : 초기화하지 않으면 error발생!
 * */
public class DataType {
	byte b;//맴버변수
	static byte a=9;//맴버변수-클래스 변수
	short s;//0
	char c;//\u0000
	int i;//0  
	long l;//0L
	static float f;//0.0f
	double db;//0.0
	boolean bool;//false
	static String str;//참조형 null
	Object obj;
	
	public static void main(String[] args) {
		int k=5;//지역변수: 초기값 없으면 error 발생
		System.out.println("DataType.a: "+DataType.a);
//		System.out.println(b);[error]
		
		//객체 생성
		DataType dt=new DataType();//클래스 변수는 반드시 new로 초기화 한다. dt: 객체명(instance)
		System.out.println("dt.b: "+dt.b);
		
//		System.out.println("k: "+k);//초기화 error(초기화 안해줬을경우)
		
		//s, c, i, l, f db, bool, str 값 출력
		System.out.println(dt.s);
		System.out.println(dt.c);//\u0000이지만 출력 생략
		System.out.println(dt.i);
		System.out.println(dt.l);//ㅣ생략됨
		System.out.println(DataType.f);//static의 경우 DataType.으로 출력
		System.out.println(dt.db);
		System.out.println(dt.bool);
		System.out.println(DataType.str);
		System.out.println(dt.obj);
	}
}
