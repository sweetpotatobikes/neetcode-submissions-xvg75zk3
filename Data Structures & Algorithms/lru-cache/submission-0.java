class LRUCache extends LinkedHashMap {
    private final Map<Integer, Integer> cache;
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        int val = cache.getOrDefault(key, -1);
        if (val != -1) {
            cache.put(key, val);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) cache.remove(key);
        else if (cache.size() == capacity) {
            int lru = cache.keySet().iterator().next();
            cache.remove(lru);
        }
        cache.put(key,value);
    }
}
