package day02;

import java.util.*;

public class IfTest3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("나이 입력=>");
		int age=sc.nextInt();
		System.out.println("정가 입력=>");
		int price=sc.nextInt();
		/*[2]
		가격과 나이를 입력받아 20세 미만이면 10%를 할인하여 가격을 알려주세요

		price=10000
		age=18
		가격은 9000원 입니다
		*/
		if(age<20) {
			System.out.println("미성년자 10%할인: "+(int)(price*0.9)+"원");
		}else {
			System.out.println("성인은 할인없음: "+(int)price+"원");
		}
		//삼항연산자
		String str=(age<20)? "미성년자 10%할인: "+(int)(price*0.9)+"원":"성인 할인없음: "+(int)price+"원";
			System.out.println(str);
			System.out.println("---NEXT---");
			
		
		/*[3]
		 * 0~9999 사이의 정수를 입력받아서 입력받은 정수가 몇 자리인지 알려주세요.
			 15 --->2  
			 123--->3  
			 7777-->4
		 * */
		System.out.println("0~9999사이의 정수를 입력하세요=>");
		int num = sc.nextInt();
//		System.out.println(num+"->"+String.valueOf(num).length()+"자리");//아이디어 개좋다...
		if(num>=0 && num<10){
			System.out.println("1자리");
		}else if(num<100) {
			System.out.println("2자리");
		}else if(num<1000) {
			System.out.println("3자리");
		}else if(num<10000) {
			System.out.println("4자리");
		}else {
			System.out.println("다시 입력!");
			return;
		}
		System.out.println("---The End---");
	}
}
