package day02;

import java.util.Comparator;

//[2] Comparator 인터페이스를 상속받는 클래스를 static inner class로 만들자
public class Emp {
	
	public static final Comparator<Emp> Height_Order=new HeightComparator();
	
	private String name;//이름
	private int height;//키
	public Emp() {
		
	}
	public Emp(String n, int h) {
		name=n;
		height=h;
	}
	public String toString() {
		return name+" : "+height+"cm";
	}
	
	static class HeightComparator implements Comparator<Emp>{
		@Override
		public int compare(Emp e1, Emp e2) {
			if(e1.height==e2.height) {
				return 0;
			}else if(e1.height>e2.height) {
				return 1;
			}else {
				return -1;
			}
			//return e1.height-e2.height;//오름차순
			//return e2.height-e1.height;//내림차순
		}
	}

}////////////////////////////
