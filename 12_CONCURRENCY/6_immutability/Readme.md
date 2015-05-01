ImmutableExample exercise 17.6
----

With regards to the example code supplied by the teacher, the exercise states
the following:
"Look at the example program of 5 classes (ImmutableExamplePSVM, Officer, Citizen,
DataGenerator, MutableIDClass). Read it carefully.
- Do you see any flaws?
- If yes, what would you change to make the program work without problems?
- What would you change to make the IDCard class immutable?"


--

The code compiles, (so there are no compilation 'flaws').

Running the code gives the following output, (which is clearly non-deterministic):

the name on this id is Mary
and the date of birth is Tue Mar 12 00:00:00 GMT 1985

run again:
the name on this id is John
and the date of birth is Wed Jun 23 00:00:00 GMT 1971

run again:
the name on this id is Mary
and the date of birth is Tue Mar 12 00:00:00 GMT 1985

etc. the output is always either Mary or John.
The DOB for either never changes.
Lisa never seems to appear.

So, whether there is a flaw or not I guess really depends on what the code is
intended to do.
If it is intended that Officer flips the identity of the output in a
non-deterministic manner, then there is nothing wrong with it.
If it isn't, then this is the flaw...

The names and DOBs are never mixed up so the threads do not appear to conflict
to generate incorrect information.

So, it seems to be thread-safe, and non-deterministic.

----
I now consider the possible changes to the code that can be made and discuss
what effects they seem to have.


There are essentially two overall approaches one could take with concurrently
run threads that involve (a) shared variable(s).

1. Mutable objects that are shared are kept as mutable, but protected with locks.

A relatively simple way to achieve thread-saftey with locks is by use of the
'synchronized' keyword.

This is simply but might also require making 'defensive copies' of mutable
objects that are initialised in more than one thread.


2. Objects that are shared are made immutable.

How to make objects immutable is described by Bloch (Effective Java, 2nd Ed 2008).
Paraphrasing the five rules:

1. don’t provide any mutators.
2. make the class final.
3. make all fields final.
4. make all fields private.
5. ensure exclusive access to any mutable components:
  . If your class has any fields that refer to mutable objects, ensure that
     clients of the class cannot obtain references to these objects.
  . Never initialise such a field to a client-provided object reference or
     return the object reference from an accessor.
  . Make defensive copies in constructors, accessors, and readObject methods.

--

Broadly-speaking, the teacherCode appears to be applying the first approach,
namely to keep mutable objects mutable but maintain thread-safety with use of
synchronized keyword.

However, if one modifies the teacherCode by introducing the use of defensive
copying (to a new constructor in MutableIDCard), the code produces a different
output.
Whereas the output used to flip non-deterministically between John and Mary,
the modified code that includes the creation of defensive copies seems to always
have the same output, (namely John).

MutableIDCard is the mutable object that gets shared between different threads.
It is mutable because it has two mutable fields: Date and BufferedImage.

It also has a mutator in the form of set(String, Date, BufferedImage) (which
has public access).

The teacherCode wraps the assignments to the MutableIDCard fields in a
synchronized block. The accessors in MutableIDCard are also synchronized.

DataGenerator class also uses synchronized to lock its (static) getters.
This means the three DataGenerator accessors calls in the PSVM right at the
start of the execution will be called by one thread at a time.. I think ..

---

Approach no2, making MutableIDCard immutable.




----

How about using volatile keyword instead of final?

Of the two threads (Citizen and Officer), only Officer calls the mutator, hence
only one thread writes to this variable while the other only reads from it. As
such, one might also apply the 'volatile' keyword here to make it thread-safe.
This would be in place of final.