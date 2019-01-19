package com.kee.basics.part3_lru;

import java.util.HashMap;

public class LruDemo {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put("001", "用户1");
        lruCache.put("002", "用户2");
        lruCache.put("003", "用户3");


        System.out.println(((Node) lruCache.get("001")).value.toString());
    }

}

/**
 * LRU算法基于一种假设：长时间不使用的数据，在未来被用到的几率也不大，因此，当数据所占内存达到一定阈值时，我们要移除掉最近最少使用的数据。
 * <p>
 * 数据结构：哈希链表 java中实现 LinkedHashMap
 * 个人理解（本质是哈希Map结构，value中额外记录前驱、后继节点信息，形成链表）
 */
class LRUCache {

    private int limit;

    private HashMap<String, Node> cacheMap;
    private Node head;
    private Node end;

    public LRUCache(int limit) {
        this.limit = limit;
        this.cacheMap = new HashMap<>();
    }

    public void put(String key, Object object) {
        Node node = cacheMap.get(key);
        if (node != null) {
            node.value = object;
            refreshNode(node);
        } else {
            addNode(new Node(key, object));
        }


    }

    public Object get(String key) {
        Node node = cacheMap.get(key);
        refreshNode(node);
        return node;
    }

    public void remove(String key) {
        Node node = cacheMap.get(key);
        if (node != null) {
            removeNode(node);
        }
    }


    private void refreshNode(Node node) {
        if (node != null) {
            removeNode(node);
            addNode(node);
        }

    }


    private void addNode(Node node) {
        if (cacheMap.size() >= limit) {
            removeNode(head);
        }
        if (head == null && end == null) {
            head = node;
            end = node;
        } else {
            end.next = node;
            node.pre = end;
            end = node;
        }
        cacheMap.put(node.key, node);
    }


    private void removeNode(Node node) {
        if (node == end) {
            node.pre.next = null;
        } else if (node == head) {
            node.next.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        cacheMap.remove(node.key);
    }
}

class Node {
    public String key;
    public Object value;
    public Node pre;
    public Node next;

    Node(String key, Object ob) {
        this.key = key;
        this.value = ob;
    }
}
