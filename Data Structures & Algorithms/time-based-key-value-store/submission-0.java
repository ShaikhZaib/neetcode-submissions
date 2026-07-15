class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyStore;
    private record Pair<K, V>(K key, V value){};

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        
        int left = 0, right = values.size() - 1;
        String result = "";

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(values.get(mid).key() <= timestamp){
                result = values.get(mid).value();
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return result;
    }
    // Time Complexity -> O(set -> O(1), get -> O(log n))
    // Space Complexity -> O(1)
}
