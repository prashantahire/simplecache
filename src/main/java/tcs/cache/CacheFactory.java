package tcs.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheFactory {
	
	/**
	 * Map to store different types of cache
	 */
	private static Map<String, ICache> cacheMap = new HashMap<String, ICache>();
	
	
	/**
	 * This static method returns singleton instance of myCache for particular cache type 
	 * if already created otherwise creates and returns.
	 * @param key class
	 * @param value class
	 * @return
	 */
	public static synchronized <K, V> ICache<K, V> getMyCache(Class<K> key, Class<V> val) {
		ICache<K, V> cacheImpl = null;
		if (!cacheMap.containsKey(key.toString()+val.toString())) {
			cacheImpl = new MyCache<K, V>();
			cacheMap.put(key.toString()+val.toString(), cacheImpl);

		} else {
			cacheImpl = cacheMap.get(key.toString()+val.toString());
		}
		return cacheImpl;
	}
	
}
