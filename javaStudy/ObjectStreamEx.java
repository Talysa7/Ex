//��ü ���� ����� + ��ü ����ȭ

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
			oos.writeObject(new Customer("ȫ�浿", 30, "1111-2222"));
			oos.writeObject(new Customer("�̼���", 40, "2222-2222"));
			fis = new FileInputStream("result.ser");
			ois = new ObjectInputStream(fis);
			Customer cus1 = (Customer) ois.readObject();
			Customer cus2 = (Customer) ois.readObject();
			System.out.println("�̸� : " + cus1.getName() + "\n" + "���� : " + cus1.getAge() + "\n" + "��ȭ��ȣ : " + cus1.getTel());
			System.out.println("�̸� : " + cus2.getName() + "\n" + "���� : " + cus2.getAge() + "\n" + "��ȭ��ȣ : " + cus2.getTel()); */
			Customer customers[] = {
				new Customer("ȫ�浿", 30, "1111-1111"),
				new Customer("�̼���", 30, "1111-2222"),
				new Customer("������", 30, "1111-3333"),
				new Customer("������", 30, "1111-4444"),
				new Customer("������", 30, "1111-5555")
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
				System.out.println("�̸� : " + vv.get(i).getName() + "\n" + "���� : " + vv.get(i).getAge() + "\n" + "��ȭ��ȣ : " + vv.get(i).getTel());
			}
		} catch (IOException /* | FileNotFoundException | */ | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
