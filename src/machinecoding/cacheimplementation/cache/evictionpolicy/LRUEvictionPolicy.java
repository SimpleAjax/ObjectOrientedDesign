package machinecoding.cacheimplementation.cache.evictionpolicy;

import machinecoding.cacheimplementation.cache.evictionpolicy.exception.EvictionException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Node<KEY> {
    KEY key;
    Node(KEY key) {
        this.key = key;
    }
}

public class LRUEvictionPolicy<KEY> implements IEvictionPolicy<KEY> {

    Deque<Node> deque = new ArrayDeque<>();
    Map<KEY, Node> map = new HashMap<>();

    @Override
    public void keyAccessed(KEY key) throws EvictionException {
        Node node = map.get(key);
        deque.remove(node);
        deque.addFirst(node);
    }

    @Override
    public void keyUpdated(KEY key) throws EvictionException {
        Node node = new Node(key);
        deque.addFirst(node);
        map.put(key, node);
        keyAccessed(key);
    }

    @Override
    public void keyRemoved(KEY key) {
        map.remove(key);
        deque.remove(key);
    }

    @Override
    public void keyAdded(KEY key) throws EvictionException {
        if(map.containsKey(key)) {
            keyAccessed(key);
        } else {
            Node node = deque.pollLast();
            map.remove(node.key);
        }
    }

    @Override
    public KEY evict() throws EvictionException {
        Node node = deque.pollLast();
        return (KEY) node.key;
    }
}
