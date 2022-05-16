package projekt;

import java.io.FileWriter;
import java.io.IOException;

public class FIbonacci {

	public static void main(String[] args) throws IOException {	
		String fileName = args[0];
		int n = Integer.valueOf(args[1]);
		FileWriter fw = new FileWriter(fileName);
		fw.write("löpnummer, sorteringstid i ns");
		
		int i = 0;
		while (i < n) {
			long t0 = System.nanoTime();
			Integer number = (int)fib(30);
			long t1 = System.nanoTime();
			fw.write("\n" + (i+1) + "," + (t1-t0));

			i++;
		}
		fw.close();
		
	}
	
	
	public static long fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
