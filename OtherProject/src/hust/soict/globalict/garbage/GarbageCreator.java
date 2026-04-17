package hust.soict.globalict.garbage;
import java.util.Random;
public class GarbageCreator {
	public static void main(String[] args) {
		Random r = new Random();
		String s = "";
		long start = System.currentTimeMillis();
		
		for (int i=0; i<500000; i++) {
			s = s + r.nextInt(10);	//Create many temporary strings
		}
		
		System.out.println("Time" + (System.currentTimeMillis() - start));
	}
}
