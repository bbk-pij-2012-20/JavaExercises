// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/SortingAlgorithms
// Exercise 7.11 (Using data structures & pointers to implement Sorting Algorithms)
/*
In this exercise, you will implement the bubble sort algorithm and use it to sort an unsorted linked list of integers.
The bubble sort algorithm is the simplest sorting algorithm there is:
1. Take the first element. Compare it with the second element. If it is greater, make them change positions (first
becomes second and viceversa); otherwise, do nothing.
2. Move to the next element. Repeat the process (i.e. compare 2 and 3, then 3 and 4, up to the last element).
3. Now you have the highest element at the end of the list.
4. Move back to the beginning and repeat the whole process until your list is sorted.
5. Once you pass through the list without swapping elements, your list is sorted.
Put your implementation in a static method in a class, maybe ListUtilities.bubbleSort(List). The name
of the algorithm comes from metaphorical bubbles always moving up in a liquid.
Try your method with different lists and see how long it takes to sort them. You can use the static method
System.currentTimeMillis() to print on the screen the current time (measured in milliseconds since 1st January
1970).
*/


/*
Bubble sort (like cocktail sort & quick sort) is an O(n^2) at worst, 

- a 'comparison' sort.
- a quadratic algorithm (like selection sort)

*/
public class BubbleSort {

	private Node first = null;
	
	public static void main(String[] args) {
	
		BubbleSort bs = new BubbleSort();
		bs.makeSLL();
		bs.sort();
		System.out.println("\nafter sorting list");
		bs.print();
		
	}
	
	public void makeSLL() {
	
		Node node0 = new Node(10);
		Node node1 = new Node(1);
		Node node2 = new Node(25);
		Node node3 = new Node(12);		
		Node node4 = new Node(248);
		Node node5 = new Node(14);
		Node node6 = new Node(125);
		Node node7 = new Node(642);		
		Node node8 = new Node(38);
		Node node9 = new Node(67);
		Node node10 = new Node(19);
		System.out.println("at start");
		print();
		add(node0);
		add(node1);
		add(node2);
		add(node3);
		add(node4);
		add(node5);
		add(node6);
		add(node7);
		add(node8);
		add(node9);
		add(node10);
		System.out.println("after making list");
		print();
				
	}
	
	public void add(Node node) {
	
		if (first == null) {
		
			first = node;
		
		} else {
		
			first.add(node);
		
		}
		
	}
	
	public void sort() {

		Node temp = first;
		boolean sorted = false;

		if (first.getN() > first.getNext().getN()) {
	
			first = first.getNext();
			temp.setNext(first.getNext());			
			first.setNext(temp);

		}

		while (!sorted) {
			
			sorted = first.sort(true);

		}

	}
	
	private void print() {
		
		if (first == null) {
		
			System.out.println("empty list");
		
		} else {
		
			first.print();
		
		}
	
	}
	
}

class Node {

	private Node next = null;
	private int n = 0;
	
	public Node(int n) {
	
		this.n = n;
		next = null;
	
	}

	public int getN() {
	
		return n;
	
	}
	
	public Node getNext() {
	
		return next;
	
	}
	
	public void setNext(Node node) {
	
		next = node;
	
	}
	
	public void add(Node node) {
	
		if (next == null) {
		
			next = node;
		
		} else {
		
			next.add(node);
		
		}
	
	}
	
	public boolean sort(boolean unchanged) {

		boolean unchanged2 = unchanged;
		
		if (next == null) {
	
			return unchanged;
		
		} else {
			
			if (next.next != null && next.n > next.next.n) {
		
				Node temp = next;
				next = next.next;
				temp.next = next.next;
				next.next = temp;
				unchanged2 = false;
				
			}

			return unchanged && next.sort(unchanged2);

		}
		
	}
	
	
		
	public void print() {
	
		System.out.println("node: " + n);
	
		if (next != null) {
		
			next.print();
		
		}	
	
	}

}