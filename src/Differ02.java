import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author a
 *
 */
public class Differ02 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
//		String input_file = "/home/a/differtest.png";
		String input_foldername = "c:\\home\\a";
		String input_filename = "differ-test.zip";
		boolean fileIsOK = false;  		
		Path dirPath = Paths.get(input_foldername);
		Path filePath = Paths.get(input_foldername + "\\" + input_filename);
		int byteBufferSize = 64*1024;

//		fileIsOK = Files.exists(dir); 		
//		System.out.format("%b \n", fileIsOK);
//		fileIsOK = Files.isRegularFile(dirPath); 		
//		System.out.format("%b \n", fileIsOK);

		fileIsOK = Files.isRegularFile(filePath); 		
		System.out.format("%b \n", fileIsOK);
		if( fileIsOK)
		{
			  FileInputStream fis;
			try {
				fis = new FileInputStream(new File(filePath.toString()));
				  FileChannel channel = fis.getChannel();
				  ByteBuffer bb = ByteBuffer.allocateDirect(byteBufferSize);
				  long len = 0;
				  int offset = 0;
				  
				  bb.clear();
//				  ipArr = new int [(int)channel.size()/4];
				  System.out.println("File size: " + channel.size()/4);
				  
				  while ((len = channel.read(bb)) != -1){
				    bb.flip();  //flip from write to read mode
				    //System.out.println("Offset: "+offset+"\tlen: "+len+"\tremaining:"+bb.hasRemaining());
//				    bb.asIntBuffer().get(ipArr,offset,(int)len/4);
//				    offset += (int)len/4;
					System.out.format("bb.hashCode() [%d] \n", bb.hashCode());
					System.out.format("len %d \n", len);
					System.out.format("channel.position() %d \n", channel.position());
					System.out.format("-    -    - \n");
				    bb.clear();
				  }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		

		
		
//		byte buf[] = new byte[1024];
//		int bytesRead = 0;
//		try {
//			DataInputStream dis = new DataInputStream(
//				    new BufferedInputStream(
//				        new FileInputStream(new File(input_file ))));
//			bytesRead = dis.read(buf);
//			System.out.format("bytes read [%d] \n", bytesRead);
//			System.out.println(Arrays.toString(buf));
//			System.out.format("0x%02X \n", buf[0]);
//			System.out.format("0x%02X \n", buf[1]);
//			System.out.format("0x%02X \n", buf[2]);
//			System.out.format("0x%02X \n", buf[3]);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
