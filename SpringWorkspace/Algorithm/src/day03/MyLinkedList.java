package day03;

import java.util.Comparator;

public class MyLinkedList<T> {
	Node<T> head= null; //머리 포인터. 처음에는 null(비어있는 상태) => 머리노드를 가리킬 예정
	Node<T> currentN=null;//선택 노드를 참조
	
	
	static class Node<T>{
		T data;//데이터
		Node<T> next;//뒤쪽을 가리킬 포인터
		
		public Node(T data, Node<T> next) {
			this.data=data;
			this.next=next;
		}
		
	}//////////////////
	
	//새로운 노드를 맨뒤에 덧붙이기하는 메서드
	public void addLast(T newData) {
		if(head==null) {//비어있는 노드라면
			addFirst(newData);
		}else {
			Node<T> endNode=new Node<>(newData, null);//끝에 붙을 노드
			Node<T> ptr=head;//탐색할 포인터 노드
			while(ptr.next!=null) {//뒤에 노드들이 있다면
				//포인터를 계속 이동
				ptr=ptr.next;
			}
			//마지막까지 갔다면..
			ptr.next=currentN=endNode;
		}
	}//-----------------------------
	
	//노드를 맨앞에 삽입하는 메서드
	public void addFirst(T newData) {
		Node<T> ptr=head;
		Node<T> newNode=new Node<>(newData,ptr);//head가 가리키는 노드의 주소값(ptr이 참조)을 next에 전달한다
		head=currentN=newNode;
		
	}//---------------------------------
	
	//머리 노드를 삭제하는 메서드
	public void removeFirst() {
		if(head!=null) {
			head =currentN=head.next;//두번째 노드를 머리노드로 만든다
		}
	}//--------------------------------
	//특정 노드를 삭제하는 메서드
	public void remove(T p) {
		if(head!=null) {
			if(p==head) {//삭제할 노드가 머리노드라면
				removeFirst();
			}else {
				Node<T> ptr=head;
				while(ptr.next.data!=p) {
					ptr=ptr.next;//다음 노드로 이동
					if(ptr==null) {
						//끝까지 같는데 못찾았다면
						return;
					}
				}//while---------
				ptr.next=ptr.next.next;
				//삭제할 노드를 찾았다면 그 다음 주소값을 포인트노드의 next주소로 전달한다
				currentN=ptr;
			}
			
		}//if-----------
	}//--------------------------------
	
	public void remove(Node<T> p) {
		if(head!=null) {
			if(p==head) {//삭제할 노드가 머리노드라면
				removeFirst();
			}else {
				Node<T> ptr=head;
				while(ptr.next!=p) {
					ptr=ptr.next;//다음 노드로 이동
					if(ptr==null) {
						//끝까지 같는데 못찾았다면
						return;
					}
				}//while---------
				ptr.next=p.next;
				//삭제할 노드를 찾았다면 그 다음 주소값을 포인트노드의 next주소로 전달한다
				currentN=ptr;
			}
			
		}//if-----------
	}//--------------------------------
	//꼬리 노드를 삭제하는 메서드
	public void removeLast() {
		if(head!=null) {
			if(head.next==null) {//노드가 하나만 있다면 => 머리노드 삭제
				removeFirst();				
			}else {
				Node<T> ptr=head;
				while(ptr.next.next!=null) {
					//마지막노드를 찾을 때까지 포인터 이동
					ptr=ptr.next;
				}
				ptr.next=null;
				currentN=ptr;
			}
		}//if--------		
	}//--------------------------------
	
	//선택노드를 삭제하는 메서드
	public void removeCurrentNode() {
		remove(currentN);
	}//---------------------------------
	//전체노드를 삭제하는 메서드
	public void clear() {
		while(head!=null) {
			removeFirst();
		}
		currentN=null;
	}//--------------------------------
	//선택노드를 하나 뒤로 이동시키는 메서드
	public boolean next() {
		if(currentN==null||currentN.next==null) {
			return false;
		}
		currentN=currentN.next;
		return true;
	}//--------------------------------
	
	public void printCurrentNode() {
		System.out.println("-----------------");
		if(currentN==null) {
			System.out.println("선택한 노드가 없습니다");
		}else {
			System.out.println("선택한 노드=>"+currentN.data);
		}
	}//-----------------------------------
	
	public void print() {
		System.out.println("****************");
		Node<T> ptr=head;
		while(ptr!=null && ptr.next!=null) {
			System.out.print(ptr.data+"->");//참조하는 데이터 출력
			ptr=ptr.next;//포인터 이동
		}
		if(ptr!=null) {
			System.out.println(ptr.data);
		}
	}//-----------------------------------
	
	//특정 노드를 검색하는 메서드
	public T search(T obj, Comparator<? super T> cobj) {
		Node<T> ptr=head;
		while(ptr!=null) {
			if(cobj.compare(obj, ptr.data)==0) {//검색에 성공했다면
				currentN=ptr;
				return ptr.data;
			}//if---
			ptr=ptr.next;//다음으로 이동			
		}//while-----
		return null;
	}//-----------------------------------
	
}///////////////////////////////////


























