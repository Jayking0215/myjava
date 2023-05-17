package day02;
import java.util.*;

public class Q19_LinearSearch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 크기 입력: ");
		int n=sc.nextInt();
		//int[] arr=new int[n];
		//보초법 이용할 경우 : 검색 값을 맨 뒤에 저장한다
		int[] arr=new int[n+1];
		
		System.out.println("저장할 데이터 입력: ");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("검색할 데이터 입력: ");
		int key=sc.nextInt();
		
		int idx=solution(arr, n, key);
		//검색 값이 없으면 -1을 반환하고 있으면 해당 인덱스 번호 반환
		System.out.println((idx==-1)?key+"값은 배열에 없습니다":key+"값은 배열 인덱스 "+idx+"에 있어요");
	}
	
	public static int solution2(int [] arr, int n, int key) {
		int i=0;
		while(true) {
			if(i==n) {//판단2
				return -1;
			}
			if(arr[i]==key) {//판단1
				return i;
			}
			
			i++;
		}
	}//-------------------------
	//보초법
	public static int solution(int[] arr, int n, int key) {
		int i=0;
		arr[n]=key;//보초(sentinel)
		while(true) {
			if(arr[i]==key) {
				//return i;
				break;
			}
			i++;
		}
		return (i==n)? -1: i;
	}//-----------------------
	
	
	
	
	

}
