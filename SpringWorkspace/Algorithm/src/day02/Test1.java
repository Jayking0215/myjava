package day02;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("좌표 개수를 입력");
		int n = sc.nextInt();

		int arr[][] = new int[n][2];
		
		System.out.println("좌표 입력");
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<2; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a1, int[] a2) {
				if (a1[0]==a2[0])
					return Integer.compare(a1[1], a2[1]);
				return Integer.compare(a1[0], a2[0]);
			}
		});
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}
}
