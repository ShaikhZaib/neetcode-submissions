class MedianFinder {
    // Max Heap
    private Queue<Integer> smallHeap;

    // Min Heap
    private Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Add the num in small Heap
        smallHeap.add(num);

        // Handle handle small heap size is greater than large heap + 1 or the max element is bigger
        if 
        (
            (smallHeap.size() - largeHeap.size() > 1) ||
            (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek())
        )
        {
            largeHeap.add(smallHeap.poll());
        }

        // handle large heap size is greater than small heap + 1
        if (largeHeap.size() - smallHeap.size() > 1)
        {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        // Find median based on size 
        if (smallHeap.size() == largeHeap.size())
        {
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        }
        else if (smallHeap.size() > largeHeap.size())
        {
            return (double) smallHeap.peek();
        }
        else
        {
            return (double) largeHeap.peek();
        }
    }
    // Time Complexity -> O(m * log n) for addNum() and O(1) for findMedian()
    // Space Complexity -> O(n)
}
