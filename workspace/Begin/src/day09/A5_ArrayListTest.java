package day09;

import java.util.*;
/*ArrayList
 *  - java.util.List계열
 *  - Vector와 기능은 동일
 *  - Vector는 메서드들이 동기화가 구현되어 있는 반면,//순차적으로 동시에 들어오는 경우 없음..대기해야함==ex)채팅
 *    ArrayList는 동기화되어 있지 않음 => 가볍다 =>웹에서 주로 사용
 * 
 * */
public class A5_ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> arrList=new ArrayList<>();
		System.out.println(arrList.size());
		arrList.add("Java");
		arrList.add("HTML");
		arrList.add("CSS");
		System.out.println(arrList.size()+"개 저장");
		
		//iterator()메서드 이용해서 한꺼번에 출력
		String str=arrList.get(0);//or elementAt(int i)
		Iterator <String> it=arrList.iterator();
		while(it.hasNext()) {
			String s=it.next();
//			System.out.println(s.toLowerCase());
			System.out.println(s);
		}
		//sort
		Collections.sort(arrList);
		System.out.println("-------sort이후---------------");
		for(String s:arrList) {
			System.out.println(s);
		}
		
		//List<T> Arrays.asList(T...)
		List <A4_Person> arrList2 = Arrays.asList(new A4_Person("김하니",22), new A4_Person("최히나",23), new A4_Person("기라두",34));
		System.out.println("arrList2.size(): "+arrList2.size());
		for(Iterator<A4_Person> it2=arrList2.iterator(); it2.hasNext();) {
			A4_Person p=it2.next();
			System.out.println(p.getName()+"@"+p.getAge());
		}
	}

}
