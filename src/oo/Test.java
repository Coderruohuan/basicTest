package oo;

public class Test {

	public static void main(String[] args) {
		new MyClass("main");

	}

}

class MyClass {

	public MyClass(String str) {
		System.out.println("构造器代码块正在执行......" + str);
	}

	static {
		System.out.println("静态代码块开始执行......");
		new MyClass("静态代码块");
		System.out.println("静态代码块结束执行......");
	}
}
