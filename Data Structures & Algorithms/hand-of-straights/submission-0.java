class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        // Total cards must be divisible by group size. 
        // Otherwise equal-sized groups are impossible.
        if (hand.length % groupSize != 0) return false;

        // TreeMap automatically keeps cards sorted.
        // Key -> card value
        // Value -> frequency of that card
        TreeMap<Integer, Integer> count = new TreeMap<>();

        // Build frequency map.
        for (int card : hand)
        {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        // Continue until all cards are used.
        while (!count.isEmpty())
        {
            // Smallest available card.
            // Every valid sequence must start
            // from the smallest remaining card.
            int start = count.firstKey();

            // Build one group of consecutive cards.
            for (int card = start; card < start + groupSize; card++)
            {
                // Required card doesn't exist.
                // Cannot form a consecutive group.
                if (!count.containsKey(card)) return false;

                // Use one occurence of this card.
                count.put(card, count.get(card) - 1);

                // Remove the card completely 
                // if its frequency becomes 0.
                if (count.get(card) == 0) count.remove(card);
            }
        }

        // Successfully formed all groups.
        return true;
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(n)
}