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
import java.util.Timer;
import java.util.TimerTask;

public class ResponsiveUI {

  private int numberOfTasks = 0;
  private List<String> finishedTasksList = null;
  private List<String> newlyFinishedTasksList = null;
  private Timer timer = null;

  public ResponsiveUI() {

    numberOfTasks = 10;
    finishedTasksList = new ArrayList<>();
    newlyFinishedTasksList = new ArrayList<>();

  }

  public static void main(String[] args) {

    ResponsiveUI rui = new ResponsiveUI();

    for (int taskNumber = 1; taskNumber < rui.numberOfTasks; taskNumber++) {

      System.out.print("Enter the duration (in ms) of task" + taskNumber + ": ");
      String input = System.console().readLine();
      Long duration = Long.parseLong(input);
      Runnable task = new Task(duration, taskNumber, rui.newlyFinishedTasksList);
      Thread taskThread = new Thread(task);
      taskThread.start();

      if (!rui.newlyFinishedTasksList.isEmpty()) {

        System.out.print("Finished tasks: " + rui.newlyFinishedTasksList + "\n");
        rui.finishedTasksList.addAll(rui.newlyFinishedTasksList);
        rui.newlyFinishedTasksList.clear();

      }

    }

    if (rui.finishedTasksList.size() < 10) {

      rui.checkForUnfinished();

    } else if (rui.finishedTasksList.size() == 10) {

      rui.timer.cancel();
      System.exit(0);

    }

  }

  public void checkForUnfinished() {

    TimerTask timerTask = new TimerTask() {

      public void run() {

        if (finishedTasksList.size() < 10 && !newlyFinishedTasksList.isEmpty()) {

          System.out.print("Finished tasks: " + newlyFinishedTasksList + "\n");
          finishedTasksList.addAll(newlyFinishedTasksList);
          newlyFinishedTasksList.clear();

        }

      }


    };

    int millisecsBetweenChecking = 1000; //i.e. it checks once per second
    timer = new Timer();
    timer.schedule(timerTask, 0, millisecsBetweenChecking);

  }

}

class Task implements Runnable {

  private long endTime;
  private int taskNumber;
  private List<String> newlyFinishedTaskList;

  public Task(long duration, int taskNumber, List<String> newlyFinishedTaskList) {

    endTime = System.currentTimeMillis() + duration;
    this.taskNumber = taskNumber;
    this.newlyFinishedTaskList = newlyFinishedTaskList;

  }

  public void run() {

    while (System.currentTimeMillis() <= endTime) {}

    newlyFinishedTaskList.add(this.getTaskNumber() + ", ");
    return;

  }

  public int getTaskNumber() {

    return taskNumber;

  }

}
