package day05;

import java.util.Arrays;

//퀵정렬 사전 학습: 피벗을 하나 정해 2 그룹으로 나누어 데이터를 교환하는 알고리즘
public class Partition {

	public static void main(String[] args) {
		int[]arr= {1,8,4,7,5,2,6,3,9};
		//pivot=5;
		partition(arr);
	}
	public static void partition(int[] arr) {
		int pl=0;//왼쪽 포인터, ++ 증가
		int pr=arr.length-1; //오른쪽 포인터, --감소
		int pivot=arr[arr.length/2];
		//System.out.println("pivot: "+pivot);
		do {
			while(arr[pl]<pivot)  pl++;
			while(arr[pr]>pivot)  pr--;
			if(pl<=pr) {
				swap(arr,pl,pr);
				pl++;
				pr--;
			}
		}while(pl<=pr);
		System.out.println("----분할한 후-----------");
		System.out.println(Arrays.toString(arr));
	}//-----------------------
	private static void swap(int[] arr, int pl, int pr) {
		int tmp=arr[pl];
		arr[pl]=arr[pr];
		arr[pr]=tmp;		
	}//------------------------------------

}
