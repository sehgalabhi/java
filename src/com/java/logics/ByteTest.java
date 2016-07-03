package com.java.logics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class ByteTest {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Default Charset=" + Charset.defaultCharset());
		System.setProperty("file.encoding", "Latin-1");
		System.out.println("file.encoding=" + System.getProperty("file.encoding"));
		System.out.println("Default Charset=" + Charset.defaultCharset());
		
		

		try {
			FileInputStream fileInputStream = new FileInputStream(new File(ByteTest.class.getResource("wordscount.txt").toURI()));
			int c;
			while (( c= fileInputStream.read()) != -1) {
				System.out.print(c + " ");
				
			}
			System.out.println();
			
			String s = "This this is a this a duplicate count and count.";
			for (int i = 0; i < s.getBytes().length; i++) {
				System.out.print(s.getBytes()[i]+ " ");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
