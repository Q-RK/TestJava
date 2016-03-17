package test;

public class TestSomething {

	private static Object lock = new Object();
	
	class Test implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				synchronized (lock){
					System.out.println(Thread.currentThread().getName()+":1");
					lock.wait();
					System.out.println(Thread.currentThread().getName()+":2");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new Thread(new TestSomething().new Test()).start();
		new Thread(new TestSomething().new Test()).start();
		Thread.sleep(200);
		synchronized (lock) {
			lock.notifyAll();
		};
	}
	
}
