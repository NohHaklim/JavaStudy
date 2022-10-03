package part5.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteExam2 {

	public static void main(String[] args) throws IOException {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		long startTime = System.currentTimeMillis();
		
		try {
			fi = new FileInputStream("JavaMiddleClass/part5/IO/ByteExam1.java");
			fo = new FileOutputStream("byte.txt");
			
			int readCount = -1;		// 파일을 다 읽으면 -1 리턴
			byte[] buffer = new byte[512];
			while ((readCount = fi.read(buffer)) != -1) {
				fo.write(buffer, 0, readCount);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fi.close();
			fo.close();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
