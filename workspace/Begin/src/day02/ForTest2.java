package day02;

public class ForTest2 {

	public static void main(String[] args) {
		//중첩 for루프 이용해서 아래와 같이 출력하세요
		/*[1]
		 *   *****
		 *   *****
		 *   *****
		 *   *****
		 *   
		 *   4행5열
		 * 
		 * */
		System.out.println("[1]");
		for(int i=1; i<5; i++) {
			for(int j=1; j<6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/* [2]
		 * 
		 *  *
		 *  **
		 *  ***
		 *  ****
		 * 
		 * */
		System.out.println("[2]");
		for(int i=1; i<5; i++) {
			for(int j=0; i>j; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*[3]
		 * 
		 *    *
		 *   **
		 *  ***
		 * ****     
		 * 
		 * (0,0)(0,1)(0,2)(0,3)
		 * (1,0)(1,1)(1,2)(1,3)
		 * (2,0)(2,1)(2,2)(2,3)
		 * (3,0)(3,1)(3,2)(3,3)
		 * */
		System.out.println("[3]");
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(i+j >= 3) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		/* [4]
		 *    *
		 *   ***
		 *  *****  
		 * 
		 * (0,0)(0,1)(0,2)(0,3)(0,4)
		 * (1,0)(1,1)(1,2)(1,3)(1,4)
		 * (2,0)(2,1)(2,2)(2,3)(2,4)
		 * */
		System.out.println("[4]");
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				if((i+j)>=2 && (j-i)<3) {//(2-i<=j && j<=2+i)
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
		/* [5]
		 * 
		 *  *
		 *  **
		 *  ***
		 *  ****
		 *  ***
		 *  **
		 *  *
		 *  
		 *  
		 * */
		System.out.println("[5]");
		/* 변수로 별 피라미드 만들기
		 * java.util.Scanner sc=new java.util.Scanner(System.in);
		 * System.out.println("정수 입력");
		 * int num=sc.nextInt();
		 * */
		for (int i = 0; i < 7; i++) {//for(int i=1; i<=num; i++){
			for (int j = 0; j < 4; j++) {//int star=(i<=num/2+1)? i:(num+1 - i);
				if ((i < 3 && i >= j) || ((2<i && i<7) && i+j<7)) {//for(int j=1; j<=star; j++){
					System.out.print("*");
				}
			}
			System.out.println();
		}System.out.println();
	}

}
