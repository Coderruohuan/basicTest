package oo;

public class OutClass {
	public OutClass() {

	}

	public OutClass(String a) {
		System.out.println(a);
	}

	int i = 1;
	static int a = 2;

	class InnerClass {
		public int i = 2;

		public void print() {
			int i = 3;
			System.out.println(
					"局部变量：" + i + " 内部类成员变量：" + this.i + " 外部类成员变量：" + new OutClass().i + " 外部类类变量：" + OutClass.a);
		}
	}

	public void test() {
		System.out.println(new InnerClass().i);
	}

	public static void main(String[] args) {
		// 因为innerClass 是静态的，所以不用new
		// new InnerClass().print();
		new OutClass().new InnerClass().print();
	}

}
