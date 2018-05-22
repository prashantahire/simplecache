package CacheMvn.MyCache;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import tcs.cache.CacheFactory;
import tcs.cache.ICache;
import tcs.cache.MyCache;

/**
 * Test class for MyCache
 * 
 * @author prashant
 *
 */
public class TestCache {
	
	 int  count=1;
	 /**
	  * Singleton test method by testing MyCache instance multiple times and
	  *  checking values inserted each time.
	  */
	@Test
	public void testForSingleton(){

		addCachData();
		//get again mycache
		ICache<String, Long> mycache = CacheFactory.getMyCache(String.class, Long.class);
		
		Assert.assertEquals("Got previously stored values...", new Long( 1001), mycache.get("test1") );
		Assert.assertEquals("Got previously stored values...", new Long( 1003), mycache.get("test3") );
		
		//replace some key values
		mycache.put("test1", new Long(2001));
		mycache.put("test2", new Long(2002));
		Assert.assertEquals("After updating cache obj value...", mycache.get("test1"), new Long( 2001));
		Assert.assertEquals("After updating cache obj value...", mycache.get("test2"), new Long( 2002));
		System.out.println("MyCache instance is singletone");
				
	}
	
	/**
	 * Test method to test thread safety
	 */
	@Test
	public void testThreadSafety(){
		//run threads on map to insert objects in caches
		runThreads();
		//wait for other threads to complete
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ICache<String, Long> mycache = CacheFactory.getMyCache(String.class, Long.class);
		System.out.println(mycache.getCacheSize());
		//check the len as 10 threade created so expecting cache size as 15.
		Assert.assertEquals("After all thread updated map", 15, mycache.getCacheSize() );
	}
	private void addCachData()
	{
		ICache<String, Long> mycache = CacheFactory.getMyCache(String.class, Long.class);
		mycache.put("test1", new Long( 1001));
		mycache.put("test2", new Long( 1002));
		mycache.put("test3", new Long( 1003));
		mycache.put("test4", new Long( 1004));
		mycache.put("test5", new Long( 1005));
	}
	
	private void runThreads(){
		for(int i=1; i<=10; i++)
		{
			
			Runnable runner = new Runnable() {
				
				public void run() {
					
					ICache<String, Long> mycache = CacheFactory.getMyCache(String.class, Long.class);	
					ICache mycache2 = CacheFactory.getMyCache(String.class, Long.class);
					mycache.put(UUID.randomUUID().toString(), new Long(3000+count));
					
						count++;
				}
			};
			new Thread(runner).start();
		}
	
	}
}
