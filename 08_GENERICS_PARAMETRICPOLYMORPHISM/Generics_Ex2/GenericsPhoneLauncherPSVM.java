// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex2
// Exercise 11.2: Casting types and introducing parametric polymorphism (aka Generics).
/*
11.2.1.
Create a script that builds a new SmartPhone with the line:
Smartphone myPhone = new Smartphone();
and then uses all its methods.

11.2.2.
Direct Upcasting.
Change the script so that the SmartPhone is created with the line:
MobilePhone myPhone = new SmartPhone();
Compile your code again. Are there any problems? Why do this problems happen?
What are the possible solutions?
ANSWER:
Compilation error - because at compile time, the Mobile_Smart object only has methods
that are in MobilePhone and its superclasses. SmartPhone is a subclass of MobilePhone so
findPosition() and browseWebFor(String) are not available at compile time.
Possible solutions are:
- upcast the myPhone object to a SmartPhone before calling the two smart methods.
(Not sure if/how one might use generics to solve this instead of upcasting.)


11.2.3.
Pass this object to a method testPhone(Phone) that has only one parameter of type Phone.
What methods can you call on the object inside the method?
ANSWER:
Can only call the one method that is described in Phone. (i.e. call(String))

11.2.4.
Inside the former method, downcast the object to SmartPhone so that you can use all the
public methods of SmartPhone.

11.2.5.
Create a MobilePhone object and then pass it to method testPhone(Phone). What happens?
ANSWER:
If MobilePhone p = new MobilePhone(), then you get a ClassCastException.
But if MobilePhone p = new SmartPhone(), no exceptions are thrown.

*/

/*
So I guess what all this is eluding to is that there are some issues around casting
and inheritance that presumably Generics may be able to partially alleviate.
The problem highlighted in 11.2.3-11.2.5 might be partially alleviated by writing
testPhone(Phone) as a Generic method....?
*/
import interfacePhone.Phone;

public class GenericsPhoneLauncherPSVM {

  public static void main(String[] args) {
    // written out for 11.2.1
    SmartPhone smart_smart = new SmartPhone();
    smart_smart.browseWebFor("birthday");// does not compile with Mobile_Smart object.
    smart_smart.call("0207 342 436");
    smart_smart.findPosition();// does not compile with Mobile_Smart object.
    System.out.println("...should say \'no brand was given\': " + smart_smart.getBrand());
    smart_smart.playGame("space invaders");
    smart_smart.printLastNumbers();
    smart_smart.ringAlarm("**boopidoopydoo**");

    // written for 11.2.2
    MobilePhone mobile_smart = new SmartPhone();// this gives compilation error (findPosition() and browseWebFor())
    // upcasting as a solution for 11.2.2
    SmartPhone smartUp_smart = (SmartPhone) mobile_smart;

    smartUp_smart.browseWebFor("birthday");// does not compile with Mobile_Smart object.
    smartUp_smart.call("0207 342 436");
    smartUp_smart.findPosition();// does not compile with Mobile_Smart object.
    System.out.println("...should say \'no brand was given\': " + smartUp_smart.getBrand());
    smartUp_smart.playGame("space invaders");
    smartUp_smart.printLastNumbers();
    smartUp_smart.ringAlarm("**boopidoopydoo**");

    testPhone(smartUp_smart); // remember smartUp_smart was a Mobile_SmartPhone object (line 64)
    // which downcasted to SmartPhone (line 66). Notice then that the object needs to be
    // downcasted yet again to SmartPhone inside the method body of testPhone(). It seems
    // to get upcast to Phone via the method's formal argument. But this appears not to be
    // the whole story.

    // MobilePhone mPhone = new MobilePhone(); // this object cannot use SmartPhone's methods..
    // testPhone(mPhone); // ..inside testPhone() because it cannot be downcast to SmartPhone.

    // The upcasting to Phone that appears to happen when passing a subclass object to the
    // testPhone(Phone) method, is restricted. The object that is passed as a SmartPhone
    // can be downcast to SmartPhone again inside the method body, but a MobilePhone object
    // throws the following exception:
    // a ClassCastException: MobilePhone cannot be cast to SmartPhone (on line 100)

    // MobilePhone msPhone = new SmartPhone(); // is fine to be downcast to SmartPhone..
    // testPhone(msPhone); // ..inside testPhone() method.

  }

  public static void testPhone(Phone phone) {

    System.out.println("\ninside testPhone(Phone)");
    phone.call("20394820934");
    SmartPhone phone2 = (SmartPhone) phone; // downcasting for 11.2.4,
    // hence even when the object passed to testPhone() is a SmartPhone,
    // it still needs to be downcast again to be able to use SmartPhone's methods.
    // Two further oddities here are that if a mobile_mobile object is passed
    // to this method, an exception is thrown if you attempt to downcast it to
    // SmartPhone.
    // However, if you pass a smart_smart object to this method, it is ok to
    // upcast it to MobilePhone. i.e. MobilePhone phone2 = (MobilePhone) phone;
    phone2.browseWebFor("tomato island");// this is a SmartPhone method
    System.out.println(phone2.findPosition());// this is a SmartPhone method
    phone2.playGame("Kickoff");// this is a MobilePhone method
    phone2.printLastNumbers();// this is a MobilePhone method

  }

/*
This following generic method does not resolve the problem encoutered above using a
non-generic method. Namely, that mobile_mobile object cannot be downcast to SmartPhone
inside the method body
*/
  public static <T extends Phone> void testPhone2(T phone) {

    System.out.println("\ninside generic method testPhone(Phone)");
    phone.call("20394820934");
    SmartPhone phone2 = (SmartPhone) phone;
    phone2.browseWebFor("tomato island");
    System.out.println(phone2.findPosition());

  }

}
