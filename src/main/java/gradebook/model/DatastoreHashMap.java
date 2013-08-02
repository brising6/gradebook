package gradebook.model;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/31/13
 * Time: 7:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatastoreHashMap implements Datastore {
    /**
     * This is the hashmap backing the datastore.
     */
    private HashMap<String, Storable> data;
    /**
     * This is the constructor for the datastore hashmap.
     */
    public DatastoreHashMap() {
        data = new HashMap<String, Storable>();
    }
    /**
     * This adds to the datastore.
     * @param data1 the data to add
     */
    @Override
    public final void add(final Storable data1) {
        this.data.put(data1.getKey(), data1);
    }
    /**
     * This gets data from the datastore using a key.
     * @param key the key for the data
     * @return the data
     */
    @Override
    public final Storable get(final String key) {
        return this.data.get(key);
    }
}
