package day04;

public class ArrayTest2 {
	public static void main(String[] args) {
		// [문제1] String 유형을 저장하는 이차원 배열을 선언하고 생성, 초기화하세요
		//  반복문 이용해서 출력하되 모두 소문자로 바꿔 출력하세요
		String s="JavaScript";
		String[] str[]= {{"Java","CSS"},{new String("HTML"),s}};//리터럴 형식,바로 메모리 할당, 변수 할당
		
		String[][] arr=new String[2][3];
		arr[0][0]="BackEnd";
		arr[0][1]="Developer";
		arr[0][2]=new String("~~~");
		
		arr[1]=new String[] {"Good","job","!!"};//3개의 열
		
		for(String[] sarr:str) {
			for(String sr:sarr) {
				System.out.println(sr.toLowerCase());
			}
		}
		System.out.println("---------------------------");
		
		for(String[] sarr:arr) {
			for(String sr:sarr) {
				if(sr!=null) {
				System.out.println(sr.toLowerCase());//3열이 비어있는 값일 경우
				}
			}
		}
		System.out.println("---------------------------");
		
		/* [문제 2] 2차원 배열에 다음의 값을 저장하되,
		  for루프를 이용해 저장하자.
		  그런 뒤, 저장된 값들을 출력해봅시다.
		  1 0 0 0 0
		  0 1 0 0 0
		  0 0 1 0 0
		  0 0 0 1 0
		  0 0 0 0 1
		 */
		int c[][]=new int[5][5];
		for(int i=0; i<c.length; i++){
			for(int j=0; j<c[i].length; j++){
				if(i==j){
					c[i][j]=1;
				}
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		
		/* [문제3] 아래 선언된 변수들의 자료형을 맞춰봅시다.
		 * 
		 * (1)   int i, j[]          : 1=정수형, j=1차원배열(정수)
		 * (2)   int[] i, j[], k;    : i=1차원배열, j=2차원배열, k=1차원배열
		 * (3)   int i, []j[], k[];   : i=정수형, j=2차원배열, k=1차원배열
		 * (4)   int [][]i, j[];    : i=2차원배열, j=3차원 배열
		 * **첫번째 변수명이 나오기 전까지 부분이 공통적으로 적용된다.
		 * */
	}
}
