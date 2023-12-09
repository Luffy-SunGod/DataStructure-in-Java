package hashmap;

import java.util.*;

public class HashMap<K, V> {
    class Node {
        K key;
        V value;
        Node next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public Node(){

        }

    }

    private ArrayList<Node> bucketArray = new ArrayList<>();
    int size = 0;

    public HashMap() {
        this(8);
    }

    public HashMap(int size) {
        for (int i = 1; i <= size; i++) {
            bucketArray.add(null);
        }
    }

    private int hashFunction(K key) {
        int hv = key.hashCode() % this.size;
        if (hv < 0)
            hv += this.size;
        return hv;
    }

    public void put(K key, V value) {
        int bn = hashFunction(key);
        Node temp = this.bucketArray.get(bn);
        if (temp == null) {
            Node nn = new Node(key, value);
            this.bucketArray.set(bn, nn);
            this.size++;

        } else {
            while (temp != null) {
                if (temp.key.equals(key)) {
                    temp.value = value;
                    return;
                } else {
                    temp = temp.next;
                }
            }
            temp=this.bucketArray.get(bn);
            Node nn = new Node(key, value);
            nn.next=temp;
            this.bucketArray.set(bn, nn);
        }
    }
    public boolean containsKey(K key){
        int bn=hashFunction(key);
        Node temp=this.bucketArray.get(bn);
        if(temp==null)return false;
        else{
            while(temp!=null){
                if(temp.key.equals(key))return true;
                else temp=temp.next;
            }
        }
        return false;
    }

    public V remove(K key){
        if(!containsKey(key))return null;
        int bn=hashFunction(key);
        Node temp=this.bucketArray.get(bn);
        Node prev=null;
        while(temp!=null){
            if(temp.key.equals(key)){
                prev.next=temp.next;
                temp.next=null;
                this.size--;
                return temp.value;
            }else {
                prev=temp;
                temp=temp.next;
            }
        }
        return null;
    }

}
