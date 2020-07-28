package src.java.problems;
/*

Problem Statement :
        Given a set of investment projects with their respective profits, we need to find the most profitable projects. We are given an initial capital and are allowed to invest only in a fixed number of projects. Our goal is to choose projects that give us the maximum profit.

        We can start an investment project only when we have the required capital. Once a project is selected, we can assume that its profit has become our capital.

        Example 1:

        Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
        Output: 6
        Explanation:

        With initial capital of ‘1’, we will start the second project which will give us profit of ‘2’. Once we selected our first project, our total capital will become 3 (profit + initial capital).
        With ‘3’ capital, we will select the third project, which will give us ‘3’ profit.
        After the completion of the two projects, our total capital will be 6 (1+2+3).

        Example 2:

        Input: Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5], Initial Capital=0, Number of Projects=3
        Output: 8
        Explanation:

        With ‘0’ capital, we can only select the first project, bringing out capital to 1.
        Next, we will select the second project, which will bring our capital to 3.
        Next, we will select the fourth project, giving us a profit of 5.
        After selecting the three projects, our total capital will be 8 (1+2+5).
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class P4 {

    public static int getMaxCapital(int []capital, int []profits, int projects, int initialCap){
        int size = profits.length;
        PriorityQueue<Integer> minCap = new PriorityQueue<>(size, Comparator.comparingInt(a -> capital[a]));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(size, (a,b) -> profits[b] - profits[a]);

        int availableCapital = initialCap;

        for(int cap: capital) {
            minCap.offer(cap);
        }

        for (int i = 0; i < projects; i++) {
            while (!minCap.isEmpty() && capital[minCap.peek()] <= availableCapital) {
                maxProfit.add(minCap.poll());
            }
            if(maxProfit.isEmpty())
                break;
            availableCapital += profits[maxProfit.poll()];

        }
        return availableCapital;
    }

    public static void main(String[] args) {
        int result = getMaxCapital(new int[]{0,1,2}, new int[] {1,2,3}, 2, 1);
        System.out.println(result);

        result = getMaxCapital(new int[]{0,1,2,3}, new int[] {1,2,3,5}, 3, 0);
        System.out.println(result);
    }
}

/*
Time complexity #

Since, at the most, all the projects will be pushed to both the heaps once, the time complexity of our algorithm is O(NlogN + KlogN),
where ‘N’ is the total number of projects and ‘K’ is the number of projects we are selecting.

Space complexity #

The space complexity will be O(N) because we will be storing all the projects in the heaps.

Mark as Completed
←    Back

 */