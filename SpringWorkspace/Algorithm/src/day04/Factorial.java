package day04;

import java.util.Scanner;
//5*4*3*2*1=120
public class Factorial {
	
	public static int factorial(int num) {
		if(num<1) return 1;
		String str=(num==1)?"=":"x";
		System.out.print(num+str);
		return num*factorial(num-1);		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("양의 정수를 입력하세요");
		int num=sc.nextInt();
		System.out.println(factorial(num));
	}

}
