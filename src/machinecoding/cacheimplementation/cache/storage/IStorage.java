package machinecoding.cacheimplementation.cache.storage;

public interface IStorage<KEY, VALUE> {
    VALUE get(KEY key);
    void set(KEY key, VALUE value);
    void remove(KEY key);

    boolean contains(KEY key);
}
