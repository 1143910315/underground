import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DoubleMap<k1, k2, v> {
    private HashMap<k1, HashMap<k2,v>> hashMap = new HashMap<>();

    public void put(k1 key1, k2 key2, v value) {
        HashMap<k2, v> hashMapKey = hashMap.get(key1);
        if (hashMapKey == null) {
            hashMapKey = new HashMap<>();
            hashMap.put(key1, hashMapKey);
        }
        hashMapKey.put(key2, value);
    }

    public v get(k1 key1, k2 key2) {
        HashMap<k2, v> hashMapKey = hashMap.get(key1);
        if (hashMapKey == null) {
            return null;
        }
        return hashMapKey.get(key2);
    }
    public Set<k1> getKey1Set(){
        return hashMap.keySet();
    }
    public Set<k2> getKey2Set(k1 key1){
        HashMap<k2,v> hashMapKey = hashMap.get(key1);
        if (hashMapKey==null){
            return new HashSet<k2>();
        }
       return hashMapKey.keySet();
    }
}
