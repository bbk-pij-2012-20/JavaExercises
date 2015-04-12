<h1>Parametric polymorphism (aka generics)</h1>

6 exercises on type-casting and the parametric polymorphism.

Exercise 11.1:
The complete code for a simple class called 'Comparator' is given. It has three methods that essentially do the same thing. Each method, however, deals with a different
type (either strings, integers or doubles).
The exercise demonstrates how type-casting can help reduce code repetition.
My first solution 'Comparator1' class achieves this with one method replacing three.
However, the type-casting must be done before the parameters can be passed to the one method, because the method only takes strings.
Thus, the type-casting is down at compile time, in contrast to how this would be achieved by use of Generics.
So, the second solution, 'Comparator2', uses parametric polymorphism that allows one method to take any type (string, double or int) and return the same type.
The advantage of this is that method is more flexible than that in 'Comparator1' in that the same code can be used again with different types. The type is given at compile time, so the compiler provides some 'type safety'.

Exercise 11.2:
This involves demonstrating the rules of upcasting and downcasting, hence has some overlap with inheritance (i.e. the previous set of exercises) and in fact re-uses
the code from the Phones inheritance exercise (Ex 10.1-10.4 in subdirectory labelled "07_INHERITANCE_ADHOCPOLYMORPHISM").

Exercise 11.3:
The doubly-linked list, re-used from the previous data structurs exercise (Ex 7.5 in subdirectory labelled "05_DATA_STRUCTURES"), is editted to be a generic doubly-linked list.

Exercise 11.4:
The generic doubly-linked list from Ex 11.3 is subclassed and converted into a sorted list by overriding the relevant method(s).

Exercise 11.5:
Building a generic stack, using bounded types.

Exercise 11.6:
Building a generic map, including a generic hash table.
