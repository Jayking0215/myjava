package day02;

import java.util.*;

public class IfTest2 {
	//main()메서드: JVM이 호출(사용자, 개발자 호출 불가)
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("2자리의 정수를 입력하세요.");
		int num=sc.nextInt();
		//유효성 체크
		if(num<10 || num>99) {//서비스 관점에서는 다시 입력보다 3자리 이상은 잘라서 10,1의 자리만 비교
			System.out.println("2자리 정수!!!");
			return;//main()메서드로 되돌아감=JVM으로 돌아감=프로그램 종료
			//return문을 가지고 있는 메서드를 호출한 쪽으로 되돌아간다.
		}
		/* 
		* 11, 22, 33, 44, 55,... 
		*==> "OK 10의 자리와 1의 자리가 같아요"
		*그렇지 않다면 No 10의 자리와 1의 자리가 달라요"
		**/
		if((num%10)==(num/10)) {
			System.out.println("OK 10의 자리와 1의 자리가 같아요");
		}else {
			System.out.println("NO 10의자리와 1의 자리가 달라요");
		}
		System.out.println("삼항연산자--->");
		String str=(num%11==0)? "같다":"다르다";//삼항연산자
		System.out.println(str);
		System.out.println("-----The End-----");
		
		
		
	}

}
