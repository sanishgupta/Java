package dev.test.demo.exception;

import java.io.*;

public class FileRead {
	public static void main(String args[]) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("abc.txt");
		} catch (FileNotFoundException e) {
			System.out.println("The source file does not exist. " + e);
		}
		int k;
		try {
			while ((k = fis.read()) != -1) {
				System.out.print((char) k);
			}
			fis.close();
		} catch (IOException e) {
			System.out.println("Some IO problem,may be corrupted data inside the file. " + e);
		}
	}
}
