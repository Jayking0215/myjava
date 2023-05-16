package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q11_SumInterval {
	static Scanner sc=new Scanner(System.in);
	
	public static int[] solution(int n, int m) {
		int answer[]= new int[m];
		System.out.println("저장할 숫자 "+n+"개 입력하세요");
		int []arr=new int[n];
		int []sumArr=new int[n+1];//입력받을때 부터 누적합을 저장할 배열 생성
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt(); //1 3 5 2 4
			sumArr[i+1]=sumArr[i]+arr[i];
		}//for-----
		System.out.println("arr: "+Arrays.toString(arr));
		System.out.println("sumArr: "+Arrays.toString(sumArr));
		
		for(int i=0;i<m;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			int sum=sumArr[end]-sumArr[start-1];
			answer[i]=sum;
			System.out.printf("%d부터 %d까지의 합: %d%n", start, end, answer[i]);
		}
		
		return answer;
	}
	
	public static int[] solution2(int n, int m) {
		//배열 활용
		int answer[]= new int[m];
		System.out.println("저장할 숫자 "+n+"개 입력하세요");
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt(); //1 3 5 2 4
		}
		
		for(int i=0;i<m;i++) {
			System.out.println("구간 정보를 입력하세요 (start, end)");
			int start=sc.nextInt();
			int end=sc.nextInt();
			int sum=0;
			for(int j=start;j<=end;j++) {
				 sum+=arr[j-1];
			}			
			answer[i]=sum;
			System.out.printf("%d부터 %d까지의 합: %d%n", start, end, answer[i]);
		}//for----------------
		
		return answer;		
	}
	
	public static void main(String[] args) {
		System.out.println("N과 M을 입력하세요");
		int N=sc.nextInt();
		int M=sc.nextInt();
		int sum[]=solution(N,M);
		
	}

}
