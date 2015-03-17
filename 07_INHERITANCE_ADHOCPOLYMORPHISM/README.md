<h1>Ad hoc polymorphism (aka inheritance)</h1>

Ad hoc polymorphism is practised here, the use of the Java Interface, Abstract Classes and
(Concrete) Classes.

Exercise 10.1-10.4:
Phones exercise demonstrates the use of Interface and Concrete classes to add increasing
functionality. It also demonstrates that subclasses can not use visibility modifiers
(public, default, protected, private) to restrict functionality, subclasses must always have equal or greater visibility.

Exercise 10.5:
Musical Instruments exercise demonstrates multiple inheritance, which is possible in Java 7 only
when inheriting from interfaces.

Exercise 10.6:
Teaching staff exercise demonstrates a bit of constructor chaining.

Exercise 10.7:
Shows effect of keyword Final on a class. It prevents the class being derived.

Exercise 10.8:
The Noah's Ark exercise allowed me to understand the interplay between minimising code repetition and the creating interfaces and classes to aid the semantics and abstraction of
the model.
For example, I could have made the 5 animal classes (Amphibia, Arthropoda etc) concrete instead of abstract classes. I could have left out the abstract makeSound() method but
chose to include it, thereby making the classes abstract, purely to emphasise that there is likely to be similarities in the sort of noises made by each of the 5 animal classes.
It also allowed me to experience creating a mixture of interface, abstract and concrete classes.

I noticed also that by applying the object-oriented principle that derived classes should not reduce functionality of superclass(es), code reptition is again sacrificed. This was in the
case of reproduce() method which is calls layEggs() in all animal classes except Mammalia.
Thus code repetition could have been reduced by moving the layEggs() method up to Vertebrata
and then overriding the method to call giveBirth() in mammalia.

As some of the previous ones, this also served as an exercise in how to annotate the 'packages' and 'imports' for each of the classes which were subdivided into subfolders.
(In fact, this was problematic from the text editor, but easily done in Eclipse.)
