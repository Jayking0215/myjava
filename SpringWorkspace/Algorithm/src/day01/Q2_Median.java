package day01;
import java.util.*;

public class Q2_Median {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("3개의 정수를 입력하세요");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		int result=median(a,b,c);
		System.out.printf("%d, %d, %d 중에 중앙값: %d",a,b,c,result);
	}
	public static int median(int a, int b, int c) {
	    int[] nums = {a, b, c};
	    Arrays.sort(nums);
	    return nums[1];
	}
	public static int median2(int a, int b, int c) {
		if(a>=b) {
			if(b>=c) {
				return b;
			}else if(a>c) {
				return c;
			}else {
				return a;
			}
		}else if(a>c) {
			return a;
		}else if(b>c) {
			return c;
		}else {
			return b;
		}
	}//--------------------------------

}
