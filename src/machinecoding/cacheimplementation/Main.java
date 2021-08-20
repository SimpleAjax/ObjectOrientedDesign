package machinecoding.cacheimplementation;

import machinecoding.cacheimplementation.cache.Cache;
import machinecoding.cacheimplementation.cache.evictionpolicy.LRUEvictionPolicy;
import machinecoding.cacheimplementation.cache.evictionpolicy.exception.EvictionException;
import machinecoding.cacheimplementation.cache.exception.CacheException;
import machinecoding.cacheimplementation.cache.storage.HashMapStorage;
import machinecoding.cacheimplementation.database.DataBase;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Cache APIs: CRUD
 * get()
 * set()
 *
 * Classes:
 * ICache:
 *      VALUE get(KEY) throws GetCacheException()
 *      void set(KEY, VALUE) throws UpdateCacheException()
 * Cache implements ICache:
 *      IEvictionPolicy (LRU, LFU, ..):
 *          void keyAccessed(KEY) throws EvictionException();
 *          void keyUpdated(KEY) throw EvictionException();
 *      LRUEvictionPolicy<KEY>()
 *          HashMap<KEY, NODE>
 *          DoublyLinkedList<NODE>
 *          NODE -> KEY, LEFT, RIGHT
 *          keyAccessed(KEY) -> updateTime()
 *          keyUpdated(KEY) -> updateValueOfKey()
 *      LFREvictionPolicy()
 *          keyAccessed(KEY) -> updateFrequency()
 *          keyUpdated(KEY) -> updateValueOfKey()
 *
 *      IStorage<KEY, VALUE> (HashMap, ..):
 *          VALUE get(KEY)
 *          boolean set(KEY, VALUE)
 *
 *      HashMapStorage<KEY, VALUE>() implements IStorage:
 *          HashMap<KEY, VALUE> map;
 *
 *
 *
 *
 */

public class Main {
    public static void main(String[] args) throws CacheException, EvictionException {
        System.out.println("here");
        Map<String, Integer> database = new HashMap<>();
        database.put("1", 1);
        database.put("2", 2);
        database.put("3", 3);
        database.put("4", 4);
        database.put("5", 5);
        database.put("6", 6);

        Cache<String, Integer> cache = new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(),
                new DataBase<>(database), 3);

        System.out.println(cache.get("1"));
        System.out.println(cache.get("1"));
        System.out.println(cache.get("2"));
        cache.set("2", 10);
        cache.remove("2");
        System.out.println(cache.get("3"));
        cache.set("2", 2);
        cache.set("4", 4);

        System.out.println("\nCache State:");
        cache.printCacheState();

        System.out.println("\ndatabase state: ");
        cache.printDatabaseState();

    }
}
