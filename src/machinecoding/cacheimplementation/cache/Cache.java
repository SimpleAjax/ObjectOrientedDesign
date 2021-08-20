package machinecoding.cacheimplementation.cache;

import machinecoding.cacheimplementation.cache.evictionpolicy.IEvictionPolicy;
import machinecoding.cacheimplementation.cache.evictionpolicy.exception.EvictionException;
import machinecoding.cacheimplementation.cache.exception.CacheException;
import machinecoding.cacheimplementation.cache.storage.IStorage;
import machinecoding.cacheimplementation.database.DataBase;

public class Cache<KEY, VALUE> {

    IEvictionPolicy<KEY> evictionPolicy;
    IStorage<KEY, VALUE> storage;
    DataBase<KEY, VALUE> dataBase;
    int capacity;
    int currentSize;
    public Cache(IEvictionPolicy<KEY> evictionPolicy, IStorage<KEY, VALUE> storage,
          DataBase<KEY, VALUE> dataBase, int capacity) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
        this.dataBase = dataBase;
        this.capacity = capacity;
        currentSize = 0;
    }

    public VALUE get(KEY key) throws CacheException, EvictionException {
        VALUE value = storage.get(key);
        if(value!=null) {
            evictionPolicy.keyAccessed(key);
            return value;
        }
        value = dataBase.get(key);
        if(value!=null) {
            set(key, value);
        }
        return value;
    }
    public void set(KEY key, VALUE value) throws CacheException, EvictionException {
        if(currentSize==capacity && !storage.contains(key)){
            KEY evictKey = evictionPolicy.evict();
            storage.remove(evictKey);
            dataBase.remove(evictKey);
            currentSize--;
        }
        storage.set(key, value);
        dataBase.set(key, value);
        evictionPolicy.keyUpdated(key);
        if(!storage.contains(key)) currentSize++;
    }
    public void remove(KEY key) throws CacheException, EvictionException {
        storage.remove(key);
        dataBase.remove(key);
        evictionPolicy.keyRemoved(key);
    }

    public void printCacheState() {
        System.out.println(storage.toString());
    }

    public void printDatabaseState() {
        System.out.println(dataBase.toString());
    }
}
