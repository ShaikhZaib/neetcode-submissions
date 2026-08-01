class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones)
        {
            maxHeap.offer(s);
        }

        while (maxHeap.size() > 1)
        {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            if (a != b) maxHeap.offer(a - b);
        }

        maxHeap.offer(0);
        return maxHeap.peek();
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(n)
}
