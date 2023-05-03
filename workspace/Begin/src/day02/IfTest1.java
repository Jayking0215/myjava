package day02;

import java.util.Scanner;

public class IfTest1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//System.in: 키보드 입력을 받을 수 있는 입력장치와 연결된 class의 객체(instance)
		System.out.println("정수를 입력하세요=>");
		int num=sc.nextInt();//사용자가 입력한 정수값을 num에 반환
		//float a=sc.nextFloat(); double b=sc.nextDouble()
		
		System.out.println("num: "+num);
		
		//[1]입력받은 값이 짝수: "Even"출력, 홀수: "Odd"출력
		if(num%2==0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
		//[2] 삼항연산자로 구현
		String str=(num%2==0)? "짝수":"홀수";
		System.out.println(str);
		System.out.println("-----The End-----");
		
	}

}
