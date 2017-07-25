package design.decorator;

public class Decorator implements Component {

	private Component c;
	Decorator(Component c){
		this.c = c;
	}
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		c.doSomething();

	}

	@Override
	public void setText(String s) {
		// TODO Auto-generated method stub
		c.setText(s);
	}

}
