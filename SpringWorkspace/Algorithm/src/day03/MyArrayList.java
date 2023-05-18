package day03;

public class MyArrayList<E> {
	
	private Object[] data;
	private int capacity;
	private int index;
	
	public MyArrayList() {
		this(5);
	}
	public MyArrayList(int capa) {
		this.capacity=capa;
		data=new Object[this.capacity];
		index=0;
	}
	//데이터 추가
	public void add(E obj) {
		if(index>=this.capacity-1) {
			//데이터가 꽉 찼다면 ==> 2배로 증가시키자
			doubling();
		}
		
		data[index++]=obj;
	}//-----------------
	
	private void doubling() {
		this.capacity=this.capacity*2;//2배로
		
		Object[] newData=new Object[this.capacity];
		//기존 배열에 저장된 데이터를 새로운 베열로 옮기자
		
		for(int i=0;i<data.length;i++) {
			newData[i]=data[i];
		}
		this.data=newData;
		//data에 새로운 배열의 주소값을 전달한다
		System.out.printf("index: %d, capacity: %d, size: %d%n", index, capacity, this.size());
	}//--------------------------

	public int size() {
		return index;
	}//--------------------------
	
	public E get(int i) {
		if(i<0) {
			throw new NumberFormatException("Negative Index Value Exception");
		}
		if(i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Object val=data[i];
		
		return (E)val;
	}//--------------------------
	
	//특정 인덱스의 데이터 삭제
	public void remove(int i) {
		if(i<0) {
			throw new NumberFormatException("Negative Index Value Exception");
		}
		if(i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int k=i;k<data.length-1;k++) {
			//뒤에 있는 요소를 앞으로 이동
			data[k]=data[k+1];			
		}
		index--;
	}
	

}//////////////////////////////















