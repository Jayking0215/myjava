package day01;
import java.util.*;
public class Q10_LongWord {

	public String solution(String str) {
		String word="";
		
		String[] arr=str.split(" ");
		int max=arr[0].length();
		int i=0, index=0;
		for(String ar:arr) {
			if(ar.length()>max) {
				max=ar.length();
				index=i;
			}
			i++;
		}
		word=arr[index];
		return word;
	}
	
	public static void main(String[] args) {
		Q10_LongWord app=new Q10_LongWord();
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String word=app.solution(str);
		System.out.println("가장 긴 단어: "+word);
	}

	//int indexOf("검색문자열") : 검색한 문자열의 인덱스 번호를 반환한다. 검색한 문자열이 없다면 -1을 반환한다
		//String substring(int start, int end): start인덱스에서 시작해서 end-1까지 오려내서 반환
		//String substring(int start): start에서 끝까지 오려내서 반환
}
