package day08;
//for루프 바깥에서 예외처리(for루프 탈출)...개발자 판단의 영역
public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			for(int i=1; i<=5; i++) {
				int a=50/(i-3);//i-3=0일때 연산오류
				System.out.printf("a: %d%n", a);
			}//for
		}catch(ArithmeticException e) {//예외 에러가 발생하는 문구를 넣어줘야함
			System.out.println("분모가 0이 되었어요. 0으로 나눌 수 없어요");
		}
		System.out.println("---The End---");
	}//main()
}//