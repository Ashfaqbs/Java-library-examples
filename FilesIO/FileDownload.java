package FilesIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.mail.Quota.Resource;

public class FileDownload {
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		
		

		//writing logic
FileOutputStream fileOutputStream = new FileOutputStream("fileD1.txt");

BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);


bufferedOutputStream.write("Hellloworld".getBytes());
		
bufferedOutputStream.close();
fileOutputStream.close();
		
		
		
		//reading logic
//		FileInputStream fileInputStream = new FileInputStream("fileD.txt");
//		BufferedInputStream    bufferedInputStream = new BufferedInputStream(fileInputStream);
//		
//		int read = bufferedInputStream.read();
//		
//		Scanner scanner = new Scanner(bufferedInputStream);
//		while(scanner.hasNext())
//		{
//			String nextLine = scanner.nextLine();
//			System.out.print(nextLine);
//		}
}

}
