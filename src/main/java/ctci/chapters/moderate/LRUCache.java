package ctci.chapters.moderate;

import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache<T> {

  private final static int MAX_SIZE = 5;

  private class Entry {
    T data;
    String key;
    Instant lastUsed;
  }

  private Map<String, Entry> entries = new HashMap<>(MAX_SIZE);
  private PriorityQueue<Entry> lruHeap
      = new PriorityQueue<Entry>(MAX_SIZE, Comparator.comparing(entry -> entry.lastUsed));

  public T getValue(String key) {
    Entry value = this.entries.get(key);
    if(value != null) {
      this.lruHeap.remove(value);
      value.lastUsed = Instant.now();
      this.lruHeap.add(value);
      return value.data;
    }
    return null;
  }

  public void insertValue(String key, T data) {
    if(this.entries.containsKey(key)) {
      throw new IllegalArgumentException("Key already used");
    }
    Entry entry = new Entry();
    entry.data = data;
    entry.key = key;
    entry.lastUsed = Instant.now();
    if(this.entries.size() >= MAX_SIZE) {
      this.entries.remove(getLRUKey());
    }
    this.entries.put(key, entry);
    this.lruHeap.add(entry);
  }

  private String getLRUKey() {
    return lruHeap.poll().key;
  }
}
