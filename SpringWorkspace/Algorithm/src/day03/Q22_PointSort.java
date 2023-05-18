package day03;
import java.util.*;
class Point implements Comparable<Point>{
	
	int x, y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int compareTo(Point obj) {
		if(this.x==obj.x) {//x좌표가 같다면
			return obj.y-this.y;//y좌표 내림차순
			
		}else {
			//return this.x-obj.x;//오름차순
			return obj.x -this.x;//x좌표 내림차순
		}
	}
	
	public String toString() {
		return "["+x+", "+y+"]";
	}
	
}///////////////////

public class Q22_PointSort {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 좌표를 입력하겠습니까?");
		int n=sc.nextInt();
		System.out.println("x,y좌표를 입력하세요");

		Point[] arr=new Point[n];
		
		for(int i=0;i<n;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			arr[i]=new Point(x,y);
		}
		
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		

	}

}////////////////////////////////




