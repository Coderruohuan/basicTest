package collection;

public class MyObject implements Comparable<MyObject> {

	private String name;
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(MyObject o) {
		if (this.getName().compareTo(o.getName()) > 0) {
			return 1;
		} else if (this.getName().compareTo(o.getName()) < 0) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		else
			return true;
	}

}
