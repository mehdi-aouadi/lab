package ctci.chapters.moderate;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void lruCacheTest() {
    LRUCache<String> lruCache = new LRUCache<>();
    lruCache.insertValue("first", "Troll 1");
    lruCache.insertValue("second", "Troll 2");
    lruCache.insertValue("third", "Troll 3");
    lruCache.insertValue("fourth", "Troll 4");
    lruCache.insertValue("fifth", "Troll 5");
    lruCache.insertValue("sixth", "Troll 6");
    Assert.assertNull(lruCache.getValue("first"));
    lruCache.getValue("second");
    lruCache.insertValue("seventh", "Troll 7");
    Assert.assertNull(lruCache.getValue("third"));
    Assert.assertNotNull(lruCache.getValue("second"));
  }
}
