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

The code compiles. So there are no compilation flaws.

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

1. Mutable objects that are shared are kept as mutable.

When this is the case, there should be mechanisms put in place to make the
mutable object(s) 'thread-safe'.

These include placing locks on sections of code, the most simple way to achieve
this is by use of the 'synchronized' keyword.

It can also involve the requirement to make 'defensive copies' of mutable
objects that are initialised in more than one thread.


Broadly-speaking, this seems to be the approach taken in the example teacherCode.
However, if one introduces the use of defensive copying in a new constructor in
MutableIDCard, the output changes. Where as the output of the unchanged
teacherCode varies between John and Mary, a modified form that includes the
creation of defensive copies seems to always have the same output, namely John.

MutableIDCard is the object that gets shared between different threads. It is
vulnerable because it has two mutable fields: Date and BufferedImage.

It also has a mutator in the form of set(String, Date, BufferedImage) (which
has public access). The teacherCode wraps the assignments to the MutableIDCard
fields in a synchronized block. The accessors in MutableIDCard are also
synchronized.

Another class DataGenerator uses synchronized to lock its (static) getters.
This means the three DataGenerator accessors calls in the PSVM right at the
start of the execution will be called by one thread at a time.. I think ..


----

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


----

Use of Volatile?

Of the two threads (Citizen and Officer), only Officer calls the mutator, hence
only one thread writes to this variable while the other only reads from it. As
such, one might also apply the 'volatile' keyword here to make it thread-safe.
This would be in place of final.
