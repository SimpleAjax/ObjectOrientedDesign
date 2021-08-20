package machinecoding.cacheimplementation.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<KEY, VALUE> implements IStorage<KEY, VALUE> {

    final Map<KEY, VALUE> map;

    public HashMapStorage() {
        this.map = new HashMap<>();
    }


    @Override
    public VALUE get(KEY key) {
        return map.get(key);
    }

    @Override
    public void set(KEY key, VALUE value) {
        map.put(key, value);
    }

    @Override
    public void remove(KEY key) {
        map.remove(key);
    }

    @Override
    public boolean contains(KEY key) {
        return map.containsKey(key);
    }

    public String toString() {
        return map.toString();
    }
}
