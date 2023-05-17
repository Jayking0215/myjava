package day02;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수 입력");
		int n = sc.nextInt();
		
		int[] arr=new int[n];
		
		System.out.println("국어 성적 입력");
		for (int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		int[] grade=new int[n];
		
		for(int i=0; i<n; i++) {
			int cnt=1;
			for(int j=0; j<n; j++) {
				if(arr[i]<arr[j]) {
					cnt++;
				}
			}
			grade[i]=cnt;
		}
		for(int i:grade) {
			System.out.println(i+" ");
		}
		
		
	}

}
