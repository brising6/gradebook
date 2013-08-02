package gradebook.model;

/**
 * This is the datastore interface.
 */
public interface Datastore {
    /**
     * This adds a piece of data to the datastore.
     * @param data the data to add
     */
    void add(Storable data);
    /**
     * This gets data from the datastore with a key.
     * @param key the key
     * @return the data
     */
    Storable get(String key);
}
