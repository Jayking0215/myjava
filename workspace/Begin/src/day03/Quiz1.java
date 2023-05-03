package day03;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		System.out.println("정수 입력");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		//입력받은 값을 뒤집어서 출력
		//그리고 각각의 숫자값들의 합계를 출력
//		int sum=0;
//		while(num>0) {
//			int n=num%10;
//			System.out.print(n+" ");
//			num/=10;
//			sum+=n;
//		}//while종료
//		System.out.println("\nsum: "+sum);
		
//		System.out.println("---------------다른방법---------------");
		
		String numStr=String.valueOf(num);//입력값을 String객체로 변환
		System.out.println("numStr.length(): "+numStr.length());
		int sum=0;
		for(int i=numStr.length()-1; i>=0; i--) {
			char ch=numStr.charAt(i);
			System.out.printf("%c ", ch);
			int c=ch-'0';//다시 정수로 변환
			sum+=c;
		}
		System.out.println("\nsum: "+sum);
		
		
	}

}

