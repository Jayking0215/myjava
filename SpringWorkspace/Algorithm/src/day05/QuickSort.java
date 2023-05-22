package day05;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[]arr= {1,8,4,7,5,2,6,3,9};
		System.out.println(Arrays.toString(arr));
		quickSort(arr,0, arr.length-1);//quickSort(arr,0,8)
		System.out.println("----퀵 정렬 이후------------");
		System.out.println(Arrays.toString(arr));
	}//-----------------------
	//분할 과정을 출력해보자
	public static void printProcess(int[] arr, int left, int right, int pivot) {
		System.out.println("pivot: "+pivot);
		System.out.printf("arr[%d] ~ arr[%d]: {", left, right);
		for(int i=left;i<right;i++) {
			System.out.printf("%d, ", arr[i]);
		}
		System.out.printf("%d}%n", arr[right]);
	}//------------------------
	
	static void quickSort(int[] arr, int left, int right) {
		int pl=left; //0
		int pr=right;//8
		int pivot=arr[(pl+pr)/2];
		
		printProcess(arr,pl,pr,pivot);
		
		do {
			while(arr[pl]<pivot) pl++;
			while(arr[pr]>pivot) pr--;
			if(pl<=pr) {
				swap(arr, pl++, pr--);				
			}
		}while(pl<=pr);
		//////////////////////////
		if(left<pr) quickSort(arr,left,pr);//재귀 호출
		if(pl<right) quickSort(arr,pl, right);
		///////////////////////////
	}//--------------------------

	private static void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}//--------------------------

}
