package oo;

public class FinalTest {
	public enum Status {
		// 第一排一定要写常量
		add("+") {
			@Override
			public int operate(int a, int b) {
				return a + b;
			}
		},
		subtract("-") {
			@Override
			public int operate(int a, int b) {
				// TODO Auto-generated method stub
				return a - b;
			}
		},
		mutiply("*") {
			@Override
			public int operate(int a, int b) {
				this.print();
				return a * b;
			}

			public void print() {
				System.out.println("这是乘法...");
			}

		};
		@SuppressWarnings("unused")
		private String a;

		Status(String a) {
			this.a = a;
		}

		public abstract int operate(int a, int b);
	}

	public static void main(String args[]) {
		System.out.println(Status.add.operate(1, 2));
		System.out.println(Status.mutiply.operate(2, 3));
	}
}
