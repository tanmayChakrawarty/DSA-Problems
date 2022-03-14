/* A Linked List Node
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
*/
class Solution {
    public static Node rearrange(Node head) {
        // empty list
        if (head == null) {
            return null;
        }
 
        Node prev = head;
        Node curr = head.next;
 
        // start from the second node
        while (curr != null) {
            // if the previous node is greater than the current node,
            // swap their values
            if (prev.data > curr.data) {
                int temp = prev.data;
                prev.data = curr.data;
                curr.data = temp;
            }
 
            // if the next node is greater than the current node,
            // swap their values
            if (curr.next != null && curr.next.data > curr.data) {
                int temp = curr.next.data;
                curr.next.data = curr.data;
                curr.data = temp;
            }
 
            // update `prev` and `curr` node
            prev = curr.next;
 
            if (curr.next == null) {
                break;
            }
 
            curr = curr.next.next;
        }
        
        return head;
    }  
}