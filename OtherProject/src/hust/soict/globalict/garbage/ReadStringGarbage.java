package hust.soict.globalict.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadStringGarbage {
	public static void main(String[] args) throws Exception {
		String filename = "C:\\Users\\SON_PC\\Desktop\\test.txt";		// Change this to your file path.
		byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for(byte b: inputBytes) {
        	outputString += (char)b;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
	}
}	
