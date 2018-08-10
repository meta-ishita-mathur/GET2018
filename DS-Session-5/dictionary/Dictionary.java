package dictionary;

import java.util.List;

/**
 * interface for creating a dictionary
 * @author Prakalpa-Rathore
 *
 */
public interface Dictionary {

    /**
     * method to add the given entry(key-value pair) into the dictionary
     * @param entry to be added
     * @return true if added, false otherwise
     */
    public boolean addEntry(DictionaryEntry entry);
    
    
    /**
     * method to delete the given entry(key-value pair) from the dictionary
     * @param key of the entry to be deleted
     * @return true if deleted, false otherwise
     */
    public boolean deleteEntry(String key);
    
    
    /**
     * method to return the value for the given key
     * @param key for which value is to be returned
     * @return value of the key if key is present else returns null
     */
    public String getValue(String key);
    
    
    /**
     * returns all the entries in ascending order of key
     */
    public List<DictionaryEntry> getSortedList();
    
    
    /**
     * return the sorted list of entries for all the keys >=key1 and <=key2
     * @param key1
     * @param key2
     * @return sorted list, returns null if input is invalid
     */
    public List<DictionaryEntry> getSortedList(String key1, String key2);
}