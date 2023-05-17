package day02;
/*#  큐와 스택
1. 큐 - Queue : Fisrt In First Out 구조
    ex) 택시 줄서기 : 가장 먼저 줄 선 사람이 먼저 택시를 탄다.
    - 큐에서 데이터를 한 개 집어넣는 동작을 인큐(enqueue),
      큐 안에 있는 데이터를 한 개 꺼내는 동작을 디큐(dequeue)라고 표현한다.
2. 스택- Stack : Last In First Out
    ex) 접시 쌓기 :  접시를 쌓아 올리면, 꺼낼 때 가장 마지막 접시부터 꺼내게 됨
    - 스택에 데이터 하나 넣는 동작을 push,
      스택에 있는 데이터를 하나 꺼내는 동작을 pop라고 표현한다.
 * */

public class IntStack {
	
	private int capacity;//용량
	private int ptr;//배열의 인덱스로 사용되는 포인터. push()할때는 ptr이 증가, pop()할때는 감소
	private int[] stk;//정수값을 저장할 배열
	
	public IntStack(int capa) {
		this.capacity=capa;
		ptr=0;
		stk=new int[this.capacity];
	}
	
	/**데이터를 삽입. 스택(배열)이 가득차서 추가할 수 없을때 예외 발생*/
	public int push(int val) throws Exception{
		if(ptr>=capacity) throw new Exception("OverflowException");
		return stk[ptr++]=val;
	}
	
	/** 데이터 꺼내기: 스택에서 꼭대기에 있는 데이터를 꺼내 반환. 포인터는 감소 시킴*/
	public int pop() throws Exception{
		if(ptr<=0) {
			throw new Exception("EmptyException");
		}
		return stk[--ptr];
	}
	
	//peek(): 스택에서 꼭대기(top)에 있는 데이터를 반환
	public int peek() {
		if(ptr<=0) {
			throw new RuntimeException("EmptyException");
		}
		
		return stk[ptr-1];
	}
	
	/** 스택에 저장되어 있는 데이터수를 반환하는 메서드*/
	public int size() {
		return ptr;
	}
	/**스택의 모든 데이터를 비우는 메서드*/
	public void clear() {
		ptr=0;
	}
	/** 스택이 비었는지 여부 반환*/
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	/** 스택이 가득 찼는지 여부 반환*/
	public boolean isFull() {
		return ptr>=capacity;
	}
	//스택 위=> 아래 방향의 데이터를 출력
	public void printStack() {
		for(int i=ptr-1;i>=0;i--) {
			System.out.println(stk[i]);
		}
	}
	
	//스택에서 특정 데이터를 검색해서 있으면 해당 데이터의 인덱스 번호를 반환, 없으면 -1을 반환
	//스택 위=> 아래 방향 순으로 데이터를 검색
	public int indexOf(int val) {
		for(int i=ptr-1;i>=0;i--) {
			if(stk[i]==val)
				return i;
		}//for----
		return -1;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	
}







