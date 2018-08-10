package dictionary;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * class to implement Dictionary using Binary Search Tree
 * @author Ishita_Mathur
 *
 */
public class BSTDictionary implements Dictionary
{
    private BSTNode root; //root node    
    
    /**
     * constructor
     * @param initialEntriesFileLocation, location of the json file having initial entries for the dictionary 
     */
    public BSTDictionary(String initialEntriesFileLocation)
    {        
        JSONParser parser = new JSONParser();
        root = null;

        try 
        {
            Object object = parser.parse(new FileReader(initialEntriesFileLocation));
            JSONObject jsonObject = (JSONObject) object;
            
            //adding the initial entries from json file to BST dictionary
            for(Object key: jsonObject.keySet()) 
            {
                DictionaryEntry newEntry = new DictionaryEntry(key.toString(), jsonObject.get(key).toString());
                addEntry(newEntry);
            }
        }
        catch(Exception exception)
        {
        	System.out.println(exception.getMessage());
        }
    }
    
    /**
     * method to add the given entry(key-value pair) into the dictionary
     * @param entry to be added
     * @return true if added, false otherwise
     */
    public boolean addEntry(DictionaryEntry entry)
    {
    	if(entry == null)
                throw new AssertionError("Invalid input");
            
            boolean inserted = false;
            root = insert(root, entry);
            if(root != null)
                inserted = true;
            
            return inserted;
    }

    
    /**
     * method to delete the given entry(key-value pair) from the dictionary
     * @param key of the entry to be deleted
     * @return true if deleted, false otherwise
     */
    @Override
    public boolean deleteEntry(String key)
    {          
            if(key == null)
                throw new AssertionError("Invalid input");
            
            if (isEmpty())
                throw new AssertionError("The dictionary is empty! Cannot delete");
            
            if (getValue(key) == null)
                throw new AssertionError("The given key is not present in the dictionary");
            
            root = delete(root, key);
                
            return true;
    }

    
    /**
     * method to return the value for the given key
     * @param key for which value is to be returned
     * @return value of the key if key is present else returns null
     */
    @Override
    public String getValue(String key)
    {        
            if(key == null)
                throw new AssertionError("Invalid input");
            
            if (isEmpty())
                throw new AssertionError("The dictionary is empty!");
            
            String value = getValue(root, key);
            
            if(value == null)
                throw new AssertionError("The given key is not present in the dictionary");
            
            return value;
    }

    
    /**
     * returns all the entries in ascending order of key
     */
    @Override
    public List<DictionaryEntry> getSortedList()
    {        
        List<DictionaryEntry> sortedEntryList = new ArrayList<DictionaryEntry>();
        inorderTraversal(root, sortedEntryList);
        
        return sortedEntryList;
    }

    
    /**
     * return the sorted list of entries for all the keys >=key1 and <=key2
     * @param key1
     * @param key2
     * @return sorted list, returns null if input is invalid
     */
    @Override
    public List<DictionaryEntry> getSortedList(String key1, String key2)
    {
    	if(key1 == null || key2 == null)
                throw new AssertionError("invalid input");
            
            List<DictionaryEntry> sortedSubList = new ArrayList<DictionaryEntry>();
            List<DictionaryEntry> sortedEntryList = getSortedList();
            
            Iterator<DictionaryEntry> iterator = sortedEntryList.iterator();
            
            while(iterator.hasNext())
            {
                DictionaryEntry entry = iterator.next();
                if(key1.compareTo(entry.getKey()) < 0 && key2.compareTo(entry.getKey()) > 0)
                {
                    sortedSubList.add(entry);
                }
            }
            
            return sortedSubList;
    }
   
    /**
     * method to check if the dictionary is empty
     * @return boolean value
     */
    public boolean isEmpty()
    {
        return root == null;
    } 
    
    /**
     * helper method for inserting entries in dictionary using recursion
     * @param root
     * @param entry
     * @return reference of the root of the current tree or subtree
     * @throws AssertionError if there is a duplicate entry
     */
    private BSTNode insert(BSTNode root, DictionaryEntry entry) throws AssertionError
    {
        if (root == null)
            root = new BSTNode(entry);
        else
        {
            if (entry.getKey().compareTo(root.getData().getKey()) == 0)
                throw new AssertionError("Duplicate entry");
            else if (entry.getKey().compareTo(root.getData().getKey()) < 0)
                root.left = insert(root.left, entry);
            else
                root.right = insert(root.right, entry);
        }
        
        return root;
    }
    
    
    /**
     * helper method to delete an entry from the dictionary using recursion
     * @param root
     * @param key of the entry to be deleted
     * @return reference of the root of the current tree or subtree
     */
    private BSTNode delete(BSTNode root, String key)
    {
        BSTNode newRoot, node;
        
        if (root.getData().getKey().equals(key))
        {
            BSTNode left, right;
            left = root.getLeft();
            right = root.getRight();

            if (left == null && right == null)
                return null;
            else if (left == null)
            {
                newRoot = right;
                return newRoot;
            }
            else if (right == null)
            {
                newRoot = left;
                return newRoot;
            }
            else
            {
                newRoot = right;
                BSTNode leftmost = right;
                
                while (leftmost.getLeft() != null)
                    leftmost = leftmost.getLeft();

                leftmost.setLeft(left);
                return newRoot;
            }
        }

        if (key.compareTo(root.getData().getKey()) < 0)
        {
            node = delete(root.getLeft(), key);
            root.setLeft(node);
        }
        else
        {
            node = delete(root.getRight(), key);
            root.setRight(node);             
        }
        
        return root;
    }
    
    
    /**
     * helper method to get the value of the given key using recursion
     * @param root
     * @param key
     * @return value 
     */
    private String getValue(BSTNode root, String key)
    {
        String value = null;

        while ((root != null) && value == null)
        {            
            if (key.compareTo(root.getData().getKey()) < 0)
                root = root.getLeft();
            else if (key.compareTo(root.getData().getKey()) > 0)
                root = root.getRight();
            else
            {
                value = root.getData().getValue();
                break;
            }
            
            value = getValue(root, key);
        }

        return value;
    }
    
    
    /**
     * helper method which adds all the entries from dictionary to a list using inorder traversal 
     * @param root of the BST Dictionary
     */
    private void inorderTraversal(BSTNode root, List<DictionaryEntry> sortedEntryList)
    {
        if (root != null)
        {
            inorderTraversal(root.getLeft(), sortedEntryList);
            sortedEntryList.add(root.getData());
            inorderTraversal(root.getRight(), sortedEntryList);
        }
    }
}