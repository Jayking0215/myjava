package day08;
//for루프 안에서 예외처리하기(for루프 계속진행)...개발자 판단의 영역
public class ExceptionTest3 {
	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			try {
				int a=50/(i-3);
				System.out.printf("a: %d%n", a);
			}catch(ArithmeticException e) {
//				System.out.println("0으로 나눌 수 없어요!!");
				continue;//continue도 가능
			}//try~catch
		}//for
		System.out.println("---The End---");
	}//main()
}//