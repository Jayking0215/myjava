package day03;

public class WhileTest1 {
	public static void main(String[] args) {
		int i=1;//i의 scope는 for문과 다르게 main()메서드 종료때까지 유지됨
		while(i<5) {
			System.out.println("Hello "+i);
			i++;
		}
		
		//while감소식
		//Java 10	Java 7 ... Java 1
		int j=10;
		while(j>0) {
			System.out.println("Java "+ j);
			j-=3;
		}
		System.out.println("The End-----");
		
		//무한루프
//		while(true) {
//			System.out.println("무한루프!!!");
//		}
		
//		for(;;) {
//			System.out.println("무한루프!!!");
//		}
		
		
	}

}
