package oo;

public class AnonymousTest {

	private String a = "weqwe";

	public void print(AnonymousInner inner) {
		inner.test();
	}

	public static void main(String[] args) {

		int f = 10;
		// 实现了inner接口
		AnonymousInner inner = new AnonymousInner() {
			@Override
			public void test() {
				System.out.println("匿名内部类实现接口......接口中的变量i：" + i + " ");
			}
		};
		new AnonymousTest().print(inner);
		AnonymousAbstract abstractClass = new AnonymousAbstract() {
			@Override
			public void print() {
				System.out.println("匿名内部类实现抽象类");
				this.print2();
			}
		};

		abstractClass.print();
		f = 30;
	}

}
