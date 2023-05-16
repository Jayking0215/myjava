package day01;

import java.util.Scanner;

public class Q9_UpperLower {
	public static String solution(String str) {
		String answer="";
		int diff='a'-'A';//소문자와 대문자의 아스키코드값의 차이: 32
		for(int i=0;i<str.length();i++) {
			answer+=(str.charAt(i)>='a')? (char)(str.charAt(i)-diff):(char)(str.charAt(i)+diff);
		}
		return answer;
	}//solution -------------
	
	public String solution2(String str) {
		
		char[] ch=str.toCharArray();
		StringBuffer buf=new StringBuffer();
		for(char c: ch) {
			if(Character.isUpperCase(c)) {
				buf.append(Character.toLowerCase(c));
			}else {
				buf.append(Character.toUpperCase(c));
			}
		}
		String answer=buf.toString();
		return answer;
	}//--------------------------------

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Q9_UpperLower app=new Q9_UpperLower();
		System.out.println("알파벳 문자열을 입력하세요");
		String str=sc.next();
		String result=app.solution(str);
		
		System.out.println(str);
		System.out.println(result);
	}

}
