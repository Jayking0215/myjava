package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_ArrayCopy {

	public static int[] inputArray(int nth) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 "+nth+"의 요소수 입력:");
		int num1=sc.nextInt();
		//배열 생성
		int[] arr=new int[num1];
		//반복문 돌면서 배열에 값 저장하기
		for(int i=0; i<num1; i++) {
			System.out.println("arr["+i+"] : ");;
			arr[i]=sc.nextInt();
		}
		
		return arr;
	}//--------------------------------------
	
	public static void copy(int[] a, int[] b) {
		//배열 크기가 작은쪽에서 큰 쪽배열로 copy
		int num=(a.length < b.length)?a.length:b.length;
		for(int i=0; i<num; i++) {
			if(a.length<b.length) {
				b[i]=a[i];
			}else {
				a[i]=b[i];
			}
		}
		System.out.println("copy완료!");
	}
	
	public static void reverse_copy(int[] a,int[] b) {
		//역순으로 copy
		int num=(a.length < b.length)?a.length:b.length;
		for(int i=0; i<num; i++) {
			if(a.length<b.length) {
				b[i]=a[num-1-i];
			}else {
				a[i]=b[num-1-i];
			}
		}
		System.out.println("reverse_copy완료!");
	}
	
	//swap
	public static int[] reverse(int[] a) {
		for(int i=0; i<a.length/2; i++) {
			//int x=a[i];
			//int y=a[a.length-1-i];
			int tmp=a[i];
			a[i]=a[a.length-1-i];
			a[a.length-1-i]=tmp;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] a=inputArray(1);
		int[] b=inputArray(2);
		//copy()
		copy(a,b);
		reverse_copy(a,b);
		//a,b값 출력
		System.out.println("배열 a: "+Arrays.toString(a));
		System.out.println("배열 b: "+Arrays.toString(b));
	}
}
