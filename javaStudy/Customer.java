import java.io.*;
import java.util.Vector;
class Customer implements Serializable {
	private String name;
	private int age;
	private String tel;

	public Customer(String name, int age, String tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public static void main(String[] args) {
		
	}
}
