package test;

import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		int sum = 0;
		try {
			File myObj = new File("input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String in = myReader.nextLine();
				int gameNum = Integer.parseInt(in.split(":")[0].split(" ")[1]);
				StringTokenizer game1 = new StringTokenizer(in.split(":")[1], ";");
				int blue=-1, red=-1, green=-1;
				while (game1.hasMoreTokens()) {
					String current = game1.nextToken();
					StringTokenizer colors = new StringTokenizer(current, ",");
					boolean possible = true;
					Hashtable <String, Integer> lowest = new Hashtable<String,Integer>();
					lowest.put("blue", -1);
					lowest.put("red", -1);
					lowest.put("green", -1);
					while (colors.hasMoreTokens()) {
						
						String temp = colors.nextToken();
						int freq = Integer.parseInt(temp.split(" ")[1]);
						String color = temp.split(" ")[2];
		
						if(lowest.get(color)<freq)
							lowest.put(color, freq);
						
					
						
						
					}
					if (blue < lowest.get("blue")) 
						blue = lowest.get("blue");
					
					if(green< lowest.get("green"))
						green = lowest.get("green");
					if(red< lowest.get("red"))
						red = lowest.get("red");
				
				
				
						
					
				}
				sum+= blue*red*green;

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println(sum);
	}

}
