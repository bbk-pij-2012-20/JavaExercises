// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/5_parallelComputation
// Exercise 17.5: Introduction to concurrency

/**
 * This class launched two heavy computations sequentially first, then in parallel.
 * Assuming there is more than one processor in the machine, parallel computations
 * finish earlier.
 */
public class ComputationLauncherVersion2 {

  /**
  * How many numbers to process? If too low, there is no noticeable
  * difference.
  */
  public static final int COUNT = 40000000;
  private int NUMBER_OF_CPUs = 4;//number of CPUs in Macbook Pro

  /*
  * The computations to be performed. Stored as fields so
  * both methods (sequential and parallel) act on exactly
  * the same data
  */
  private Computation c1 = null;
  private Computation c2 = null;
  private Computation c3 = null;// added
  private Computation c4 = null;// added

  /**
  * The main method that launches the computations
  *
  * @param args command-line arguments, ignored
  */
  public static void main(String args[]) {

    ComputationLauncherVersion2 cv2 = new ComputationLauncherVersion2();
    cv2.launch();

  }

  private void launch() {

    // Uncomment the following line to know how many processors your machine has
    // System.out.println("#CPU: " + Runtime.getRuntime().availableProcessors());
    long start, stop;

    c1 = new Computation(createArray(COUNT / NUMBER_OF_CPUs));
    c2 = new Computation(createArray(COUNT / NUMBER_OF_CPUs));
    c3 = new Computation(createArray(COUNT / NUMBER_OF_CPUs));// added
    c4 = new Computation(createArray(COUNT / NUMBER_OF_CPUs));// added

    //  start = System.currentTimeMillis();
    start = System.nanoTime();
    sequentialComputations();
    //  stop = System.currentTimeMillis();
    stop = System.nanoTime();
    //  System.out.println("Time without threads: " + (stop - start) + " ms");
    System.out.println("Time without threads: " + (stop - start) + " ns");
    //  start = System.currentTimeMillis();
    start = System.nanoTime();
    parallelComputations();
    //  stop = System.currentTimeMillis();
    stop = System.nanoTime();
    //	System.out.println("Time with threads: " + (stop - start) + " ms");
    System.out.println("Time with threads: " + (stop - start) + " ns");

  }

  /**
  * unchanged
  */
  private double[] createArray(int size) {

    double[] result = new double[size];

    for (int i = 0; i < result.length; i++) {

      result[i] = Math.random();

    }

    return result;

  }

  private void sequentialComputations() {

    c1.run();
    c2.run();
    c3.run();// added
    c4.run();// added

	  double result1 = c1.getResult();
	  double result2 = c2.getResult();
    double result3 = c3.getResult();//added
    double result4 = c4.getResult();//added

	  System.out.println("Result: " + (result1 + result2 + result3 + result4));// 3 and 4 added

  }

  private void parallelComputations() {

    Thread t1 = new Thread(c1);
	  t1.start();
	  Thread t2 = new Thread(c2);
	  t2.start();
    Thread t3 = new Thread(c3);// added
	  t3.start();                // added
	  Thread t4 = new Thread(c4);// added
	  t4.start();                // added
	  double result1 = c1.getResult();
	  double result2 = c2.getResult();
	  double result3 = c3.getResult();// added
	  double result4 = c4.getResult();// added
	  System.out.println("Result: " + (result1 + result2 + result3 + result4));// 3 and 4 added

  }

}
