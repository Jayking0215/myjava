package day10;
/*
 * Map계열
 * 	- Hashtable, HashMap
 * 	- key(Object유형)값과 value(Object유형)값을 맵핑하여 저장하는 자료구조(=인덱스가 없다)
 * 	- key값의 중복을 허용하지 않는다
 * 	- 순서가 없다
 * 	- 데이터가 75%차면 자동으로 저장영역을 확대한다.
 * 	- 데이터저장: Object put(Object key, Object value)
 * 				<Generic>put(K key, V value)
 * 	- 데이터 꺼내기: Object get(Object key) : key값에 맵핑된 value값을 반환한다.
 * */

import java.util.*;

public class A1_HashtableTest {

	public static void main(String[] args) {
		//jdk 1.4버전
		Hashtable h=new Hashtable(20,0.8f);//초기용량:20, 적재율(load factor):0.8//default=(11, 0.75)
		//데이터용량의 80%가 차면 자동으로 저장영역을 확대한다
		h.put("하나", Integer.valueOf(1));//데이터 저장...value가 int타입인 경우
		h.put("들", "Two");//value가 string인 경우
		h.put("빨강","Red");
		h.put("파랑", java.awt.Color.blue);//Object유형이면 모두 저장 가능
//		h.put("하나", "One");//key값 중복허용하지 않음. 덮어쓰기 함(권장x)
		
		Object obj=h.get("하나");//Object타입의 obj에 key값"하나"를 반환
		Integer ival=(Integer)obj;//형변환...기본이 Object타입이기 때문
		System.out.println("ival="+ival);
		
		String str=(String)h.get("빨강");//String으로 반환받으려면 형변환 필요
		System.out.println(str);
		
//		String str2=(String)h.get("파랑");//런타임 오류(형변환실패)
		java.awt.Color str2=(java.awt.Color)h.get("파랑");//import하지 않아서 직접 선언해줘야함
		System.out.println(str2);
		
		//jdk 5.0버전 - Generic....형변환 할 필요가 없다
		Hashtable<String, Integer> h2=new Hashtable<>();
		
		h2.put("생년",Integer.valueOf(2003));
		h2.put("나이", 20);//auto boxing(기본형으로 해도 integer형이 자동으로 들어감)
		h2.put("용돈", 100000);
//		h2.put("용돈", "100000");//value 타입에러
		
		Integer year=h2.get("생년");
		System.out.println("생년: "+year+"년");
		System.out.println("h2.size(): "+h2.size());
		
		//key값들만 추출하여 반환
		//Enumeration<K> 		keys() //순서는 x
		//set<K> 				keyset()
		//[1]h2에 저장된 key값들만 출력하기
		System.out.println("-----------Enumeration(K)------------------");
		Enumeration<String> en=h2.keys();
		while(en.hasMoreElements()) {
			String key=en.nextElement();
			System.out.println(key+": "+h2.get(key));//key값을 알면 value는 자동으로 따라온다
		}
		System.out.println("-----------keySet()------------------");
		
		Set<String> kset=h2.keySet();
		Iterator<String> it=kset.iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println(key);
		}
		
		//value값들만 추출하여 반환
		//Collection<V>			values()
		//Enumeration<V>		elements()
		//[2] h2에 저장된 value값들만 출력하기
		System.out.println("-----------Enumeration(V)------------------");
		Enumeration<Integer> en2=h2.elements();
		while(en2.hasMoreElements()) {
			Integer value=en2.nextElement();//value값을 받아올건데 en2의 nextElement()로 커서 옮겨서 반환
			System.out.println(value);
		}
		System.out.println("------------Collection-----------------");
		
		Collection<Integer> col=h2.values();
		Iterator<Integer> it2=col.iterator();
		for(;it2.hasNext();) {
			Integer val=it2.next();
			System.out.println(val);
		}
		
		//boolean		replace(K key, V oldValue, V newValue)
		h2.replace("용돈", 100000, 300000);//value변경
		
		System.out.println(h2.get("용돈"));
		//
		h2.remove("나이");//key 삭제
		System.out.println("---remove()---------");
		for(String key:h2.keySet()) {
			System.out.println(key+"=>"+h2.get(key));
		}
		//boolean containsKey(K)//key값이 있는가
		//boolean containsValue(V)//value값이 있는가
		System.out.println(h2.containsKey("나이"));//remove했음
		System.out.println(h2.containsKey("용돈"));
		
		System.out.println(h2.containsValue(100000));//value값 변경했음
		System.out.println(h2.containsValue(300000));
		
		h2.clear();//모두 삭제
		System.out.println("h2.size(): "+h2.size());//삭제 확인
		
		
	}

}
