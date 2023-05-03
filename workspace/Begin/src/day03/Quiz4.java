package day03;

import java.util.Scanner;

public class Quiz4 {
	public static void showMenu() {
		String str="--수도요금 계산기 v1.1--\n";
			   str+="1. 가정용 (50원/L)\n";
			   str+="2. 상업용 (40원/L)\n";
			   str+="3. 공업용 (30원/L)\n";
			   str+="9. 종          료\n";
			   str+="--------------------\n";
			   str+="메뉴 번호를 입력하세요 =>\n";
			   str+="--------------------\n";
	System.out.println(str);	
	}//-----------------------------
	public static void main(String[] args) {
		// 무한반복 돌면서 수도요금을 계산하는 프로그램을 구성하세요
		// switch ~case문 활용해서 수도요금 계산하기
		// output
		// 1. 선택한 메뉴번호
		// 2. 사용한 수도량
		// 3. 수도요금
		// 4. 세   금 (수도요금의 5%)
		// 5. 총수도요금(수도요금+세금)
		Scanner sc=new Scanner(System.in);
		for(;;) {//그냥 조건없이 for문 돌림
			Quiz4.showMenu();
			int num=sc.nextInt();
			if(num==9) {
				System.out.println("Bye Bye~~");
				System.exit(0);//시스템 종료 0:정상종료, 음수값: error발생시 종료
			}
			//유효성 체크
			if(num<1||num>3) {
				System.out.println("메뉴에 없는 번호");
				continue;
			}//if
			System.out.println("수도 요금 사용량을 입력=>");
			int use=sc.nextInt();
			
			//System.out.println("수도 요금 계산예정...");
			String str="";
			int price=1;
			switch(num) {
			case 1:
				price=50;
				str="가정용 ";
				break;
			case 2:
				price=45;
				str="상업옹 ";
				break;
			case 3:
				price=30;
				str="공업용 ";
				break;
			}//switch
			//수도요금
			int fee=use*price;
			int tax=(int)(fee*0.05);
			str+="단가: "+price+"원";
			System.out.println("---------------------");
			System.out.println("메뉴번호: "+num+" ("+str+")");
			System.out.println("사용량: "+use+"L");
			System.out.println("수도요금: "+fee+"원");
			System.out.println("세금: "+tax+"원");
			System.out.println("총수도요금: "+(fee+tax)+"원");
			System.out.println("---------------------");
			
		}//for
		
//		System.out.println(Quiz4.showMenu());
//		Scanner sc=new Scanner(System.in);
//		System.out.println("메뉴 번호를 입력하세요");
//		int menu=sc.nextInt();
//		System.out.println(">>사용량을 입력하세요.");
//		int use=sc.nextInt();
//		
//		//청구서 표시 내용
//		String bill="메뉴번호: %s%n";
//		bill+="사 용 량: %dL%n";
//		bill+="수도요금: %d원%n";
//		bill+="세   금: %d원%n";
//		bill+="종합요금: %d원%n";
//		
//		//수도요금 계산
//		int price=(menu==1)? 50:(menu==2)? 40:(menu==3)? 30:-1;
//		int wbill=use*price;
//		
//		//세금 계산
//		int tax=(int)(wbill*0.05);//청구 요금에는 소수점 x
//			
//		switch(menu){
//		case 1:
//			System.out.printf(bill, menu,use,wbill,tax,(wbill+tax));
//			break;
//		case 2:
//			System.out.printf(bill, menu,use,wbill,tax,(wbill+tax));
//			break;
//		case 3:
//			System.out.printf(bill, menu,use,wbill,tax,(wbill+tax));
//			break;
//		case 9:
//			System.out.println("종          료");
//			break;
//		default:
//			System.out.println("옮바른 값을 입력해주세요");
//			break;
//		}
	}
}
/*
 * Java의 정석 3장
 * [1] 6 true 13 5 false 2 5 66 B B C
 * [2] numOfApples / sizeOfBucket+(numOfApples % sizeOfBucket>0)? 1: 0
 * [3] (num>0)? "양수" : (num<0)? "음수" : 0
 * [4] num/100*100
 * [5] num/10*10+1
 * */
