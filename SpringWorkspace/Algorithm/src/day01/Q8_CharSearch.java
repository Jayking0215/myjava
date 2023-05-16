package day01;
import java.util.*;

public class Q8_CharSearch {
	
	public static int solution(String str, char ch) {
		int cnt=0;
		str=str.toUpperCase();
		ch=Character.toUpperCase(ch);
		char[] arr=str.toCharArray();
		for(char c:arr) {
			if(c==ch) {
				cnt++;
			}
		}
		return cnt;
	}//--------------------------------
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String str=sc.nextLine();
		System.out.println("검색할 문자 하나를 입력하세요");
		char ch=sc.next().charAt(0);
		int cnt=solution(str, ch);
		System.out.println("검색한 문자 "+ch+"는 "+cnt+"개 있어요");
	}

}
