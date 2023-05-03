package day02;



public class ForTest1 {
	public static void main(String[] args) {
		for(int i=1; i<4; i++) {
			System.out.println("Hello"+i);
		}
		int j=5;
		for(; j>0; j-=2) {//변수를 위에서 선언(초기화)했기 때문에 생략
			System.out.println("Java"+j);
		}
		//j의 scope는? main()메서드 블럭이 끝날때까지 사용가능
		System.out.println("j: "+j);//-1(-1이 되어야 for문 종료)
		
		//[1] 1~100까지 정수를 다음과 같은 식으로
//		계산한 수식과 결과값을 출력하세요
//		1 + (-2) + 3+(-4)+5 +(-6) ....+(-100) = 결과값
		int sum=0;
		int d=1;
		for(int i=1; i<101; i++, d=-d) {
			sum+=i*d;
//			if(i<100) {
//				System.out.print(i*d+"+");
//			}else {
//				System.out.print(i*d+"=");
//			}
		}
		System.out.println("[1]answer: "+sum);
		
		//[2] 알파벳 대문자A,B...Z 를 for루프 이용해 출력하기
		for(int k='A'; k<='Z'; k++) {
			System.out.printf("%c ",k);
		}
		System.out.println();
		
		for(char k='A'; k<='Z'; k++) {
			System.out.print(k+" ");
		}
		System.out.println();
		
		//[3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 총 합계값을 출력하세요
		int sum2=0;
		int total=0;
		for(int i=1;i<11;i++) {
			sum2+=i;
			total+=sum2;
		}
		System.out.println("sum: "+sum2);
		System.out.println("total: "+total);
	}

}
