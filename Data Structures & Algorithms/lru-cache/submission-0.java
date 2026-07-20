public class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;

        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;

            remove(node);
            insert(node);
        } else{
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);

            if(cache.size() > cap){
                Node lru = this.left.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }
    // Time Complexity -> O(1) for get() and put()
    // Space Complexity -> O(n)
}
