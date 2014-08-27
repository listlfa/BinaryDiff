import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author a
 *
 */
public class Differ01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
//		String input_file = "/home/a/differtest.png";
		String input_file = "c:\\home\\a\\differ-test.zip";
		byte buf[] = new byte[1024];
		int bytesRead = 0;
		try {
			DataInputStream dis = new DataInputStream(
				    new BufferedInputStream(
				        new FileInputStream(new File(input_file ))));
			bytesRead = dis.read(buf);
			System.out.format("bytes read [%d] \n", bytesRead);
			System.out.println(Arrays.toString(buf));
			System.out.format("0x%02X \n", buf[0]);
			System.out.format("0x%02X \n", buf[1]);
			System.out.format("0x%02X \n", buf[2]);
			System.out.format("0x%02X \n", buf[3]);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
