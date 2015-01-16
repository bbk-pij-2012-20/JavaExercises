// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/Stack
// Exercise 7.8 (Introduction to data structures & pointers)
/*
A stack is a dynamic structure that implements these methods:

push(...) inserts an element at the beginning of the stack.

pop(...) remove an element from the beginning of the stack.

empty(...) returns true if there are no elements on the stack, false otherwise.

Stacks are heavily used in computing. The method call stack that stores the variables for each method in a
program is just one well-known example.
Implement a stack of integers. This could represent requests to a hard drive to read from different sectors.
Implement the three methods listed above.
Then write another class that creates a stack, and makes several push(), and pop() calls. Make sure you check
the size of the stack before popping elements out. Check that the values you get are consistent. The output of the
program could look like this:
Pushing 5...
Pushing 8...
Pushing 12...
Popping... it’s a 12
Pushing 13...
Popping... it’s a 13
Popping... it’s a 8
Popping... it’s a 5
Stack is empty
*/

/*
empty list:

null <- top
---------------------------------------------------
single-node list:

node <- top
 | (next)
 V
null
---------------------------------------------------
2 or more-node list:

node <- top
 | (next)
 V
node
 | (next)
 V
node 
 | (next)
 V
null
---------------------------------------------------
Hence only ever need one pointer.
*/

public class StackMain {

	public static void main(String[] args) {
	
		Stack s = new Stack();
		StackMain sm = new StackMain();
		
		System.out.println();
		sm.popping(s);
		sm.pushing(s, 1);
		sm.pushing(s, 20);	
		sm.pushing(s, 5);
		sm.popping(s);//should be 5
		sm.pushing(s, 1234);
		sm.popping(s);//should be 1234
		sm.popping(s);// should be 20
		sm.popping(s);// should be 1
		System.out.printf("\nStack is %sempty\n", s.empty()? "" : "not ");
		
	}
	
	private void pushing(Stack s, int n) {
	
		s.push(n);
		System.out.printf("\nPushing %d...",n);
	
	}
	
	private void popping(Stack s) {
			
		Stack.Node node = s.pop();
		
		if (node != null) {
	
			int n = node.getN();
			System.out.printf("\nPopping... it's a %d", n);
		
		}
		
	}

}

class Stack {

	private Stack.Node top = null; // (referred to as 'beginning' in exercise specification)
	
	public Stack () {
	
		top = null;
	
	}
	
	//inner class. Not private so that StackMain's popping can instantiate it.
	protected class Node {
		
		private Node next;
		private int n;
		
		public Node(int n) {
		
			this.n = n;
			next = null;
	
		}	
		
		public int getN() {
	
			return n;
	
		}
			
	}
	
	public Stack.Node pop() {
	
		Stack.Node result = null;
		
		try {
		
			if (empty()) {
		
				throw new NullPointerException("\nCan't pop an empty stack jack!");
			
			}
			
			result = top;
			top = top.next;
			
		} catch (NullPointerException e) {
					
			System.out.println(e.getMessage());
	
		}
	
		return result;

	}
	
	public void push(int n) {
	
		Stack s = new Stack();
		Stack.Node node = s.new Node(n); 
		
		if (empty()) {
		
			top = node;
		
		} else {
		
			node.next = top;
			top = node;
		
		}
		
	}
	
	public boolean empty() {
	
		return top == null;
	
	}
		
}