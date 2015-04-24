// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/5_parallelComputation
// Exercise 17.5: Introduction to concurrency

/*
Computation versions 1-3 are identical to each other. Only this version is different.

Differences are:
- result as a double is not a shared variable as it is in versions 1-4.

- result is an array of double, holding the results of all threads in each thread.

- As a result of this, there is no risk of a race condition, therefore run() and
getResult() are changed so that they are no longer synchronized.

- the lock held at the end of run() never needs to wait on other threads to
finish running, to release getResult() from their waiting state. Thus no use for
notifyAll().
*/
import java.util.*;

/**
 * A class that performs a costly computation
 */
public class ComputationVersion4 implements Runnable {

  /*
  * The result of the computation.
  */
//  private double result = 0;//commented out
  private double[] result = null; // added in

  /**
  * True when the computation result is ready, false otherwise.
  */
  private boolean resultReady = false;

  /**
  * The number to perform the computation with
  */
  private double[] numbers = null;

  /**
  * Keeps track of which thread it is - this is only for version5 which does
  * use a shared result variable.
  */
  private int thread = 0;// comment back in

  /**
  * A new computation.
  *
  * @param data an array of doubles to perform the computation
  */
  public ComputationVersion4double[] data, int numOfCPUs, int thread) {

    this.numbers = data;
    result = new double[numOfCPUs];
    this.thread = thread;

  }

  /**
  * Runs the computation.
  */
  public void run() {

//  synchronized (this) { // commented out

    double result = 0.0;

    // A new Random is created here because Math.random() is
    // synchronised, which leads to no improvement being seen
    Random r = new Random(-1);

    for (int i = 0; i < numbers.length; i++) {

      result += Math.sqrt(numbers[i]);
      result += Math.sqrt(r.nextDouble() * result);
      result += Math.sqrt(r.nextDouble() * result);
      result += Math.sqrt(r.nextDouble() * result);

    }

//  this.result = result; // commented out
    result[thread] = result; // added in
//  this.resultReady = true; // commented out
//  notifyAll();// commented out

//  }// commented out

  }

  /**
  * Returns the result of the computation if it is ready.
  * If it is not, it blocks until it is.
  *
  * @return the result of the computation.
  */
  public double getResult() {// synchronized removed

//  while (!resultReady) {// commented out
    while (result[thread] == 0.0) {//added in

      try {

        wait();

      } catch (InterruptedException ex) {
		    // Nothing to do, just sleep less
      }

    }

//  resultReady = false;//commented out
//	return result;//commented out
    return result[thread];//added in

  }

}
