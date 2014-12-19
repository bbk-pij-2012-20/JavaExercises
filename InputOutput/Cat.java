//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/InputOutput
//Exercise 7.9 (Introduction to input/output)

/*
a) Write a program that takes a name from the user at the  command line. 
If a file with that name exists, the program  must show its contents on screen. 
If it does not, the program must say so.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cat { 
	
	public static void main(String[] args) {
		
		if (args.length != 0) {
			
			String str = args[0];
			
			if (str != null) {
				
				File file = new File(str);
				
				if (file.exists()) {
				
					echo(file);
				
				} else {
					
					System.out.println("file " + file + " don't exist");
				
				}
			
			}
	
		} else System.out.println("no files to process");

	}

	//
	private static void echo(File file) {
	
		try (Scanner sc = new Scanner(file);) {
	
			while (sc.hasNext()) {
	
				System.out.println(sc.next());
	
			}
			
		} catch (FileNotFoundException ex) {
			
			ex.printStackTrace();
		
		}	

	}

}
