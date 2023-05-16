package day01;

import java.util.Random;
import java.util.Scanner;

public class Q4_ArrayMaxMin {
	
	//최대,최소값을 배열에 담아서 반환하세요
	public static int[] solution(int [] heights) {
		int[] answer= new int[2];//최대키, 최소키값을 저장할 배열
		int max=heights[0];
		int min=heights[0];
		for(int h:heights) {
			if(h>max) {
				max=h;
			}
			if(h<min) {
				min=h;
			}
		}//for---
		answer[0]=max;
		answer[1]=min;
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("사람수를 입력하세요 [키의 최대,최소값을 구합니다]");
		int num=sc.nextInt();
		//반복문 돌면서 height에 랜덤한 키값을 저장하기 (100 ~190)
		Random ran=new Random();
		int [] heights=new int[num];
		for(int i=0;i<num;i++) {
			heights[i]=ran.nextInt(91)+100;
			System.out.println(heights[i]);
		}
		
		//제일 큰키
		//제일 작은키
		int [] max_min=solution(heights);
		System.out.println("최대키: "+max_min[0]);
		System.out.println("최소키: "+max_min[1]);
		
	}

}
