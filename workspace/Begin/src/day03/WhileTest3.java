package day03;

import javax.swing.JOptionPane;

public class WhileTest3 {

	public static void main(String[] args) {
		//[1] JOptionPane으로 "구구단 몇단을 출력할까요?"
		
		//[2] 구구단 전체를 아래와 같은 형태로 출력하세요 =>중첩 while or do~while
		/*
		 * 2x1=2	3x1=3	....		9x1=9
		 * 2x2=4	3x2=6				9x2=18
		 * ...
		 * 2x9=18
		 * */
		
		String str=JOptionPane.showInputDialog("구구단을 구구!");
		if(str==null) return; //입력 안하면 종료
		int gugu=Integer.parseInt(str.trim());//trim() 앞뒤 공백제거
		int i=1;
		System.out.println(str+"단!");
		while(i<10) {
			System.out.printf("%s x %d = %d%n",gugu,i,(gugu*i));
			i++;
		}
		
		
		int y=1;
		while(y<10) {
			int x=2;//while문에서는 밖에서 초기화 해줘야함.for문은 자동 초기화 됨
			while(x<10) {
				System.out.printf("%d x %d = %d\t", x, y, (x*y));
				x++;
			}
			System.out.println();
			y++;
		}
		
		
		
	}

}
