/* cd desktop/JAVA_CODING/JavaEx_noGIT/d12Ex_noGIT

Ex#3 is to practice "find bugs once" algorithm: 
Hence: reproduce bug manually (done in PersonJU), programmatically 
by adding new test to testing class (done on line 28), then fix it 
and check it. 
*/
import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest
{ 
// If u don't write @Test,JUnit will ignore the test immediately below.

	@Test 
	public void testsNormalName()
	{
		PersonJU p=new PersonJU();
		String input="Dereck Robert Yssirt"; 
		String output=p.getInitials(input);
		String expected="DRY";
		assertEquals(output,expected);
	}
	@Test 
	public void testsNormalName2()
	{
		PersonJU p=new PersonJU();
		String input="Dereck  Robert Yssirt"; // <-- reproducing the bug programmatically.
		String output=p.getInitials(input);
		String expected="DRY";
		assertEquals(output,expected);
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
> cd desktop/JAVA_CODING/JavaEx_noGIT/d12Ex_noGIT
this contains both PersonJU and PersonTest.

Then I put JUnit folder (called Java_lib) into the folder desktop/JAVA_CODING 
Then I wrote:
> javac -cp .:/Users/Shahin/desktop/JAVA_CODING/Java_lib/junit-4.11.jar:/Users/Shahin/desktop/JAVA_CODING/Java_lib/hamcrest-core-1.3.jar PersonTest.java

To run the test: 

> java -cp .:/Users/Shahin/desktop/JAVA_CODING/Java_lib/junit-4.11.jar:/Users/Shahin/desktop/JAVA_CODING/Java_lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore PersonTest

*/