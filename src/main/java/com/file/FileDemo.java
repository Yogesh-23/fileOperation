package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {

	public static void main(String[] args) {
		// reading file from specified path
		Path path = Paths.get("D:\\UploadByProgram\\a.txt");
		int i;

		// path.toFile() it will convert specified file path to file object
		FileInputStream is;
		try {
			is = new FileInputStream(path.toFile());
			while ((i = is.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
