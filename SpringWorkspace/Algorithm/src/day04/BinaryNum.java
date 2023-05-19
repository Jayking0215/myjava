package day04;
import java.util.*;
public class BinaryNum {
	/*
	public static void solution(int num) {
		if(num <1) return;		
		solution(num/2);
		System.out.print(num%2);
	}//------------------------------
	*/
	private static void solution(int num, int rad) {
		if(num < rad) {
			System.out.print(num);
			return;
		}
		solution(num/rad, rad);
		int mod=num%rad;
		String str="0123456789ABCDEF";		
		System.out.print(str.charAt(mod));
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("양의 정수를 입력하세요");
		int num=sc.nextInt();
		
		solution(num, 16);
		

	}

}
