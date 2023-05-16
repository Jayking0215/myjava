package day01;

import java.util.*;

public class Txt1 {
	
	public int solution(int n) {
		int answer=0;
		
		String[] arr=String.valueOf(n).split("");
		for(int i=0; i<arr.length; i++) {
			answer+=Integer.parseInt(arr[i]);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Txt1 app=new Txt1();
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자를 입력해주세요"); 
		String str=sc.next();
		int answer=app.solution(n);
		System.out.println("숫자의 합: "+answer);
		
	}
}
