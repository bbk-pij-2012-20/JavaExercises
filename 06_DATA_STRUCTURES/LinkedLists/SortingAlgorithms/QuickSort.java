// cd ~/Desktop/ALL_POOLED/COMPUTING/CODING/JavaExercises/06_DATA_STRUCTURES/LinkedLists/SortingAlgorithms
// Exercise 7.13 (Using data structures & pointers to implement Sorting Algorithms). Difficulty level: very.
/*
This is a popular sorting algorithm that is very fast in most situations. Once you have finished all the other exercises,
look up in wikipedia how this method works and make your own implementation (put it in ListUtilities.quickSort(List)).
Then compare its performance with the other two methods. In order to see significant differences, you will need to
use lists of some length.
*/

/*
like bubble sort & cocktail sort, quick sort is at worst O(n^2). (n is number of elements).
However, quick sort typically acts more like an O(n log n) algorithm. 

Also known as a partition-exchange sort

Steps in quick sort:

1. randomly pick one element in a list. This is called the "pivot".
2. randomly partition the remainder of the list.
3. compare pivot with the elements and re-arrange according to their comparison with the pivot.

*/

import java.util.Random;

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
		System.out.println();
		qs.makeDLL(list);
		System.out.print("after making list: ");
		qs.print(list);
		System.out.println();
		qs.sort(list);
		System.out.print("after sorting list: ");
//		qs.print(sortedList);// gives the same output
		qs.print(list);
		System.out.println();
