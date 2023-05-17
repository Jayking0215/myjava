package day02;
import java.util.*;
/*
 * 소수 구하기
 * 소수: 1과 자신으로만 나눠지는 수
 * 1~1000 정수 중 소수를 구해 출력
 * */

public class Q14_PrimeNumber {

	public static void main(String[] args) {
		int cnt=0;
		for(int num=2; num<=1000; num++) {
			int i;
			for(i=2; i<=num; i++) {
				cnt++;
				if(num%i==0) {
					break;
				}
			}
			if(i==num) {
				System.out.println(num);
			}
		}
		System.out.println("수행횟수: "+cnt);
	}

}
