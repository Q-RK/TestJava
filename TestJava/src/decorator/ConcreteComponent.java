package decorator;

public class ConcreteComponent implements Component {

	private String text;
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		if(text!=null){
			System.out.println(text);
		}
		else{
			System.out.println("nothing");
		}

	}
	@Override
	public void setText(String s) {
		// TODO Auto-generated method stub
		this.text = s;
	}

}
