package vo;

public class CountVO {
	private int number;  //

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number += number;  set은 number를 누적처리하고 있다.
	}	
}











package vo;

public class MyDataVO {
	private String name;
	private int number;
	private int age;
	private String address;
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
