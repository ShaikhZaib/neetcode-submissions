class Solution 
{
    // Intialize preMap that Maps each course to it's prerequisite.
    private Map<Integer, List<Integer>> preMap = new HashMap<>();

    // Intialize a visiting set that stores all courses in current dfs path.
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        // Intialize every course with a prerequisite list
        for (int i = 0; i < numCourses; i++)
        {
            preMap.put(i, new ArrayList<>());
        }

        // Build the graph for prerequisites for each course
        for (int[] preReq : prerequisites)
        {
            preMap.get(preReq[0]).add(preReq[1]);
        }

        // Run dfs from every course
        for (int c = 0; c < numCourses; c++)
        {
            // If detects cycle return false
            if (!dfs(c))
            {
                return false;
            }
        }    

        // Return true.
        return true;
    }

    private boolean dfs(int crs)
    {
        // Check if the course is already in the dfs stack.
        if (visiting.contains(crs)) return false;

        // If no prerequisite return true.
        if (preMap.get(crs).isEmpty()) return true;

        // Add the course in the visited set and recursively check all the prerequisite.
        visiting.add(crs);
        for (int pre : preMap.get(crs))
        {
            if (!dfs(pre)) return false;
        }

        // Remove the course and clear it's prerequisites and return true.
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
    // Time Complexity -> O(V + E)
    // Space Complexity -> O(V + E)
}
