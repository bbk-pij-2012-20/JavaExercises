// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/08_GENERICS_PARAMETRICPOLYMORPHISM/Generics_Ex5_Stack
// Exercise 11.5: Intro to parametric polymorphism (aka Generics).
/*
Create a generic stack (with methods for pushing, popping, and checking emptiness) that only works with classes
that extend Number (e.g. Integer and Double, but not String).
*/

public class GenericStack<T extends Number> {

  private Node topOfStack;

  public static void main(String args[]) {

    GenericStack<Double> stack1 = new GenericStack<>();
    System.out.println("new generic double stack isEmpty() should return true: " + stack1.isEmpty());
    GenericStack<Double>.Node node1 = stack1.new Node(1.23);
    stack1.push(node1);
    System.out.println("top of stack should be 1.23: " + stack1.pop().getElement());

  }


  public GenericStack(){

    topOfStack = null;

  }

  public boolean isEmpty() {

    boolean empty = false;

    if (topOfStack == null) {

      empty = true;

    }

    return empty;

  }

  public void push(Node element) {

    if (isEmpty()) {

      topOfStack = element;

    } else {

      topOfStack.next = element;
      topOfStack = element;

    }

  }

  public Node pop() {

    try {

      if (topOfStack == null) {

        throw new Exception("Stack is empty, nothing to pop");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

    return topOfStack;

  }

  private class Node {

    private T element;
    private Node next;

    public Node(T element) {

      this.element = element;
      next = null;

    }

    public T getElement() {

      return element;

    }

  }

}
