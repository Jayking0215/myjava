package day04;

public class Recursive {
	
	public static void recursive(int num) {
		//종료조건 -기본단계
		if(num<=0) {
			return;
		}
		//System.out.printf("recursive() call num=%d%n", num); // 4 3 2 1
		//재귀 단계
		recursive(num-1);
		System.out.printf("recursive() call num=%d%n", num); //1 2 3 4
	}
	
	
	public static void main(String[] args) {
		recursive(4);
	}

}
