// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/InputOutput
// Exercise 16.1: Introduction to Input/Output
/* 
Write a program that shows on screen the names of the files in the current directory. 
(Hint: look at methods from class File).
*/
/* from Java API 7: 

File(String pathname)
This constructor creates a new File instance by converting the given pathname string 
into an abstract pathname.

listFiles()
This method returns an array of abstract pathnames denoting the files in the directory 
denoted by this abstract pathname.

getCanonicalFile()
This method returns the canonical form of this abstract pathname.

The following code is based on StackOverFlow: 
http://stackoverflow.com/questions/9148467/get-current-path-of-java-file-that-is-running
*/

import java.io.File;
import java.io.IOException;

public class Ls {

	public static void main(String[] args) throws IOException {

		File file = new File(".");		
		File[] files  = file.listFiles();
		System.out.println("Current dir : " + file.getCanonicalPath());
 
		for (int i = 0; i < files.length; i++) {
		
			System.out.println(files[i]);
		
		}
	
	}

}