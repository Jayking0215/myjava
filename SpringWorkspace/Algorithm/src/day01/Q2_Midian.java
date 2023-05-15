package day01;
import java.util.*;
public class Q2_Midian {

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
		  //int[] md= {a,b,c};
		  //Arrays.sort(md);
		  //return md[1];
		
		  //int max=(a>b)?a:b;
		  //max=(max>c)?max:c;
		  //int min=(a<b)?a:b;
		  //min=(min<c)?min:c;
		  
		  //int median=a+b+c-max-min;
		  //return median;
		
			//피타고라스 정의(대소구분 불가)
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
		 }//

}