/*		List.Node node1 = list.new Node(1);
		List.Node node2 = list.new Node(2);
		List.Node node3 = list.new Node(3);
		List.Node node4 = list.new Node(4);						
		qs.add(list, node1);
		qs.add(list, node2);
		qs.add(list, node3);
		qs.add(list, node4);
		System.out.print("\n\nafter adding nodes 1,2,3,4 to end of list: ");
		qs.print(list);		
		System.out.print("\n\nafter inserting node 4 next to node 1: ");
		list.insert(node1, node4, list.getFirst(), list.getLast(), "next");
		qs.print(list);
		System.out.print("\n\nafter inserting node 1 previous to node 4: i.e. should be the same");
		list.insert(node4, node1, list.getFirst(), list.getLast(), "previous");
		qs.print(list);
		System.out.println();
*/		
	}
	
	public void makeDLL(List list) {
		
/*		add(list, list.new Node(5));
		add(list, list.new Node(67));
		add(list, list.new Node(2));		
		add(list, list.new Node(985));
		add(list, list.new Node(36));
		add(list, list.new Node(56));
		add(list, list.new Node(1));		
		add(list, list.new Node(34));
*/		add(list, list.new Node(1));
		add(list, list.new Node(9));
		add(list, list.new Node(7));
		add(list, list.new Node(4));
		add(list, list.new Node(34));	
		add(list, list.new Node(34));
//		add(list, list.new Node(34));		
//there NullPointerException when I have an odd number of nodes, but it works fine with even numbers.

	}

	/**
	*	Directly adds node to empty list. Sets pointers to 
	*	For lists larger than two nodes, calls sort method in List to sort list recursively by quicksort
	*/
	public void add(List list, List.Node node) {

		if (list.getFirst() == null) {
		
			list.setFirst(node);
			list.setLast(node);

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
			
			if (sortedList.length() < 2) {
			
				throw new IllegalArgumentException("...can't sort a list with only 1 node!");
			
			}
		
			if (sortedList.length(list.getFirst(), list.getLast()) > 1) {
		
				sortedList.sort(sortedList.getFirst(), sortedList.getLast());
		
			}
		
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
		
			list.print(list.getFirst());
		
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
	*	Sorts by quicksort, recursive calls.
	*/
	public void sort(Node firstInPartition, Node lastInPartition) {

		Node[] firstLastInPartitions = {firstInPartition, lastInPartition};
		Node currentNode = firstInPartition;
		Node pivot = lastInPartition;

		if (firstInPartition == null || lastInPartition == null || currentNode == pivot) {
		
			return;
							
		}

		Node currentNode_ = currentNode;
		int listLength = length(firstLastInPartitions[0], firstLastInPartitions[1]);
		int counter = 0;
		Node currentNodeIndependentPtr = currentNode;
		
		while (counter <= listLength) {

			if (currentNode_ != pivot && (currentNode_.n <= pivot.n)) {
			
				currentNodeIndependentPtr = currentNodeIndependentPtr.next;
				firstLastInPartitions = insert(pivot, currentNode_, firstLastInPartitions[0], firstLastInPartitions[1], "previous");
				
			} else if (currentNode_ != pivot && (currentNode_.n > pivot.n)) {

				currentNodeIndependentPtr = currentNodeIndependentPtr.next;
				firstLastInPartitions = insert(pivot, currentNode_, firstLastInPartitions[0], firstLastInPartitions[1], "next");
				
			} else if (currentNode == pivot) {
			
				currentNodeIndependentPtr = currentNodeIndependentPtr.next;
			
			}

			counter++;
			currentNode_ = currentNodeIndependentPtr;

		}  

		sort(firstLastInPartitions[0], pivot.previous);
		sort(pivot.next, firstLastInPartitions[1]);
       	
	}

	/**
	*	Calculates the length of list starting from first to last nodes in list.
	*/
	public int length() {

		int length = 0;
		Node currentNode = first;
		
		if (currentNode != null) {
		
			length = 1;
		
		} 
		
		while (currentNode.next != null) {
		
			length++;
			currentNode = currentNode.next;
		
		}	
		
		return length;
		
	}

	/**
	*	Calculates the length of list starting from first to last nodes passed.
	*/
	public int length(Node firstInPartition, Node lastInPartition) {

		int length = 0;
		Node current = firstInPartition;
		
		if (current != null) {
		
			length = 1;
		
		}
		
		while (current != lastInPartition && current.next != null) {
		
			length++;
			current = current.next;
			
		}

		return length;
	
	}
		
	/**
	*	Prints list starting from node passed to it, sent from print method in 'QuickSort' class.
	*/
	public void print(Node node) {
		
		System.out.print(node.n + " ");
		
		if (node.next != null) {
		
			print(node.next);
			
		}
	
	}
	
	/**
	*	Prints a section of the list, specified by the two nodes passed.
	*/
	public void print(Node node, Node last) {
		
		if (node == null) {
		
			System.out.print("the first node is null");
		
		} else {
		
			System.out.print(node.n + " ");
		
			if (node == last) {
			
				return;
			
			} else if (node.next != null) {
		
				print(node.next);
				
			}
	
		}
		
	}

	
	/**
	*	Takes nodeToMove and inserts it immediately up or downstream of pivot.
	*
	*                           pivot,   currentNode,     firstInPartition,       lastInPartition,     "next" or "previous"
	*/
	public Node[] insert(Node pivot, Node nodeToMove, Node firstInPartition, Node lastInPartition, String nextOrPrevious) {
	
		Node pivot_ = pivot;//pivot
		Node nodeToMove_ = nodeToMove;
		Node pivotGetNext = pivot.next;
		Node pivotGetPrevious = pivot.previous;
		Node nodeToMoveGetNext = nodeToMove.next;
		Node nodeToMoveGetPrevious = nodeToMove.previous;
		Node[] firstLastInPartitions = {firstInPartition, lastInPartition};

		if (nextOrPrevious.equals("next")) { 

			if (nodeToMove == firstInPartition) {//if nodeToMove is first, first must be reassigned.

				firstLastInPartitions[0] = nodeToMove.next;
				
			}

			if (pivot == lastInPartition) {//if pivot is last, last must be reassigned.
			
				firstLastInPartitions[1] = nodeToMove;

			}

			if (nodeToMove == lastInPartition) {//if nodeToMove is last, last might need reassigning 

				if (nodeToMove.previous != pivot) {
			
					firstLastInPartitions[1] = nodeToMove.previous;
			
				}
			
			}
			
			if (pivot.next != nodeToMove) {

				if (nodeToMove.previous != null) {
			
					nodeToMoveGetPrevious.setNext(nodeToMove.next);
					
				}
			
				if (nodeToMove.next != null) {
			
					nodeToMoveGetNext.setPrevious(nodeToMove.previous);
			
				} 
			
				if (pivot.next != null) {
			
					pivotGetNext.setPrevious(nodeToMove);
			
				}
			
				nodeToMove_.setNext(pivot.next);
				pivot_.setNext(nodeToMove);
				nodeToMove_.setPrevious(pivot);
			
			} 	
		
		} else if (nextOrPrevious.equals("previous")) {

			if (nodeToMove == lastInPartition) {//if nodeToMove is last, last must be reassigned.

				firstLastInPartitions[1] = nodeToMove.previous;

			}

			if (pivot == firstInPartition) {//if pivot is first, first must be reassigned.

				firstLastInPartitions[0] = nodeToMove;
				
			}
			
			if (nodeToMove == firstInPartition) {//if nodeToMove is first, first might need reassigning.

				if (nodeToMove.getNext() != pivot) {

					firstLastInPartitions[0] = nodeToMove.next;

				}
				
			}
	
			if (pivot.previous != nodeToMove) {

				if (nodeToMove.previous != null) {

					nodeToMoveGetPrevious.setNext(nodeToMove.next);
			
				}

				if (nodeToMove.next != null) {

					nodeToMoveGetNext.setPrevious(nodeToMove.previous);
			
				}
			
				if (pivot.previous != null) {

					pivotGetPrevious.setNext(nodeToMove);
			
				}
			
				nodeToMove_.setPrevious(pivot.previous);
				pivot_.setPrevious(nodeToMove);
				nodeToMove_.setNext(pivot);				
	
			}
		
		}

	//	setFirst(firstLastInPartitions[0]);// before I commented out these
	//	setLast(firstLastInPartitions[1]);// two lines, the pivot at the end of a list kept disappearing. Due to print list?
		return firstLastInPartitions;
		
	}
	/* NOT USING THIS METHOD IN THIS VERSION
	*	
	Swaps position of two nodes passed to it. (Incomplete as it does reassign first & last yet)
	*	(This method may not be used at all though)
	*
	protected void swap(Node node1, Node node2) {
		
		Node preNode1 = node1.getPrevious();
		Node nextNode1 = node1.getNext();
		Node preNode2 = node2.getPrevious();
		Node nextNode2 = node2.getNext();		
		Node newNode1 = node1;
		Node newNode2 = node2;
		
		if (preNode1 == node2) {
				
			newNode2.setPrevious(node1);
			newNode1.setNext(node2);
			newNode2.setNext(nextNode1);
			
			if (nextNode1 != null) {
			
				nextNode1.setPrevious(newNode2);
			
			}
			
			newNode1.setPrevious(preNode2);
			
			if (preNode2 != null) {
				
				preNode2.setNext(node1);
			
			}
		
		} else if (preNode2 == node1) {
				
			newNode1.setPrevious(node2);
			newNode2.setNext(node1);
			newNode1.setNext(nextNode2);
			
			if (nextNode2 != null) {
			
				nextNode2.setPrevious(node1);
			
			}
			
			newNode2.setPrevious(preNode1);
			
			if (preNode1 != null) {
			
				preNode1.setNext(node2);
			
			}
		
		} else {

			newNode2.setPrevious(preNode1);
		
			if (preNode1 != null) {
		
				preNode1.setNext(newNode2);
		
			}
		
			newNode2.setNext(nextNode1);
		
			if (nextNode1 != null) {
		
				nextNode1.setPrevious(newNode2);
		
			}
		
			newNode1.setPrevious(preNode2);
		
			if (preNode2 != null) {
		
				preNode2.setNext(newNode1);
		
			} 
		
			newNode1.setNext(nextNode2);
		
			if (nextNode2 != null) {
			
				nextNode2.setPrevious(newNode1);
		
			}

		}
	
	}*/
	
	public void setFirst(Node node) {
	
		first = node;

	}
	
	public Node getFirst() {
	
		return first;
	
	}

	public Node getLast() {
	
		return last;
	
	}
	
	public void setLast(Node node) {
	
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
		
		public void setNext(Node node) {
		
			next = node;
		
		}
		
		public void setPrevious(Node node) {
	
			previous = node;
		
		}
		
		public int getN() {
		
			return n;
		
		}
	
	}
	
}