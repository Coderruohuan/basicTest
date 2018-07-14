package reflect;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<Car> class1 = Car.class;
		Class<?> class2 = Class.forName("reflect.Car");
		Car car = new Car();
		Class<? extends Car> class3 = car.getClass();
		System.out.println("class1:" + class1 + ";  class2:" + class2 + ";   class3:" + class3);

	}

}
