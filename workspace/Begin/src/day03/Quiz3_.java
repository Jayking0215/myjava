package day03;

import java.util.Scanner;

public class Quiz3_{//main()메서드에서는 게임 실행만 할 수 있도록 만들기
	
	public static void startGame() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1~100사이의 정수를 입력하세요");
		
		int cnt=1;
		int com=(int)(Math.random()*100+1);
		
		while(cnt!=8) {
			int user=sc.nextInt();//입력값 받기
			if(com==user) {
				System.out.println("Correct! You WIN!!! Try: "+cnt);
				return;
			}else if(com>user) {
				System.out.println(user+"보다 더 큰 수 잆니다 Try: "+cnt);
			}else if(com<user){
				System.out.println(user+"보다 더 작은 수 잆니다 Try: "+cnt);
			}
			cnt++;
		}//while
		System.out.println("-----GAME OVER-----");
	}
	
	public static void main(String[] args) {
		Quiz3_.startGame();
	}
}