package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOneByOne implements Runnable {

	private ReentrantLock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	private int state = 1;

	class Printer1 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				try {
					lock.lock();
					while (state != 1)
						try {
							c1.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(Thread.currentThread().getName());
					state = 2;
					c2.signal();
				} finally {
					lock.unlock();
				}
			}
		}
		
	}
	
	class Printer2 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				try {
					lock.lock();
					while (state != 2)
						try {
							c2.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(Thread.currentThread().getName());
					state = 3;
					c3.signal();
				} finally {
					lock.unlock();
				}
			}
		}
		
	}
	
	class Printer3 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				try {
					lock.lock();
					while (state != 3)
						try {
							c3.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(Thread.currentThread().getName());
					state = 1;
					c1.signal();
				} finally {
					lock.unlock();
				}
			}
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		new Thread(new Printer1(),"1").start();
		new Thread(new Printer2(),"2").start();
		new Thread(new Printer3(),"3").start();
	}

	public static void main(String[] args) {
		new Thread(new PrintOneByOne()).start();
	}
}
