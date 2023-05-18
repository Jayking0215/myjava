package day03;

import java.util.Arrays;
import java.util.Scanner;

/*
 10 18 41 23 62
 25 78 35 12 28
 23 17 28 16 39
 78 45 16 34 17
 52 21 18 30 10
  
 * */

public class Q24_ArrayMax {
	
	public static int solution(int n, int[][] arr) {
		int max=-9999;
		int row_sum=0;//행들의 합
		int col_sum=0;//열들의 합
		
		//각행과 열, 대각선들의 합을 저장할 배열
		int[] sums=new int[2*n+2];
		
		for(int i=0;i<n;i++) {
			row_sum=0;
			col_sum=0;
			for(int j=0;j<n;j++) {
				//System.out.print(arr[j][i]+", ");
				row_sum+=arr[i][j];
				
				col_sum+=arr[j][i];
			}//for---
			sums[i]=row_sum;
			sums[n+i]=col_sum;
			//System.out.println("의 합: "+col_sum);
			if(row_sum>max) {
				max=row_sum;
			}
			if(col_sum>max) {
				max=col_sum;
			}
		}//for------
		//대각선1, 대각선2
		int sum1=0, sum2=0;
		for(int i=0;i<n;i++) {
			sum1+=arr[i][i];//대각선1의 합
			sum2+=arr[i][n-1-i];//대각선2의 합
		}
		
		sums[2*n]=sum1;
		sums[2*n+1]=sum2;
		
		if(sum1>max) {
			max=sum1;
		}
		if(sum2>max) {
			max=sum2;
		}
		System.out.println("각각의 행의 합,열의합,대각선합: "+Arrays.toString(sums));
		return max;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 크기 입력: ");
		int n=sc.nextInt();
		System.out.printf("%d행 %d열 배열에 저장할 값 입력: %n",n,n);
		
		int [][] arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}//for--
		}//for-------
		
		int max=solution(n, arr);
		System.out.println("최대합계: "+max);
	}

}
