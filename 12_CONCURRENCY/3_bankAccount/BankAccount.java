// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY
// Exercise 17.3: Introduction to concurrency

/*
Look at the following code of a simplified bank account. Assume that there are
many threads accessing this object and think what is the minimum number of
synchronized statements that are needed to ensure a correct behaviour.
Check your answer with a colleage or with one of the members of the faculty.
*/

public class BankAccount {

  private int balance = 0;

  public int getBalance() {

    return balance;

  }

  public void deposit(int money) {

    balance = balance + money;

  }

  public int retrieve(int money) {

    int result = 0;

    if (balance > money) {

      result = money;

    } else {

      result = balance;

    }

    balance = balance - result;
    return result;

  }

}
