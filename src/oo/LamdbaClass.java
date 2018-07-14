package oo;

public class LamdbaClass {

	public static void main(String[] args) {
		/* --------------method1----------- */
		LamdbaInterface lamdba = (a) -> new OutClass(a);
		lamdba.calculate("test");
		/* --------------method2----------- */
		LamdbaInterface lamdba1 = OutClass::new;// 格式是 类名：：new
		lamdba1.calculate("test2");
	}

}
