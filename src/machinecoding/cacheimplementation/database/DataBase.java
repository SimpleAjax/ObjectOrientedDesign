package machinecoding.cacheimplementation.database;

import java.util.Map;

public class DataBase<KEY, VALUE> {
     Map<KEY, VALUE> map;

     public DataBase(Map<KEY, VALUE> map) {
         this.map = map;
     }

     public VALUE get(KEY key) {
         return map.get(key);
     }

     public void set(KEY key, VALUE value) {
         map.put(key, value);
     }

    public void remove(KEY key) {
         map.remove(key);
    }

    public String toString() {
         return map.toString();
    }
}
