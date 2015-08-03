package decorator;

public class ExtendConcreteComponentA extends ConcreteComponent{
	@Override
	public void doSomething() {
		System.out.println("A start ");
		super.doSomething();
	}
}
