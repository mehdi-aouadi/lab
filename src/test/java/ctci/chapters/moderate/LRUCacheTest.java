package ctci.chapters.moderate;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void lruCacheWithHeapTest() {
    LRUCacheWithHeap<String> lruCache = new LRUCacheWithHeap<>();
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

  @Test
  public void lruCacheLinkedListTest() {
    LRUCache<String> lruCache = new LRUCache<>(5);
    lruCache.insertValue(1, "one");
    lruCache.insertValue(2, "two");
    lruCache.insertValue(3, "three");
    lruCache.insertValue(4, "four");
    lruCache.insertValue(5, "five");
    lruCache.insertValue(6, "six");
    Assert.assertNull(lruCache.getValue(1));
    Assert.assertEquals("two", lruCache.getValue(2));
    lruCache.insertValue(7, "seven");
    Assert.assertNotNull(lruCache.getValue(2));
    Assert.assertNull(lruCache.getValue(3));
  }
}
