/*
 * 
4 3

1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7

2 2 3 4
3 4 3 4
1 1 4 4
 * 
 * */
package day01;

import java.util.*;
public class Q12_SumInterval {
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("N과M을 입력하세요");
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int[][] arr=new int[N+1][N+1];
		int[][] dp=new int[N+1][N+1];
		
		//데이터 입력받아 arr에 저장하고
		//구간합 표 구해서 dp에 저장하기 => 구간합 테이블
		System.out.println("데이터를 입력하세요");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j]=sc.nextInt();
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
			}//for
		}//for
		System.out.println();
		printArray(arr);
		printArray(dp);
		
		System.out.println("구간 데이터를 입력하세요");
		for(int i=0; i<M; i++) {
			int sum=0;
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			sum=dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
			System.out.println("\n"+sum);
		}
	}
	
	public static void printArray(int[][] arr) {
		for(int[] a:arr) {
			for(int b:a) {
				System.out.printf("%3d", b);
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}//
	

}
