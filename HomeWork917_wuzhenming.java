package ibm.com.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeWork917_wuzhenming {
	public static void main(String[] args) {
		File file = new File("myfile.txt");
		File file_cp = new File("myfile_cp.txt");
		File file_cp2 = new File("myfile_cp2.txt");

		try {
			System.out.println("ʹ���ļ��������ļ�������");
			streamCopyFile(file, file_cp);
			System.out.println("�ļ�������ɣ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("ʹ�û����������ļ�������");
			bufferedStreamCopyFile(file, file_cp2);
			System.out.println("�ļ�������ɣ�");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void streamCopyFile(File srcFile, File deFile) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(srcFile);
		FileOutputStream fileOutputStream = new FileOutputStream(deFile);
		Integer by = 0;

		while ((by = fileInputStream.read()) != -1) {
			fileOutputStream.write(by);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}

	private static void bufferedStreamCopyFile(File srcFile, File desFile) throws IOException {

		// ʹ�û����ֽ��������ļ�����

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));

		byte[] b = new byte[1024];

		Integer len = 0;

		// һ�ζ�ȡ1024�ֽڵ�����

		while ((len = bis.read(b)) != -1) {

			bos.write(b, 0, len);

		}

		bis.close();

		bos.close();

	}
}
