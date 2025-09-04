package L2163;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
* Minimum difference in sums after removal of element
* You are given a 0-indexed integer array nums consisting of 3 * n elements.
*
* You are allowed to remove any subsequence of elements of size exactly n from nums. The remaining 2 * n elements will be divided into two equal parts:
*
* The first n elements belonging to the first part and their sum is sumfirst.
* The next n elements belonging to the second part and their sum is sumsecond.
* The difference in sums of the two parts is denoted as sumfirst - sumsecond.
*
* For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
* Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1.
* Return the minimum difference possible between the sums of the two parts after the removal of n elements.
*/

class Solution {
    private int LEFT_MOST_MIDPOINT;
    private int RIGHT_MOST_MIDPOINT;
    private static boolean MAX = true;
    private static boolean MIN = false;

    public long minimumDifference(int[] nums) {
        long sum = Long.MAX_VALUE;
        int n = nums.length / 3;
        ArrayList<Long> leftSum = new ArrayList<>();
        ArrayList<Long> rightSum = new ArrayList<>();
        Heap.setMaxSize(n);
        LEFT_MOST_MIDPOINT = n - 1;
        RIGHT_MOST_MIDPOINT = 2 * n - 1;

        Heap leftMinElements = new Heap(MAX);
        Heap rightMaxElements = new Heap(MIN);
        int l = 0;
        int r = n;

        for (int i = 0; i <= RIGHT_MOST_MIDPOINT; i++) {
            if (leftMinElements.getSize() >= n - 1) {
                leftSum.add(leftMinElements.insert(nums[i]));
                l++;
                continue;
            }
            leftMinElements.insert(nums[i]);
        }

        for (int i = (nums.length - 1); i > LEFT_MOST_MIDPOINT; i--) {
            if (rightMaxElements.getSize() >= n - 1) {
                rightSum.add(rightMaxElements.insert(nums[i]));
                r--;
                continue;
            }
            rightMaxElements.insert(nums[i]);
        }

        for (int i = 0; i <= n; i++) {
            long curSum = leftSum.get(i) - rightSum.get(rightSum.size() - 1 - i);
            sum = Math.min(sum, curSum);
        }



        return sum;
    }

    private class Heap {
        PriorityQueue<Integer> heap;
        long sum;
        int size;
        static int MaxSize;

        public Heap(boolean useMaxHeap) {
            if (useMaxHeap)
                heap = new PriorityQueue<>(Collections.reverseOrder());
            else
                heap = new PriorityQueue<>();
            sum = 0;
            size = 0;
        }

        public long insert(int val) {
            sum = sum + val;
            heap.offer(val);
            if (heap.size() > MaxSize)
                sum -= heap.remove();
            size ++;
            return sum;
        }

        public int getSize(){
            return size;
        }

        static public void setMaxSize(int maxSize) {
            MaxSize = maxSize;
        }
    }
}

