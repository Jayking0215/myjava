package day04;

import java.util.Arrays;
import java.util.Scanner;
//피보나치 수열
//1 1 2 3 5 8 13 21 34 55
public class Fibonacci {
	
	//반복문 이용해서 구현해보기 => 출력도 하기
	public static void fibo(int n) {//n은 항
		int[] arr=new int[n];
		arr[0]=1;
		arr[1]=1;
		//System.out.print(arr[0]+", "+arr[1]);
		for(int i=2;i<n;i++) {
			arr[i]=arr[i-2]+arr[i-1];
		}
		System.out.println(Arrays.toString(arr));
	}//-------------------------------
	
	//재귀함수 이용해서 구현해보기
	public static int fibo2(int n) {
		if(n==1) return 1;
		else if(n==2) return 1;
		else
			return fibo2(n-2)+fibo2(n-1);		
	}//------------------------------------------

	static int [] arr;
	public static int fibo3(int n) {
		if(n==1) return arr[n]=1;
		else if(n==2) return arr[n]=1;
		else
			return arr[n]=fibo3(n-2)+fibo3(n-1);		
	}//------------------------------------------
	//메모제이션
	public static int fibo4(int n) {
		///////////////////////
		if(arr[n]>0) return arr[n];
		////////////////////////
		if(n==1) return arr[n]=1;
		else if(n==2) return arr[n]=1;
		else
			return arr[n]=fibo4(n-2)+fibo4(n-1);		
	}//------------------------------------------
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇 항까지 할까요?");
		int num=sc.nextInt();
		arr=new int[num+1];
		//fibo(num);
		//System.out.println("1.-----------------");
		//for(int i=1;i<=num;i++)
			//System.out.print(fibo2(i)+", ");
		
		System.out.println("2.-----------------");
		//fibo3(num);
		System.out.println(Arrays.toString(arr));
		System.out.println("3.-----------------");
		fibo4(num);
		
		
		System.out.println(Arrays.toString(arr));
	}//main()--------------------

}
