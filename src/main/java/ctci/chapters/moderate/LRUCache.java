package ctci.chapters.moderate;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

  private final int MAX_CAPACITY;
  private Map<Integer, Node> cache;
  private Node head;
  private Node tail;

  public LRUCache(int maxCapacity) {
    this.MAX_CAPACITY = maxCapacity;
    this.cache = new HashMap<>();
  }

  public T getValue(int key) {
    if(!this.cache.containsKey(key)) {
      return null;
    }
    Node node = this.cache.get(key);
    if(node != this.head) {
      removeFromLinkedList(node);
      insertAtFront(node);
    }
    return node.data;
  }

  public void insertValue(int key, T data) {
    removeNode(key);
    if(this.cache.size() >= this.MAX_CAPACITY && this.tail != null) {
      removeNode(this.tail.key);
    }

    Node node = new Node(key, data);
    insertAtFront(node);
    this.cache.put(key, node);
  }

  private void insertAtFront(Node node) {
    if(this.head == null) {
      this.head = node;
      this.tail = node;
    } else {
      head.previous = node;
      node.next = head;
      this.head = node;
    }
  }

  private void removeFromLinkedList(Node node) {
    if(node == null) {
      return;
    }

    if(node.previous != null) {
      node.previous.next = node.next;
    }
    if(node.next != null) {
      node.next.previous = node.previous;
    }
    if(node == this.head) {
      this.head = node.next;
    }
    if(node == this.tail) {
      this.tail = node.previous;
    }
  }

  private void removeNode(int key) {
    Node node = this.cache.remove(key);
    removeFromLinkedList(node);
  }


  private class Node  {
    int key;
    T data;
    Node next, previous;
    public Node(int key, T data) {
      this.key = key;
      this.data = data;
    }
  }
}
