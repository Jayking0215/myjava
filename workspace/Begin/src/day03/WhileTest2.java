package day03;
//eclipse에서 명령줄 인수 입력하기: run>run Configuration>arguments
//dos에서 실행하기
//C:\myjava\workspace\Begin\bin>java day03.WhitelTest2 99 97
//args[0] = 99
//args[1] = 77
public class WhileTest2 {
	public static void main(String[] args) {
		//명령줄 인수 2개를 받아 더하기를 해보자
		String num1=args[0];
		String num2=args[1];
		System.out.printf("%s + %s= %s%n", num1, num2, num1+num2);//문자열을 결합시키는 문제 발생!
		//java.lang.Integer클래스
		//public static int parseInt(String s)를 이용해서 덧셈식 출력
		int n1=Integer.parseInt(num1);//자주쓰이니 암기!!!
		int n2=Integer.parseInt(num2);
		System.out.printf("%d + %d =%d%n", n1,n2,n1+n2);
	}
}
