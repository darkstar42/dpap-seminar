package de.fau.cs.dpap.layer;

import java.util.List;

/**
 * General data layer interface
 */
public interface DataLayer {
    /**
     * Save the data under the given key
     *
     * @param key Identification key
     * @param data Data to save
     * @return Unique identifier for the new data entry
     */
    boolean store(String key, String data);

    /**
     * Load the data of the entry with the given key
     *
     * @param key Identifier of the entry to load
     * @return Entry data
     */
    String load(String key);

    /**
     * Return the list of previously saved keys
     *
     * @return List of keys
     */
    List<String> list();
}
