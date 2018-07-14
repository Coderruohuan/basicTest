package threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Executors.newFixedThreadPool(0);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 2000, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(3));
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			System.out.println("线程池要执行的任务数" + executor.getTaskCount());

			executor.execute(new ThreadPoolClass(i));
		}
	}
}

class ThreadPoolClass implements Runnable {

	private int i;

	public ThreadPoolClass(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		if (i < 5) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("线程" + i + "正在执行.....");

	}

}