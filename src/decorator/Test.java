package decorator;

public class Test {
	public static void main(String[] args) {
		Component c = new ConcreteComponent();
		c.setText("wangjie");
		c = new ConcreteDecoratorA(new ConcreteDecoratorB(c));//适配器模式的源和目标因为没有统一的超类型（接口或抽象类）所以不能这样嵌套组合
		c.doSomething();
		ConcreteDecoratorA a = (ConcreteDecoratorA) c; //装饰者模式中具体装饰角色添加的方法向上是不可见的，必须要进行向下类型转换才能调用
		a.doA();
		
		AddDoA add = new Adapter(new ConcreteComponent());//适配器添加的方法是可见的或者说适配器模式就是为添加方法而生
		add.doA();
		
		Component e = new ExtendConcreteComponentA();//继承可以减少创建的对象和类文件，但只能通过创建更过的子类实现附加动作，而装饰者模式可以在兄弟装饰类之间自由组合
		e.setText("wangjie");
		e.doSomething();
	}
}
