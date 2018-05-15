package tcs.cache;

/**
 * Interface for cache implementation
 * @author prashant
 *
 * @param <K>
 * @param <V>
 */
public interface ICache <K, V>{
	
	/**
	 * Method declaration for putting key-value in cache.
	 * 
	 * @param key
	 * @param value
	 */
	public void  put(K key, V value);
	
	/**
	 * Method declaration for getting stored value from cache
	 * @param key
	 * @return
	 */
	public V get(K key);
	
	/**
	 * Returns cache size
	 * @return
	 */
	public int getCacheSize();
}
