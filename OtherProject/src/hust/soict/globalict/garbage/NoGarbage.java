package hust.soict.globalict.garbage;
import java.util.Random;
public class NoGarbage {
	public static void main(String[] args) {
		Random r = new Random(123);
		StringBuilder sb = new StringBuilder();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
		    sb.append(r.nextInt(10));			// Only one object grows, no new object is created
		}
		String s = sb.toString();
		System.out.println("Time" + (System.currentTimeMillis() - start));
	}
}
