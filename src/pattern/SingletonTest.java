package pattern;

public class SingletonTest {

	public static void main(String[] args) {
		SingletonClass singletonClass1 = SingletonClass.getInstance();
		SingletonClass singletonClass2 = SingletonClass.getInstance();
		if (singletonClass1 == singletonClass2) {
			System.out.println("两个对象 一样");
		} else {
			System.out.println("两个对象 不一样");
		}

		SingletonClass1 singletonClass3 = SingletonClass1.getInstance();
		SingletonClass1 singletonClass4 = SingletonClass1.getInstance();
		if (singletonClass3 == singletonClass4) {
			System.out.println("两个对象 一样");
		} else {
			System.out.println("两个对象 不一样");
		}
	}

}

/**
 * 饿汉模式
 * 
 * @author wwn
 *
 */
class SingletonClass {
	private static SingletonClass singleton = new SingletonClass();

	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		return singleton;
	}
}

/**
 * 懒汉模式
 * <li>使用时才创建对象
 * 
 * @author wwn
 *
 */
class SingletonClass1 {

	private static SingletonClass1 singleton;

	private SingletonClass1() {
	}

	public synchronized static SingletonClass1 getInstance() {
		if (singleton == null) {
			singleton = new SingletonClass1();
		}
		return singleton;
	}
}

/**
 * 静态内部类实现 使用时加载
 * 
 * @author Administrator
 *
 */
class SingletonClass2 {

	private SingletonClass2() {
	}

	private static class SingletonClassInstance {
		private static final SingletonClass2 singletonClass = new SingletonClass2();
	}

	public static SingletonClass2 getInstall() {
		return SingletonClassInstance.singletonClass;
	}
}