package day01;
import java.util.*;
public class Q10_LongWord {
	
	public String solution2(String str) {
		String word="";//문자열중 제일 긴 단어 반환
		
		String[] tokens=str.split(" ");
		System.out.println(Arrays.toString(tokens));
		int max=tokens[0].length();
		int i=0, index=0;
		for(String tk: tokens) {
			if(tk.length()>max) {
				max=tk.length();
				index=i;
			}
			i++;
		}
		word=tokens[index];
		return word;
	}//--------------------------------
	
	//int indexOf("검색문자열") : 검색한 문자열의 인덱스 번호를 반환한다. 검색한 문자열이 없다면 -1을 반환한다
	//String substring(int start, int end): start인덱스에서 시작해서 end-1까지 오려내서 반환
	//String substring(int start): start에서 끝까지 오려내서 반환
	//Never mind I am Fine
	public String solution(String str) {
		System.out.println(str);
		String word="";
		int pos=0;
		int max=-9999;
		while((pos=str.indexOf(" "))!=-1) {
			String wd=str.substring(0,pos);//Never
			if(wd.length()>max) {
				max=wd.length();
				word=wd;
			}
			str=str.substring(pos+1);
			System.out.println(str);
		}
		
		if(str.length()>max) {
			max=str.length();
			word=str;
		}
		return word;
	}
	
	

	public static void main(String[] args) {
		Q10_LongWord app=new Q10_LongWord();
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String word=app.solution(str);
		System.out.println("가장 긴 단어: "+word);

	}

}
