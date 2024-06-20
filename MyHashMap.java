// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node[1000];

    }

    public void put(int key, int value) {
        int idx = key%1000;
        if(storage[idx]==null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = find(storage[idx], key);
        if(prev.next==null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }

    }

    public Node find(Node head,int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }
    public int get(int key) {

        Node prev = find(storage[key%1000],key);
        if(prev!=null && prev.next!=null){
            return prev.next.value;
        }
        return -1;

    }

    public void remove(int key) {
        Node prev = find(storage[key%1000],key);
        if(prev!= null && prev.next != null){
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
        }
    }
}