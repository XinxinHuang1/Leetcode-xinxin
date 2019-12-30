// 138. Copy List with Random Pointer
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//Solution 1: HashMap
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        //loop 1: copy all nodes
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next; // next is null
        }
        //loop 2: assign next and random pointers
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
//Time: O(n), Time: O(n)

//Solution 2: HashMap, this
class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        if(this.map.containsKey(head)){
            return this.map.get(head);
        }
        Node node = new Node(head.val, null, null);
        this.map.put(head, node);// copy current node
        node.next = this.copyRandomList(head.next);// copy next pointer
        node.random = this.copyRandomList(head.random);// copy random pointer 

        return node;
    }
}
//Time: O(n), Time: O(n)