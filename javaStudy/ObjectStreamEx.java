//객체 단위 입출력 + 객체 직렬화

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
	public String getName () {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getTel() {
		return tel;
	}
}

class ObjectStreamEx {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try { /*
			fos = new FileOutputStream("result.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Customer("홍길동", 30, "1111-2222"));
			oos.writeObject(new Customer("이순신", 40, "2222-2222"));
			fis = new FileInputStream("result.ser");
			ois = new ObjectInputStream(fis);
			Customer cus1 = (Customer) ois.readObject();
			Customer cus2 = (Customer) ois.readObject();
			System.out.println("이름 : " + cus1.getName() + "\n" + "나이 : " + cus1.getAge() + "\n" + "전화번호 : " + cus1.getTel());
			System.out.println("이름 : " + cus2.getName() + "\n" + "나이 : " + cus2.getAge() + "\n" + "전화번호 : " + cus2.getTel()); */
			Customer customers[] = {
				new Customer("홍길동", 30, "1111-1111"),
				new Customer("이순신", 30, "1111-2222"),
				new Customer("김유신", 30, "1111-3333"),
				new Customer("강감찬", 30, "1111-4444"),
				new Customer("대조영", 30, "1111-5555")
			};
			Vector <Customer> v = new Vector<Customer>(customers.length);
			for (int i=0; i<customers.length; i++) {
				v.add(customers[i]);
			}
			fos = new FileOutputStream("result.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(v);

			fis = new FileInputStream("result.ser");
			ois = new ObjectInputStream(fis);
			Vector<Customer> vv = (Vector<Customer>) ois.readObject();

			for (int i=0; i<customers.length; i++) {
				System.out.println("이름 : " + vv.get(i).getName() + "\n" + "나이 : " + vv.get(i).getAge() + "\n" + "전화번호 : " + vv.get(i).getTel());
			}
		} catch (IOException /* | FileNotFoundException | */ | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
