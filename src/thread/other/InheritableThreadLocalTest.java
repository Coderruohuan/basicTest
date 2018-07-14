package thread.other;

public class InheritableThreadLocalTest {
	public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
	public static InheritableThreadLocal<Object> inheritableThreadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) throws InterruptedException {
		ThreadC threadc = new ThreadC();
		threadc.start();
	}
}

class ThreadC extends Thread {
	@Override
	public void run() {
		InheritableThreadLocalTest.threadLocal.set("线程C设置了threadLocal");
		InheritableThreadLocalTest.inheritableThreadLocal.set("线程C设置inheritableThreadLocal");
		ThreadD threadD = new ThreadD();
		threadD.start();
		System.out.println("线程C执行完毕");

	}

}

class ThreadD extends Thread {
	@Override
	public void run() {
		System.out.println("线程D开始执行");
		System.out.println(InheritableThreadLocalTest.threadLocal.get());
		System.out.println(InheritableThreadLocalTest.inheritableThreadLocal.get());
	}
}
