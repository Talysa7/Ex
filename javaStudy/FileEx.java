import java.io.File;
import java.io.IOException;

class FileEx {
	public static void main(String[] args) throws IOException	{
		//C드라이브 파일 목록 출력
		String path = "c://";
		// \는 C에서 문자로 인식 안해서, 쓰고 싶으면 2개 써야함 \\ 이렇게 -_-
		// 리눅스에서는 C:/ 이렇게임 ㅡㅡ
		File cdrive = new File(path);
		String[] files = cdrive.list();

		for(int i=0; i<files.length; i++) {
			File file = new File(cdrive, files[i]);
			if(file.isFile()) {
				//파일
				System.out.println(file.getName() + "(" + file.length() + ")");
			} else {
				//디렉토리
				System.out.println("+ " + file.getName());
			}
		}

		//파일 생성
		File f1 = new File("a.txt");		
		if(!f1.exists()) System.out.println("생성 : " + f1.createNewFile());

		//파일 정보
		System.out.println("절대경로 : " + f1.getAbsolutePath());
		System.out.println("정규경로 : " + f1.getCanonicalPath());
		System.out.println("부모폴더 : " + f1.getParent());
		System.out.println("상대경로 : " + f1.getPath());
		System.out.println("전체용량 : " + f1.getTotalSpace()/1024/1024/1024+"GB");
		System.out.println("가능용량 : " + f1.getFreeSpace()/1024/1024/1024+"GB");

		//이름 변경
		//a.txt -> b.xtx
		File b = new File("b.txt");
		if(!b.exists()) System.out.println("변경 : " + f1.renameTo(b));

		//파일 삭제
		//f1.delete();
		//b.delete();

	}
}
