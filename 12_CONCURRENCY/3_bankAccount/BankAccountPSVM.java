// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/12_CONCURRENCY/3_bankAccount
// Exercise 17.3: Introduction to concurrency

/**
* BankAccountPSVM creates two threads that call BankAccount's methods.
* The balance is checked and eventually gives the value that is altered by both threads.
* If the
*/
public class BankAccountPSVM {

  public static void main(String[] args) {

    BankAccount account = new BankAccount();
    System.out.println("balance should be 0:" + account.getBalance());

    for (int i = 0; i < 250; i++) {

      System.out.println("balance at start of for-loop:" + account.getBalance());
      Runnable adam = new Adam(account);
      Runnable eve = new Eve(account);
      Thread adamThread = new Thread(adam);
      Thread eveThread = new Thread(eve);
      adamThread.start();
      eveThread.start();

    }

    System.out.println("balance after for-loop:" + account.getBalance());

  }

}

/**
* One of two classes that shares a BankAccount
*/
class Adam implements Runnable {

  BankAccount account = null;

  public Adam(BankAccount account) {

    this.account = account;

  }

  @Override
  public void run() {

    account.deposit(100);
    account.retrieve(50);

  }

}

/**
* One of two classes that shares a BankAccount
*/
class Eve implements Runnable {

  BankAccount account = null;

  public Eve(BankAccount account) {

    this.account = account;

  }

  @Override
  public void run() {

    account.deposit(24);
    account.retrieve(4);

  }

}
