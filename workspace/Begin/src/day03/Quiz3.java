package day03;

import java.util.*;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1~100사이의 정수를 입력하세요");
		//컴퓨터가 랜덤한 정수값을 1<= r <=100 사이의 임의의 정수를 발생시킨다.
		//이 값을 맞추는 게임
		//단 게임시도횟수가 7번을 초과하면 "실패!!" 게임 종료
		
		int num=sc.nextInt();
		int r=(int)(Math.random()*100+1);//100포함
		for(int i=1; i<8; i++) {
			if(num==r) {
				System.out.println("Correct! You Win!");
				return;
			}else if(num>r) {
				System.out.printf("%d보다 작은 수 입니다 Try: %d%n",num,i);
				num = sc.nextInt();
			}else if(r>num) {
				System.out.printf("%d보다 큰 수 입니다 Try: %d%n",num,i);
				num = sc.nextInt();
			}
		}
		System.out.println("---GAME OVER---");
		
//		int cnt=1;
//		int com=(int)(Math.random()*100+1);
//		
//		while(cnt!=8) {
//			int user=sc.nextInt();//입력값 받기
//			if(com==user) {
//				System.out.println("Correct! You WIN!!! Try: "+cnt);
//				return;
//			}else if(com>user) {
//				System.out.println(user+"보다 더 큰 수 잆니다 Try: "+cnt);
//			}else if(com<user){
//				System.out.println(user+"보다 더 작은 수 잆니다 Try: "+cnt);
//			}
//			cnt++;
//		}//while
//		System.out.println("-----GAME OVER-----");
	}
}