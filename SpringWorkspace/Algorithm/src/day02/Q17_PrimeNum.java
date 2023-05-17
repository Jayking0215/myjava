package day02;

import java.util.Arrays;

public class Q17_PrimeNum {
	public static int[] solution() {
		int prime[] = new int[1001];

		// 1. 반복문 돌면서 2~1000값을 배열에 저장
		for (int i = 2; i <= 1000; i++) {
			prime[i] = i;
		}
		System.out.println(Arrays.toString(prime));
		System.out.println("-----------------------");
		// 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다 ==> 0을 넣는다
		// 지울 때 자기 자신은 지우지 않고 이미 지운수는 건너뛰기 한다.
		for (int n = 2; n <= 1000; n++) {
			for (int i = 2; i * n <= 1000; i++) {
				prime[n * i] = 0;
			}
		}
		System.out.println(Arrays.toString(prime));
		System.out.println("**************************");
		
		return prime;
	}

	public static void main(String[] args) {
		int [] a=solution();
		for(int  x: a) {
			if(x!=0)
				System.out.print(x+" ");
		}
	}

}
