package day01;
import java.util.*;
public class Q4_ArrayMaxMin {

	//최대 최소값을 배열에 담아서 반환
	public static int[] solution(int[] heights) {
		int[] answer=new int[2];
		int max=heights[0];
		int min=heights[0];
		for(int h:heights) {
			if(h>max) {
				max=h;
			}
			if(h<min) {
				min=h;
			}
		}
		answer[0]=max;
		answer[1]=min;
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("사람수를 입력하세요 [키의 최대,최소값을 구합니다]");
		int num=sc.nextInt();
		//반복문 돌면서 heights에 랜덤 키값 저장하기(100~190cm)
		Random ran=new Random();
		int[] heights=new int[num];
		for(int i=0; i<num;i++) {
			heights[i]=ran.nextInt(91)+100;
			System.out.println(heights[i]);
		}
		int[] max_min=solution(heights);
		System.out.println("최대키: "+max_min[0]);
		System.out.println("최소키: "+max_min[1]);
	}

}
