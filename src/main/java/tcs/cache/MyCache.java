package tcs.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements ICache interface to provide type safe, singleton and 
 * thread safe cache implementation.
 *  
 * @author prashant
 *
 * @param <K>
 * @param <V>
 */
public class MyCache<K, V> implements ICache<K, V>{
	
	/**
	 * Map to store cache values
	 */
	private Map<K, V> cacheMap;
	
	/**
	 * private constructor to make sure singleton instance
	 */
	public MyCache()
	{
		cacheMap = new HashMap<K, V>();
	}
	
	/**
	 * Synchronized method to put cache values
	 * 
	 */
	public synchronized void put(K key, V value) {
			cacheMap.put(key, value);
	}
	
	/**
	 * Method to return value stored in cache
	 */
	public V get(K key) {
			return cacheMap.get(key);
	}
	
	public int getCacheSize()
	{
		return cacheMap.size();
	}
}
