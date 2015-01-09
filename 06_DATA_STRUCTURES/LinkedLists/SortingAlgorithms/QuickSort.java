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

3.  
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
		qs.makeDLL(list);
		System.out.print("after making list: ");
		qs.print(list);
		List sortedList = qs.sort(list);
		System.out.print("after sorting list: ");
		qs.print(sortedList);
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
		
		add(list, list.new Node(5));
		add(list, list.new Node(67));
		add(list, list.new Node(2));		
		add(list, list.new Node(985));
		add(list, list.new Node(36));
		add(list, list.new Node(56));
		add(list, list.new Node(1));		
		add(list, list.new Node(34));
	
	}
	
	public void add(List list, List.Node node) {

		List.Node first = list.getFirst();
		List.Node last = list.getLast();
			
		if (first == null) {
		
			list.setFirst(node);
			
			if (list.length(first, last) == 1) {
			
				list.setLast(node);
			
			}
		
		} else {
		
			first.add(node);
		
		}
	
	}
	
	public List sort(List list) {
	
		List sortedList = list;
		List.Node first = list.getFirst();
		List.Node last = list.getLast();
				
		if (sortedList.length(first, last) == 2) {
		
			if (sortedList.getFirst().getN() > sortedList.getLast().getN()) {
			
				sortedList.swap(sortedList.getFirst(), sortedList.getLast());
							
			} 	
			
			return sortedList;
		
		} 
						     // currentNode,           pivot,                firstInPartition,      lastInPartition
		return sortedList.sort(sortedList.getFirst(), sortedList.getLast(), sortedList.getFirst(), sortedList.getLast());
	
	}

	public void print(List list) {
	
		if (list.getFirst() == null) {
		
			System.out.println("List is empty");
		
		} else {
		
			System.out.println();
			list.print(list.getFirst());
		
		}
	
	}
	
}

class List {

	private Node first, last;
	
	public List() {
	
		last = first = null;
		
	}
	
	public List sort(Node currentNode, Node pivot, Node firstInPartition, Node lastInPartition) {
		
		List sortedList = this;
		Node firstInPartition_ = firstInPartition;
		Node lastInPartition_ = lastInPartition;
		Node[] firstLastInPartitions = {firstInPartition_, lastInPartition};
		
		if (currentNode_ == lastInPartition) {
		
			return sortedList;
							
		}
				
		boolean reachedEnd = false;
		int listLength = length(firstLastInPartitions[0], firstLastInPartitions[1]);
		int counter = 0;
		
		while (counter < listLength) {
		
			Node currentNode_ = currentNode;
System.out.println("\ncurrentNode_ top of while : " + currentNode_.n);
			if (currentNode_ != pivot && (currentNode_.n <= pivot.n)) {

				firstLastInPartitions = sortedList.insert(pivot, currentNode_, firstLastInPartitions[0], firstLastInPartitions[1], "previous");
				
			} else if (currentNode_ != pivot && (currentNode_.n > pivot.n)) {

				firstLastInPartitions = sortedList.insert(pivot, currentNode_, firstLastInPartitions[0], firstLastInPartitions[1], "next");
				
			}

			setFirst(firstLastInPartitions[0]);
			setLast(firstLastInPartitions[1]);
					
			print(sortedList.getFirst());
	
			counter++;
System.out.println("\ncurrentNode_ before : " + currentNode_.n);
			currentNode_ = currentNode_.next;
System.out.println("\ncurrentNode_ after : " + currentNode_.n);				
		}
        
        Node pivotPart1 = null;
        
        if (pivot.previous != null) {
        
        	pivotPart1 = pivot.previous;
        
        } else {
        
        	pivotPart1 = pivot.next;
        
        }

        Node pivotPart2 = null;

        if (pivot.next != null) {
        
        	pivotPart2 = pivot.next;
        
        } else {
        
        	pivotPart2 = pivot.previous;
        
        }

                           // currentNode,    pivot,          firstInPartition,         lastInPartition
		sortedList.sort(firstLastInPartitions[0], pivotPart1, firstLastInPartitions[0], pivotPart1);
		return sortedList.sort(pivotPart2, firstLastInPartitions[1], pivotPart2, firstLastInPartitions[1]);
			
	}

	public int length(Node firstInPartition, Node lastInPartition) {
	
		int length = 0;
		Node current = firstInPartition;
		if (current != null) {
		
			length = 1;
		
		}
		
		while (current != lastInPartition) {
		
			length++;
			current = current.next;
			
		}
	
		return length;
	
	}
	
   /**
	*	Takes node2 and inserts it immediately up or downstream of node1.
	*
	*                           pivot, currentNode,     firstInPartition,       lastInPartition,     "next" or "previous"
	*/
	protected Node[] insert(Node pivot, Node nodeToMove, Node firstInPartition, Node lastInPartition, String nextOrPrevious) {
	
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
			
				firstLastInPartitions[1] = pivot;

			}

			if (nodeToMove == lastInPartition) {//if nodeToMove is last, last might need reassigning 

				if (nodeToMove.previous != pivot) {
			
					firstLastInPartitions[1] = nodeToMove.previous;
			
				}
			
			}
			
			if (pivot != nodeToMove.previous) {

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
	
			if (nodeToMove.next != pivot) {

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
		
		return firstLastInPartitions;
		
	}
	 
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
	
	}
	
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
	
	public void print(Node node) {
		
		System.out.print(node.n + " ");
		
		if (node.next != null) {
		
			print(node.next);
			
		}
	
	}
		
   	protected class Node {
	
		private Node next;
		private Node previous;
		private int n;
			
		protected Node(int n) {
		
			this.n = n;
		
		}
		
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