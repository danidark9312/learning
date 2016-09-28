package com.danielgm.io;

import java.io.IOException;

public class CSVReaderHelper {
	public static void main(String[] args) {
		try {
			String[][] readFileIntoArray = new ReadingCSV().readFileIntoArray("C:/pruebaDaniel.txt");
			System.out.println(readFileIntoArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
