package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>{

    private int capacity;

    public LRUCache(int capacity) {
        super((capacity << 2 / 3), 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        try {
            return super.get(key);
        }catch(NullPointerException e){
            return -1;
        }
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        if(this.size() > capacity) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}

