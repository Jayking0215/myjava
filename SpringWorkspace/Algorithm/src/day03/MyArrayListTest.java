package day03;

import day02.Emp;

public class MyArrayListTest {

	public static void main(String[] args) {
		//MyArrayList생성해서
		//Integer유형 객체 저장한 후 반복문 이용해서 출력하기
		MyArrayList<Integer> arr=new MyArrayList<>();//초기 용량: 5
		arr.add(Integer.valueOf(10));
		arr.add(20);//auto boxing
		arr.add(30);
		arr.add(40);
		System.out.println("arr.size(): "+arr.size());
		arr.add(50);
		arr.add(60);
		System.out.println("arr.size(): "+arr.size());
		
		for(int i=0;i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		arr.remove(2);
		System.out.println("---인덱스2번 객체 삭제후-----");
		for(int i=0;i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		
		MyArrayList<Emp> arr2=new MyArrayList<Emp>();
		
		Emp e1=new Emp("Scott",158);
		Emp e2=new Emp("Ward",169);
		arr2.add(e1);
		arr2.add(e2);
		
		Emp tmp=arr2.get(0);
		System.out.println(tmp);
		
		
		
	}

}
