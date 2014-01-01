//cd ~/Desktop/JavaCoding/JavaExercises
/*
Day16 Ex1:
Write a program that shows on screen the names of the 
files in the current directory. (Hint: look at methods 
from class File).

Java API 7: The following is a Constructor description:
File(String pathname)
Creates a new File instance by converting the 
given pathname string into an abstract pathname.

Java API 7: The following are Method descriptions:
listFiles()
Returns an array of abstract pathnames denoting the 
files in the directory denoted by this abstract pathname.

Java API 7: 
getCanonicalFile()
Returns the canonical form of this abstract pathname.

This code is based on StackOverFlow: 
http://stackoverflow.com/questions/9148467/get-current-path-of-java-file-that-is-running
*/

import java.io.File;
import java.io.IOException;

public class Ls {
	public static void main(String[] args) throws IOException {
		File file = new File(".");		
		File[] files  = file.listFiles();
		System.out.println("Current dir : " + file.getCanonicalPath());
 
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i]);
		}
	}
}
