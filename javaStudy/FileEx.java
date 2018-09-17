import java.io.File;
import java.io.IOException;

class FileEx {
	public static void main(String[] args) throws IOException	{
		//C����̺� ���� ��� ���
		String path = "c://";
		// \�� C���� ���ڷ� �ν� ���ؼ�, ���� ������ 2�� ����� \\ �̷��� -_-
		// ������������ C:/ �̷����� �Ѥ�
		File cdrive = new File(path);
		String[] files = cdrive.list();

		for(int i=0; i<files.length; i++) {
			File file = new File(cdrive, files[i]);
			if(file.isFile()) {
				//����
				System.out.println(file.getName() + "(" + file.length() + ")");
			} else {
				//���丮
				System.out.println("+ " + file.getName());
			}
		}

		//���� ����
		File f1 = new File("a.txt");		
		if(!f1.exists()) System.out.println("���� : " + f1.createNewFile());

		//���� ����
		System.out.println("������ : " + f1.getAbsolutePath());
		System.out.println("���԰�� : " + f1.getCanonicalPath());
		System.out.println("�θ����� : " + f1.getParent());
		System.out.println("����� : " + f1.getPath());
		System.out.println("��ü�뷮 : " + f1.getTotalSpace()/1024/1024/1024+"GB");
		System.out.println("���ɿ뷮 : " + f1.getFreeSpace()/1024/1024/1024+"GB");

		//�̸� ����
		//a.txt -> b.xtx
		File b = new File("b.txt");
		if(!b.exists()) System.out.println("���� : " + f1.renameTo(b));

		//���� ����
		//f1.delete();
		//b.delete();

	}
}
