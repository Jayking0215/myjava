package day04;

import java.util.Arrays;
import java.util.Scanner;

public class Q25_ArrayMerge {
	
	public static int [] solution(int[] a, int[] b) {
		Arrays.sort(a);//오름차순 정렬
		Arrays.sort(b);
		int pa=0;
		int pb=0;
		int pc=0;
		
		int c[]= new int[a.length+b.length];
		while(pa<a.length && pb <b.length) {
			c[pc++]=(a[pa] <  b[pb])? a[pa++]: b[pb++];
		}
		//남아있는 데이터를 모두 c에 저장하기
		while(pa<a.length) 
			c[pc++]=a[pa++];
		while(pb<b.length) 
			c[pc++]=b[pb++];
		return c;
	}//-------------------------------
	
	public static int[] solution2(int[] a, int[] b) {
		int[] c=new int[a.length+b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		//배열 a를 c로 카피
		System.arraycopy(b, 0, c, a.length, b.length);
		System.out.println("-- 병합한 c (정렬전)----------------");
		System.out.println(Arrays.toString(c));
		Arrays.sort(c);
		
		System.out.println("-- 병합한 c (정렬후)----------------");
		System.out.println(Arrays.toString(c));
		return c;
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열1의 크기: ");
		int n=sc.nextInt();
		
		System.out.println("배열2의 크기: ");
		int m=sc.nextInt();
		
		int[] a=new int[n];
		int[] b=new int[m];
		System.out.println("배열1에 저장할 데이터 입력: ");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("배열2에 저장할 데이터 입력: ");
		for(int i=0;i<m;i++) {
			b[i]=sc.nextInt();
		}
		int c[]=solution(a,b);
		System.out.println(Arrays.toString(c));
	}

}
