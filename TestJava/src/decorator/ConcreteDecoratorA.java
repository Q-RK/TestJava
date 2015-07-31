package decorator;

public class ConcreteDecoratorA extends Decorator {

	ConcreteDecoratorA(Component c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("A start ");
		super.doSomething();

	}
	
	public void doA(){
		System.out.println("do A");
	}

}
