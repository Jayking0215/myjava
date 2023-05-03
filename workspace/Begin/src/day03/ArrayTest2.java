package day03;

public class ArrayTest2 {
	public static void main(String[] args) {
		int x[]= {1, 2, 3, 4};//stack에 x올라가고 {}배열은 Heap에 올라감
		int [] y;
		
		y=x;//x가 참조하는 배열을 y도 같이 참조하는 형태
		//stack의 y도 x가 가리키는 Heap을 가리키게 된다
		
		//확장 for로 y출력(자료구조는 다 가능)
		for(int a:y) {
			System.out.println("a: "+a);
		}
		y[2]=300;//y 객체 변경
		
		System.out.println("y[2]: "+y[2]);
		System.out.println("x[2]: "+x[2]);//같은 Heap을 가리키기 때문에 x의 객체도 변경되어 출력됨
		
		System.out.println("---------------------Practice!!!!---------------------");
		//[1] m과 n의 배열을 서로 바꿔서 참조
		int [] m= {10,20};
		int n[]= {3, 4, 5, 6};

		int tmp[];
		tmp=m;
		m=n;
		n=tmp;
		
		for(int i=0; i<m.length; i++) {
			System.out.printf("m[%d]=%d%n",i,m[i]);
		}
		for(int i=0; i<n.length; i++) {
			System.out.printf("n[%d]=%d%n",i,n[i]);
		}
		
		
		
		
		
		
	}

}
