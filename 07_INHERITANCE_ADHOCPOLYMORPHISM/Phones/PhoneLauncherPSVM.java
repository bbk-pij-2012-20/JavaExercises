//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Phones
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
import interfacePhone.Phone;

public class PhoneLauncherPSVM {

  public static void main(String[] args) {

  //  Phone phone = new OldPhone();
  //  phone.call("0207 342 436");
/*
    MobilePhone mobile = new MobilePhone();
    mobile.call("1_0207 342 436");
    mobile.call("2_0208 111 245");
    mobile.call("3_01923 234 209");
    mobile.call("4_02323 2334 21109");
    mobile.call("5_07989 203 4593");
    mobile.call("6_076083 134 445");
    mobile.call("7_0118 475 942");
    mobile.call("8_0870 123 234");
    mobile.call("9_0800 3435 1029");
    mobile.call("10_0900 439 3493");
    mobile.call("11_11442 343 900");
    mobile.call("12_3356 452 230");
    mobile.call("13_2346 334 32400");
    mobile.call("14_34678 222 540");
    mobile.printLastNumbers();
*/
    OldPhone old_Mobile = new MobilePhone("Eriksson");
    System.out.println("Brand is: " + old_Mobile.getBrand());
//  oldMobile.playGame("kickoff on mobile phone, (OldPhone .. = new MobilePhone())");
//  this won't compile (playGame() still public)

//NB: THE METHOD CALL IN SMART PHONE IS NOT COMPLETED YET (NEED TO COMPLETE THE REG EXPRESSION)
    OldPhone old_Smart = new SmartPhone("iPhone");
    old_Smart.call("0207 342 436");
    old_Smart.call("0208 111 245");
    old_Smart.call("001923 234 209");
    old_Smart.call("+002323 2334 21109");
    old_Smart.call("+07989 203 4593");
    System.out.println("Brand is: " + old_Smart.getBrand());
//  iPhone.playGame("speedball on smart phone, (OldPhone .. = new SmartPhone())");
//  this won't compile (playGame() still public)

    MobilePhone mobile_Smart = new SmartPhone("Nokia");
    mobile_Smart.playGame("pacman on mobile (Mobile .. = new SmartPhone())");

    SmartPhone smart_Smart = new SmartPhone("iPhone2");
    smart_Smart.browseWebFor("chocolate");
    smart_Smart.findPosition();
    System.out.println("Brand is: " + smart_Smart.getBrand());
    smart_Smart.playGame("tictactoe on smart phone, (SmartPhone .. = new SmartPhone())");

  }

}
