package design.decorator;

public class ConcreteDecoratorB extends Decorator {

	ConcreteDecoratorB(Component c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("B start ");
		super.doSomething();

	}
}
