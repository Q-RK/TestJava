package testJunit;

public class Computer {
	private static int result;
	
	public static int getResult() {
		return result;
	}
	
	public void plus(int x, int y) {
		result =  x + y;
	}
	
	public void creatException() throws Exception{
		throw new Exception("catch me");
	}
	
	public void forEver() {
		for(;;);
	}
}
