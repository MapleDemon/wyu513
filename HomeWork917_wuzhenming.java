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
			System.out.println("使用文件流复制文件。。。");
			streamCopyFile(file, file_cp);
			System.out.println("文件复制完成！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("使用缓冲流复制文件。。。");
			bufferedStreamCopyFile(file, file_cp2);
			System.out.println("文件复制完成！");
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

		// 使用缓冲字节流进行文件复制

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));

		byte[] b = new byte[1024];

		Integer len = 0;

		// 一次读取1024字节的数据

		while ((len = bis.read(b)) != -1) {

			bos.write(b, 0, len);

		}

		bis.close();

		bos.close();

	}
}
