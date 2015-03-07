// cd
// Exercise 10.1 : Introducing Interfaces, ad hoc polymorphism and casting.
/*
Create a small script called PhoneLauncher in which you create a SmartPhone and use all its methods, including
those inherited from its ancestor classes.

public class PhoneLauncher {
  public static void main(String[] args) {
    PhoneLauncher launcher = new PhoneLauncher();
    launcher.launch();

  public void launch() {
    // your code creating and using SmartPhone here...
  }
*/

public class PhoneLauncherPSVM {

  public static void main(String[] args) {

  //  Phone phone = new OldPhone();
  //  phone.call("0207 342 436");

    MobilePhone phone2 = new MobilePhone();
    phone2.printLastNumbers();
    phone2.call("1_0207 342 436");
    phone2.call("2_0208 111 245");
    phone2.call("3_01923 234 209");
    phone2.call("4_02323 2334 21109");
    phone2.call("5_07989 203 4593");
    phone2.call("6_076083 134 445");
    phone2.call("7_0118 475 942");
    phone2.call("8_0870 123 234");
    phone2.call("9_0800 3435 1029");
    phone2.call("10_0900 439 3493");
    phone2.call("11_000192 232 900");
    phone2.printLastNumbers();

    Phone phone2 = new SmartPhone();

  }

}
