// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/5_parallelComputation/modifiedCode/noSharedVariable
// Exercise 17.5: Introduction to concurrency
//***NO SHARED VARIABLE, SO RUN() IN COMPUTATION NEVER NEEDS TO BE LOCKED****
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
  private ComputationVersion4[] computations = null;
  private Thread[] threads = null;

  public ComputationLauncherVersion4() {

    computations = new ComputationVersion4[NUMBER_OF_CPUs];
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
    long start, stop, startNs, stopNs;

//    c1 = new Computation(createArray(COUNT / 2));
//    c2 = new Computation(createArray(COUNT / 2));

    for (int i = 0; i < NUMBER_OF_CPUs; i++) {
      //The i passed to Computation's constructor is the thread#, this is so that
      //this Computation's result will know which thread it belongs to, hence
      //it's not a shared variable as in versions 1-4.
      computations[i] = new ComputationVersion4(createArray(COUNT / NUMBER_OF_CPUs), NUMBER_OF_CPUs, i);
      threads[i] = new Thread(computations[i]);

    }

    start = System.currentTimeMillis();
    startNs = System.nanoTime();
    sequentialComputations();
    stop = System.currentTimeMillis();
    stopNs = System.nanoTime();
    System.out.println("Time without threads: " + (stop - start) + " ms");
    System.out.println("Time without threads: " + (stopNs - startNs) + " ns");
    long durationSeqNs = stopNs - startNs;

    start = System.currentTimeMillis();
    startNs = System.nanoTime();
    parallelComputations();
    stop = System.currentTimeMillis();
    stopNs = System.nanoTime();
    System.out.println("Time with threads: " + (stop - start) + " ms");
    System.out.println("Time with threads: " + (stopNs - startNs) + " ns");

    System.out.println("Using multithreading is atleast: " + (durationSeqNs / (stopNs - startNs)) + " times faster than a single thread");

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
      //The i passed to getResult(int) is the thread number (hence result is not
      //is not a shared variable as in versions 1-4).
      totalResult += computations[i].getResult(i);

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
      //The i passed to getResult(int) is the thread number (hence result
      //is not a shared variable as in versions 1-4).
      totalResult += computations[i].getResult(i);

    }

//  System.out.println("Result: " + (result1 + result2));
    System.out.println("Result (parallel): " + totalResult);

  }

}
