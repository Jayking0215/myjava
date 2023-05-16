package day01;
import java.util.*;
public class Q13_Pallindrome {
	
	public static String solution(String str) {
		str = str.toLowerCase();
		String answer = "YES";
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				answer = "NO";
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("문자열을 입력하세요=>");
		String str=sc.next();
		
		System.out.println("회문 문자열이 맞아요? "+solution(str));
		
	}

}
