package day05;

import java.util.Comparator;

/*이진 검색 트리는 이진 트리가 다음 조건을 만족하면 된다.
 * 1. 어떤 노드 N을 기준으로 왼쪽 서브 트리 노드의 모든 키 값은 
 * 노드 N의 키값 보다 작아야 한다.
 * 2. 오른쪽 서브트리 노드의 키 값은 노드 N의 키 값 보다 커야 한다
 * 3. 같은 키 값을 갖는 노드는 없다.
 * */
public class BinaryTree<K,V> {
	
	private Node<K,V> root;
	private Comparator<? super K> comparator;
	//BinaryTree<Integer,User>
	static class Node<K,V>{
		K key;
		V data;
		
		Node<K,V> left;
		Node<K,V> right;
		public Node(K key, V data, Node<K,V> left, Node<K,V> right) {
			this.key=key;
			this.data=data;
			this.left=left;
			this.right=right;
		}
		public void print() {
			System.out.println(data);
		}
		
	}//inner class/////////////////
	
	public BinaryTree() {
		root=null;
	}
	public BinaryTree(Comparator<? super K> comp) {
		this.comparator=comp;
	}
	//키값을 비교하는 메서드
	private int compare(K key1, K key2) {
		if(this.comparator!=null) {
			return this.comparator.compare(key1, key2);
		}else {
			//String,Integer클래스들은 Comparable인터페이스를 상속받고 있다.
			return ((Comparable<K>)key1).compareTo(key2);
		}
	}//-----------------------------
	//노드를 삽입하는 메서드
	 public void add(K key, V data) {
		 if(root==null) {
			 root=new Node(key, data,null, null);
		 }else {
			 addNode(root, key, data);
		 }
	 }//-------------------------
	private void addNode(Node<K, V> node, K key, V data) {
		int cond=compare(key, node.key);
		if(cond==0) {//key가 이진트리에 이미 있는 경우
			return;
		}else if(cond <0) {//새로 추가할 노드가 부모노드값 보다 작다면 왼쪽 방향 진행
			if(node.left==null) {
				node.left=new Node<K,V>(key, data, null, null);
			}else {//다시 탐색
				addNode(node.left, key, data);
			}
			
		}else {//오른 방향 진행
			if(node.right==null) {
				node.right=new Node<K,V>(key, data, null, null);
			}else {//다시 탐색
				addNode(node.right, key, data);
			}
		}		
	}//---------------------------
	//키값으로 이진검색트리에서 검색을 수행하는 메서드
	public V search(K key) {
		Node<K,V> p=root;
		while(true) {
			if(p==null) return null;//검색하지 못했을 경우
			int cond=this.compare(key, p.key);
			if(cond==0) {
				return p.data;//검색에 성공한 경우
			}else if(cond <0) {
				p=p.left;//왼쪽 서브트리에서 계속 검색
			}else {
				p=p.right;//오른쪽에서 계속 검색
			}
		}//while----
	}//-------------------------------------
	//key값에 해당하는 노드를 삭제하자
	public boolean remove(K key) {
		Node<K,V> p=root;//스캔 중인 노드
		Node<K,V> parent=null;//스캔 중인 노드의 부모 노드
		boolean isLeftChild=true;
		//삭제할 노드를 검색하자
		while(true) {
			if(p==null) return false;
			int cond=compare(key, p.key);
			if(cond==0) break;//삭제할 노드를 찾았다면 반복문 벗어나기
			else {
				parent=p;
				if(cond<0) {
					isLeftChild=true;
					p=p.left;
				}else {
					isLeftChild=false;
					p=p.right;
				}
			}
		}//while------------
		//삭제할 노드를 찾았다면
		if(p.left==null) {//검색한 p노드의 왼쪽에 자식이 없다면
			if(p==root) {
				root=p.right;
			}else if(isLeftChild) {//왼쪽방향
				parent.left=p.right;
			}else {//오른쪽 방향
				parent.right=p.right;
			}						
		}else if(p.right==null) {
			if(p==root) {
				root=p.left;
			}else if(isLeftChild) {
				parent.left=p.left;
			}else {
				parent.right=p.left;
			}
		}else {
			//삭제할 노드의 자식노드가 2개가 있을 경우==> 왼쪽 서브트리 중에서 가장 큰 노드를 찾는다
			parent=p;//5
			Node<K,V> left=p.left;
			isLeftChild=true;
			while(left.right!=null) {
			    parent=left;
			    left=left.right;
			    isLeftChild=false;
			}
			//왼쪽 방향 서브트리에서 찾은 큰 값을 삭제하려했던 노드에 복사
			p.key=left.key;//4
			p.data=left.data;
			if(isLeftChild) {
				parent.left=left.left;
			}else {
				parent.right=left.left;
			}
		}
		return true;
	}//-----------------------------
	
	
	public void print() {
		printSubTree(root);		
	}//--------------------
	//중위순회
	private void printSubTree(Node<K, V> node) {
		if(node!=null) {
			printSubTree(node.left);
			System.out.println(node.key+": "+node.data);
			printSubTree(node.right);
		}		
	}//---------------------------

}///////////////////////////////














