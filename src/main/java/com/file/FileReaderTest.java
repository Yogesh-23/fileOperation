package com.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReaderTest {
	
	public static void main(String[] args) {
		
		String fileName = "D:\\UploadByProgram\\File\\Read\\a.txt";
		usingBufferReader(fileName);
		usingFileReader(fileName);
		usingScanner(fileName);
		readFileInList(fileName); 
		readFileAsString(fileName);
	}

	public static void usingBufferReader(String fileName) {
		System.out.println("usingBufferReader");
		File file = new File(fileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				System.out.println(st);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void usingFileReader(String fileName) {
		System.out.println("usingFileReader(String fileName)");
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			  int i; 
			    while ((i=fr.read()) != -1) 
			      System.out.print((char) i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void usingScanner(String fileName) {
		System.out.println("usingScanner(String fileName)");
		try {
			// pass the path to the file as a parameter
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine())
				System.out.println(sc.nextLine());
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static List<String> readFileInList(String fileName) 
	  { 	  
		System.out.println("readFileInList(String fileName)");
	    List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	      Iterator<String> itr = lines.iterator(); 
		    while (itr.hasNext()) 
		      System.out.println(itr.next()); 
	    }catch (IOException e) 
	    { 
	      e.printStackTrace(); 
	    } 
	    return lines; 
	  } 
	  
	 public static void readFileAsString(String fileName) 
	  { 
	    String data = ""; 
	    try {
			data = new String(Files.readAllBytes(Paths.get(fileName)));
			System.out.println(data);
	    } catch (IOException e) {
			e.printStackTrace();
		} 
	  } 
}