Sorting Algorithms
---

Three sorting algorithms are included in the exercises. bubble sort, cocktail sort and quicksort. The first two are very similar. The latter is very efficient and widely used. I have implemented these three using linked lists.


There are however many other sorting algorithms.
Wikipedia lists over 20 'comparison sorts', including bubble sort, cocktail sort and quicksort.

They can be categorised further to insertion, selection, merge, exchange, et al.
Bubble sort and quicksort are both exchange sorts.
Selection sorts include heapsort.
They can also be classified further as stable or not, recursive or not, adaptive or not, parallel or serial.

Of the algorithms not already covered in the exercises, I am also covering heapsort, merge sort, insertion sort and selection sort.


The peformance of the algorithms is important. They each have a worst case, average case and best case, presented in big O notation.



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
