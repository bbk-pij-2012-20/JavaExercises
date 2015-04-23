// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/4_responsiveUI
// Exercise 17.4: Introduction to concurrency

/*
Write a program that asks from the user the length in milliseconds of ten tasks.
As the user enters the length, the tasks start running in the background while
the user enters the length of the other tasks. When the tasks end, the program
must register it and say it unless it is waiting for the user to enter data.
See this sample output:
Enter the duration (in ms) of task 0: 10
Enter the duration (in ms) of task 1: 3000
Finished tasks: 0
Enter the duration (in ms) of task 2: 2000
Enter the duration (in ms) of task 3: 1000
Enter the duration (in ms) of task 4: 10
Enter the duration (in ms) of task 5: 1000
Finished tasks: 2, 1, 3, 4
Enter the duration (in ms) of task 6:
...
Note that several tasks may end in between two user inputs.
*/
import java.util.List;
import java.util.ArrayList;

public class ResponsiveUI {

  private int numberOftasks = 10;
  private String task = "";
  private Task task;
  private List<Task> newlyFinished = new ArrayList<>();

  public static void main(String[] args) {

    for (int i = 0; i < numberOfTasks; i++) {

      System.out.println("Enter the duration (in ms) of task" + i + ": ");
      Runnable task = new Task(Integer.parseInt(System.console.readLine()));
      Thread taskThread = new Thread(task, i, newlyFinished);
      taskThread.start();

    }

    //some timer task that periodically checks which are the newly finished tasks


  }

}

class Task implements Runnable {

  private int millisecs;
  private int taskNumber;
  private List<Task> newlyFinished;

  public Task(int millisecs, int taskNumber, List<Task> newlyFinished) {

    this.millisecs = millisecs;
    this.taskNumber = taskNumber;
    this.newlyFinished = newlyFinished;

  }

  public void run() {

    //timer task for millisecs.

    //at end of run, newlyFinished.add(this);

  }


}
