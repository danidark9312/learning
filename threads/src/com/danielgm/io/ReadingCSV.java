package com.danielgm.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingCSV {
	
	public String[][] readFileIntoArray(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		List<String[]> records = new ArrayList<String[]>();
		String line = null;
		try{
			while ((line = reader.readLine()) != null) {
				records.add(line.split("\t"));
			}
		}finally{
			reader.close();
		}

		return (String[][]) records.toArray(new String[0][0]);
	}

}
