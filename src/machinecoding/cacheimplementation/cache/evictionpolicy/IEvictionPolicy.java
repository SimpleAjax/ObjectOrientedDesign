package machinecoding.cacheimplementation.cache.evictionpolicy;

import machinecoding.cacheimplementation.cache.evictionpolicy.exception.EvictionException;

public interface IEvictionPolicy<KEY> {
    void keyAccessed(KEY key) throws EvictionException;
    void keyUpdated(KEY key) throws EvictionException;
    void keyRemoved(KEY key) throws EvictionException;
    void keyAdded(KEY key) throws EvictionException;
    KEY evict() throws EvictionException;
}
