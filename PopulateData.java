package DataAlloc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PopulateData {
	public static void main(String[] args) throws IOException{
		populate();
	}
	
	public static void populate() throws IOException{
		File file = new File("Data/anime_cleaned.csv");
		BufferedReader buff = new BufferedReader(new FileReader(file));
		
		String line = buff.readLine();
		StringTokenizer stoken = new StringTokenizer(line);
		
		for (int i = 0; i < 2; i++) {	
			String prodid = stoken.nextToken(",");
			String salestr = stoken.nextToken(",");
			System.out.println(prodid);
		}
	}
}
