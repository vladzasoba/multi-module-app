package caching.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    class Node<K, V> {
        K key;
        V value;
        Node next;
        Node prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<K, Node<K, V>> cache = new HashMap<>();
    private int capacity;
    private int count;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
        count = 0;
    }


    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public V get(K key) {
        if (cache.get(key) != null) {
            Node node = cache.get(key);
            V result = (V) node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.get(key) != null) {
            Node node = cache.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}
