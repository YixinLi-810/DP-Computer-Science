/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2021-12-24 14:56:41
 * @LastEditors: Yixin Li
 * @LastEditTime: 2021-12-27 13:58:47
 */
class Node {
    private Object data;
    private Node next;

    public Node (Object data) {
        this.data = data;
        this.next = null;
    }

    public Node (Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void linkTo(Node next) {
        this.next = next;
    }

    public Object getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getNode() {
        return this.next;
    }

    public String toString() {
        return this.data + "->";
    }
}

class LinkedList {
    private Node head;
    public LinkedList (Node head) {
        this.head = head;
    }
    public void show() {
        Node current = this.head;

        while (current != null) {
            System.out.print( current.getData() + "-> " );
            current = current.getNode() ;
        }

        System.out.println();
    }

    public int getSize(){
        int size = 0;
        Node current = this.head;
        while (current != null) {
            size ++;
            current = current.getNode();
        }
        return size;
    }

    public void addAtBeginning (Object nodeData){
        // link node to previous head
        Node newNode = new Node(nodeData);
        newNode.linkTo(this.head);

        // assign head to new node
        this.head = newNode;
    }

    public void addAtTheEnd(Object nodeData){
        Node newNode = new Node(nodeData);

        Node current = this.head;

        // move all the way to the end
        while (current.getNext() != null) {
            System.out.print( current.getData() + "-> " );
            current = current.getNode();
        }

        // assign node to next of end
        current.linkTo(newNode);
    }

    public void addAtIndexPosition(Object NodeData, int index){
        int size = this.getSize();
        System.out.println(size);
        if (index < 0 || index > size){
            throw new IllegalArgumentException("indexError");
        }
        if (index == 0){
            this.addAtBeginning(NodeData);
            return;
        }
        
        System.out.println(this);

        Node prenoNode = this.head;
        for(int i = 0; i<index-1; i++){
            prenoNode = prenoNode.getNode();
        }

        Node node = new Node(NodeData);
        node.linkTo(prenoNode.getNode());
        prenoNode.linkTo(node);

    }

}

public class LinkedListDemo {
    public static void main(String[] args) {
        Node nodeD = new Node("d");
        Node nodeB = new Node("b", nodeD);
        Node nodeA = new Node("a", nodeB);
        System.out.println( nodeA );
        System.out.println( nodeB );
        System.out.println( nodeD );

        LinkedList ll = new LinkedList(nodeA);
        ll.show();
        System.out.println( "insert before head" );
        // Node nodeX = new Node("x", nodeD);
        ll.addAtBeginning("x");
        ll.show();

        ll.addAtIndexPosition("z", 4); 
        ll.show();

        ll.addAtBeginning("0");
        ll.show();

        ll.addAtTheEnd("e");
        ll.show();

    }
}
