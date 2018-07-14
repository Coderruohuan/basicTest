package thread;

public class ThreadTest {
	public static void main(String[] args) {
		ActionClass actionClass = new ActionClass();
		ThreadClass threadClass1 = new ThreadClass(actionClass);
		threadClass1.setName("A");
		threadClass1.start();
		ThreadClass threadClass2 = new ThreadClass(actionClass);
		threadClass2.setName("B");
		threadClass2.start();

	}

}
