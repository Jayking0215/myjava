package day04;

public class Recursive2 {
	
	static void recur(int n) {
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}

	public static void main(String[] args) {		
		recur(4);
	}

}
