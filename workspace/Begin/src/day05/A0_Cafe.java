package day05;

public class A0_Cafe {

	public static void main(String[] args) {
		A0_CoffeeMachine cm=new A0_CoffeeMachine();//기본생성자
//		cm.coffee=2;
		cm.setCoffee(2);
//		cm.sugar=1;
		cm.setSugar(1);;
//		cm.cream=3;
		cm.setCream((short)3);
		System.out.println("cm.coffee: "+cm.getCoffee());//cm.coffee[x]
		System.out.println("cm.sugar: "+cm.getSugar());//cm.sugar[x]
		System.out.println("cm.cream: "+cm.getCream());//cm.cream[x]
		
	}

}
 