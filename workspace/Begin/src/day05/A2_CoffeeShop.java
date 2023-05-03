package day05;

public class A2_CoffeeShop {
	public static void main(String[] args) {
		//자판기 생성
		A2_VendingMachine vm=new A2_VendingMachine();
		//[1]밀크커피 만들기
		vm.makeTea(1,2,3);
		//[2]설탕커피 만들기
		vm.makeTea(2,3);
		//[3]블랙커피 만들기
		System.out.println(vm.makeTea(2));
		//[4]크림커피 만들기
		vm.makeTea(1,(short)7);
		vm.makeTea((short)3,3);
		//[5]유자차 만들기
		A2_Yuja yj=new A2_Yuja();
		yj.setYuja(10);
		yj.setSugar(11);
		
		vm.makeTea(yj);
		
	}

}
