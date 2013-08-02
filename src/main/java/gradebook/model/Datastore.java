package gradebook.model;

/**
 * Created with IntelliJ IDEA.
 * User: Brandon
 * Date: 7/31/13
 * Time: 7:07 AM
 * To change this template use File | Settings | File Templates.
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
