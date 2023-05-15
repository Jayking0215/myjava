package day01;
import java.util.*;
public class Q4_ArrayMaxMin {

	//최대 최소값을 배열에 담아서 반환
	public static int[] solution(int[] heights) {
		int[] answer=new int[2];
		
		answer[0]=Math.max(heights[0], heights[1]);
		answer[1]=Math.min(heights[0], heights[1]);
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("사람수를 입력하세요 [키의 최대,최소값을 구합니다]");
		int num=sc.nextInt();
		//반복문 돌면서 heights에 랜덤 키값 저장하기(100~190cm)
		
	}

}
