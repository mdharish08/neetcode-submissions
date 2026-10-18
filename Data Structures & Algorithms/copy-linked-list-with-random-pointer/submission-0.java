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

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();

        Node cur = head , prev = null, newHead = null;
        while(cur != null){
            Node copy = new Node(cur.val);
            if(newHead == null){
                newHead = copy;
                prev = copy;
            }else{
                prev.next = copy;
            }
            map.put(cur,copy);
            cur = cur.next;
            prev = copy;
        }

        cur = head;
        Node cur2 = newHead;

        while(cur != null){
            cur2.random = map.get(cur.random);
            cur = cur.next;
            cur2 = cur2.next;
        }

        return newHead;
    }
}
