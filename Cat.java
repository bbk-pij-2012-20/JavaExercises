//cd ~/Desktop/JavaCoding/JavaExNoGIT/d16Ex_noGIT
/* Day16 Ex 3 
a) Write a program that takes a name from the user at the 
command line. If a file with that name exists, the program 
must show its contents on screen. If it does not, the 
program must say so.

QUESTION: I thought Unix/Mac treat all folders and files as 
the same thing. So why does the code below give exception 
for a folder names? 

java.io.FileNotFoundException: Test (Is a directory)
	at java.io.FileInputStream.open(Native Method)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.util.Scanner.<init>(Scanner.java:656)
	at Cat.echo(Cat.java:26)
	at Cat.main(Cat.java:18)
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