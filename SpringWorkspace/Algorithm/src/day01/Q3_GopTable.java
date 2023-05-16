package day01;

public class Q3_GopTable {
	
	public static void solution() {
		System.out.print("    |  ");
		for (int a = 1; a <= 9; a++) {
			System.out.print(a + "   ");
		}
		System.out.println();
		System.out.println("----+---------------------------------------");

		 
		for (int i=1; i<=9; i++) { 
			System.out.print("  "+i+" |");
			for (int j=1; j<=9; j++) {
				System.out.print("  "+i*j+" ");
			} 
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		solution();
		
	}
	
	public static void printTable() {
		System.out.print("   |");
		for(int i=1; i<10; i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.println("---+---------------------------------");
		for(int i=1;i<10;i++) {
			System.out.printf("%2d |",i);
			for(int j=1;j<10;j++) {
				System.out.printf("%3d",(i*j));
			}
			System.out.println();
		}
	}//--------------------------------
	public static void printTable2() {
		for(int x=1;x<=9;x++) {
			System.out.println();
			if(x==1) {
				System.out.print("  |   1  2  3  4  5  6  7  8  9 \n");
				System.out.println("--+-----------------------------");
			}
			for(int y=1;y<=9;y++) {
				if(y==1) {
					System.out.print(x+" | ");
				}
				System.out.printf("%3d",x*y);
			}
		}
	}//--------------------------------


}
