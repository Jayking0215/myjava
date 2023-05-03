package day08;

public class ExceptionTest1 {

	public static void main(String[] args) {
		String[] fruits= {"Apple","Grape","Orange"};
		//[1] Handle하는 방법: try~catch(개발자가 직접 수정)
		//[2] Declare하는 방법: throws(다른 매서드나 class로 넘겨서 처리하는 방법)
		try {
			for(int i=0; i<4; i++) {//런타임에러 발생시키기
				System.out.println(fruits[i]);
			}//for
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스가 초과되었어요!!! 확인해보세요");
		}//catch
		System.out.println("##반드시 실행되어야 하는 중요한 코드라고 가정##");
	}//main()

}//