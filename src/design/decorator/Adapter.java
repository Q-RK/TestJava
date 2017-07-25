package design.decorator;
/**
 * 适配器模式
 * 源(Adapee)角色：ConcreteComponent
 * 目标(Target)角色：AddDoA
 * 适配器(Adaper)角色：Adapter
 * @author Administrator
 *
 */
public class Adapter implements AddDoA {

	private ConcreteComponent c;
	
	Adapter(ConcreteComponent c){
		this.c = c;
	}
	
	@Override
	public void setText(String s) {
		// TODO Auto-generated method stub
		c.setText(s);

	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		c.doSomething();

	}

	@Override
	public void doA() {
		// TODO Auto-generated method stub
		System.out.println("do A");

	}

}
