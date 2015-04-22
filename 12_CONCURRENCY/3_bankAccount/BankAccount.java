// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/3_bankAccount
// Exercise 17.3: Introduction to concurrency

/*
Look at the following code of a simplified bank account. Assume that there are
many threads accessing this object and think what is the minimum number of
synchronized statements that are needed to ensure a correct behaviour.
Check your answer with a colleage or with one of the members of the faculty.
*/
/*
Code before and after is shown. Before at bottom, commented out.
BankAccount in its before form is vulnerable to a race condition. i.e. half
way through deposit(int), for example, another thread updates the balance with
a call to retrieve(int). Then the deposit(int) method resumes and the balance
is updated. But because deposit(int) had already started and taken the balance
value (on the right-hand side of balance = balance + money), the new value of
balance will be overwritten and therefore lost. This would obviousy be disastrous
in a real-world setting so it not a trivial matter at all!.

Thus, both methods that update the balance need to be locked (using synchronized
keyword). Note: even though only a single line updates the balance in retrieve(int),
it would be insufficient to wrap just this line (balance = balance+money statement)
inside a synchronized block because the statement may or may not be carried out
according to the if-else condition that precedes it and that reads the same shared
variable of balance.
*/

/**
* Only two changes have been made in this class. The keyword synchronized has been
* added to retrieve(int) and to deposit(int)
*/
public class BankAccount {

  private int balance = 0;

  public BankAccount() {}

  public int getBalance() {

    return balance;

  }

  /**
  * This is one of two method has been made synchronised to prevent it being interupted at
  * any stage that could result in a race condition.
  */
  public synchronized void deposit(int money) {

    balance = balance + money;

  }

  /**
  * This is one of two method has been made synchronised to prevent it being interupted at
  * any stage that could result in a race condition.
  */
  public synchronized int retrieve(int money) {

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
