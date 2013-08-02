package gradebook.model;

/**
 * This is the storable interface for things
 * to be stored in the database.
 */
public interface Storable {
    /**
     * Getter for the key.
     * @return the key
     */
    String getKey();
}
