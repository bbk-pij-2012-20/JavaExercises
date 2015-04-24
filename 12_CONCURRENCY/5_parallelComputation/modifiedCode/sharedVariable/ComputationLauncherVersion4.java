// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/5_parallelComputation
// Exercise 17.5: Introduction to concurrency

/**
 * This class launched two heavy computations sequentially first, then in parallel.
 * Assuming there is more than one processor in the machine, parallel computations
 * finish earlier.
 */
public class ComputationLauncherVersion4 {

  /**
  * How many numbers to process? If too low, there is no noticeable
  * difference.
  */
  public static final int COUNT = 40000000;
  private int NUMBER_OF_CPUs = Runtime.getRuntime().availableProcessors();//4 in my Macbook Pro

  /*
  * The computations to be performed. Stored as fields so
  * both methods (sequential and parallel) act on exactly
  * the same data
  */
  //private Computation c1 = null;
  //private Computation c2 = null;

  //arrays of Computation and Thread, so degree of parallelism is determined at runtime
  private Computation[] computations = null;
  private Thread[] threads = null;

  public ComputationLauncherVersion4() {

    computations = new Computation[NUMBER_OF_CPUs];
    threads = new Thread[NUMBER_OF_CPUs];

  }

  /**
  * The main method that launches the computations
  *
  * @param args command-line arguments, ignored
  */
  public static void main(String args[]) {

    ComputationLauncherVersion4 cv4 = new ComputationLauncherVersion4();
    cv4.launch();

  }

  private void launch() {

    // Uncomment the following line to know how many processors your machine has
    // System.out.println("#CPU: " + Runtime.getRuntime().availableProcessors());
    long start, stop;

//    c1 = new Computation(createArray(COUNT / 4));
//    c2 = new Computation(createArray(COUNT / 4));

    for (int i = 0; i < NUMBER_OF_CPUs; i++) {

      computations[i] = new Computation(createArray(COUNT / NUMBER_OF_CPUs), i);
      threads[i] = new Thread(computations[i]);

    }

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

  private double[] createArray(int size) {

    double[] result = new double[size];

    for (int i = 0; i < result.length; i++) {

      result[i] = Math.random();

    }

    return result;

  }

  private void sequentialComputations() {

//  c1.run();
//  c2.run();
//	double result1 = c1.getResult();
//	double result2 = c2.getResult();
    double totalResult = 0;

    /*
    * (The number of computation instances is determined by the number of CPUs,
    * but this does not mean each instance is processed on a different CPU.
    * Hence, I have emphasised this by using 'computations.length' instead of
    * NUMBER_OF_CPUs, even though they are always the same number.)
    */
    for (int i = 0; i < computations.length; i++) {

      computations[i].run();
      totalResult += computations[i].getResult();

    }

//  System.out.println("Result: " + (result1 + result2));
    System.out.println("Result (sequential): " + totalResult);

  }

  private void parallelComputations() {

//  Thread t1 = new Thread(c1);
//	t1.start();
//	Thread t2 = new Thread(c2);
//	t2.start();
//	double result1 = c1.getResult();
//	double result2 = c2.getResult();
    double totalResult = 0;

    for (int i = 0; i < NUMBER_OF_CPUs; i++) {

      threads[i].start();
      totalResult += computations[i].getResult();

    }

//  System.out.println("Result: " + (result1 + result2));
    System.out.println("Result (parallel): " + totalResult);

  }

}
