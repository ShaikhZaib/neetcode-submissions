class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        // Intialize indegree to track how many prerequisites each course has.
        int[] indegree = new int[numCourses];

        // Intialize graph to an emptyList for all the courses.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
        {
            graph.add(new ArrayList<>());
        }

        // For each prerequisite[a, b] add b -> a(because b must be taken before a) and increment indegree of a(since it depends on b).
        for (int[] pre : prerequisites)
        {   
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        // Intialize a queue with all the courses that have no prerequisites(indegree == 0).
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0) q.offer(i);
        }

        // Intialize order array(for output) and idx(to fill the array sequentially).
        int[] order = new int[numCourses];
        int idx = 0;

        // While the queue is not empty process the courses. 
        while (!q.isEmpty())
        {
            // Take the course and place it in the order.
            int course = q.poll();
            order[idx++] = course;

            // For each of the neighbor decrement indegree and if indegree becomes 0 enqueue it.
            for (int neighbor : graph.get(course))
            {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.offer(neighbor);
            }
        }

        // If we procedd all the courses return order or if an cycle exists return empty array.  
        return idx == numCourses ? order : new int[0];  
    }
    // Time Complexity -> O(V + E)
    // Space Complexity -> O(V + E)
}
