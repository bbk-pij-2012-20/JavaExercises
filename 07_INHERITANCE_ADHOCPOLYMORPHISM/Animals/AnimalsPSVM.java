//cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/07_INHERITANCE_ADHOCPOLYMORPHISM/Animals
//Exercise 10: Introduction to inheritance (aka ad hoc polymorphism).

public class AnimalsPSVM {

  public static void main(String[] args) {

  //	Animal d=new Dog();  	// This also works
  //	Animal a=new Animal();	// This does not work cos Animal is abstract (can't be instantiated)
    Dog d = new Dog();
    d.move(10);
    System.out.println("Doggy says " + d.makeSound());
    d.breath(25);
    System.out.printf("Doggy's panting %s", d.oxygen > 5? "heavily\n" : " ..not so much\n");
    Animal h = new Human();
    h.move(10);
    System.out.println("Human says " + h.makeSound());
    h.breath(25);
    System.out.printf("Human's wheezing %s", h.oxygen > 5? "heavily\n" : " ..not so much\n");

  }

}
