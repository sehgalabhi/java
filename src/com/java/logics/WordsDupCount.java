package com.java.logics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordsDupCount {
	public static void main(String[] args) {

		WordsDupCount wordsDupCount = new WordsDupCount();
		wordsDupCount.printWords();

	}

	private void printWords() {
		File file = new File("/home/abhi/workspace/ds/java/src/com/java/logics/wordscount.txt");
		System.out.println(file.length());
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
