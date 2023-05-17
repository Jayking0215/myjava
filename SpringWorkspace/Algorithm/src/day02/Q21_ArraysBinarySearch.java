package day02;
import java.util.*;
public class Q21_ArraysBinarySearch {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void floatBinarySearch() {
		float[]arr= {1.3f, 2.45f, 10,'A','z',30e-1f, 7.5f};
		Arrays.sort(arr);//정렬된 상태에서 사용해야 함
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println("검색할 실수값을 입력하세요");
		float key=sc.nextFloat();
		
		int idx=Arrays.binarySearch(arr, key);
		if(idx<0) {
			System.out.println(key+"값은 없습니다");
		}else {
			System.out.printf("검색하려는 %.2f값은 오름차순 정렬된 배열의 %d 인덱스에 있습니다  arr[%d]=%.2f%n",key,idx, idx, arr[idx]);
		}
		
	}//--------------------------------
	/*String클래스가 Comparable인터페이스(compareTo()메서드를 구현하고 있음)를 상속받아 구현하고 있기 때문에 정렬이된다. 
	 * => 정렬이 되면 이진검색 가능하다.
	 * */
	public static void StringBinarySearch() {
		String[] str= {
				"abstract",   "assert",       "boolean",   "break",      "byte",
	            "case",       "catch",        "char",      "class",      "const",
	            "continue",   "default",      "do",        "double",     "else",
	            "enum",       "extends",      "final",     "finally",    "float",
	            "for",        "goto",         "if",        "implements", "import",
	            "instanceof", "int",          "interface", "long",       "native",
	            "new",        "package",      "private",   "protected",  "public",
	            "return",     "short",        "static",    "strictfp",   "super",
	            "switch",     "synchronized", "this",      "throw",      "throws",
	            "transient",  "try",          "void",      "volatile",   "while"
		};
		
		System.out.println("검색할 Java키워드를 입력하세요: ");
		String key=sc.next();
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		
		
		int i=Arrays.binarySearch(str, key);
		System.out.println(key+"는 "+i+"번째 인덱스에 있어요");
		
	}//---------------------------------------
	
	public static void MemberBinarySearch() {
		Member m1=new Member("홍길동",22, 177);
		Member m2=new Member("홍길동",32, 177);
		Member m3=new Member("홍길동",22, 178);
		
		Member m4=new Member("김길동",27,156);
		Member m5=new Member("이길동",20,165);
		Member m6=new Member("김철수",37,186);
		
		Member[] users= {m1,m2,m3,m4,m5,m6};
		System.out.println("--나이 오름차순 정렬----------");
		Arrays.sort(users);
		System.out.println(Arrays.toString(users));
		
		System.out.println("검색할 회원의 나이 입력: ");
		int findAge=sc.nextInt();
		
		int idx=Arrays.binarySearch(users, new Member("",findAge,0));
		if(idx>=0) {
			System.out.println(findAge+"세의 회원은 배열 "+idx+" 번째에 있어요");
			System.out.println(users[idx]);
			
		}else {
			System.out.println(findAge+"세의 회원은 없어요");
		}
	}//---------------------------------------
	
	public static void EmpBinarySearch() {
		Emp e1=new Emp("Scott", 158);
		Emp e2=new Emp("James", 178);
		Emp e3=new Emp("Tom", 172);
		Emp e4=new Emp("King", 168);
		
		Emp emps[]= {e1, e2, e3, e4};
		System.out.println(Arrays.toString(emps));
		Arrays.sort(emps, Emp.Height_Order);
		System.out.println("---키 오름차순 정렬 후-------------------");
		System.out.println(Arrays.toString(emps));
		//키로 검색하세요
		System.out.println("검색할 사원의 키 입력: ");
		int findHeight=sc.nextInt();
		int idx=Arrays.binarySearch(emps, new Emp("",findHeight), Emp.Height_Order );
		if(idx<0) {
			System.out.println(findHeight+"cm 키의 사원은 없어요");
		}else {
			System.out.println(idx+"번째에 있습니다");
			System.out.println(emps[idx]);
		}
	}//---------------------------------------
	

	public static void main(String[] args) {
		//floatBinarySearch();
		//StringBinarySearch();
		//MemberBinarySearch();
		EmpBinarySearch();

	}

}
