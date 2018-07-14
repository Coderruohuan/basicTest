package oo;

//枚举实现接口
public enum EnumClass implements EnumInterface {
	// 这些都是实例，所以需要相应的构造器
	Spring(0, "春天"), Summer(1, "夏天"), Fall(2, "秋天"), Winter(3, "冬天");
	// 构造器只能private

	EnumClass(int code, String name) {
		this.code = code;
		this.name = name;
	}

	// 实例变量
	private int code;
	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// 返回该枚举实例在枚举类定义的索引，从0开始
		System.out.println(EnumClass.Fall.ordinal());
		System.out.println(EnumClass.Spring.toString() + "  " + EnumClass.Spring.name());// 返回枚举实例名
		System.out.println(EnumClass.Spring.compareTo(EnumClass.Winter));// spring比winter位置在前（负数）还是在后（正数），同一个返回0

		// 获取所有的枚举实例
		for (EnumClass enumClass : EnumClass.values()) {
			System.out.println(enumClass);
		}
		System.out.println(EnumClass.Spring.name);
	}

	@Override
	public void print() {
		System.out.println("枚举实现接口类");
	}

}
