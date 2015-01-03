// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/SortingAlgorithms
// Exercise 7.12 (Using data structures & pointers to implement Sorting Algorithms)
/*
Cocktail sort is a combination of two bubble sorts. 
First the list is traversed in one direction to move the highest element to the end, and 
then it is traversed in the opposite direction to move the lowest element to the beginning.
This bidirectional process is repeated until there are no swaps in the list, which shows 
that the list is sorted. 
Implement cocktail sort in a static method in a class, maybe ListUtilities.cocktailSort(List). 
The name of the algorithm comes from a metaphorical cocktail shaker moving up and down, up and down. . .
Try your method with the same lists as bubble sort and see how long it takes to sort them.
*/

//first I'll make a doubly linked list. Then call ListUtilities to sort it. CocktailSort will call two private methods to call
public class CocktailSort {
	
	public static void main(String[] args) {
	
		CocktailSort cs = new CocktailSort();
		List list = new List();
//		System.out.println("Before making list: ");
//		list.print();

		list = cs.makeDLL();
		System.out.println("After making list: ");
		list.print();
		ListUtilities.cocktailSort(list);
		System.out.println("After sorting list: ");
		list.print();
	
	}
	
	public List makeDLL() {
	
		
		List list = new List();
/*		add(list, new Node(5));
		add(list, new Node(12));
		add(list, new Node(1));		
		add(list, new Node(8));
		add(list, new Node(213));
		add(list, new Node(356));
		add(list, new Node(53));
		add(list, new Node(973));
		add(list, new Node(34));		
		add(list, new Node(67));
		add(list, new Node(50));
		add(list, new Node(2));
*/
		add(list, new Node(5));		
		add(list, new Node(1));
		add(list, new Node(2));
		add(list, new Node(4));
/*		add(list, new Node(5));
		add(list, new Node(6));
		add(list, new Node(7));
		add(list, new Node(8));
		add(list, new Node(9));
		add(list, new Node(10));
		add(list, new Node(11));
		add(list, new Node(12));
*/		
		return list;
																					
	}
	
	public void add(List list, Node node) {
		
		if (list.getFirst() == null) {
			
			list.setLast(node);
			list.setFirst(node);
		
		} 
		
		else {
		
			list.getFirst().add(node, list);
		
		}
	
	}
	
}

class List {

	private Node first = null;
	private Node last = null;
	
	public Node getFirst() {
	
		return first;
	
	}
	
	public Node getLast() {
	
		return last;
	
	}
	
	public void setFirst(Node node) {
	
		first = node;
		first.setPrevious(null);
	
	}
	
	public void setLast(Node node) {
	
		last = node;
		last.setNext(null);
	
	}
	
	public void print() {
			
		if (first == null) {
		
			System.out.println("Empty list.");
		
		} else {
		
			first.print();
		
		} 
	
	}

}

class Node {

	private Node previous = null;
	private Node next = null;
	private int n = 0;
	
	public Node(int n) {
	
		this.n = n;
	
	}
	
	public void add(Node node, List list) {
	
		if (next == null) {
		
			next = node;
			node.previous = this;
			list.setLast(node);
		
		} else {
		
			next.add(node, list);
		
		}
	
	}
	
	public int getN() {
	
		return n;
	
	}
	
	public Node getNext() {
	
		return next;
	
	}
	
	public Node getNextNext() {
	
		return next.next;
	
	}
	
	public Node getPrevious() {
	
		return previous;
	
	}
	
	public Node getPreviousPrevious() {
	
		return previous.previous;
	
	}
	
	public void setNext(Node node) {
	
		next = node;
	
	}
	
	public void setPrevious(Node node) {
	
		previous = node;
	
	}
	
	public void print() {
	
		System.out.println("Node n: " + n);
		
		if (next != null) {
		
			next.print();
		
		}
		
	}
	
}

class ListUtilities {

	public static void cocktailSort(List list) {
	
		Node first = list.getFirst();
		Node last = list.getLast();
	
		boolean startedToSort = false;
		boolean sorted = false;

		try {

			if (first == null) {

				throw new NullPointerException("Nothing to sort, list is empty.");
			
			} else if (first.getNext() == null) {

				throw new NullPointerException("Nothing to sort, list only has one Node.");
				
			} else if (first.getNext() == last) { //only two in the list

				if (first.getN() > first.getNext().getN()) {				

					last.setNext(first);
					last.setPrevious(null);
					first.setNext(null);
					first.setPrevious(last);
					list.setFirst(last);
					list.setLast(last.getPrevious());
					
				} 
				
				return;

			}

			startedToSort = true;

			while (!sorted) {

				sorted = sort(list, first, startedToSort);
//				sorted = sortRev(list, last, startedToSort);
				
			}

			
		} catch (NullPointerException e) {

			e.printStackTrace();
			//System.out.println(e.getMessage());
		
		}
		
	}	

	private static boolean sort(List list, Node node, boolean sorted) {

		boolean sorted2 = sorted;	
			
		if (node == list.getLast()) {

			return sorted2;

		}
		
		Node nextNextNode = null;
		Node nextNode = node.getNext();
		Node prevNode = null;

		if (nextNode.getNext() != null) {
		
			nextNextNode = node.getNextNext();
			
		}
		
		if (node.getPrevious() != null) {
		
			prevNode = node.getPrevious();
		
		}
		
		if (node.getN() > nextNode.getN()) {

			sorted2 = false;
			node.setPrevious(nextNode);
			nextNode.setNext(node);

			if (nextNode == list.getLast()) {
			
				list.setLast(node);
			
			} else {
			
				node.setNext(nextNextNode);
				
				if (nextNextNode != null) {

					nextNextNode.setPrevious(node);
	
				}
	
			}
	
			if (node == list.getFirst()) {

				list.setFirst(nextNode);

			} else {
			
				nextNode.setPrevious(prevNode);
				prevNode.setNext(nextNode);
				
			}
		
		}	

		return sorted2 && sort(list, nextNode, sorted);
			
	}

/*	private static boolean sortRev(Node node, boolean sorted) {
	
		boolean sorted2 = sorted;	
				
		if (node.getPrevious().getPrevious().getPrevious() == null) {
		
			if (node.getPrevious().getPrevious().getN() > node.getPrevious().getN()) {
			
				sorted = false;
				list.setFirst(mid2);
				mid2.setPrevious(null);
				mid2.setNext(mid1);
				mid1.setNext(after);
				mid1.setPrevious(mid2);
				after.setPrevious(mid1);
				
			}
			
			return sorted;
		
		} else {
			
			mid1 = node.getPrevious().getPrevious();
			before = node.getPrevious().getPrevious().getPrevious();

		}

		if (after == last) {
		
			if (mid2.getN() > after.getN()) {
			
				mid2.setNext(null);
				after.setPrevious(mid1);
				mid1.setNext(after);
				after.setNext(mid2);
				mid2.setPrevious(after);
				list.setLast(after);
			
			}
		
		} else if (mid1.getN() > mid2.getN()) {		
		
			sorted2 = false;
			after.setPrevious(mid1);
			before.setNext(mid2);
			mid1.setPrevious(mid2);
			mid2.setNext(mid1);
			mid2.setPrevious(before);
			mid1.setNext(after);
					
		} 		
		
		return sorted2 && sortRev(node.getPrevious(), sorted);
	
	}*/
	
}