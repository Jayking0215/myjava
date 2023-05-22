package day05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//분할,정복,병합의 과정을 거친다
public class MergeSort {

	public static void main(String[] args) {
		//int arr[]= {6,5,13,7,1,9,8,15,2};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 크기 입력: ");
		int n=sc.nextInt();
		Random ran=new Random();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			//1<= r <20
			arr[i]=ran.nextInt(20)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		partition(arr, 0, arr.length-1);
		System.out.println("---병합 정렬 후---------------");
		System.out.println(Arrays.toString(arr));
	}//--------------------------
	static void partition(int[] arr, int left, int right) {
		if(left==right) return;//분할 하다보면 (2로 나누기)  left==right순간이 생긴다
		int mid=(left+right)/2;
		partition(arr, left, mid);//전반부 분할
		partition(arr, mid+1, right);//후반부 분할
		merge(arr, left, right);//2개로 나눈 배열을 병합하는 메서드
	}
	static void merge(int[] arr, int left, int right) {
		int tmp[]=new int[arr.length];//임시 저장소
		int index=0;//tmp에서 사용할 인덱스
		int pc=(left+right)/2;
		int pl=left;
		int pr=pc+1;
		index=left;
		while(pl<=pc && pr<=right) {
			tmp[index++] = (arr[pl] < arr[pr])? arr[pl++]: arr[pr++];
		}
		//남은 배열이 있을 경우 tmp로 옮긴다
		if(pl>pc) {//왼쪽 배열을 tmp로 다 옮겼다면 오른쪽 배열 남은 요소를 tmp로 옮긴다
			for(int i=pr;i<=right;i++) {
				tmp[index++]=arr[i];
			}			
		}else {//반대의 경우, 왼쪽에 배열 남은요소 옮기기
			for(int i=pl;i<=pc;i++) {
				tmp[index++]=arr[i];
			}			
		}
		//임시배열 tmp를 원본 배열 arr에 카피하자
		for(int i=left;i<=right;i++) {
			arr[i]=tmp[i];
		}
		
	}

}
