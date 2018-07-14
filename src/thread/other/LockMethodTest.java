package thread.other;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 某些方法的测试
 * 
 * @author Administrator
 *
 */
public class LockMethodTest {

	public static void main(String[] args) {
		Service service = new Service();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				service.test();
			}
		});
		thread.start();
		thread.interrupt();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				service.unLock();
			}
		}).start();
	}

}

class Service {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void test() {

		lock.lock();
		System.out.println("wait begain");
		try {
			// condition.awaitUninterruptibly();// 释放lock
			try {
				Date date = new Date(new Date().getTime() + 4000);
				condition.awaitUntil(date);
				System.out.println("wait end");
			} catch (InterruptedException e) {
				System.out.println("是否早执行了。。。。。");
				e.printStackTrace();

			}

		} finally {
			lock.unlock();
		}
	}

	public void unLock() {
		System.out.println("执行了吗.....");
		lock.lock();
		condition.signal();// 这个必须在lock里
		lock.unlock();
	}
}
