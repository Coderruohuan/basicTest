package thread.other;

public class ThreadLocalTest {

	public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
	public static ThreadLocalExt object = new ThreadLocalExt();

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1(threadLocal, object);
		Thread2 thread2 = new Thread2(threadLocal, object);
		thread1.start();
		thread2.start();
	}

}

class Thread1 extends Thread {
	private ThreadLocalExt object;
	private ThreadLocal<Object> threadLocal;

	public Thread1(ThreadLocal<Object> threadLocal, ThreadLocalExt object) {
		this.threadLocal = threadLocal;
		this.object = object;
	}

	@Override
	public void run() {
		System.out.println(object.get());
		object.set("Thread1 设置了");
		System.out.println(object.get());
		if (threadLocal.get() == null) {
			threadLocal.set("threadLocal 被Thread1设置了");
		}
		System.out.println(threadLocal.get());
	}

}

class Thread2 extends Thread {
	private ThreadLocalExt object;
	private ThreadLocal<Object> threadLocal;

	public Thread2(ThreadLocal<Object> threadLocal, ThreadLocalExt object) {
		this.threadLocal = threadLocal;
		this.object = object;
	}

	@Override
	public void run() {
		System.out.println(object.get());
		object.set("Thread2 设置了");
		System.out.println(object.get());
		if (threadLocal.get() == null) {
			threadLocal.set("threadLocal 被Thread2设置了");
		}
		System.out.println(threadLocal.get());
	}

}

class ThreadLocalExt extends ThreadLocal<Object> {

	@Override
	public Object initialValue() {
		return "设定了初始值";
	}
}

class ThreadLocal1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
