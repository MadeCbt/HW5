/******************************************************************
 *
 *   jees amodemaja / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

 import java.util.*;

 class ProblemSolutions {
 
     /**
      * Method: isSubset()
      *
      * Given two arrays of integers, A and B, return whether
      * array B is a subset of array A.
      * Example:
      *      Input: [1,50,55,80,90], [55,90]
      *      Output: true
      *      Input: [1,50,55,80,90], [55,90, 99]
      *      Output: false
      *
      * Time complexity is O(n) by using a HashSet.
      *
      * @param list1 - Input array A
      * @param list2 - Input array B
      * @return      - returns true if B is a subset of A, else false.
      */
     public boolean isSubset(int list1[], int list2[]) {
         // Create a HashSet from list1 for O(n) membership checks.
         Set<Integer> set = new HashSet<>();
         for (int num : list1) {
             set.add(num);
         }
         // Check each element in list2; if any is missing, return false.
         for (int num : list2) {
             if (!set.contains(num)) {
                 return false;
             }
         }
         return true;
     }
 
     /**
      * Method: findKthLargest
      *
      * Given an Array A and integer K, return the kth maximum element in the array.
      * Example:
      *      Input: [1,7,3,10,34,5,8], 4
      *      Output: 7
      *
      * This solution uses a min-heap (PriorityQueue) of size k.
      *
      * @param array - Array of integers
      * @param k     - the kth maximum element
      * @return      - the kth largest value in the array
      */
     public int findKthLargest(int[] array, int k) {
         // Use a min-heap (PriorityQueue) to keep track of the k largest elements.
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
         for (int num : array) {
             if (minHeap.size() < k) {
                 minHeap.offer(num);
             } else if (num > minHeap.peek()) {
                 minHeap.poll();
                 minHeap.offer(num);
             }
         }
         return minHeap.peek();
     }
 
     /**
      * Method: sort2Arrays
      *
      * Given two arrays A and B with n and m integers respectively, return
      * a single array of all the elements in A and B in sorted order.
      * Example:
      *      Input: [4,1,5], [3,2]
      *      Output: [1,2,3,4,5]
      *
      * @param array1    - Input array 1
      * @param array2    - Input array 2
      * @return          - Sorted array with all elements in A and B.
      */
     public int[] sort2Arrays(int[] array1, int[] array2) {
         int n = array1.length;
         int m = array2.length;
         int[] combined = new int[n + m];
         // Copy both arrays into a new array.
         System.arraycopy(array1, 0, combined, 0, n);
         System.arraycopy(array2, 0, combined, n, m);
         // Sort the combined array.
         Arrays.sort(combined);
         return combined;
     }
 }
 