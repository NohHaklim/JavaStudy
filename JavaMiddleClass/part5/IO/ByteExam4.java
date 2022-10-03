package part5.IO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteExam4 {

	public static void main(String[] args) {
		try (DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
				) {
			int i = in.readInt();
			boolean b = in.readBoolean();
			double d = in.readDouble();
			
			System.out.println(i);
			System.out.println(b);
			System.out.println(d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
