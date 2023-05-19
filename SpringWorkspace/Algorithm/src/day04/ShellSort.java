package day04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*쉘정렬 알고리즘은 삽입정렬 알고리즘의 느린 속도를 보완하기 위해 만들어진 알고리즘.
 * 데이터의 그룹을 나누어 그룹 안에서 쉘 정렬을 수행하고, 마지막에 삽입정렬을 수행하는 알고리즘이다.
 * 삽입정렬의 장점: 대부분이 정렬되어 있는 상태에 가까울 때 속도가 아주 빠르다
 *         단점: 삽입할 곳이 멀리 떨어지면 이동(대입)하는 횟수가 많다.
 *         ex) 1 2 3 4 5 0 6  식의 배열일 경우 0을 삽입하려면 총 6회에 걸쳐 요소를 이동시켜야 한다.
 *셀정렬의 시간복잡도는 O(n^1.25), 삽입정렬 O(n^2)보다는 빠르다. but안정적이진 않음 멀리 떨어진 요소를 교환함으로         
 * */
public class ShellSort {
	
	//interval을 4 2 1 순으로 건너뛰기 하면서 삽입정렬을 수행한다 => 셀정렬
	static void intervalSort(int[] arr) {
		//i: interval  4 2 1 순으로 
		for(int i=arr.length/2;i>0;i=i/2) {
			for(int k=i;k<arr.length;k++) {
				int j;
				int tmp=arr[k];//arr[4]
				for(j=k-i;j>=0;j-=i) {
					if(arr[j]>tmp) {
						arr[j+i]=arr[j];
					}else {
						break;
					}					
				}//for---	
				arr[j+i]=tmp;
				System.out.println("i(interval): "+i+" k :"+k+" arr: "+Arrays.toString(arr));
			}//for---			
		}//for---------------		
	}//-------------------------------------------
	
	//interval을 n배수로 증가시키면  나눈 그룹이 서로 섞이지 않고 같은 멤버로 구성될 수도 있다.
	//이것을 개선하기 위해 증분 수열을=>3*n+1
	static void intervalSort2(int[] arr) {
		//interval의 초기값을 구하자
		int inter;
		for(inter=1;inter<arr.length;inter=3*inter+1);
		System.out.println("inter: "+inter);//13, 4, 1
		for(;inter>0; inter=inter/3) {
			for(int k=inter;k<arr.length;k++) {
				System.out.println("k: "+k+", inter: "+inter);
				int j;
				int tmp=arr[k];
				for(j=k-inter;j>=0 && arr[j]>tmp  ;j-=inter) {
					arr[j+inter]=arr[j];//뒤로 inter만큼 밀어내기
				}//for----
				//삽입하기
				arr[j+inter]=tmp;
			}//for-------------			
		}//for--------------
	}//---------------------------------------------
	

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
		
		//intervalSort(arr);
		intervalSort2(arr);
		
		System.out.println(Arrays.toString(arr));

	}

}
