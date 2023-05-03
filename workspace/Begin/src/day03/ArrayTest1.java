package day03;
/* 배열
 * - 하나의 변수에 인덱스번호를 붙여 여러개의 데이터를 저장할 수 있도록 하는 자료구조
 * - 고정크기
 * - 동종의 데이터만 저장 가능하다
 * */
public class ArrayTest1 {
	public static void main(String[] args) {
		//배열은 아래 3단계 꼭 지켜야함
		//[1] 배열 선언
		int [] a; //1차원 배열
		int b[];//1차원 배열
		
		//[2] 메모리 할당
		a=new int[3];//배열의 크기가 3
		b=new int[1];//배열의 크키가 1
		
		//[3] 초기화;초기값 부여
		a[0]=10;
		a[1]=20;
		a[2]=30;
		
		System.out.printf("a[0]=%d%n",a[0]);
		System.out.printf("a[1]=%d%n",a[1]);
		System.out.printf("a[2]=%d%n",a[2]);
		
		System.out.printf("b[0]=%d%n",b[0]);//메모리 할당만 하고 초기화하지 않으면 default값이 저장
		b[0]=100;
		System.out.printf("b[0]=%d%n",b[0]);
//		b[1]=200;//RunTime Error
		
		// 배열이 크기 확인
		System.out.println("a.length : "+a.length);
		System.out.println("b.length : "+b.length);
		
		//[1][2] 선언과 동시에 메모리 할당
		double d[]=new double[4];
		//[3] 초기화
		d[0]=12.45;
		d[1]='A';
		d[2]=50e-3;
		d[3]=.123f;

		//for루프 이용해서 d에 저장된 값을 모두 출력하세요
		for(int i=0; i<d.length; i++) {
			System.out.printf("d[%d]=%.3f%n",i,d[i]);
		}
		
		//[1][2][3] 선언과 동시에 메모리 할당 및 초기화
		char[] ch= {'J', 'a', 'v', 'a', 66};
		for(int i=0;i<ch.length;i++) {
			System.out.printf("%c", ch[i]);
		}
		
		//[1] float타입의 배열 요소를 받아들이는
		// 배열을 선언하고 크기는 3만큼 잡는다.
		// 인덱스0에는 -16.1을 넣어주고,
		// 인덱스1에는 200.1
		// 인덱스 2에는 30E-7의 값을 넣어주자.
	 	// 반복문 이용해 저장된 값을 출력하세요
		System.out.println("[1]문제");
		float f[]=new float[3];
		f[0]= -16.1f;
		f[1]= 200.1f;
		f[2]= 30e-7f;
		for(int i=0; i<f.length; i++) {
			System.out.printf("f[%d]=%.2f%n", i, f[i]);//소수점 2째자리까지 표현
		}
		//=>확장 for루프(for each루프)
		// for(변수선언문:자료구조){
		//	실행문;
		//}
		for(float a1:f) {//a1에는 배열에 저장된 요소값들이 전달된다
			System.out.println("a1: "+a1);
		}
		
		
		//[2] String 을 저장할 배열을 생성하고 해당 배열에 문자열 3개 저장하세요
		//	for루프 이용해 저장된 값을 출력하되 모두 대문자로 바꿔서 출력하세요
		System.out.println("[2]문제");
		String s[]= {"Hello world", "Nice to meet you", "Good afternoon"};
		for(int i=0; i<s.length; i++) {
			System.out.printf("s[%d]= %s%n", i, s[i]);
		}
		//확장 for루프
		for(String a2:s) {
			System.out.println("a2: "+a2.toUpperCase());//전부 대문자로 출력
		}//non static 메서드...; static 메서드는 static s.toUppercase()로 입력해야함
		
		
	}

}
