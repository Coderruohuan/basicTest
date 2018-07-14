package basic;

import java.util.Date;

public class BasicTest {

	public static void main(String[] args) {
		System.out.println(new Date().after(null));
		// System.out.println(new Date().after(null));
	}

	@SuppressWarnings("finally")
	public int print() {

		try {
			return function1();
		} catch (Exception e) {
		} finally {
			return function2();
		}

	}

	public int function1() {
		System.out.println("try  输出");
		return 1;
	}

	public int function2() {
		System.out.println("finally  输出");
		return 2;
	}
}
