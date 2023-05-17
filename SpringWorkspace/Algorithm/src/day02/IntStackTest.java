package day02;

public class IntStackTest {
	
	public static void test1() {
		IntStack sk=new IntStack(5);
		try {
			sk.push(10);
			sk.push(20);
			sk.push(30);
			System.out.println(sk.peek());
			sk.push(40);
			sk.push(50);
			//sk.push(60);
			System.out.println("------------");
			sk.printStack();
			System.out.println("------------");
			sk.pop();
			System.out.println(sk.peek());
			System.out.println("size: "+sk.size());
			System.out.println("capacity: "+sk.getCapacity());
			sk.clear();//모두 지우기
			System.out.println("clear이후()----------");
			System.out.println("size: "+sk.size());
			System.out.println("isEmpty: "+sk.isEmpty());
			System.out.println("isFull: "+sk.isFull());
			
			for(int i=1;i<6;i++)
				sk.push(i*100);
			System.out.println("--다시 push후--------");
			System.out.println("size: "+sk.size());
			System.out.println("isEmpty: "+sk.isEmpty());
			System.out.println("isFull: "+sk.isFull());
			
			System.out.println(sk.indexOf(200));
			System.out.println(sk.indexOf(205));
		
			sk.pop();
			sk.pop();
			sk.printStack();
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		test1();

	}

}
