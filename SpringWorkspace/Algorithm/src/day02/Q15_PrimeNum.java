package day02;

import java.util.Arrays;

/*알고리즘 개선 [교재 74p]
 * n이 2또는 3으로 나누어 떨어지지 않으면 2x2인 4 또는 2x3 인 6으로도 나눠 떨어지지 않는다.
 * 즉 정수 n이 소수인지 여부는 2부터 n-1까지 어떤 소수로도 나누어 떨어지지 않는다.
 * 예를 들어 7이 소수인지는 7보다 작은 소수 2,3,5로 나눗셈을 하면 충분하다
 * 이렇게 하면 계산 시간을 줄일 수 있다.
 * */
public class Q15_PrimeNum {
	public static int[] solution() {
		int prime[]=new int[500];//소수를 저장할 배열
		int index=0;
		prime[index++]=2;//prime[0]=2; index=1
		int cnt=0;
		for(int num=3;num<=1000;num+=2) {//판별 대상은 홀수만
			int j;
			for(j=1;j<index;j++) {
				cnt++;
				if(num%prime[j]==0) {
					break;
				}
			}//for----
			if(j==index) {//소수인 경우
				prime[index++]=num;
			}
		}//for-------------
		System.out.println("수행 횟수: "+cnt);
		return prime;
	}

	public static void main(String[] args) {
		int [] arr=solution();
		System.out.println(Arrays.toString(arr));

	}

}
