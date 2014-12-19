// cd~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/JUnitTesting/PersonTest
// Exercise 12.3: Introduction to JUnit Testing

/*
The method getInitials(String) has a bug! If you introduce a name with more than one 
space between words, it throws an exception. 
Create a class that contains the method getInitials(String) as described in the notes. 
Create also the test class as described in the notes. 
Then follow the “find bugs once” algorithm: reproduce the bug manually, reproduce the 
bug programmatically by adding a new test to the testing class, then fix the bug and 
check that all tests pass.
*/
import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest { 

	@Test 
	public void testsNormalName() {
	
		PersonJU p = new PersonJU();
		String input = "Dereck Robert Yssirt"; 
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	
	}
	
	@Test 
	public void testsNormalName2() {
	
		PersonJU p = new PersonJU();
		String input = "Dereck  Robert Yssirt"; // <-- reproducing the bug programmatically.
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	
	}

}

/*
PiJ NOTES (Santos):

JUnit is not part of core Java, so I must add it to the classpath.
When modifying it, must also add current folder to this.

TO COMPILE THE TEST CLASSES:
> javac -cp .:junit-4.10.jar PersonTest.java

- 'javac' is obviously an instruction to the compiler to compile the following file.
- the '-cp' parameter is the way you can modify the classpath when executing javac or java.

TO RUN TESTS:
> java -cp .:junit-4.10.jar org.junit.runner.JUnitCore PersonTest

For JUnit 4.11, needed to include hamcrest.
http://search.maven.org/#search|ga|1|g%3A%22org.hamcrest%22
Downloaded the jar of hamcrest-core.(not the pom javadoc or sources.jar) 

------------------------------------------------------------------------------------

WHAT I ACTUALLY TYPED:

Thus to compile/run this test I set the current folder to:

> cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/JavaExercises/JUnitTesting
(which contains both PersonJU and PersonTest)

The JUnit folder (called Java_lib) is currently in the folder desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding

So I entered in the terminal the following:

> javac -cp .:/Users/Shahin/desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/Java_lib/junit-4.11.jar:/Users/Shahin/desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/Java_lib/hamcrest-core-1.3.jar PersonTest.java

To run the test: 

> java -cp .:/Users/Shahin/desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/Java_lib/junit-4.11.jar:/Users/Shahin/desktop/ALL_POOLED/COMPUTING/CODING/JavaCoding/Java_lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore PersonTest

This gives the following output to the terminal:

JUnit version 4.11
.Dereck Robert Yssirt .Dereck  Robert Yssirt 
Time: 0.006

OK (2 tests)

*/