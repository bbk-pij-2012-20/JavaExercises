// cd ~/Desktop/all_pooled/computing/CODING/JavaExercises/05_DATA_STRUCTURES/LINKED_LISTS/SortingAlgorithms
// Exercise 7.13 (Using data structures & pointers to implement Sorting Algorithms). Difficulty level: very.
/*
This is a popular sorting algorithm that is very fast in most situations. Once you have finished all the other exercises,
look up in Wikipedia how this method works and make your own implementation (put it in ListUtilities.quickSort(List)).
Then compare its performance with the other two methods. In order to see significant differences, you will need to
use lists of some length.
*/

/*
Like bubble sort & cocktail sort, quick sort is at worst a O(n^2) algorithm
(where n is number of elements). However, quick sort typically acts more like
an O(n log n) algorithm.
The reason for this better performance is that quick sort is comparing and
moving values very efficiently without shifting, which means it will only be
comparing numbers once. So in essence, each comparison will reduce the possible
final sorted list in half, or in other words, to log (n!) which is n log (n)

Quick sort is also known as a 'partition-exchange sort'.

Steps in quick sort:

1. randomly pick one element in a list. This is called the "pivot".
2. randomly partition the remainder of the list.
3. compare pivot with the elements and re-arrange according to their comparison with the pivot.

*/

public class QuickSort {

//	private List list = null;

	public QuickSort() {

//		list = new List();

	}

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		List list = new List();
		System.out.print("Before adding nodes to list: ");
		qs.print(list);
		qs.makeDLL(list);
		System.out.print("\nafter making list: ");
		qs.print(list);
		long start, end;
		start = System.nanoTime();
		qs.sort(list);
		end = System.nanoTime();
		System.out.println("\nit took: " + ((end - start) / 1000) + " microseconds");
		System.out.print("after sorting list: ");
//	qs.print(sortedList);// gives the same output
		qs.print(list);
		System.out.println();
	}

	public void makeDLL(List list) {

		add(list, list.new Node(5));
		add(list, list.new Node(67));
		add(list, list.new Node(2));
		add(list, list.new Node(985));
		add(list, list.new Node(36));
		add(list, list.new Node(56));
		add(list, list.new Node(1));
		add(list, list.new Node(34));
		add(list, list.new Node(10));
		add(list, list.new Node(2));
		add(list, list.new Node(7));
		add(list, list.new Node(4));
		add(list, list.new Node(1));
		add(list, list.new Node(341));
		add(list, list.new Node(340));

	}

	/**
	*	Directly adds node to empty list. Sets pointers to
	*	For lists larger than two nodes, calls sort method in List to sort list recursively by quicksort
	*/
	public void add(List list, List.Node node) {

		if (list.getFirst() == null) {

			list.pointFirstAt(node);
			list.pointLastAt(node);

		} else {

			list.getFirst().add(node);

		}

	}

	/**
	*	For lists larger than two nodes, calls sort method in List to sort list recursively by quicksort
	*/
	public void sort(List list) {

		List sortedList = list;

		try {

			if (list.listLength() < 2) {

				throw new IllegalArgumentException("...can't sort a list with only 1 node!");

			}

			sortedList.sort(sortedList.getFirst(), sortedList.getLast(), 0, 0);

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}

	/**
	*	Directly prints "empty" for empty list.
	*	For non-empty lists, prints by calling print method in List.
	*/
	public void print(List list) {

		if (list.getFirst() == null) {

			System.out.println("List is empty");

		} else {

			System.out.println(list.toString());

		}

	}

}

/**
*	List implemented as linked list of Nodes. Has nested Node class.
*/
class List {

	private Node first, last;

	public List() {

		last = first = null;

	}

	/**
	*	Sorts by quick sort, recursive calls.
	*/
	public void sort(Node first, Node last, int nL, int nR) {

		if (first == null || last == null || first == last) {

			return;

		}

		Node currentNode = first;
		Node pivot = last;
		int comparisonsToMake = -1 + listLengthBetween(first, last);
		int comparisonsMadeWithPivot = 0;
		Node currentNodePtr = currentNode;
		Node[] firstLast = {first, last};

		while (comparisonsMadeWithPivot < comparisonsToMake) {

			if (currentNode != pivot && (currentNode.n <= pivot.n)) {

				currentNodePtr = currentNodePtr.next;
				firstLast = insert(pivot, currentNode, firstLast[0], firstLast[1], "previous");
				comparisonsMadeWithPivot++;

			} else if (currentNode != pivot && (currentNode.n > pivot.n)) {

				currentNodePtr = currentNodePtr.next;
				firstLast = insert(pivot, currentNode, firstLast[0], firstLast[1], "next");
				comparisonsMadeWithPivot++;

			} else if (currentNode == pivot) {

				currentNodePtr = currentNodePtr.next;

			}

			currentNode = currentNodePtr;

		}

		pivot.sorted = true;
		Node firstLeft = firstLast[0];
		Node lastLeft = pivot.previous;

		if (firstLeft == lastLeft) {

			firstLeft.sorted = lastLeft.sorted = true;
			firstLeft = lastLeft = null;

		}

		if (lastLeft == null) {

			firstLeft = null;

		}

		Node firstRight = pivot.next;
		Node lastRight = firstLast[1];

		if (firstRight == lastRight) {

			firstRight.sorted = lastRight.sorted = true;
			firstRight = lastRight = null;

		}

		if (firstRight == null) {

			lastRight = null;

		}

		while (lastLeft != null && lastLeft != firstLeft && lastLeft.sorted != false) {

			lastLeft = lastLeft.previous;

		}

		while (firstLeft != null && lastLeft != firstLeft && firstLeft.sorted != false) {

			firstLeft = firstLeft.next;

		}

		int nLL = nL + 1;
		sort(firstLeft, lastLeft, nLL, nR);

		while (lastRight != null && lastRight != firstRight && lastRight.sorted != false) {

			lastRight = lastRight.previous;

		}

		while (firstRight != null && lastRight != firstRight && firstRight.sorted != false) {

			firstRight = firstRight.next;

		}

		int nRR = nR + 1;
		sort(firstRight, lastRight, nL, nRR); // and finally here is the recursion!

	}

