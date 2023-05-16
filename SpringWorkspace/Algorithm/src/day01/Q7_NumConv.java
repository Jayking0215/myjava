package day01;
import java.util.*;
//0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ
public class Q7_NumConv {

	public static void main(String[] args) {
		char[] arr=new char[32];//int 크키=>32
		Scanner sc=new Scanner(System.in);
		System.out.println("정수(양수) 입력: ");
		int num=sc.nextInt();
		System.out.println("몇 진수로 변환할까요? (2~36)");
		int radix=sc.nextInt();
		solution(num,radix, arr);
	}
	public static void solution(int num, int radix, char[] arr) {
		String ans="";
		int temp=num;
		while(temp>=1) {
			int val=temp%radix;
			String digit="";
			if(val>9) digit=Character.toString(val+55);
			else digit=Integer.toString(val);
			ans=digit+ans;
			temp=temp/radix;
		}
		arr=ans.toCharArray();
		System.out.printf("%d를 %d진수로 변환: "+ans, num, radix);
	}//--------------------------------------
	public static void solution2(int num, int radix, char[] arr) {
		System.out.printf("%d를 %d진수로 변환: %n", num, radix);
		String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int cnt=0;
		do {
			int mod=num%radix;
			char c=str.charAt(mod);
			arr[cnt++]=c;
			num=num/radix;
		}while(num!=0);
		/*
		for(int i=0;i<cnt;i++) {
			System.out.print(arr[cnt-1-i]);
		}
		*/
		for(int i=0;i<cnt/2;i++) {
			char tmp=arr[i];
			arr[i]=arr[cnt-1-i];
			arr[cnt-1-i]=tmp;
		}//-------------------
		System.out.println(Arrays.toString(arr));
		
		
	}

}
