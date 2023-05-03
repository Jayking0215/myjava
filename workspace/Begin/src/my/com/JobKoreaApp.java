package my.com;

import java.util.*;
//기본적인 application의 기능: CRUD
/*
 * Create : 데이터 등록
 * Read : 데이터 조회
 * Update : 데이터 수정
 * Delete : 데이터 삭제
 * */
public class JobKoreaApp {
	Scanner sc=new Scanner(System.in);
	JobSeeker[] arr=new JobSeeker[3];//메모리 할당
	int count=0;
	Company[] arr2=new Company[3];
	int count2=0;
	
	public void menu() {
		System.out.println("---JobKoreaApp v1.1---");
		System.out.println("1. 구직자 등록");
		System.out.println("2. 회 사 등록");
		System.out.println("3. 구직자 정보 출력");
		System.out.println("4. 회 사 정보 출력");
		System.out.println("9. 종         료");
		System.out.println("----------------------");
		System.out.println("메뉴 번호를 선택하세요 =>");
		System.out.println("----------------------");
	}
	
	/* 구직자 정보를 입력받아 배열에 저장하는 메서드*/
	public void registerJobSeeker() {
		//3명 모두 등록시 마감처리
		if(count>=arr.length) {
			System.out.println("등록마감!! 현재 등록인원: "+count+"명");
		}
		//JobSeeker객체 생성하기
		JobSeeker js1=new JobSeeker();
		//input() 호출하기
		js1.input();
		String info=js1.introduce();
		System.out.println(info);
		System.out.println(">>위 정보를 등록할까요? [1. YES 2. NO]<<");
		//arr에 저장하기
		int no=sc.nextInt();
		if(no==1) {
			arr[count++]=js1;//배열에 저장
			System.out.println("등록 완료!!! 현재 등록 인원: "+count+"명");
		}else {
			System.out.println("등록을 취소하였습니다");
		}
	}//-------------------------
	
	/*등록된 모든 구직자 정보를 배열 arr에서 꺼내서 출력하는 메서드*/
	public void printJobSeeker() {
		for(int i=0; i<count; i++) {
			System.out.println(arr[i].introduce());
		}
	}
	
	/* 회사 정보를 입력받아 배열에 저장하는 메서드*/
	public void registerCompany() {
		Company cp1=new Company();
		cp1.input();
		String info=cp1.introduce();
		System.out.println(info);
		System.out.println(">>위 정보를 등록할까요? [1. YES 2. NO]<<");
		//arr에 저장하기
		int no=sc.nextInt();
		if(no==1) {
			this.arr2[count2]=cp1;
			count2++;
			System.out.println("등록 완료!!! 현재 등록 회사: "+count2+"개");
		}else {
			System.out.println("등록을 취소하였습니다");
		}
	}
	/*등록된 모든 회사 정보를 배열 arr2에서 꺼내서 출력하는 메서드*/
	public void printCompany() {
		for(int i=0; i<count2; i++) {
			System.out.println(arr2[i].introduce());
		}
	}
	
	public static void main(String[] args) {
		//반복문 돌리면서 menu보여주고 입력받기
		JobKoreaApp app=new JobKoreaApp();
		while(true) {
			app.menu();
			int num=app.sc.nextInt();
			if(num==9) {
				System.out.println("프로그램이 종료됩니다");
				break;
			}
			if(num<1||num>4) {
				System.out.println("메뉴에 없는 번호입니다 다시 입력하세요");
				continue;
			}
			switch(num) {
				case 1://구직자 등록
					app.registerJobSeeker();
					break;
				case 2://회사 등록
					app.registerCompany();
					break;
				case 3://등록한 모든 구직자 정보 출력
					app.printJobSeeker();
					break;
				case 4://모든 회사 정보 출력
					app.printCompany();
					break;
			}
		}//while-----
	}//main()-----

}//class-----
