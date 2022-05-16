package projekt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args) throws IOException {
		String textFile = args[0];
		String fileName = args[1];
		int n = Integer.valueOf(args[2]);
		int[] vec = new int[1000];
		FileWriter fw = new FileWriter(fileName);
		fw.write("löpnummer, sorteringstid i ns");
		Scanner scan = new Scanner(new File(textFile));
		
		int it = 0;
		while (scan.hasNext()) {
			Integer number = scan.nextInt();
			vec[it] = number;
			it++;
		}
		int[] vecClone = vec.clone();
		scan.close();
		int i = 0;
		while (i < n) {
			long t0 = System.nanoTime();
			sort(vec);
			long t1 = System.nanoTime();
			long time = t1 - t0;
			vec = vecClone;
			fw.write("\n" + (i+1) + "," + time);
			i++;
		}
		fw.close();
	}
	
	public static void sort(int[] a) {
		int[] tmpArray = new int[a.length];
		mergeSort(a,tmpArray, 0, a.length - 1);
	}
	
	private static void mergeSort(int[] a, int[] tmpArray, int first, int last) {
		if (first < last) {
			int mid = first + (last - first) / 2;
			mergeSort(a, tmpArray, first, mid);
			mergeSort(a, tmpArray, mid + 1, last);
			merge(a, tmpArray, first, mid + 1, last);
		}
	}
	
	private static void merge(int[] a, int[] tmpArray, int leftPos, 
			                  int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int leftStart = leftPos;
		// Så länge element "finns kvar" i bägge halvorna
		//    välj minsta och lägg in tmpArray
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos] <= a[rightPos]) {
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		// Kopiera ev resterande element från vänster halva till tmpArray
		while (leftPos <= leftEnd) {
			tmpArray[tmpPos++] = a[leftPos++];
		}
		// Kopiera ev resterande element från höger halva till tmpArray
		while (rightPos <= rightEnd) {
			tmpArray[tmpPos++] = a[rightPos++];
		}
		// Kopiera  elementen från tmpArray till a
		for (int i = leftStart; i <= rightEnd; i++) {
			a[i] = tmpArray[i];
		}
	}

}
