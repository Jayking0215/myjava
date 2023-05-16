package day01;
import java.util.*;
public class Q5_ArrayEquals {
	
	public int[] inputArray(int nth) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 "+nth+"의 요소수 입력:");
		int num1=sc.nextInt();
		//배열 생성
		int [] arr=new int[num1];
		//반복문 돌면서 배열에 값 저장하기
		for(int i=0;i<num1;i++) {
			arr[i]=sc.nextInt();
			System.out.printf("arr[%d] : %d%n", i, arr[i]);
		}
		return arr;
	}//----------------------
	public boolean solution(int[] a, int b[]) {
		if(a.length!= b.length) return false;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i])
				return false;
		}//for----------
		return true;
	}

	public static void main(String[] args) {
		
		Q5_ArrayEquals app=new Q5_ArrayEquals();
		//inputArray()호출해서 배열 2개 반환받기
		int[] arr1=app.inputArray(1);
		int[] arr2=app.inputArray(2);
		//2배열이 같은지 여부 체크 (solution()호출)
		String str=(app.solution(arr1, arr2))?"배열 arr1과 arr2는 같습니다":"두 배열은 서로 달라요";
		System.out.println(str);
	}

}
