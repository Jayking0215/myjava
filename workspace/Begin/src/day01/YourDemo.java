package day01;
import java.util.*;

public class YourDemo {
	public static void main(String[] args){
		System.out.println("------YourDemo------");
		Date d=new Date();
		System.out.println(d);
		UUID uid=UUID.randomUUID();
		System.out.println(uid);

		// System.out.pringf("출력서식", 출력할 내용);
		//출력 서식 %지시자
		/* %d : 정수형식으로 출력
		 * %f : 소수점 형식으로 출력
		 * %s : 문자열 형식으로 출력
		 * %b : boolean형식으로 출력
		 * %n : 줄바꿈
		 * */

		System.out.printf("제 이름은 %s이고, 제 나이는 %d세 입니다.%n", "James", 22);
		System.out.printf("제 평균성적은 %f 입니다.%n", 95.33333);

		double avg = 95.55555;
		double avg2 = Math.round(avg*100)/100.0;
		System.out.println(avg2);

		System.out.printf("평균성적: %.2f %n" ,95.55555);

		System.out.printf("%d%n" ,1);
		System.out.printf("%5d%n" ,1);
		System.out.printf("%5d%n" ,10); //오른쪽 정렬
		System.out.printf("%-5d%n" ,100); //왼쪽 정렬

		System.out.printf("%05d%n",100);
	}
}
