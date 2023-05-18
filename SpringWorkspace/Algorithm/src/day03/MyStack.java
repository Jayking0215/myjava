package day03;

public class MyStack<T> {
	
	private Node<T> top=null;
	//inner class
	class Node<T>
	{
		private T data;
		private Node<T> next=null;
		
		public Node(T data) {
			this.data=data;
		}
		
	}////////////////
	
	public void push(T item) {
		Node<T> newNode=new Node<>(item);
		newNode.next=top;
		top=newNode;//top에 방금 들어온 item노드를 전달한다
	}
	public T peek() {
		if(top==null) {
			throw new RuntimeException("EmptyException");					
		}		
		return top.data;
	}
	public T pop() {
		if(top==null) {
			throw new RuntimeException("EmptyException");
		}
		T delData=top.data;//꼭대기 데이터<=삭제할 데이터
		
		top=top.next;//top.next는 이전에 push한 Node객체의 주소값을 가지고 있다. 이전 주소값으로 top을 변경
		return delData;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	

}///////////////////////////
















