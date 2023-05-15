package day01;

public class Q3_GopTable {

	public static void solution() {
		System.out.println("   | ");
		for(int a=1; a<10; a++) {
			System.out.print(a+" ");
		}
		System.out.println();
		System.out.println("----+-----------------------------");
		
		for(int i=1; i<10; i++) {
			System.out.print(" "+i+"|");
			for(int j=1; j<10; j++) {
				System.out.print((i*j)+"  ");
			}
			System.out.println();
		}
	}
	
	private static void main(String[] args) {
		solution();
	}
}
