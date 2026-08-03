class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (int task : tasks)
        {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : counts)
        {
            if (cnt > 0)
            {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty())
        {
            time++;
            if (maxHeap.isEmpty())
            {
                time = q.peek()[1]; 
            } 
            else
            {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0)
                {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time)
            {
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
    // Time Compleity -> O(m)
    // Space Complexity -> O(1)
}
