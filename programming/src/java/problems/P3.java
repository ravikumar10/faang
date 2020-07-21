package src.java.problems;

import java.util.PriorityQueue;

/*
Problem Statement :
        Design a class to calculate the median of a number stream. The class should have the following two methods:

        insertNum(int num): stores the number in the class
        findMedian(): returns the median of all numbers inserted in the class

        If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

        Example 1:

        1. insertNum(3)
        2. insertNum(1)
        3. findMedian() -> output: 2
        4. insertNum(5)
        5. findMedian() -> output: 3
        6. insertNum(4)
        7. findMedian() -> output: 3.5
*/

public class P3 {
    PriorityQueue<Integer> maxPQ;
    PriorityQueue<Integer> minPQ;

    public P3(){
        maxPQ = new PriorityQueue<>((a,b) ->b-a);
        minPQ = new PriorityQueue<>((a,b) ->a-b);
    }

    public void insertNum(int n) {

        if(maxPQ.isEmpty() || maxPQ.peek() >= n){
            maxPQ.add(n);
        } else {
            minPQ.add(n);
        }

        if(maxPQ.size() > minPQ.size()+1) {
            minPQ.add(maxPQ.poll());
        } else if (minPQ.size() > maxPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    public double findMedian(){
        if(maxPQ.size() == minPQ.size())
            return maxPQ.peek()/2.0 + minPQ.peek()/2.0;

        return maxPQ.peek();
    }

    public static void main(String[] args) {
        P3 p3 = new P3();

        p3.insertNum(3);
        p3.insertNum(1);
        System.out.println(p3.findMedian());

        p3.insertNum(5);
        System.out.println(p3.findMedian());

        p3.insertNum(4);
        System.out.println(p3.findMedian());

    }


}

/*

Time complexity #
The time complexity of the insertNum() will be O(logN) due to the insertion in the heap. The time complexity of the findMedian() will be O(1) as we can find the median from the top elements of the heaps.

Space complexity #
The space complexity will be O(N) because, as at any time, we will be storing all the numbers.

 */