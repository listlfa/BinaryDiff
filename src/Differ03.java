import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author a
 * 
 * write hash results to text file
 *
 */
public class Differ03 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");

		//		String input_file = "/home/a/differtest.png";
		String inputFolderName = "c:\\home\\a";
		String inputFileName = "differ-test.zip";
		String outputFolderName = "c:\\home\\a";
		String outputFileName = "differ-hashes.text";
		String outputFileContents = "";
		String[] test;
		StringBuilder test2 = new StringBuilder();
		boolean fileIsOK = false;  		
		Path dirPath = Paths.get(inputFolderName);
		Path inputFilePath = Paths.get(inputFolderName + "\\" + inputFileName);
		Path outputFilePath = Paths.get(outputFolderName + "\\" + outputFileName);
		int byteBufferSize = 64*1024;

		//		fileIsOK = Files.exists(dir); 		
		//		System.out.format("%b \n", fileIsOK);
		//		fileIsOK = Files.isRegularFile(dirPath); 		
		//		System.out.format("%b \n", fileIsOK);

		fileIsOK = Files.isRegularFile(inputFilePath); 		
		System.out.format("%b \n", fileIsOK);
		if( fileIsOK)
		{
			try
			{
				FileInputStream fis = new FileInputStream(new File(inputFilePath.toString()));
				FileChannel channel = fis.getChannel();
				ByteBuffer bb = ByteBuffer.allocateDirect(byteBufferSize);
				long len = 0;
				int offset = 0;

				bb.clear();
				//				  ipArr = new int [(int)channel.size()/4];
				System.out.println("File size: " + channel.size()/4);

				while ((len = channel.read(bb)) != -1)
				{
					bb.flip();  //flip from write to read mode

					//debug
					System.out.format("bb.hashCode() [%d] \n", bb.hashCode());
					System.out.format("len %d \n", len);
					System.out.format("channel.position() %d \n", channel.position());
					System.out.format("-    -    - \n");

					outputFileContents += String.valueOf(bb.hashCode()) + "\n";
//					test += String.valueOf(bb.hashCode()) + "\n";
					test2.append(String.valueOf(bb.hashCode()));
					test2.append(System.lineSeparator());

					bb.clear();
				}

				fis.close();
				
				if (!Files.isRegularFile(outputFilePath))
				{
					Files.createFile(outputFilePath);
				}				
//				Files.write(Paths.get(outputFolderName + "\\" + outputFileName), outputFileContents.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
				Files.write(Paths.get(outputFolderName + "\\" + outputFileName), test2.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

				//future read code
				//				  List<String> lines = Files.readAllLines(Paths.get("./duke.txt"), Charset.defaultCharset());
				//				  for (String line : lines) {
				//				  System.out.println("line read: " + line);
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
