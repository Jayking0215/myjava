package day03;
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
public class MyQueue {
	private Object[] que;//배열 => 큐
	private int capacity;//큐의 크기
	private int front;//맨앞 요소 커서
	private int end;//맨뒤 요소 커서
	private int cnt;//현재 데이터 수
	
	public MyQueue(int capa) {
		this.capacity=capa;
		front=0;
		end=0;
		cnt=0;
		que=new Object[this.capacity];
	}
	
	//인큐: 데이터가 맨 뒤서부터 들어간다 FIFO
	public Object enque(Object val) {
		if(cnt>=this.capacity) {
			throw new OverflowException();
		}
		que[end++]=val;
		cnt++;
		if(end>=this.capacity) {
			end=0;
		}
		return val;
	}//------------------------------
	
	//front 데이터를 바라보는 메서드
	public Object peek() {
		if(cnt<=0) {
			throw new EmptyException();
		}
		return que[front];
	}//------------------------------
	//디큐: 데이터가 맨 앞에서부터 나와야 한다 FIFO구조
	public Object deque() {
		if(cnt<=0) throw new EmptyException();
		Object val=que[front++];
		cnt--;
		if(front>=this.capacity) {
			front=0;
		}
		return val;
	}//------------------------------
	
	public int size() {
		return cnt;
	}
	
	public boolean isEmpty() {
		return cnt  <=0;
	}
	public boolean isFull() {
		return cnt>=this.capacity;
	}
	public void clear() {
		cnt=0;
		front=0;
		end=0;
	}
	//큐 내용을 출력하는 메서드
	public void printQueue() {
		for(int i=0;i<cnt;i++) {
			System.out.println(que[(i+front)%capacity]);
		}
	}//-------------------
	//큐에서 검색하는 메서드
	public int indexOf(Object val) {
		for(int i=0;i<cnt;i++) {
			int idx=(i+front)%capacity;
			if(que[idx].equals(val)) {
				return i;
			}
		}//for-----
		return -1;
	}
	

}//////////////////////////////////

