	/**
	*	Calculates the length of list starting from first to last nodes in list.
	*/
	public int listLength() {

		return listLengthBetween(getFirst(), getLast());

	}

	/**
	*	Calculates the length of list starting from first to last nodes passed.
	*/
	public int listLengthBetween(Node first, Node last) {

		int length = 0;
		Node current = first;

		if (current != null) {

			length = 1;

		}

		while (current != last && current.next != null) {

			length++;
			current = current.next;

		}

		return length;

	}

	/**
	*	Returns string representation of list from start to end.
	*/
	@Override
	public String toString() {

		if (getFirst() == null) {

			return "List is empty";

		} else {

			return toString(getFirst());

		}

	}

	/**
	*	Returns string representation of list, but only starting from node passed to it.
	*/
	public String toString(Node node) {

		Node currentLastInList = node;

		while (currentLastInList.next != null) {

			currentLastInList = currentLastInList.next;

		}

		return toString(node, currentLastInList);

	}

	/**
	*	Returns string representation of list, starting from and ending at the nodes passed to it.
	*/
	public String toString(Node node, Node node2) {

		if (node == node2) {

			return "" + node2.n;

		} else {

			return node.n + " " + toString(node.next, node2);

		}

	}

	/**
	*	Takes nodeToMove and inserts it immediately up or downstream of pivot.
	*
	*                           pivot,   currentNode,     firstInPartition,       lastInPartition,     "next" or "previous"
	*/
	public Node[] insert(Node pivot, Node nodeToMove, Node first, Node last, String nextOrPrevious) {

		Node pivot_ = pivot;
		Node nodeToMove_ = nodeToMove;
		Node[] firstLast = {first, last};

		if (nextOrPrevious.equals("next")) {

			if (nodeToMove == first) {//if nodeToMove is first, first must be reassigned.

				firstLast[0] = nodeToMove.next;

				if (first == getFirst()) {//this would change the position of the

					pointFirstAt(nodeToMove.next);

				}

			}

			if (pivot == last) {//if pivot is last, last must be reassigned.

				firstLast[1] = nodeToMove;

			}

			if (nodeToMove == last) {//if nodeToMove is last, last might need reassigning

				if (nodeToMove.previous != pivot) {

					firstLast[1] = nodeToMove.previous;

				}

			}

			if (pivot.next != nodeToMove) {

				if (nodeToMove.previous != null) {

					nodeToMove.getPrevious().setNextTo(nodeToMove.next);

				}

				if (nodeToMove.next != null) {

					nodeToMove.getNext().setPreviousTo(nodeToMove.previous);

				}

				if (pivot.next != null) {

					pivot.getNext().setPreviousTo(nodeToMove);

				}

				nodeToMove_.setNextTo(pivot.next);
				pivot_.setNextTo(nodeToMove);
				nodeToMove_.setPreviousTo(pivot);

			}

		} else if (nextOrPrevious.equals("previous")) {

			if (nodeToMove == last) {//if nodeToMove is last, last must be reassigned.

				firstLast[1] = nodeToMove.previous;

			}

			if (pivot == first) {//if pivot is first, first must be reassigned.

				firstLast[0] = nodeToMove;

				if (first == getFirst()) {

					pointFirstAt(nodeToMove);

				}

			}

			if (nodeToMove == first) {//if nodeToMove is first, first might need reassigning.

				if (nodeToMove.getNext() != pivot) {

					firstLast[0] = nodeToMove.next;

					if (first == getFirst()) {

						pointFirstAt(nodeToMove.next);

					}

				}

			}

			if (pivot.previous != nodeToMove) {

				if (nodeToMove.previous != null) {

					nodeToMove.getPrevious().setNextTo(nodeToMove.next);

				}

				if (nodeToMove.next != null) {

					nodeToMove.getNext().setPreviousTo(nodeToMove.previous);

				}

				if (pivot.previous != null) {

					pivot.getPrevious().setNextTo(nodeToMove);

				}

				nodeToMove_.setPreviousTo(pivot.previous);
				pivot_.setPreviousTo(nodeToMove);
				nodeToMove_.setNextTo(pivot);

			}

		}

		return firstLast;

	}

	public void pointFirstAt(Node node) {

		first = node;

	}

	public Node getFirst() {

		return first;

	}

	public Node getLast() {

		return last;

	}

	public void pointLastAt(Node node) {

		last = node;

	}

	public Node getNext(Node node) {

		return node.getNext();

	}

	/**
	*	Inner Node class
	*/
   	protected class Node {

		private Node next;
		private Node previous;
		private int n;
		private boolean sorted = false;

		protected Node(int n) {

			this.n = n;

		}

		/**
		*	Used at beginning when building the list.
		*/
		public void add(Node node) {

			if (next == null) {

				next = node;
				node.previous = this;
				last = node;

			} else {

				next.add(node);

			}

		}

		public Node getNext() {

			return next;

		}

		public Node getPrevious() {

			return previous;

		}

		public void setNextTo(Node node) {

			next = node;

		}

		public void setPreviousTo(Node node) {

			previous = node;

		}

		public int getN() {

			return n;

		}

	}

}
