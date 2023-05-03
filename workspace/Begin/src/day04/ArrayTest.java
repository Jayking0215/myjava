package day04;

public class ArrayTest {
	public static void main(String[] args) {
		//2차원 배열
		//[1]선언...여러 변수 선언시 변수명 전까지의 배열크기가 자료형에 영향을 준다
//		int[][]a;
//		int[]a[];
		int a[][];
		//[2]메모리 할당
		a=new int[3][2];
		System.out.println(a[0][0]);
		
		//[3]초기화
		a[0][0]=10;
		a[0][1]=20;
		
		a[1][0]=30;
		a[1][1]=40;
		
		a[2][0]=50;
		a[2][1]=60;
		
		//for루프 이용해서 a에 저장된 값을 모두 출력 - 중첩 for루프
		//행의 크기: a.length
		//열의 크기: a[i].length
		
		System.out.println("a.length: "+a.length);
		System.out.println("a[0].length: "+a[0].length);
		System.out.println("a[0].length: "+a[1].length);
		System.out.println("a[0].length: "+a[2].length);
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		//배열 한번에 하는 법
		short b[][]= {{100,200},{-5,-8,1},{20}};
		
		//[1] for루프 이용해서 출력
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.printf("b[%d][%d]=%d ", i, j, b[i][j]);
			}
			System.out.println();
		}
		
		//[2] 확장 for루프 이용해서 출력
		for(short[] sb:b) {
//			System.out.println(sb);//주소(해시코드) 출력됨
			for(short s:sb) {
				System.out.print(s+"\t");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		//행의 크기만 먼저 잡아놓고, 나중에 열의 크기를 할당하는 방법
		char ch[][]=new char[3][];//3행
		
		ch[0]=new char[2];//2열
		ch[1]=new char[4];//4열
		ch[2]=new char[3];//3열
		
		ch[0][0]='H';
		ch[0][1]='i';
		
		ch[1][0]='J';
		ch[1][1]='a';
		ch[1][2]='v';
		ch[1][3]='a';
		
		//지정하지 않으면 char의 default값이 저장됨 '\u0000'
		//[3] 확장for로프 사용해서 출력
		for(char[] ca:ch) {
			for(char c:ca) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
}
