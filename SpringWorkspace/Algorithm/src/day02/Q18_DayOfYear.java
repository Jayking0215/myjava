package day02;
import java.util.*;
public class Q18_DayOfYear {
	int [][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,29,31,30,31,30,31,31,30,31,30,31}
	};
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		int no=0;
		do {
			System.out.print("년도: ");
			int year=sc.nextInt();
			System.out.print("월 : ");
			int month=sc.nextInt();
			System.out.print("일: ");
			int day=sc.nextInt();
			
			int totalDays=getDayOfYear(year,month,day);
			
			System.out.printf("%d년 %d일째 입니다%n", year, totalDays);
			
			System.out.println("한번 더 하시겠습니까? [1. yes 2. no]");
			no=sc.nextInt();
		}while(no==1);
		System.out.println("Bye Bye~~");
		
	}//----------------------------
	/* 윤년 : 년도를 4로 나누어 떨어지면서 100으로는 나누어 떨어지면 안된다
	 * 	     다만 400으로 나누어 떨어지면 윤년
	 * 
	 * */
	public int getDayOfYear(int yy, int mm, int dd) {
		int total=0;
		int leap=(yy%4==0&& yy%100!=100 || yy%400==0)?1:0;
		for(int i=0;i<mm-1;i++) {
			total+=mdays[leap][i];
		}		
		total+=dd;
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q18_DayOfYear app=new Q18_DayOfYear();
		app.input();
	}

}
