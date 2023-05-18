package day03;

import java.util.Arrays;
import java.util.Scanner;
//78  82 65 82 100
public class Q23_KorGrade {
	
	public int[] solution(int n, int[] kor) {
		int grade[]=new int[n];
		
		for(int i=0;i<n;i++) {
			grade[i]=1;
			for(int j=0;j<n;j++) {
				if(kor[i]<kor[j]) {
					grade[i]++;
				}
				
			}//for----
		}//for-----------
		return grade;
	}

	public static void main(String[] args) {
		Q23_KorGrade app=new Q23_KorGrade();
		Scanner sc=new Scanner(System.in);
		System.out.println("학생 수 입력: ");
		int n=sc.nextInt();
		System.out.println("국어 성적 "+n+"개 입력: ");
		int [] kor=new int[n];
		for(int i=0;i<n;i++) {
			kor[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(kor));
		
		int grade[]=app.solution(n, kor);
		System.out.println(Arrays.toString(grade));

	}

}
