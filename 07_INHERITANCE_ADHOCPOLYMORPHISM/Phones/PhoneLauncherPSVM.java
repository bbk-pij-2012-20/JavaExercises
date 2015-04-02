// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
// Exercise 10.1: Introducing ad hoc polymorphism (aka inheritance).
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
import interfacePhone.sub.Phone;

public class PhoneLauncherPSVM {

  public static void main(String[] args) {

    Phone phone_oldPhone = new OldPhone();
    phone_oldPhone.call("0207 342 436");
    System.out.println("Note: none of the methods in OldPhone which are not in Phone can be used with phone_oldPhone. For e.g. phone_oldPhone.getBrand() will not compile.");

    OldPhone oldPhone_oldPhone = new OldPhone();
    oldPhone_oldPhone.call("0207 342 436");
    System.out.println("...should say \'no brand was given\': " + oldPhone_oldPhone.getBrand());
    System.out.println("Btw, this is an oldPhone-oldPhone object");

    OldPhone old_mobile = new MobilePhone("(old-mobile) Eriksson");
    System.out.println("Brand should be Eriksson: " + old_mobile.getBrand());
    old_mobile.call("1_0207 342 436");
    old_mobile.call("2_0208 111 245");
    old_mobile.call("3_01923 234 209");
    old_mobile.call("4_02323 2334 21109");
    old_mobile.call("5_07989 203 4593");
    old_mobile.call("6_076083 134 445");
    old_mobile.call("7_0118 475 942");
    old_mobile.call("8_0870 123 234");
    old_mobile.call("9_0800 3435 1029");
    old_mobile.call("10_0900 439 3493");
    old_mobile.call("11_11442 343 900");
    old_mobile.call("12_3356 452 230");
    old_mobile.call("13_2346 334 32400");
    old_mobile.call("14_34678 222 540");
    System.out.println("Note: old_mobile.playGame() will not compile (regardless of visibility).");
    System.out.println("Hence, as before, none of the methods in run-time type (here MobilePhone) which are not in the compile-time type (here OldPhone) can be used with old_mobile.");
    System.out.println("Note also, the brand, which is retrieved by the method in OldPhone, is set by SmartPhone's constructor, (which chains with constructors in MobilePhone and OldPhone).");

    OldPhone old_smart = new SmartPhone("(old-smart) iPhone1");
    old_smart.call("0207 342 436");
    old_smart.call("0207");
    old_smart.call("0208 111 245");
    old_smart.call("001923 234 209");
    old_smart.call("+002323 2334 21109");
    old_smart.call("+07989 203 4593");
    System.out.println("Brand should be iPhone1: " + old_smart.getBrand());

    MobilePhone mobile_mobile = new MobilePhone("(mobile-mobile) Sony");
    System.out.println("Brand should be Sony: " + mobile_mobile.getBrand());
    mobile_mobile.call("1_0207 342 436");
    mobile_mobile.call("2_0208 111 245");
    mobile_mobile.call("3_01923 234 209");
    mobile_mobile.call("4_02323 2334 21109");
    mobile_mobile.call("5_07989 203 4593");
    mobile_mobile.call("6_076083 134 445");
    mobile_mobile.call("7_0118 475 942");
    mobile_mobile.call("8_0870 123 234");
    mobile_mobile.call("9_0800 3435 1029");
    mobile_mobile.call("10_0900 439 3493");
    mobile_mobile.call("11_11442 343 900");
    mobile_mobile.call("12_3356 452 230");
    mobile_mobile.call("13_2346 334 32400");
    mobile_mobile.call("14_34678 222 540");
    mobile_mobile.printLastNumbers();
    mobile_mobile.playGame("(mobile-mobile) pacman");

    MobilePhone mobile_smart = new SmartPhone("(mobile-smart) Nokia");
    mobile_smart.playGame("(mobile-smart) pacman");
    System.out.println("with the overriden playGame() method in smartPhone commented out, mobile-smart can still call playGame() which is written in MobilePhone.");
    System.out.println("Now, for ex 10.4.2, the overriden playGame() method in smartPhone is put back in, it works fine as public, but if I reduce the visibility in SmartPhone's playGame() to protected or private, it will not compile.");
    System.out.println("The visibility of playGame() in SmartPhone can be reduced to protected, but only if that of MobilePhone's playGame() is reduced to protected as well. The visbility of the base class can not be greater than that in the derived class");

    SmartPhone smart_r_smart = new RestrictedSmartPhone("smart-r_smart iPhone2");
    smart_r_smart.browseWebFor("chocolate");
    smart_r_smart.findPosition();
    System.out.println("Brand should be iPhone2: " + smart_r_smart.getBrand());
    smart_r_smart.playGame("(smart-r_smart) pacman");

  }

}
