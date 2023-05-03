package day02;

import javax.swing.JOptionPane;

public class SwitchTest {
	/*
	 * switch(변수|수식){ case 값1: 실행문; break;(continue;) case 값2: 실행문; break; ... default: 실행문; }
	 * 이 때 변수 또는 수식은 int형 이하의 자료형 이거나 String유형만 가능하다.
	 */
	public static void main(String[] args) {
		//long a=1;//int형 이하의 자료형만 사용 가능!
//		String a="1";
//		switch(a) {
//			case "1"://변수가 문자열일때 반환도 문자열
//			System.out.println("One"); break;
//		}
		
		String month=JOptionPane.showInputDialog("1~12월 사이의 값을 입력하세요");
		if(month==null) return;
		// 월을 입력하세요 (1 ~ 12) 
		// 일수를 알려주는 프로그램
		//1,3,5,7,8,10,12 : 31일
		//2  : 28일 or 29일
		//4,6,9,11  : 30일
		int days=30;
		switch(month) {
		case "2":
			days=28;
//			System.out.println(month + "월은 28일 또는 29일까지 있습니다");
			break;
		case "4": case"6": case"9": case"11":
			days=30;
//			System.out.println(month + "월은 30일까지 있습니다");
			break;
		case "1": case"3": case"5": case"7": case"8": case"10": case"12":
			days=31;
//			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		default:{
			System.out.println("Error");
			return;
		}
		}
		System.out.printf("%s월은 %d일까지 있습니다%n", month, days);
	}
}

