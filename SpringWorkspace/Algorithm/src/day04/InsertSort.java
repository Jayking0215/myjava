package day04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertSort {

	public static void main(String[] args) {
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
		System.out.println("---삽입 정렬 후---------------");
		//insertSort(arr);
		insertSort2(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void insertSort(int[] arr) {
		//i=1, j=i-1, j--
		//tmp <=삽입할 값을 보관 arr[i], tmp와 < arr[j]값을 비교 => 뒤로 보내기 else 삽입할 위치를 찾음(삽입 수행)
		for(int i=1;i<arr.length;i++) {
			int tmp=arr[i];
			int j=i-1;
			for(;j>=0;j--) {
				if(arr[j] > tmp) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
			}//for----
			arr[j+1]=tmp;
			System.out.println(i+": arr : "+Arrays.toString(arr));
		}//for-----
	}//------------------
	
	private static void insertSort2(int[] arr) {
		//i=1, j=i-1, j--
		//tmp <=삽입할 값을 보관 arr[i], tmp와 < arr[j]값을 비교 => 뒤로 보내기 else 삽입할 위치를 찾음(삽입 수행)
		for(int i=1;i<arr.length;i++) {
			int tmp=arr[i];
			int j=i-1;
			for(;j>=0&& arr[j]>tmp;j--) {				
				arr[j+1]=arr[j];				
			}//for----
			arr[j+1]=tmp;
			System.out.println(i+": arr : "+Arrays.toString(arr));
		}//for-----
	}

}




