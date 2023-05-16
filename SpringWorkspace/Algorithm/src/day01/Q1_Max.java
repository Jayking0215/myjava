package day01;

public class Q1_Max {
	
	public static int max2(int a, int b) {
		//int max=(a>b)? a:b;
		int max=a;
		if(b>max) {
			max=b;
		}		
		return max;
	}
	
	public static int max3(int a, int b, int c) {
		int max=a;
		if(b>max) {
			max=b;
		}
		if(c>max) {
			max=c;
		}
		return max;
	}
	
	public static int max4(int a,int b, int c, int d) {
		return max2(max2(max2(a,b),c),d);
	}

	public static void main(String[] args) {
		int a=50;
		int b=133;
		int c=45;
		int d=82;
		
		System.out.println(max2(b,c));
		
		int mx=max3(a,b,c);
		System.out.printf("%d, %d, %d 중 최대값: %d%n", a,b,c, mx);
		
		mx=max3(a,c,d);
		System.out.printf("%d, %d, %d 중 최대값: %d%n", a,c,d, mx);
		
		mx=max4(a,b,c,d);
		System.out.printf("%d, %d, %d, %d 중 최대값: %d%n", a,b,c,d, mx);
		
		
	}

}
