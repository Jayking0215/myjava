package day03;

import java.util.*;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//입력한 값이 숫자가 맞는지 여부를 체크
		//숫가자 아니면 "숫자가 아니에요 다시 입력하세요"
		//숫가자 맞다면 해당 숫자의 2진수 값을 출력
		//static String	toBinaryString(int i)
		System.out.println("숫자를 입력하세요=>");
		String str=sc.nextLine();//다시 입력 받는 코드
		System.out.println("str: "+str);
		for(int i=0; i<str.length(); i++) {
			boolean b=Character.isDigit(str.charAt(i));
			if(!b) {
				System.out.println("숫자가 아니에요 다시입력하세요");
				str=sc.nextLine();
				i=0;
			}
		}
		int num=Integer.parseInt(str);
		System.out.println(str+"의 2진수: "+Integer.toBinaryString(num));
		System.out.printf(str+"의 8진수: 0%s%n",Integer.toOctalString(num));
		System.out.printf(str+"의 16진수: 0x%s%n",Integer.toHexString(num));
		
	}
}
